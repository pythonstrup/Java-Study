package com.pythonstrup.singleton.classic;

public class InitialSingleton {
  private static InitialSingleton uniqueInstance = new InitialSingleton();;

  private InitialSingleton() {}

  public static InitialSingleton getInstance() {
    return uniqueInstance;
  }

  // 기타 메소드
}
