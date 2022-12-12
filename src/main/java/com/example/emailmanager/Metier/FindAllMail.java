package com.example.emailmanager.Metier;

import com.example.emailmanager.DAO.Dbconnect;
import com.example.emailmanager.Model.Email;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindAllMail {
    private ArrayList<String>emailList = new ArrayList();

    Dbconnect dbconnect;

    public FindAllMail() {
        setDbconnect(new Dbconnect());

    }

    public void getlistmail () throws SQLException, ClassNotFoundException {

        ArrayList<String> list =new ArrayList();
        String req ="SELECT * FROM `email`";
        ResultSet rs =dbconnect.select(req);
        while (rs.next()){
            Email email = new Email();
            email.setId(rs.getString(1));
            email.setEmail(rs.getString(2));
            list.add(email.getEmail());
        }
        setEmailList(list);


    }

    /**
     * get field
     *
     * @return emailList
     */
    public ArrayList<String> getEmailList() {
        return this.emailList;
    }

    /**
     * set field
     *
     * @param emailList
     */
    public void setEmailList(ArrayList<String> emailList) {
        this.emailList = emailList;
    }


    /**
     * get field
     *
     * @return dbconnect
     */
    public Dbconnect getDbconnect() {
        return this.dbconnect;
    }

    /**
     * set field
     *
     * @param dbconnect
     */
    public void setDbconnect(Dbconnect dbconnect) {
        this.dbconnect = dbconnect;
    }
}
