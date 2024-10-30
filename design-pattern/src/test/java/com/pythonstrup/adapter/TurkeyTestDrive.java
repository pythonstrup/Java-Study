package com.pythonstrup.adapter;

import com.pythonstrup.adapter.bird.Duck;
import com.pythonstrup.adapter.bird.DuckAdapter;
import com.pythonstrup.adapter.bird.MallardDuck;
import com.pythonstrup.adapter.bird.Turkey;
import com.pythonstrup.adapter.bird.TurkeyAdapter;
import com.pythonstrup.adapter.bird.WildTurkey;
import org.junit.jupiter.api.Test;

class TurkeyTestDrive {

  @Test
  void test() {
    Duck duck = new MallardDuck();
    Turkey duckAdapter = new DuckAdapter(duck);

    System.out.println("오리 Adapter");
    testTurkey(duckAdapter);
  }

  private void testTurkey(Turkey turkey) {
    turkey.gobble();
    turkey.fly();
  }
}