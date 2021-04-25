package Services;

import constants.CSVConstant;
import constants.HouseConstant;
import constants.VillaConstant;
import converter.VillaConverter;
import models.Villa;
import utils.FileUtils;
import utils.ScannerSingeton;
import validation.GenericValidation;
import validation.VillaValidation;

import java.io.File;
import java.util.*;

public class VillaServiceImpl implements VillaService{
    private Scanner scanner = ScannerSingeton.getInstance();

    @Override
    public Set<String> getNames(List<Villa> villas) {
        Set<String> names = new HashSet<>();
        for (Villa villa: villas) {
            names.add(villa.getNameServices());
        }
        return names;
    }

    @Override
    public List<Villa> getVillaFromRawVilla(List<String> villasStr) {
        List<Villa> result = new ArrayList<>();
        Boolean isHeader = true;
        for (String row: villasStr) {
            if (isHeader){
                isHeader = false;
                continue;
            }

            Villa villa = new VillaConverter().convert(row);
            if (villa != null)
                result.add(villa);
        }
        return result;
    }

    @Override
    public List<String> getVilla() {
        try {
            File file = new File(VillaConstant.VILLA_FILE_PATH);
            return FileUtils.read(file);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void showDistinctName(List<Villa> villas) {
        Set<String> names = this.getNames(villas);
        for (String name: names) {
            System.out.println(name);
        }
    }

    @Override
    public void showAllVilla() {
        List<String> rows = this.getVilla();
        List<Villa> villas = this.getVillaFromRawVilla(rows);
        System.out.println(VillaConstant.VILLA_HEADER);
        for (Villa villa: villas) {
            System.out.println(villa.toString());
        }
    }

    @Override
    public Villa add() {
        Villa villa = new Villa();
        GenericValidation validate= new VillaValidation();

        do {
            System.out.println("Enter ID: ");
            String id = String.valueOf(scanner.nextLine());
            if (validate.idValidate(id)){
                villa.setId(id);
                break;
            }
        }while (true);

        do {
            System.out.println("Enter Name Service: ");
            String name = String.valueOf(scanner.nextLine());
            if (validate.nameValidate(name)){
                villa.setNameServices(name);
                break;
            }
        }while (true);

        do {
            System.out.println("Area: ");
            int area = Integer.parseInt(scanner.nextLine());
            if (validate.areaValidate(area)){
                villa.setArea(area);
                break;
            }
        }while (true);

        do {
            System.out.println("Cost: ");
            int cost = Integer.parseInt(scanner.nextLine());
            if (validate.costValidate(cost)){
                villa.setCost(cost);
                break;
            }
        }while (true);

        do {
            System.out.println("Max Person: ");
            int maxPerson = Integer.parseInt(scanner.nextLine());
            if (validate.maxPersonValidate(maxPerson)){
                villa.setCost(maxPerson);
                break;
            }
        }while (true);

        System.out.println("Type: ");
        String type = String.valueOf(this.getVillaType());
        villa.setType(type);
        scanner.nextLine();

        System.out.println("Room Standart: ");
        String roomStandart = String.valueOf(this.getRoomStandart());
        villa.setType(roomStandart);
        scanner.nextLine();

        System.out.println("Description: ");
        villa.setDescription(String.valueOf(scanner.nextLine()));

        do {
            System.out.println("Pool Area: ");
            int area = Integer.parseInt(scanner.nextLine());
            if (validate.areaValidate(area)){
                villa.setPoolArea(area);
                break;
            }
        }while (true);

        do {
            System.out.println("Number Of Floor: ");
            int floors = Integer.parseInt(scanner.nextLine());
            if (validate.numberOfFloorsValidate(floors)){
                villa.setNumberOfFloors(floors);
                break;
            }
        }while (true);


        return villa;
    }

    public String getVillaType(){
        System.out.println("Select your house Type");
        System.out.println("1. Day");
        System.out.println("2. Month");
        System.out.println("3. Year");
        int choose = Integer.parseInt(String.valueOf(scanner.nextInt()));

        switch (choose){
            case 1:
                System.out.println("Type Day selected");
                return VillaConstant.TYPE_DAY;
            case 2:
                System.out.println("Type Month selected");
                return VillaConstant.TYPE_MONTH;
            case 3:
                System.out.println("Type Year selected");
                return VillaConstant.TYPE_YEAR;
            default:
                System.err.println("Type Day selected by default");
                return VillaConstant.TYPE_DAY;
        }
    }
    public String getRoomStandart(){
        System.out.println("Select your villa Room Standart");
        System.out.println("1. 5 Star");
        System.out.println("2. 4 Star");
        System.out.println("3. 3 Star");
        System.out.println("4. 2 Star");
        System.out.println("5. 1 Star");
        int choose = Integer.parseInt(String.valueOf(scanner.nextInt()));

        switch (choose){
            case 1:
                System.out.println("5 Star selected");
                return VillaConstant.ROOM_STANDART_FIVE_STAR;
            case 2:
                System.out.println("4 Star selected");
                return VillaConstant.ROOM_STANDART_FOUR_STAR;
            case 3:
                System.out.println("3 Star selected");
                return VillaConstant.ROOM_STANDART_THREE_STAR;
            case 4:
                System.out.println("3 Star selected");
                return VillaConstant.ROOM_STANDART_TWO_STAR;
            case 5:
                System.out.println("3 Star selected");
                return VillaConstant.ROOM_STANDART_ONE_STAR;
            default:
                System.err.println("5 star selected by default");
                return VillaConstant.ROOM_STANDART_FIVE_STAR;
        }
    }


    @Override
    public void show(List<Villa> villas) {
        if (villas.isEmpty()) {
            System.out.println("This service is empty");
        } else {
            for (Villa villa : villas) {
                villa.toString();

            }
        }
    }

    @Override
    public Villa save(Villa villa) throws Exception {
        VillaService villaService = new VillaServiceImpl();
        List<String> villas = villaService.getVilla();
        /**
         *
         * nếu thêm validate* nhập vào trùng ==> báo lỗi
         * */
        GenericValidation validation = (GenericValidation) new VillaValidation();
        validation.validate(villa);
        if (villas.isEmpty()){
            villas = new ArrayList<String>();
            villas.add(VillaConstant.VILLA_HEADER);
            villas.add(CSVConstant.NEW_LINE_SEPARATOR);
        }
        villas.add(villa.toString());
        FileUtils.write(villas, new File(VillaConstant.VILLA_FILE_PATH));
        System.out.println("Add New Villa Succeed!!!");
        return villa;
    }


}
