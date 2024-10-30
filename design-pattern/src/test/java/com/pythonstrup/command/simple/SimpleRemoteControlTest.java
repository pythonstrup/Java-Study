package com.pythonstrup.command.simple;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleRemoteControlTest {

  @Test
  void test() {
    SimpleRemoteControl remote = new SimpleRemoteControl();
    Light light = new Light();
    LightOnCommand lightOn = new LightOnCommand(light);
    GarageDoor garageDoor = new GarageDoor();
    GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);

    remote.setSlot(lightOn);
    remote.buttonWasPressed();
    remote.setSlot(garageOpen);
    remote.buttonWasPressed();
  }
}