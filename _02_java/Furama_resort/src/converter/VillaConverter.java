package converter;

import models.Villa;

public class VillaConverter {
    public Villa convert(String villaStr){
        Villa villa = new Villa();
        String [] cols = villaStr.split(",");
        villa.setId(String.valueOf(cols[0]));
        villa.setNameServices(String.valueOf(cols[1]));
        villa.setArea(Integer.parseInt(cols[2]));
        villa.setCost(Integer.parseInt(cols[3]));
        villa.setMaxPerson(Integer.parseInt(cols[4]));
        villa.setType(String.valueOf(cols[5]));
        villa.setRoomStandart(cols[6]);
        villa.setDescription(cols[7]);
        villa.setPoolArea(Integer.parseInt(cols[8]));
        villa.setNumberOfFloors(Integer.parseInt(cols[9]));

        return villa;
    }
}
