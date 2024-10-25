package com.pythonstrup.command.undo;

public class RemoteControl {
  Command[] onCommands;
  Command[] offCommands;
  Command undoCommand;

  public RemoteControl() {
    this.onCommands = new Command[7];
    this.offCommands = new Command[7];

    Command noCommand = new NoCommand();
    for (int i = 0; i < 7; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
    undoCommand = noCommand;
  }

  public void setCommand(final int slot, final Command onCommand, final Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
    undoCommand = onCommands[slot];
  }

  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
    undoCommand = offCommands[slot];
  }

  public void undoButtonWasPushed() {
    undoCommand.undo();
  }

  @Override
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("\n-------리모컨-------\n");
    for (int i = 0; i < 7; i++) {
      stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    " + offCommands[i].getClass().getName() + "\n");
    }
    stringBuffer.append("UndoCommand: " + undoCommand + "\n");
    return stringBuffer.toString();
  }
}
