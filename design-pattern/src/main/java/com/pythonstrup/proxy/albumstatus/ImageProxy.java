package com.pythonstrup.proxy.albumstatus;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

class ImageProxy implements Icon {

  volatile ImageIcon imageIcon;
  final URL imageUrl;
  ImageStatus status = new ImageNotLoaded(this);

  public ImageProxy(final URL imageUrl) {
    this.imageUrl = imageUrl;
  }

  public URL getImageUrl() {
    return imageUrl;
  }

  @Override
  public int getIconWidth() {
    return status.getIconWidth();
  }

  @Override
  public int getIconHeight() {
    return status.getIconHeight();
  }

  @Override
  public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
    status.paintIcon(c, g, x, y);
  }

  synchronized void setImageIcon(ImageIcon imageIcon) {
    this.imageIcon = imageIcon;
    status = new ImageLoaded(imageIcon);
  }
}
