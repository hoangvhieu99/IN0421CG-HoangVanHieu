package validation;

import Services.HouseService;
import Services.HouseServiceImpl;
import models.House;

import java.util.List;
import java.util.Set;

public class HouseValidation implements GenericValidation<House>{

    @Override
    public House validate(House house) throws Exception {
        HouseService houseService = new HouseServiceImpl();
        List<String> houseDB = houseService.getHouse();
        Set<String> names = houseService.getNames(houseService.getHouseFromRawHouse(houseDB));
//        if (names.contains(house.getNameServices())){
//            throw new Exception("Name đã tồn tại!");
//        }
        if (!house.getId().matches("^SV+HO*-[0-9]{4}")){
            throw new Exception("ID House format must be SVHO-YYYY");
        }

        if (!house.getNameServices().matches("[A-Z][a-z]+\\b")){
            throw new Exception("Name format must start with upper-case letter");
        }

        //tiếp tục validate các trường khác
        return house;
    }

    @Override
    public boolean nameValidate(String name){
        if (!name.matches("[A-Z][a-z]+\\b")){
            System.err.println("Name format must start with upper-case letter");
            return false;
        }
        return true;
    }

    @Override
    public boolean idValidate(String id){
        if (!id.matches("^SV+HO*-[0-9]{4}")){
            System.err.println("ID House format must be SVHO-YYYY(YYYY: 0-9)");
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
            System.err.println("Cost must be > 0");
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
        if(numberOfFloors<=0){
            System.err.println("Number Of Floors  must be > 0");
            return false;
        }
        return true;
    }


}
