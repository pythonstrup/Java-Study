package com.pythonstrup.compound.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DjView implements ActionListener, BeatObserver, BPMObserver {

  BeatModelInterface model;
  ControllerInterface controller;
  JFrame viewFrame;
  JPanel viewPanel;
  BeatBar beatBar;
  JLabel bpmOutputLabel;
  JFrame controlFrame;
  JPanel controlPanel;
  JLabel bpmLabel;
  JTextField bpmTextField;
  JButton setBPMButton;
  JButton increaseBPMButton;
  JButton decreaseBPMButton;
  JMenuBar menuBar;
  JMenu menu;
  JMenuItem startMenuItem;
  JMenuItem stopMenuItem;

  public DjView(final ControllerInterface controller, final BeatModelInterface model) {
    this.controller = controller;
    this.model = model;
    model.registerObserver((BeatObserver) this);
    model.registerObserver((BPMObserver) this);
  }

  public void createView() {
    viewPanel = new JPanel(new GridLayout(1, 2));
    viewFrame = new JFrame("View");
    viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    viewFrame.setSize(new Dimension(100, 80));
    bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
    beatBar = new BeatBar();
    beatBar.setValue(0);
    JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
    bpmPanel.add(beatBar);
    bpmPanel.add(bpmOutputLabel);
    viewPanel.add(bpmPanel);
    viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
    viewFrame.pack();
    viewFrame.setVisible(true);
  }

  public void updateBPM() {
    int bpm = model.getBPM();
    if (bpm == 0) {
      bpmOutputLabel.setText("offline");
    } else {
      bpmOutputLabel.setText("Current BPM: " + model.getBPM());
    }
  }

  public void updateBeat() {
    beatBar.setValue(100);
  }

  @Override
  public void actionPerformed(final ActionEvent e) {

  }

  public void createControls() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    controlFrame = new JFrame("Control");
    controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    controlFrame.setSize(new Dimension(100, 80));

    controlPanel = new JPanel(new GridLayout(1, 2));

    menuBar = new JMenuBar();
    menu = new JMenu("DJ Control");
    startMenuItem = new JMenuItem("Start");
    menu.add(startMenuItem);
    startMenuItem.addActionListener(e -> controller.start());

    stopMenuItem = new JMenuItem("Stop");
    menu.add(stopMenuItem);
    startMenuItem.addActionListener(e -> controller.stop());

    JMenuItem exit = new JMenuItem("Quit");
    exit.addActionListener(e -> System.exit(0));
  }

  public void enableStartMenuItem() {

  }

  public void disableStartMenuItem() {
  }

  public void enableStopMenuItem() {

  }

  public void disableStopMenuItem() {

  }
}
