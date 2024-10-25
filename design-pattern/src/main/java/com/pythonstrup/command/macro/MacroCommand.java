package com.pythonstrup.command.macro;

public class MacroCommand implements Command {

  Command[] commands;

  public MacroCommand(final Command[] commands) {
    this.commands = commands;
  }

  @Override
  public void execute() {
    for (int i = 0; i < commands.length; i++) {
      commands[i].execute();
    }
  }
}
