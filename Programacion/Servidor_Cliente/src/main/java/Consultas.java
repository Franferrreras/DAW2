import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {

    public static void main(String[] args) throws SQLException {
        Connection connection = ConexionDB.getConnection();
        System.out.println(Consultas.getEmployees("1"));

        connection.close();
    }

    public static boolean getEmployees(String officeCode) {
        Connection connection = ConexionDB.getConnection();

        try {
            String sql = "SELECT * FROM employees WHERE officeCode=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,officeCode);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int emplNumber = rs.getInt("employeeNumber");
                String lastname = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                String extsion = rs.getString("extension");
                String email = rs.getString("email");
                String offCode = rs.getString("officeCode");
                int rpTo = rs.getInt("reportsTo");
                String jbTitle = rs.getString("jobTitle");

                System.out.println("_________________________");
                System.out.println("employeeNumber: " + emplNumber);
                System.out.println("lastName: " + lastname);
                System.out.println("firstName: " + firstName);
                System.out.println("extension: " + extsion);
                System.out.println("email: "+ email);
                System.out.println("officeCode: " + offCode);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
