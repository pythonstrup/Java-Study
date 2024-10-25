package com.pythonstrup.command.undo;

public interface Command {
  void execute();
  void undo();
}
