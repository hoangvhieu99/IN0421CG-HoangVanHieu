package Services;

import java.util.List;

public interface GenericService<T> {
    public T add() throws Exception;

    public void show(List<T> items);

    public T save(T t) throws Exception;
}
