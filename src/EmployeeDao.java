import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
  void addEmployee(Employee employee) throws SQLException;
  void updateEmployee(Employee employee) throws SQLException;
  void deleteEmployee(int id) throws SQLException;
  List<Employee> getEmployee() throws SQLException;
  Employee getEmployeeId(int id) throws SQLException;
}
