package converter;


import models.Room;

public class RoomConverter {
    public Room convert(String roomStr) {
        Room room = new Room();
        String[] cols = roomStr.split(",");
        room.setId(String.valueOf(cols[0]));
        room.setNameServices(String.valueOf(cols[1]));
        room.setArea(Integer.parseInt(cols[2]));
        room.setCost(Integer.parseInt(cols[3]));
        room.setMaxPerson(Integer.parseInt(cols[4]));
        room.setType(String.valueOf(cols[5]));
        room.setAccompaniedService(cols[6]);

        return room;
    }
}
