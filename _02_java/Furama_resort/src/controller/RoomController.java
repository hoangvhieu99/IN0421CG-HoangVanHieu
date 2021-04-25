package controller;


import Services.*;

import models.Room;

import java.util.List;


public class RoomController {

    private RoomService roomService = new RoomServiceImpl();

    List<String> rows = roomService.getRoom();
    List<Room> rooms = roomService.getRoomFromRawRoom(rows);

    public void showAllRoom() {
        roomService.showAllRoom();
    }

    public void showDistinctRoomName(){
        roomService.showDistinctName(rooms);
    }

    public void add() {
        try {
            roomService.save(roomService.add());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
