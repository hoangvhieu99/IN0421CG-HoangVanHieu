package Services;

import constants.CSVConstant;
import constants.HouseConstant;
import converter.HouseConverter;
import models.House;
import utils.FileUtils;
import utils.ScannerSingeton;
import validation.GenericValidation;
import validation.HouseValidation;

import java.io.File;
import java.util.*;

public class HouseServiceImpl implements HouseService {

    private Scanner scanner = ScannerSingeton.getInstance();

    @Override
    public Set<String> getNames(List<House> houses) {
        Set<String> names = new HashSet<>();
        for (House house: houses) {
            names.add(house.getNameServices());
        }
        return names;
    }



    @Override
    public List<House> getHouseFromRawHouse(List<String> housesStr) {
        List<House> result = new ArrayList<>();
        Boolean isHeader = true;
        for (String row: housesStr) {
            if (isHeader){
                isHeader = false;
                continue;
            }

            House house = new HouseConverter().convert(row);
            if (house != null)
                result.add(house);
        }
        return result;
    }

    @Override
    public List<String> getHouse() {
        try {
            File file = new File(HouseConstant.HOUSE_FILE_PATH);
            return FileUtils.read(file);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void showDistinctName(List<House> houses) {
        Set<String> names = this.getNames(houses);
        for (String name: names) {
            System.out.println(name);
        }
    }

    @Override
    public void showAllHouse() {
        List<String> rows = this.getHouse();
        List<House> houses = this.getHouseFromRawHouse(rows);
        System.out.println(HouseConstant.HOUSE_HEADER);
        for (House house: houses) {
            System.out.println(house.toString());
        }
    }

    @Override
    public House add(){
        House house = new House();
        GenericValidation validate = new HouseValidation();

        do {
            System.out.println("Enter ID: ");
            String id = String.valueOf(scanner.nextLine());
            if (validate.idValidate(id)){
                house.setId(id);
                break;
            }
        }while (true);

        do {
            System.out.println("Enter Name Service: ");
            String name = String.valueOf(scanner.nextLine());
            if (validate.nameValidate(name)){
                house.setNameServices(name);
                break;
            }
        }while (true);

        do {
            System.out.println("Area: ");
            int area = Integer.parseInt(scanner.nextLine());
            if (validate.areaValidate(area)){
                house.setArea(area);
                break;
            }
        }while (true);

        do {
            System.out.println("Cost: ");
            int cost = Integer.parseInt(scanner.nextLine());
            if (validate.costValidate(cost)){
                house.setCost(cost);
                break;
            }
        }while (true);

        do {
            System.out.println("Max Person: ");
            int maxPerson = Integer.parseInt(scanner.nextLine());
            if (validate.maxPersonValidate(maxPerson)){
                house.setMaxPerson(maxPerson);
                break;
            }
        }while (true);

        System.out.println("Type: ");
        String type = String.valueOf(this.getHouseType());
        house.setType(type);
        scanner.nextLine();

        System.out.println("Room Standart: ");
        String roomStandart = String.valueOf(this.getRoomStandart());
        house.setRoomStandart(roomStandart);
        scanner.nextLine();

        System.out.println("Description: ");
        house.setDescription(String.valueOf(scanner.nextLine()));

        do {
            System.out.println("Number Of Floor: ");
            int floors = Integer.parseInt(scanner.nextLine());
            if (validate.numberOfFloorsValidate(floors)){
                house.setNumberOfFloors(floors);
                break;
            }
        }while (true);

        return house;
    }

    public String getHouseType(){
        System.out.println("Select your house Type");
        System.out.println("1. Day");
        System.out.println("2. Month");
        System.out.println("3. Year");
        int choose = Integer.parseInt(String.valueOf(scanner.nextInt()));

        switch (choose){
            case 1:
                System.out.println("Type Day selected");
                return HouseConstant.TYPE_DAY;
            case 2:
                System.out.println("Type Month selected");
                return HouseConstant.TYPE_MONTH;
            case 3:
                System.out.println("Type Year selected");
                return HouseConstant.TYPE_YEAR;
            default:
                System.err.println("Type Day selected by default");
                return HouseConstant.TYPE_DAY;
        }
    }

    public String getRoomStandart(){
        System.out.println("Select your house Room Standart");
        System.out.println("1. 5 Star");
        System.out.println("2. 4 Star");
        System.out.println("3. 3 Star");
        System.out.println("4. 2 Star");
        System.out.println("5. 1 Star");
        int choose = Integer.parseInt(String.valueOf(scanner.nextInt()));

        switch (choose){
            case 1:
                System.out.println("5 Star selected");
                return HouseConstant.ROOM_STANDART_FIVE_STAR;
            case 2:
                System.out.println("4 Star selected");
                return HouseConstant.ROOM_STANDART_FOUR_STAR;
            case 3:
                System.out.println("3 Star selected");
                return HouseConstant.ROOM_STANDART_THREE_STAR;
            case 4:
                System.out.println("3 Star selected");
                return HouseConstant.ROOM_STANDART_TWO_STAR;
            case 5:
                System.out.println("3 Star selected");
                return HouseConstant.ROOM_STANDART_ONE_STAR;
            default:
                System.err.println("5 star selected by default");
                return HouseConstant.ROOM_STANDART_FIVE_STAR;
        }
    }

    @Override
    public void show(List<House> houses) {
        if (houses.isEmpty()) {
            System.out.println("This service is empty");
        } else {
            for (House house : houses) {
                house.toString();

            }
        }
    }

    /**
     * Lấy data từ database lên
     * nếu không có data đã lưu truoc đó
     * thì tạo một list rỗng
     *
     * @param house
     * @return
     */
    @Override
    public House save(House house) throws Exception {
        HouseService houseService = new HouseServiceImpl();
        List<String> houses = houseService.getHouse();
        /*** nếu thêm validate* nhập vào trùng ==> báo lỗi*/
        GenericValidation validation = new HouseValidation();
        validation.validate(house);
        if (houses.isEmpty()){
            houses = new ArrayList<String>();
            houses.add(HouseConstant.HOUSE_HEADER);
            houses.add(CSVConstant.NEW_LINE_SEPARATOR);
        }

        houses.add(house.toString());
        FileUtils.write(houses, new File(HouseConstant.HOUSE_FILE_PATH));
        System.out.println("Add New House Succeed!!!");
        return house;
    }

}
