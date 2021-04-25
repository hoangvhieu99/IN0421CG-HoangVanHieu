package Services;

import constants.CSVConstant;
import constants.RoomConstant;
import converter.RoomConverter;
import models.Room;
import utils.FileUtils;
import utils.ScannerSingeton;
import validation.GenericValidation;
import validation.RoomValidation;

import java.io.File;
import java.util.*;

public class RoomServiceImpl implements RoomService {

    private Scanner scanner = ScannerSingeton.getInstance();

    @Override
    public Set<String> getNames(List<Room> rooms) {
        Set<String> names = new HashSet<>();
        for (Room room: rooms) {
            names.add(room.getNameServices());
        }
        return names;
    }

    @Override
    public List<Room> getRoomFromRawRoom(List<String> roomsStr) {
        List<Room> result = new ArrayList<>();
        Boolean isHeader = true;
        for (String row: roomsStr) {
            if (isHeader){
                isHeader = false;
                continue;
            }

            Room room = new RoomConverter().convert(row);
            if (room != null)
                result.add(room);
        }
        return result;
    }

    @Override
    public List<String> getRoom() {
        try {
            File file = new File(RoomConstant.ROOM_FILE_PATH);
            return FileUtils.read(file);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void showDistinctName(List<Room> rooms) {
        Set<String> names = this.getNames(rooms);
        for (String name: names) {
            System.out.println(name);
        }
    }

    @Override
    public void showAllRoom() {
        List<String> rows = this.getRoom();
        List<Room> rooms = this.getRoomFromRawRoom(rows);
        System.out.println(RoomConstant.ROOM_HEADER);
        for (Room room: rooms) {
            System.out.println(room.toString());
        }
    }

    @Override
    public Room add() {
        Room room = new Room();
        GenericValidation validate= new RoomValidation();

        do {
            System.out.println("Enter ID: ");
            String id = String.valueOf(scanner.nextLine());
            if (validate.idValidate(id)){
                room.setId(id);
                break;
            }
        }while (true);

        do {
            System.out.println("Enter Name Service: ");
            String name = String.valueOf(scanner.nextLine());
            if (validate.nameValidate(name)){
                room.setNameServices(name);
                break;
            }
        }while (true);

        do {
            System.out.println("Area: ");
            int area = Integer.parseInt(scanner.nextLine());
            if (validate.areaValidate(area)){
                room.setArea(area);
                break;
            }
        }while (true);

        do {
            System.out.println("Cost: ");
            int cost = Integer.parseInt(scanner.nextLine());
            if (validate.costValidate(cost)){
                room.setCost(cost);
                break;
            }
        }while (true);

        do {
            System.out.println("Max Person: ");
            int maxPerson = Integer.parseInt(scanner.nextLine());
            if (validate.maxPersonValidate(maxPerson)){
                room.setMaxPerson(maxPerson);
                break;
            }
        }while (true);

        System.out.println("Type: ");
        String type = String.valueOf(this.getRoomType());
        room.setType(type);
        scanner.nextLine();

        System.out.println("Accompanied Service: ");
        String accompaniedService = String.valueOf(this.getAccompaniedService());
        room.setType(accompaniedService);

        return room;
    }

    public String getRoomType(){
        System.out.println("Select your room Type");
        System.out.println("1. Day");
        System.out.println("2. Month");
        System.out.println("3. Year");
        int choose = Integer.parseInt(String.valueOf(scanner.nextInt()));

        switch (choose){
            case 1:
                System.out.println("Type Day selected");
                return RoomConstant.TYPE_DAY;
            case 2:
                System.out.println("Type Month selected");
                return RoomConstant.TYPE_MONTH;
            case 3:
                System.out.println("Type Year selected");
                return RoomConstant.TYPE_YEAR;
            default:
                System.err.println("Type Day selected by default");
                return RoomConstant.TYPE_DAY;
        }
    }

    public String getAccompaniedService(){
        System.out.println("Select your room Accompanied Service");
        System.out.println("1. Massage");
        System.out.println("2. Karaoke");
        System.out.println("3. Food");
        System.out.println("4. Drink");
        System.out.println("5. Car");
        int choose = Integer.parseInt(String.valueOf(scanner.nextInt()));

        switch (choose){
            case 1:
                System.out.println("Massage selected");
                return RoomConstant.accompanied_Service_1;//constant viết hoa hết
            case 2:
                System.out.println("Karaoke selected");
                return RoomConstant.accompanied_Service_2;
            case 3:
                System.out.println("Food selected");
                return RoomConstant.accompanied_Service_3;
            case 4:
                System.out.println("Drink selected");
                return RoomConstant.accompanied_Service_4;
            case 5:
                System.out.println("Car selected");
                return RoomConstant.accompanied_Service_5;
            default:
                System.err.println("Message selected by default");
                return RoomConstant.accompanied_Service_1;
        }
    }
    @Override
    public void show(List<Room> rooms) {
        if (rooms.isEmpty()) {
            System.out.println("This service is empty");
        } else {
            for (Room room : rooms) {
                room.toString();

            }
        }
    }

    @Override
    public Room save(Room room) throws Exception{
        RoomService roomService = new RoomServiceImpl();
        List<String> rooms = roomService.getRoom();
        /**
         *
         * nếu thêm validate* nhập vào trùng ==> báo lỗi
         * */
        GenericValidation validation = new RoomValidation();
        validation.validate(room);
        if (rooms.isEmpty()){
            rooms = new ArrayList<String>();
            rooms.add(RoomConstant.ROOM_HEADER);
            rooms.add(CSVConstant.NEW_LINE_SEPARATOR);
        }
        rooms.add(room.toString());
        FileUtils.write(rooms, new File(RoomConstant.ROOM_FILE_PATH));
        System.out.println("Add New Room Succeed!!!");
        return room;
    }


}
