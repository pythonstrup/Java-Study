package com.pythonstrup.command.slot;

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

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
    remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
    remoteControl.setCommand(3, stereoOn, stereoOff);

    System.out.println(remoteControl);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(1);
    remoteControl.offButtonWasPushed(1);
    remoteControl.onButtonWasPushed(2);
    remoteControl.offButtonWasPushed(2);
    remoteControl.onButtonWasPushed(3);
    remoteControl.offButtonWasPushed(3);
  }
}
