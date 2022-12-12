package com.example.emailmanager.DAO;

public class Config {
    private String  HOST ;
    private int PORT ;
    private String Name_DB ; // name data base
    private String username; // identified database
    private String Password_DB ; // password data base="";


    public Config() {

        setHOST("127.0.0.1");   /* host server  data base */
        setPORT(3306);          /* port data base  */
        setName_DB("listmail");         /* name data base  */
        setUsername("root");    /* identified database */
        setPassword_DB("");      /* password data base */
    }


    /**
     * get field
     *
     * @return HOST
     */
        public String getHOST () {
            return this.HOST;
        }

        /**
         * set field
         *
         * @param HOST
         */
        public void setHOST (String HOST){
            this.HOST = HOST;
        }

        /**
         * get field
         *
         * @return PORT
         */
        public int getPORT () {
            return this.PORT;
        }

        /**
         * set field
         *
         * @param PORT
         */
        public void setPORT ( int PORT){
            this.PORT = PORT;
        }

        /**
         * get field
         *
         * @return Name_DB
         */
        public String getName_DB () {
            return this.Name_DB;
        }

        /**
         * set field
         *
         * @param Name_DB
         */
        public void setName_DB (String Name_DB){
            this.Name_DB = Name_DB;
        }

        /**
         * get field
         *
         * @return username
         */
        public String getUsername () {
            return this.username;
        }

        /**
         * set field
         *
         * @param username
         */
        public void setUsername (String username){
            this.username = username;
        }

        /**
         * get field
         *
         * @return Password_DB
         */
        public String getPassword_DB () {
            return this.Password_DB;
        }

        /**
         * set field
         *
         * @param Password_DB
         */
        public void setPassword_DB (String Password_DB){
            this.Password_DB = Password_DB;
        }

        /**
         * get field
         *
         * @return url driver data base for jdbc : mysql c'est  la data base qui on a choisir
         */
        public String getUrl () {
            return "jdbc:mysql://" + getHOST() + ":"+getPORT()+"/"+getName_DB() ;
        }


    }