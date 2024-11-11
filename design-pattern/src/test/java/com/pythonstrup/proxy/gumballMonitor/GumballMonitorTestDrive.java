package com.pythonstrup.proxy.gumballMonitor;

import org.junit.jupiter.api.Test;

class GumballMonitorTestDrive {

  @Test
  void test() {
    int count = 112;
    String location = "Seoul";

    GumballMachine gumballMachine = new GumballMachine(count, location);
    GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);

    gumballMonitor.report();
  }
}