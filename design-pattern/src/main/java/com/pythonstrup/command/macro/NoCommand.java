package com.pythonstrup.command.macro;

public class NoCommand implements Command {

  @Override
  public void execute() {
    System.out.println("NoCommand");
  }
}
