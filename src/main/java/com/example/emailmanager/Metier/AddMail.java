package com.example.emailmanager.Metier;
import com.example.emailmanager.DAO.Dbconnect;
import com.example.emailmanager.modele.Email;

import java.sql.SQLException;



public class AddMail {
    Dbconnect dbconnect;
    Email email;
    public AddMail(String mail) throws SQLException, ClassNotFoundException {
        setDbconnect(new Dbconnect());
        setEmail(new Email(mail));
        inserMail ();
    }

    public void inserMail () throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO `email`(`Id`, `Email`) VALUES ('"+email.getId()+"','"+email.getEmail()+"')";
        dbconnect.Ins_Upd_Del(sql);
    }

    /**
     * set field
     *
     * @param email
     */
    public void setEmail(Email email) {
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
}
