package com.example.emailmanager.traitment;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;


public class GetfileList {
    final String path = "E:\\LCS3\\JEE\\EmailManager\\src\\main\\resources\\file";
    private ArrayList<String> list = new ArrayList<>();

    public void getboitsmail() throws Exception {

        try {
            // Le fichier d'entrée
            File file = new File(path);
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // ajoute la ligne au buffer
              if(!line.equals("")) {
                  list.add(line);
                  list.add("\n");
              }
            }
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String addmail(String str) {
        list.add(str);
        return writefile();
    }
    public void espace_remove() {
        boolean isRemoved = false;
        for (String s : list) {
                isRemoved = list.remove("\n");
                writefile();
        }


    }
    public String search_and_remove(String str) {
        boolean isRemoved = false;
        for (String s : list) {
            if (s.equals(str)) {
                isRemoved = list.remove(str);
                writefile();
            }
        }
        if (isRemoved) {
            return "your email is removed";
        } else {
            return "your email not exist in the list";
        }

    }

    public String writefile() {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : list) {

                bw.write(s);
                bw.write("\n");
            }
            bw.close();
            return ("Successfully add to the mail.");
        } catch (IOException e) {
            return ("An error occurred.");
        }
    }

    public ArrayList<String> getList() {
        return list;
    }

}
