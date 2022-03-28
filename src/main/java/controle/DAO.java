package controle;

import java.util.List;

public interface DAO<T> {

    void insert(T element);

    boolean update(T element);

    boolean delete(T element);

    T getById(int id, Class<T> tClass);

    List<T> getAll(Class<T> tClass);
}
