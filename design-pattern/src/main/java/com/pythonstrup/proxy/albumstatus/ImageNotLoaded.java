package com.pythonstrup.proxy.albumstatus;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ImageNotLoaded implements ImageStatus {

  Thread retrievalThread;
  boolean retrieving = false;

  ImageProxy imageProxy;

  public ImageNotLoaded(final ImageProxy imageProxy) {
    this.imageProxy = imageProxy;
  }

  @Override
  public int getIconWidth() {
    return 800;
  }

  @Override
  public int getIconHeight() {
    return 600;
  }

  @Override
  public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
    g.drawString("앨범 커버를 불러오는 중...", x+300, y+300);
    if (!retrieving) {
      retrieving = true;

      retrievalThread = new Thread(new Runnable() {
        @Override
        public void run() {
          try{
            imageProxy.setImageIcon(new ImageIcon(imageProxy.getImageUrl(), "Album Cover"));
            c.repaint();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
      retrievalThread.start();
    }
  }
}
