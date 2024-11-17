package com.pythonstrup.compound.mvc;

public class HeartAdapter implements BeatModelInterface {

  HeartModelInterface heart;

  public HeartAdapter(final HeartModelInterface heart) {
    this.heart = heart;
  }

  @Override
  public void initialize() {}

  @Override
  public void on() {}

  @Override
  public void off() {}

  @Override
  public void setBPM(final int bpm) {}

  @Override
  public int getBPM() {
    return heart.getHeartRate();
  }

  @Override
  public void registerObserver(final BeatObserver o) {
    heart.registerObserver(o);
  }

  @Override
  public void removeObserver(final BeatObserver o) {
    heart.removeObserver(o);
  }

  @Override
  public void registerObserver(final BPMObserver o) {
    heart.registerObserver(o);
  }

  @Override
  public void removeObserver(final BPMObserver o) {
    heart.removeObserver(o);
  }
}
