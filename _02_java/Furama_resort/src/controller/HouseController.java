package controller;

import Services.HouseService;
import Services.HouseServiceImpl;
import constants.HouseConstant;
import models.House;
import utils.ScannerSingeton;

import java.util.List;


public class HouseController {

    private HouseService houseService = new HouseServiceImpl();

    List<String> rows = houseService.getHouse();
    List<House> houses = houseService.getHouseFromRawHouse(rows);

    public void showAllHouse() {
        houseService.showAllHouse();
    }

    public void showDistinctHouseName(){
        houseService.showDistinctName(houses);
    }

    public void add() throws Exception {
        houseService.save(houseService.add());
    }
}
