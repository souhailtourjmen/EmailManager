package com.example.emailmanager.Validation;

import com.example.emailmanager.DAO.Dbconnect;

import java.util.regex.Pattern;

public class Checkmail {
    private String Msg ="";
    String email = "";
    Dbconnect dbconnect;
    public Checkmail() {

    }


    public boolean resulttest(String email){
    String regexPattern="";
        if(email.equals("")){
        setMsg("<h1 class='warning'>Please fill in your email address</h1>");
        }
        regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
      return  patternMatches(email, regexPattern);
    }
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    /**
     * get field
     *
     * @return Msg
     */
    public String getMsg() {
        return this.Msg;
    }

    /**
     * set field
     *
     * @param Msg
     */
    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    /**
     * get field
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set field
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
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

