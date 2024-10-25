package com.pythonstrup.command.simple;

public class SimpleRemoteControl {
  Command slot;

  public SimpleRemoteControl() {}

  public void setSlot(final Command slot) {
    this.slot = slot;
  }

  public void buttonWasPressed() {
    slot.execute();
  }
}
