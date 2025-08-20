package sri;
//Abstract  class

abstract class SmartDevice {
 protected String name;

 public SmartDevice(String name) {
     this.name = name;
 }

 public abstract void turnOn();
 public abstract void turnOff();
}

class SmartLight extends SmartDevice {
 public SmartLight(String name) {
     super(name);
 }

 @Override
 public void turnOn() {
     System.out.println(name + " light is now ON.");
 }

 @Override
 public void turnOff() {
     System.out.println(name + " light is now OFF.");
 }
}

class SmartThermostat extends SmartDevice {
 public SmartThermostat(String name) {
     super(name);
 }

 @Override
 public void turnOn() {
     System.out.println(name + " thermostat is now ON.");
 }

 @Override
 public void turnOff() {
     System.out.println(name + " thermostat is now OFF.");
 }
}

//Final class
final class SmartHub {
 private SmartDevice[] devices;

 public SmartHub(SmartDevice[] devices) {
     this.devices = devices;
 }

 public void activateAll() {
     System.out.println("Activating all smart devices...");
     for (SmartDevice device : devices) {
         device.turnOn();
     }
 }

 public void deactivateAll() {
     System.out.println("Deactivating all smart devices...");
     for (SmartDevice device : devices) {
         device.turnOff();
     }
 }
}

//Main class 

public class SmartHomeSystem {
 public static void main(String[] args) {
     SmartDevice light = new SmartLight("Living Room");
     SmartDevice thermostat = new SmartThermostat("Bedroom");

     SmartDevice[] devices = { light, thermostat };
     SmartHub hub = new SmartHub(devices);

     hub.activateAll();
     hub.deactivateAll();
 }
}
