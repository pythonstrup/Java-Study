package com.pythonstrup.proxy.gumballrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote {
  int getCount() throws RemoteException;
  String getLocation() throws RemoteException;
  State getState() throws RemoteException;
}
