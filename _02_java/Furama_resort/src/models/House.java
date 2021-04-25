package models;


public class House extends Service{

    private String roomStandart;
    private String description;
    private int numberOfFloors;

    public House() {
    }

    public House(String roomStandart, String description, int numberOfFloors) {
        super();
        this.roomStandart = roomStandart;
        this.description = description;
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
                .append(this.getNumberOfFloors())
                .toString();
    }
}
