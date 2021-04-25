package Services;

import models.House;
import models.Villa;

import java.util.List;
import java.util.Set;

public interface VillaService extends GenericService<Villa> {
    /**
     * Lấy distinct các id trong database
     * @param villas
     * @return
     */
    public Set<String> getNames (List<Villa> villas);

    /**
     * Convert list villa dạng raw text List<String>
     * "1, name, maxsize"
     * "2, name, maxsize"
     * sang một list các object dạng List<House>
     * House(1, name, maxsize)
     * House(2, name, maxsize)
     *
     * @param villasStr
     * @return
     */
    public List<Villa> getVillaFromRawVilla(List<String> villasStr);

    /**
     * Lấy toàn bộ villa từ database dạng
     *  "1, name, maxsize"
     *  "2, name, maxsize"
     * @return
     */
    public  List<String> getVilla();

    public void showDistinctName(List<Villa> villas);

    public void showAllVilla();
}
