package com.pythonstrup.adapter;

import com.pythonstrup.adapter.bird.Duck;
import com.pythonstrup.adapter.bird.MallardDuck;
import com.pythonstrup.adapter.bird.Turkey;
import com.pythonstrup.adapter.bird.TurkeyAdapter;
import com.pythonstrup.adapter.bird.WildTurkey;
import org.junit.jupiter.api.Test;

class DuckTestDrive {

  @Test
  void test() {
    Duck duck = new MallardDuck();

    Turkey turkey = new WildTurkey();
    Duck turkeyAdapter = new TurkeyAdapter(turkey);

    System.out.println("칠면조");
    turkey.gobble();
    turkey.fly();

    System.out.println("오리");
    testDuck(duck);

    System.out.println("칠면조 Adapter");
    testDuck(turkeyAdapter);
  }

  private void testDuck(Duck duck) {
    duck.quack();
    duck.fly();
  }
}