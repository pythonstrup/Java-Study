package com.pythonstrup.command.macro;

public class RemoteControl {
  Command[] onCommands;
  Command[] offCommands;

  public RemoteControl() {
    this.onCommands = new Command[7];
    this.offCommands = new Command[7];

    Command noCommand = new NoCommand();
    for (int i = 0; i < 7; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
  }

  public void setCommand(final int slot, final Command onCommand, final Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
  }

  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
  }

  @Override
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("\n-------리모컨-------\n");
    for (int i = 0; i < 7; i++) {
      stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    " + offCommands[i].getClass().getName() + "\n");
    }
    return stringBuffer.toString();
  }
}
