package reservah.dao;

import java.util.List;

public interface EntityDao <T> {
    
    public List<T> findAll();

    public void create(T obj);

    public void update(T obj);

    public void delete(T obj);

    public List<T> findByParameter(String parametro);
}
