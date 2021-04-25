package validation;


import Services.VillaService;
import Services.VillaServiceImpl;
import models.Villa;

import java.util.List;
import java.util.Set;

public class VillaValidation implements GenericValidation<Villa> {

    @Override
    public Villa validate(Villa villa) throws Exception {
        VillaService villaService = new VillaServiceImpl();
        List<String> villaDB = villaService.getVilla();
        Set<String> names = villaService.getNames(villaService.getVillaFromRawVilla(villaDB));

        if (!villa.getId().matches("^SV+VL*-[0-9]{4}")){
            throw new Exception("ID Villa format must be SVHO-YYYY");
        }

        if (!villa.getNameServices().matches("[A-Z][a-z]+\\b")){
            throw new Exception("Name format must start with upper-case letter");
        }
        return villa;
    }

    @Override
    public boolean nameValidate(String name) {
        if(!name.matches("[A-Z][a-z]+\\b")){
            System.err.println("Name format must start with upper-case letter");
            return false;
        }
        return true;
    }

    @Override
    public boolean idValidate(String id) {
        if (!id.matches("^SV+VL*-[0-9]{4}")){
            System.err.println("ID Villa format must be SVVL-YYYY(YYYY: 0-9)");
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
