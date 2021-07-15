import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddDataRun {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null; // monta o comando SQL para ser executado
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "insert into seller" + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                            + "VALUES"
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Maria Melo");
            st.setString(2, "maria@email.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/01/1996").getTime()));
            st.setDouble(4, 300.00);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done! The id is: " + id);
                }
            } else {
                System.out.println("No rown affected!");
            }


        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();

        }
    }
}
