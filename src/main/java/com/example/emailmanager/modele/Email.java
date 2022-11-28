package com.example.emailmanager.modele;

import com.example.emailmanager.Metier.RandomGeneratorteString;

public class Email {
    private String id ;
    private String email ;


    public Email( String email) {
        RandomGeneratorteString gs = new RandomGeneratorteString();
        setId(gs.getStringgeneratorte());
        setEmail(email);
    }


    /**
     * get field
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * set field
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
}
