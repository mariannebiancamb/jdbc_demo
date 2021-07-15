package db.application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataRun {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null; // monta o comando SQL para ser executado
        ResultSet rs = null; //conte o resultado da consulta em forma de tabela (relacional)

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from department");

            //o rs.nest retorna verdadeiro ate que acabe as linhas do resultSet
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "," + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }


    }

}
