package models;

import exceptions.StateException;
import states.OnBase;
import states.OnRepair;
import states.OnRoute;
import states.State;

import java.util.Objects;

public class Truck {

    private int id;
    private String name;
    private String driver;
    private String state;
    private transient State stateObj;

    private void initStateObj() {
        switch (state) {
            case "On base":
                stateObj = new OnBase();
                break;
            case "On route":
                stateObj = new OnRoute();
                break;
            case "On repair":
                stateObj = new OnRepair();
                break;
            default:
                stateObj = new OnBase();
                state = "On base";
                break;
        }
    }

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

    public void setDriver(String driver) {
        this.driver = driver;
    }

    //    public String toString() {
//        String l = "%3s | %-17s | %10s | %-8s";
//        return  "| " + " " + name + " " + " " + driver + state;
//    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Truck{");
        sb.append("id").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", driver='").append(driver).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStateObj(State stateObj) {
        this.stateObj = stateObj;
    }

//    public void setDriverObj(Driver driverObj) {
//        this.driverObj = driverObj;
//    }

//    public Driver getDriverObj() {
//        return driverObj;
//    }

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
        if (Objects.isNull(stateObj))
            initStateObj();
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
