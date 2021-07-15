package db.application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataRun {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false); //so autoriza a acao no banco quando fizer o commit

            st = conn.prepareStatement("update seller set BaseSalary = BaseSalary + ?"
                            + "where (DepartmentId = ?)");

            //simulando uma exception falsa
            int x = 1;
            //if(x < 2) throw new SQLException("Fake error!");

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rownsAffected = st.executeUpdate();

            conn.commit(); //permite salvar no banco

            System.out.println("Done!");

        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException(e.getMessage());
            } catch (SQLException e1 ) {
                throw new DbIntegrityException(e.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
