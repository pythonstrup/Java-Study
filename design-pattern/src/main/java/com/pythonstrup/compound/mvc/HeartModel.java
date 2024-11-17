package com.pythonstrup.compound.mvc;

public class HeartModel implements HeartModelInterface {

  int heartRate;


  @Override
  public int getHeartRate() {
    return heartRate;
  }

  @Override
  public void registerObserver(final BeatObserver o) {

  }

  @Override
  public void removeObserver(final BeatObserver o) {

  }

  @Override
  public void registerObserver(final BPMObserver o) {

  }

  @Override
  public void removeObserver(final BPMObserver o) {

  }
}
