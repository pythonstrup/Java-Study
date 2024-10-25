package com.pythonstrup.command.slot;

public class NoCommand implements Command{

  @Override
  public void execute() {
    System.out.println("NoCommand");
  }
}
