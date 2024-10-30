package com.pythonstrup.facade.hometheater;

public class HomeTheaterFacade {

  Amplifier amplifier;
  Tuner tuner;
  StreamingPlayer player;
  Projector projector;
  TheaterLights lights;
  Screen screen;
  PopcornPopper popper;

  public HomeTheaterFacade(final Amplifier amplifier, final Tuner tuner,
      final StreamingPlayer player,
      final Projector projector, final TheaterLights lights, final Screen screen,
      final PopcornPopper popper) {
    this.amplifier = amplifier;
    this.tuner = tuner;
    this.player = player;
    this.projector = projector;
    this.lights = lights;
    this.screen = screen;
    this.popper = popper;
  }

  public void watchMovie(String movie) {
    System.out.println("영화 볼 준비");
    popper.on();
    popper.off();
    lights.dim();
    screen.down();
    projector.on();
    projector.wideScreenMode();
    amplifier.on();
    amplifier.setStreamingPlayer(player);
    amplifier.setSurroundSound();
    amplifier.setVolume(5);
    player.on();
    player.play(movie);
  }

  public void endMovie() {
    System.out.println("홈시어터 끄는 중");
    popper.off();
    lights.on();
    screen.up();
    projector.off();
    amplifier.off();
    player.stop();
    player.off();
  }
}
