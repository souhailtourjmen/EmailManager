package com.example.emailmanager.DAO;

import java.sql.*;

public class Dbconnect {
    Connection connection;
    Statement statement;
    Config param;

    public Dbconnect() {
        setParam(new Config());
    }

    /**
     * le methode c'est dessous c'est une methode de connection  a notre base de donne
     */

    public void connexionDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(param.getUrl(), param.getUsername(), param.getPassword_DB());
            System.out.println("connection valide");
        } catch (Exception e) {
            System.err.println(e);//
        }

    }


    public void closeconnexion() {

        try {
            connection.close();
        } catch (Exception e) {
            System.err.println(e);//
        }

    }

    public ResultSet select(String request) throws ClassNotFoundException, SQLException, SQLException {
        ResultSet rs = null;
        connexionDatabase();
        statement = connection.createStatement();
        return rs = statement.executeQuery(request);


    }
    public int exist(String request) throws ClassNotFoundException, SQLException, SQLException {
        ResultSet rs = null;
        int count =0;

        connexionDatabase();
        statement = connection.createStatement();
        rs = statement.executeQuery(request);
        while (rs.next()) {
            count++;
        }
        System.err.println(count);
        return count;
    }
    public int Ins_Upd_Del(String req) throws SQLException, ClassNotFoundException {
        int rs = 0;
        try {
            connexionDatabase();
            statement = connection.createStatement();
            rs = statement.executeUpdate(req);
            closeconnexion();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }


    /**
     * set field
     *
     * @param param
     */
    public void setParam(Config param) {
        this.param = param;
    }
}

