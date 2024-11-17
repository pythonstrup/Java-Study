package com.pythonstrup.compound.mvc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line.Info;

public class BeatModel implements BeatModelInterface, Runnable {
  List<BeatObserver> beatObservers = new ArrayList<>();
  List<BPMObserver> bpmObservers = new ArrayList<>();
  int bpm = 90;
  Thread thread;
  boolean stop = false;
  Clip clip;


  @Override
  public void initialize() {
    try {
      File resource = new File("clap.wav");
      clip = (Clip) AudioSystem.getLine(new Info(Clip.class));
      clip.open(AudioSystem.getAudioInputStream(resource));
    } catch (Exception e) {

    }
  }

  @Override
  public void on() {
    bpm = 90;
    notifyBPMObservers();
    thread = new Thread();
    stop = false;
    thread.start();
  }

  @Override
  public void off() {
    stopBeat();
    stop = true;
  }

  @Override
  public void setBPM(final int bpm) {
    this.bpm = bpm;
    notifyBPMObservers();
  }

  @Override
  public int getBPM() {
    return bpm;
  }

  @Override
  public void registerObserver(final BeatObserver o) {
    beatObservers.add(o);
  }

  public void notifyBeatObservers() {
    for (int i = 0; i < beatObservers.size(); i++) {
      BeatObserver beatObserver = beatObservers.get(i);
      beatObserver.updateBeat();
    }
  }

  @Override
  public void removeObserver(final BeatObserver o) {
    int i = beatObservers.indexOf(o);
    if (i >= 0) {
      beatObservers.remove(i);
    }
  }

  @Override
  public void registerObserver(final BPMObserver o) {
    bpmObservers.add(o);
  }

  public void notifyBPMObservers() {
    for (int i = 0; i < bpmObservers.size(); i++) {
      BPMObserver bpmObserver = bpmObservers.get(i);
      bpmObserver.updateBPM();
    }
  }

  @Override
  public void removeObserver(final BPMObserver o) {
    int i = bpmObservers.indexOf(o);
    if (i >= 0) {
      bpmObservers.remove(i);
    }
  }

  @Override
  public void run() {
    while(!stop) {
      playBeat();
      notifyBeatObservers();
      try {
        Thread.sleep(60_000/getBPM());
      } catch (InterruptedException e) {}
    }
  }

  private void playBeat() {
    clip.setFramePosition(0);
    clip.start();
  }

  private void stopBeat() {
    clip.setFramePosition(0);
    clip.stop();
  }
}
