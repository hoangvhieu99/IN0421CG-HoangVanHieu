package validation;


import Services.RoomService;
import Services.RoomServiceImpl;
import models.Room;

import java.util.List;
import java.util.Set;

public class RoomValidation implements GenericValidation<Room> {

    @Override
    public Room validate(Room room) throws Exception {
    RoomService roomService = new RoomServiceImpl();
    List<String> roomDB = roomService.getRoom();
    Set<String> names = roomService.getNames(roomService.getRoomFromRawRoom(roomDB));
        if (!room.getId().matches("^SV+RO*-[0-9]{4}")){
            throw new Exception("ID Room format must be SVRO-YYYY");
        }

        if (!room.getNameServices().matches("[A-Z][a-z]+\\b")){
            throw new Exception("Name format must start with upper-case letter");
        }


        //tiếp tục validate các trường khác
        return room;
    }

    @Override
    public boolean nameValidate(String name) {
        if (!name.matches("[A-Z][a-z]+\\b")){
            System.err.println("Name format must start with upper-case letter");
            return false;
        }
        return true;
    }

    @Override
    public boolean idValidate(String id) {
        if (!id.matches("^SV+RO*-[0-9]{4}")){
            System.err.println("ID Room format must be SVRO-YYYY(YYYY: 0-9)");
            return false;
        }
        return true;
    }

    @Override
    public boolean areaValidate(int area) {
        if(area<30 || area<=0){
            System.err.println("Area must be > 30m2");
            return false;
        }
        return true;
    }

    @Override
    public boolean costValidate(int cost) {
        if(cost<=0){
            System.err.println("Cos must be > 0");
            return false;
        }
        return true;
    }

    @Override
    public boolean maxPersonValidate(int maxPerson) {
        if(maxPerson<=0 || maxPerson>=20){
            System.err.println("Max Person must be >0 and <20");
            return false;
        }
        return true;
    }

    @Override
    public boolean typeValidate(String type) {
        return false;
    }

    @Override
    public boolean roomStandartValidate(String roomStandart) {
        return false;
    }

    @Override
    public boolean accompaniedService(String accompaniedService) {
        return false;
    }

    @Override
    public boolean numberOfFloorsValidate(int numberOfFloors) {
        return false;
    }
}
