package com.pythonstrup.factory.pizza.factorypattern;

public class ChicagoStyleCheesePizza extends Pizza {

  public ChicagoStyleCheesePizza() {
    name = "시카고 스타일 치즈 피자";
    dough = "두꺼운 크러스트 도우";
    sauce = "플럼토마토 소스";
    toppings.add("모짜렐라 치즈");
  }

  public void cut() {
    System.out.println("네코난 모양으로 자르기");
  }
}
