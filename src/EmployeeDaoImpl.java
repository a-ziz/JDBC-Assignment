import com.mysql.cj.xdevapi.SelectStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

  Connection connection;

  public EmployeeDaoImpl(){
    connection = ConnectionFactory.getConnection();
  }

  @Override
  public void addEmployee(Employee employee) throws SQLException {
    String sql = "INSERT into employee (name, email) values (?, ?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, employee.getName());
    preparedStatement.setString(2, employee.getEmail());
    int count = preparedStatement.executeUpdate();

    if (count > 0)
      System.out.println("Employee saved.");
    else
      System.out.println("Oops! Something went wrong, please try again.");
  }

  @Override
  public void updateEmployee(Employee employee) throws SQLException {
    String sql = "UPDATE employee " +
            "SET name=?, email=? WHERE id=?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, employee.getName());
    preparedStatement.setString(2, employee.getEmail());
    preparedStatement.setInt(3, employee.getId());
    int count = preparedStatement.executeUpdate();

    if (count > 0)
      System.out.println("Rows affected: " + count);
    else
      System.out.println("Oops! Something went wrong, please try again.");
  }

  @Override
  public void deleteEmployee(int id) throws SQLException {
    String sql = "DELETE from employee where id=(?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, id);
    int count = preparedStatement.executeUpdate();

    if (count > 0)
      System.out.println("Rows affected: " + count);
    else
      System.out.println("Oops! Something went wrong, please try again.");
  }

  @Override
  public List<Employee> getEmployee() throws SQLException {

    List<Employee> employees = new ArrayList<>();
    Statement st = connection.createStatement();
    String sql = "SELECT * from employee";
    ResultSet rs = st.executeQuery(sql);

    while (rs.next()){
//      String col1 = rs.getString("id");
//      String col2 = rs.getString("name");
//      String col3 = rs.getString("email");
//      System.out.println(col1 + "\t" + col2 + "\t" + col3);
      int id = rs.getInt("id");
      String name = rs.getString("name");
      String email = rs.getString("email");
      Employee employee = new Employee(id, name, email);
      employees.add(employee);
    }
    return employees;
  }

  @Override
  public Employee getEmployeeId(int id) throws SQLException {
    Employee employee = null;

    String sql = "SELECT * from employee where id=?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, id);
    ResultSet rs = preparedStatement.executeQuery();

    while (rs.next()){
      employee = new Employee();
      employee.setId(rs.getInt("id"));
      employee.setName(rs.getString("name"));
      employee.setEmail(rs.getString("email"));
    }
    return employee;
  }
}
