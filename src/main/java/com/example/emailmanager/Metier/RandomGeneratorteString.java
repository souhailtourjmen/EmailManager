package com.example.emailmanager.Metier;

import java.util.Random;

public class RandomGeneratorteString{

    private String  stringgeneratorte;


    public RandomGeneratorteString() {
        setStringgeneratorte(generator());
    }

    /**
     * methode concate une chaine selon le chois des carecteres
     */
    public String  generator() {
        String CH="";
        CH+=randomGenerator(65,90,3); /* return chaine contient  A jus qua Z */
        CH+=randomGenerator(48,57,2);  /* return chaine numerique */
        CH+=randomGenerator(60,64,2);  /* return chaine carecere sepeciaux */
        CH+=randomGenerator(97,122,3);  /* return chaine contient alphabetique minuscule  */
        return CH;
    }
    /**
     * methode Générer une chaîne délimitée aléatoire
     */
    public  String randomGenerator(int leftLimit, int rightLimit, int targetStringLength) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }


    /**
     * get field
     *
     * @return stringgeneratorte
     */
    public String getStringgeneratorte() {
        return this.stringgeneratorte;
    }

    /**
     * set field
     *
     * @param stringgeneratorte
     */
    public void setStringgeneratorte(String stringgeneratorte) {
        this.stringgeneratorte = stringgeneratorte;
    }
}


