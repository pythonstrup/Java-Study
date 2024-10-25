package com.pythonstrup.command.macro;

public class RemoteLoader {

  public static void main(String[] args) {
    RemoteControl remoteControl = new RemoteControl();

    Light livingRoomLight = new LivingRoomLight();
    Light kitchenLight = new KitchenLight();
    CeilingFan ceilingFan = new CeilingFan();
    GarageDoor garageDoor = new GarageDoor();
    Stereo stereo = new Stereo();

    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
    LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
    LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

    CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
    CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

    GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
    GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

    StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
    StereoOffWithCDCommand stereoOff = new StereoOffWithCDCommand(stereo);

    MacroCommand macroOn = new MacroCommand(
        new Command[]{livingRoomLightOn, kitchenLightOn, ceilingFanOn, stereoOn});
    MacroCommand macroOff = new MacroCommand(
        new Command[]{livingRoomLightOff, kitchenLightOff, ceilingFanOff, stereoOff});

    remoteControl.setCommand(0, macroOn, macroOff);

    System.out.println(remoteControl);

    System.out.println("--- Macro On ---");
    remoteControl.onButtonWasPushed(0);
    System.out.println();

    System.out.println("--- Macro Off ---");
    remoteControl.offButtonWasPushed(0);
  }
}
