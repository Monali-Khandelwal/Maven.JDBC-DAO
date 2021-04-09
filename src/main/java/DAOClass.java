import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.*;
import java.util.List;

public class DAOClass <T>implements DAO <T>{

   Statement stm;

    public DAOClass(Statement stm) {
        this.stm = stm;
    }


    public T findById(int id) throws SQLException {
        ResultSet rs = stm.executeQuery("select * from car where ID =" + id);
        //rs.first();
        while (rs.next()) {
            System.out.println(rs.getString("MAKE"));
            System.out.println(rs.getString("MODEL"));
        }
        System.out.println();
        return null;
    }

    public List findAll() throws SQLException{
        ResultSet rs = stm.executeQuery("select * from car");
        //rs.first();
        while (rs.next()) {
            System.out.println(rs.getInt("ID"));
            System.out.println(rs.getString("MAKE"));
            System.out.println(rs.getString("MODEL"));
            System.out.println(rs.getInt("YEAR"));
            System.out.println(rs.getString("COLOR"));
            System.out.println(rs.getString("VIN"));

        }
        return null;
    }

    public T update(T dto) {
        Connection connection = Runner.getConnection();
        try {
            PreparedStatement pStmt = connection.prepareStatement("UPDATE car SET MODEL = 'Cherokee' WHERE ID = 102");
            pStmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public T create(T dto) {
        Connection connection = Runner.getConnection();
        System.out.println("Creating new record");
        try {
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO car VALUES  ('107', 'BMW', 'X61', '2020', 'White', '1HGBH41JXNG876555')");
//            pStmt.setInt(1, 106);
//            pStmt.setString(2, "BMW");
//            pStmt.setString(3, "X60");
            pStmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        Connection connection = Runner.getConnection();
        try {
            Statement stm = connection.createStatement();
            int i = stm.executeUpdate("DELETE from car WHERE ID =" + id);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
