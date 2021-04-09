import com.mysql.cj.jdbc.CallableStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;

public class DAOClass <T>implements DAO <T>{

   Statement stm;

    public DAOClass(Statement stm) {
        this.stm = stm;
    }


    public T findById(int id) throws SQLException {
        ResultSet rs = stm.executeQuery("select * from car where ID =" + id);
        //rs.first();
        while (rs.next()) {
            System.out.println(rs.getInt("ID: " + id));
        }
        System.out.println();
        return null;
    }

    public List findAll() throws SQLException{
        ResultSet rs = stm.executeQuery("select * from car");
        //rs.first();
        while (rs.next()) {
            System.out.println(rs.getInt("ID: "));
            System.out.println(rs.getString("MAKE"));
            System.out.println(rs.getString("MODEL"));
            System.out.println(rs.getInt("YEAR"));
            System.out.println(rs.getString("COLOR"));
            System.out.println(rs.getString("VIN"));

        }
        return null;
    }

    public T update(T dto) {

        return null;
    }

    public T create(T dto) {
        return null;
    }

    public void delete(int id) {

    }
}
