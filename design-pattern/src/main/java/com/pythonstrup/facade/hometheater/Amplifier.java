package com.pythonstrup.facade.hometheater;

public class Amplifier {

  Tuner tuner;
  StreamingPlayer player;

  void on() {
  }

  void off() {
  }

  void setStreamingPlayer(StreamingPlayer player) {this.player = player;}
  void setStereoSound() {}
  void setSurroundSound() {}
  void setTuner() {}
  void setVolume(final int volume) {}

  public String toString() {
    return "";
  }
}
