package com.pythonstrup.templatemethod.hook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

  @Override
  public void brew() {
    System.out.println("필터로 커피 우려내는 중");
  }

  @Override
  public void addCondiments() {
    System.out.println("설탕과 우유를 추가하는 중");
  }

  @Override
  boolean customWantCondiments() {
    String answer = getUserInput();

    if (answer.toLowerCase().startsWith("y")) {
      return true;
    } else {
      return false;
    }
  }

  public String getUserInput() {
    String answer = null;

    System.out.println("커피에 우유와 설탕을 넣을까요? (y/n)? ");

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      answer = in.readLine();
    } catch (IOException e) {
      System.out.println("I/O 오류");
    }
    if (answer == null) {
      return "no";
    }
    return answer;
  }
}
