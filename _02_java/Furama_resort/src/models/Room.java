package models;

public class Room extends Service {
    private String accompaniedService;

    public Room() {
    }

    public Room(String accompaniedService) {
        super();
        this.accompaniedService = accompaniedService;
    }

    public String getAccompaniedService() {
        return accompaniedService;
    }

    public void setAccompaniedService(String accompaniedService) {
        this.accompaniedService = accompaniedService;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.getId()).append(",")
                .append(super.getNameServices()).append(",")
                .append(super.getArea()).append(",")
                .append(super.getCost()).append(",")
                .append(super.getMaxPerson()).append(",")
                .append(super.getType()).append(",")
                .append(this.getAccompaniedService())
                .toString();

    }
}
