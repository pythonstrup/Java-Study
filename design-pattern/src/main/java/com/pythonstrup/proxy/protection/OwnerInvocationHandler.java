package com.pythonstrup.proxy.protection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OwnerInvocationHandler implements InvocationHandler {

  Person person;

  public OwnerInvocationHandler(final Person person) {
    this.person = person;
  }

  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args) throws IllegalAccessException {
    try {
      if (method.getName().startsWith("get")) {
        return method.invoke(person, args);
      } else if (method.getName().equals("setGeekRating")) {
        throw new IllegalAccessException();
      } else if (method.getName().startsWith("set")) {
        return method.invoke(person, args);
      }
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

  Person getOwnerPerson(Person person) {
    return (Person) Proxy.newProxyInstance(
        person.getClass().getClassLoader(),
        person.getClass().getInterfaces(),
        new OwnerInvocationHandler(person));
  }
}
