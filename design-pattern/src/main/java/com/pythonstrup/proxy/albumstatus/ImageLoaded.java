package com.pythonstrup.proxy.albumstatus;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ImageLoaded implements ImageStatus {

  volatile ImageIcon imageIcon;

  public ImageLoaded(final ImageIcon imageIcon) {
    this.imageIcon = imageIcon;
  }

  @Override
  public int getIconWidth() {
    return imageIcon.getIconWidth();
  }

  @Override
  public int getIconHeight() {
    return imageIcon.getIconHeight();
  }

  @Override
  public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
    imageIcon.paintIcon(c, g, x, y);
  }
}
