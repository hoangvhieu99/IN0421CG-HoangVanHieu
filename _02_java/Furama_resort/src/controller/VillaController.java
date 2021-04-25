package controller;


import Services.VillaService;
import Services.VillaServiceImpl;
import models.Villa;
import java.util.List;


public class VillaController {
    private VillaService villaService = new VillaServiceImpl();

    List<String> rows = villaService.getVilla();
    List<Villa> villas = villaService.getVillaFromRawVilla(rows);

    public void showAllVilla() {
        villaService.showAllVilla();
    }

    public void showDistinctVillaName(){
        villaService.showDistinctName(villas);
    }

    public void add() {
        try {
            villaService.save(villaService.add());
            System.out.println("Add New Villa Succeed!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
