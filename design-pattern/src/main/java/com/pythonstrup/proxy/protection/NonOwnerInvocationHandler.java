package com.pythonstrup.proxy.protection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NonOwnerInvocationHandler implements InvocationHandler {

  Person person;

  public NonOwnerInvocationHandler(final Person person) {
    this.person = person;
  }

  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args) throws IllegalAccessException {
    try {
      if (method.getName().startsWith("get")) {
        return method.invoke(person, args);
      } else if (method.getName().equals("setGeekRating")) {
        return method.invoke(person, args);
      } else if (method.getName().startsWith("set")) {
        throw new IllegalAccessException();
      }
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

  Person getNonOwnerPerson(Person person) {
    return (Person) Proxy.newProxyInstance(
        person.getClass().getClassLoader(),
        person.getClass().getInterfaces(),
        new NonOwnerInvocationHandler(person));
  }
}
