package com.pythonstrup.templatemethod.jframe;

import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

  public MyFrame(final String title) throws HeadlessException {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setSize(300, 300);
    this.setVisible(true);
  }

  public void paint(Graphics graphics) {
    super.paint(graphics);
    String msg = "메시지";
    graphics.drawString(msg, 100, 100);
  }

  public static void main(String[] args) {
    MyFrame myFrame = new MyFrame("Head First Design Patterns");
  }
}
