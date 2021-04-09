import java.sql.SQLException;
import java.util.List;

public interface DAO <T>{

    public T findById(int id) throws SQLException;
    public List findAll() throws SQLException;
    public T update(T dto) throws SQLException;
    public T create(T dto) throws SQLException;
    public void delete(int id) throws SQLException;
}
