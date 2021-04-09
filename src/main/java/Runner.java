import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {

    static String username = "Monali";
    static String password = "Monali";
    static String dbUrl = "jdbc:mysql://localhost:3306/NewDB";
    //static Logger demoLog = Logger.getLogger("demoJDBC");

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }


    public static void main(String[] args) {
        Connection connection = Runner.getConnection();
        try {
            System.out.println("SQL Connection to database established!");
            Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            DAOClass dao = new DAOClass(stm);
            System.out.println("find by id");
            dao.findById(101);
            dao.findAll();
            dao.update(102);
            dao.delete(105);
            dao.create(106);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection Failed! Check output console");
            return;
        }

    }
}








        // try catch block for Logger
//        demoLog.log(Level.INFO, "Car database");
//        System.out.println("-------- MySQL JDBC Connection Demo ------------");
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("MySQL JDBC Driver not found!!");
//            return;
//        }
//        System.out.println("MySQL JDBC Driver Registered!");


        //Try catch finally block to develop connection

//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(dbUrl, username, password);
//            System.out.println("SQL Connection to database established!");
//
//            // The function goes here!!
//           Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//           DAOClass dao = new DAOClass (stm);
//           System.out.println("find by id");
//           dao.findById(101);
//           dao.findAll();
//           dao.update()
////            System.out.println("delete");
//
//        }catch (SQLException e) {
//            System.out.println(e.getMessage());
//            System.out.println("Connection Failed! Check output console");
//            return;
//        }
//        finally {
//            try
//            {
//                if(connection != null)
//                    connection.close();
//                System.out.println("Connection closed!!");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

