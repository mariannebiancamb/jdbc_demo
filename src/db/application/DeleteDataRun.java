package db.application;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteDataRun {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("delete from department where Id = ?" );

            st.setInt(1, 2);

            int rownsAffected = st.executeUpdate();
            System.out.println("Done!");

        } catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
