package models;

public class Villa extends Service {
    private String roomStandart;
    private String description;
    private int poolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String roomStandart, String description, int poolArea, int numberOfFloors) {
        super();
        this.roomStandart = roomStandart;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandart() {
        return roomStandart;
    }

    public void setRoomStandart(String roomStandart) {
        this.roomStandart = roomStandart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.getId()).append(",")
                .append(super.getNameServices()).append(",")
                .append(super.getArea()).append(",")
                .append(super.getCost()).append(",")
                .append(super.getMaxPerson()).append(",")
                .append(super.getType()).append(",")
                .append(this.getRoomStandart()).append(",")
                .append(this.getDescription()).append(",")
                .append(this.getPoolArea()).append(",")
                .append(this.getNumberOfFloors())
                .toString();

    }
}
