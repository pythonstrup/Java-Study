package com.pythonstrup.proxy.albumstatus;

import java.awt.Component;
import java.awt.Graphics;

public interface ImageStatus {

  int getIconWidth();
  int getIconHeight();
  void paintIcon(final Component c, final Graphics g, final int x, final int y);
}
