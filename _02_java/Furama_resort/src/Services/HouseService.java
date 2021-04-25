package Services;

import models.House;

import java.util.List;
import java.util.Set;

public interface HouseService extends  GenericService<House> {
    /**
     * Lấy distinct các id trong database
     * @param houses
     * @return
     */
    public Set<String> getNames (List<House> houses);

    /**
     * Convert list house dạng raw text List<String>
     * "1, name, maxsize"
     * "2, name, maxsize"
     * sang một list các object dạng List<House>
     * House(1, name, maxsize)
     * House(2, name, maxsize)
     *
     * @param housesStr
     * @return
     */
    public List<House> getHouseFromRawHouse(List<String> housesStr);

    /**
     * Lấy toàn bộ house từ database dạng
     *  "1, name, maxsize"
     *  "2, name, maxsize"
     * @return
     */
    public  List<String> getHouse();

    public void showDistinctName(List<House> houses);

    public void showAllHouse();
}
