package com.pythonstrup.compound.mvc;

public interface HeartModelInterface {

  int getHeartRate();
  void registerObserver(BeatObserver o);
  void removeObserver(BeatObserver o);
  void registerObserver(BPMObserver o);
  void removeObserver(BPMObserver o);
}
