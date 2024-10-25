package com.pythonstrup.command.slot;

public class Stereo {

  public void on() {
    System.out.println("오디오 On");
  }

  public void off() {
    System.out.println("오디오 Off");
  }

  public void setCD() {
    System.out.println("CD 설정");
  }

  public void setVolume(int volume) {
    System.out.println("볼륨 설정: " + volume);
  }
}
