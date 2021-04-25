package Services;

import models.House;
import models.Room;

import java.util.List;
import java.util.Set;

public interface RoomService extends GenericService<Room> {
    /**
     * Lấy distinct các id trong database
     * @param rooms
     * @return
     */
    public Set<String> getNames (List<Room> rooms);

    /**
     * Convert list room dạng raw text List<String>
     * "1, name, maxsize"
     * "2, name, maxsize"
     * sang một list các object dạng List<House>
     * House(1, name, maxsize)
     * House(2, name, maxsize)
     *
     * @param roomsStr
     * @return
     */
    public List<Room> getRoomFromRawRoom(List<String> roomsStr);

    /**
     * Lấy toàn bộ room từ database dạng
     *  "1, name, maxsize"
     *  "2, name, maxsize"
     * @return
     */
    public  List<String> getRoom();

    public void showDistinctName(List<Room> rooms);

    public void showAllRoom();
}
