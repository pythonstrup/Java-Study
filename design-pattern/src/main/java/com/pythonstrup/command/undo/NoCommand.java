package com.pythonstrup.command.undo;

public class NoCommand implements Command {

  @Override
  public void execute() {
    System.out.println("NoCommand");
  }

  @Override
  public void undo() {
    System.out.println("NoCommand");
  }
}
