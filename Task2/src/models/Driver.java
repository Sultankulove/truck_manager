package models;

public class Driver {
    private String id;
    private String name;
    private String truck;
//    private boolean assigned;


    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", truck='" + truck + '\'' +
                '}';
    }

//    public Driver(int id, String name) {
//        this.id = id;
//        this.name = name;
//        this.assigned = false;
//    }

//    public boolean isAssigned() {
//        return assigned;
//    }

//    public void setAssigned(boolean assigned) {
//        this.assigned = assigned;
//    }

    public String getName() {
        return name;
    }
}