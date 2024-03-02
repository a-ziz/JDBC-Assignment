import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConnectionFactory {
  private static Connection connection = null;

  private ConnectionFactory() {

  }

  public static Connection getConnection() {
    if (connection == null) {
      ResourceBundle bundle = ResourceBundle.getBundle("config");
      String url = bundle.getString("url");
      String username = bundle.getString("username");
      String password = bundle.getString("password");
      try {
        connection = DriverManager.getConnection(url, username, password);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }

    }
    return connection;
  }
}

class Main2 {
  public static void main(String[] args) {
    // not able to make multiple obj of a class
    // make connectionfactory constructor private
    // singleton design pattern - no more than 1 obj

    // multiple connection string obj
//    Connection c1 = ConnectionFactory.getConnection();
//    Connection c2 = ConnectionFactory.getConnection();
//    Connection c3 = ConnectionFactory.getConnection();
//    ConnectionFactory c2 = new ConnectionFactory();
//    ConnectionFactory c3 = new ConnectionFactory();
  }
}
