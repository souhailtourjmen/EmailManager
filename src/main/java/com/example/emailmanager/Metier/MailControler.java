package com.example.emailmanager.Metier;
import com.example.emailmanager.DAO.Dbconnect;
import com.example.emailmanager.Model.Email;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MailControler {
    Dbconnect dbconnect;
    Email email;
    private ArrayList<String> emailList = new ArrayList();

    public MailControler() throws SQLException, ClassNotFoundException {
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
    public Email getmail (String mail) throws SQLException, ClassNotFoundException {

        ArrayList<String> list =new ArrayList();
        String req ="SELECT * FROM `email`  WHERE `Email`="+mail+";";
        ResultSet rs =dbconnect.select(req);
        while (rs.next()){
            this.email.setId(rs.getString(1));
            this.email.setEmail(rs.getString(2));
        }
        return this.email;
    }


    public int updatemail (String mail) throws SQLException, ClassNotFoundException {
        setEmail(mail);
        if(dbconnect.exist("SELECT * FROM `email` WHERE `Email`='"+mail+"'; ") ==1 ){
            String sql ="UPDATE `email` SET `Id`='"+email.getId()+"',`Email`='"+email.getEmail()+"' WHERE `Email`="+email.getEmail()+";";
            dbconnect.Ins_Upd_Del(sql);
        }
        else {
            return 0 ;
        }
       return 1;
    }
    public int  insertemail (String mail) throws SQLException, ClassNotFoundException {
        setEmail(mail);
        if(dbconnect.exist("SELECT * FROM `email` WHERE `Email`='"+mail+"'; ") ==0 ){
            String sql ="INSERT INTO `email`(`Id`, `Email`) VALUES ('"+email.getId()+"','"+email.getEmail()+"')";
            System.err.println(sql);
            dbconnect.Ins_Upd_Del(sql);
        }
        else {
            return 0 ;
        }
        return 1;
    }
    public int deleteemail (String mail) throws SQLException, ClassNotFoundException {
        setEmail(mail);
        if(dbconnect.exist("SELECT * FROM `email` WHERE `Email`='"+mail+"'; ") ==1 ){
            String sql ="DELETE FROM `email` WHERE `Email`='"+email.getEmail()+"';";

            dbconnect.Ins_Upd_Del(sql);
        }
        else {
            return 0 ;
        }
        return 1;
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
     * set field
     *
     * @param email
     */
    public void setEmail(String mail) {
        Email email =new Email(mail);
        this.email = email;
    }

    /**
     * set field
     *
     * @param dbconnect
     */
    public void setDbconnect(Dbconnect dbconnect) {
        this.dbconnect = dbconnect;
    }

    /**
     * get field
     *
     * @return email
     */
    public Email getEmail() {
        return this.email;
    }
}
