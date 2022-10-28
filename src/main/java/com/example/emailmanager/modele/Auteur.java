package com.example.emailmanager.modele;

public class Auteur {
    private String Nom;
    private String Prenom;
    private String Email;

    public Auteur(String nom, String prenom, String email) {
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
    }

    /**
     * get field
     *
     * @return Nom
     */
    public String getNom() {
        return this.Nom;
    }

    /**
     * set field
     *
     * @param Nom
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * get field
     *
     * @return Prenom
     */
    public String getPrenom() {
        return this.Prenom;
    }

    /**
     * set field
     *
     * @param Prenom
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
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
