package models;

import exceptions.StateException;
import states.State;

public class Truck {

    private int id;
    private String name;
    private String driver;
    private String state;
    private State stateObj;
    private Driver driverObj;

    public int getId() {
        return id;
    }

    public String getDriver() {
        return driver;
    }

    public String getState() {
        return state;
    }

    public State getStateObj() {
        return stateObj;
    }

    public String toString() {
        String l = "%3s | %-17s | %10s | %-8s";
        return  "| " + " " + name + " " + " " + driver + state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStateObj(State stateObj) {
        this.stateObj = stateObj;
    }

    public void setDriverObj(Driver driverObj) {
        this.driverObj = driverObj;
    }

    public Driver getDriverObj() {
        return driverObj;
    }

    public void startDriving() {
        try {
            stateObj.startDriving(this);
        } catch (StateException se) {
            se.getMessage();
            se.printStackTrace();
        }
    }

    public void startRepair() {
        try {
            stateObj.startRepair(this);
        } catch (StateException se) {
            se.getMessage();
            se.printStackTrace();
        }
    }

    public void changeDriver() {
        try {
            stateObj.changeDriver(this);
        } catch (StateException se) {
            se.getMessage();
            se.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
