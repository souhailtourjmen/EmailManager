package com.example.emailmanager.Model;

public class Mail {
    private String objet;
    private String Body;
    private String Email;


    public Mail(String objet, String body, String email) {
        setObjet(objet);
        setBody(body);
        setEmail(email);
    }


    /**
     * get field
     *
     * @return objet
     */
    public String getObjet() {
        return this.objet;
    }

    /**
     * set field
     *
     * @param objet
     */
    public void setObjet(String objet) {
        this.objet = objet;
    }

    /**
     * get field
     *
     * @return Body
     */
    public String getBody() {
        return this.Body;
    }

    /**
     * set field
     *
     * @param Body
     */
    public void setBody(String Body) {
        this.Body = Body;
    }

    /**
     * get field
     *
     * @return Email
     */
    public String getEmail() {
        return this.Email;
    }

    /**
     * set field
     *
     * @param Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
}
