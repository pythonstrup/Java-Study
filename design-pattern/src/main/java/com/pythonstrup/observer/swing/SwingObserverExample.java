package com.pythonstrup.observer.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
  JFrame frame;

  public static void main(String[] args) {
    SwingObserverExample example = new SwingObserverExample();
    example.go();
  }

  private void go() {
    frame = new JFrame();

    JButton button = new JButton("할까? 말까?");
    button.addActionListener(event -> System.out.println("하지마"));
    button.addActionListener(event -> System.out.println("저질러"));
  }
}
