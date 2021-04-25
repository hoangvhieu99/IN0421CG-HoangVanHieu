package converter;

import models.House;

public class HouseConverter {
    public House convert(String houseStr){
        if (houseStr.isEmpty() || houseStr.isBlank()){
            return null;
        }
        House house = new House();
        String [] cols = houseStr.split(",");
        house.setId(String.valueOf(cols[0]));
        house.setNameServices(String.valueOf(cols[1]));
        house.setArea(Integer.parseInt(cols[2]));
        house.setCost(Integer.parseInt(cols[3]));
        house.setMaxPerson(Integer.parseInt(cols[4]));
        house.setType(String.valueOf(cols[5]));
        house.setRoomStandart(cols[6]);
        house.setDescription(cols[7]);
        house.setNumberOfFloors(Integer.parseInt(cols[8]));
        //tương tự các trường theo header
        // cái đó là xét ở giá trị id thứ 1 ànghe
        //lúc mi đọc từ file lên nó sẽ dạng như này
        //"1, "tên house","
        //nguyên cục đó là một chuỗi
        //giờ tách nó ra để gán đô lại một object java
        //hiểu mà gán vô để so sánh à?
        //để mình qua validate mình lấy ra được
        //ví dụ
        //trong db giờ đang có
        ////"1, "tên house","
        //"2, "tên house","
        //là 2 chuỗi string
        //cái cần là 2 object
        //để house.getId() thì nó trả ra 1 và 2

        return house;
    }
}
