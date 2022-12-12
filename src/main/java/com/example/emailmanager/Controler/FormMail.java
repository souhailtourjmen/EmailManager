package com.example.emailmanager.Controler;

import com.example.emailmanager.Metier.MailControler;

import com.example.emailmanager.Validation.Checkmail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.sql.SQLException;

@WebServlet(name = "FormMail", value = "/FormMail")
public class FormMail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getmails(request);

        this.getServletContext().getRequestDispatcher("/WEB-INF/layout/FormMail.jsp").forward(request, response);
       
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Aucune addresse email specifiée.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("sb").equals("subscribe")) {
            subscribe( request);
        } else if (request.getParameter("sb").equals("unsubscribe")) {
            unsubscribe( request);

        }
        getmails(request);
        this.getServletContext().getRequestDispatcher("/WEB-INF/layout/FormMail.jsp").forward(request, response);
    }











    public void getmails( HttpServletRequest request) {
        try {

                MailControler mail = new MailControler();
                mail.getlistmail();
                request.setAttribute("emlist", mail.getEmailList());
            }catch (Exception e) {
                e.printStackTrace();
            }

    }
    public void subscribe(HttpServletRequest request) {
        Checkmail checkmail =new Checkmail();
        if(!checkmail.resulttest(request.getParameter("email"))){
            request.setAttribute("alert", "<div class='alert danger'>Successfully add to the mail "+request.getParameter("email")+"</div>");
        }else{
            MailControler mail = null;
            try {
                mail = new MailControler();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                mail.insertemail(request.getParameter("email"));
                request.setAttribute("msg", "<h1 class='success'>Successfully add to the mail "+request.getParameter("email")+"</h1>");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
    public void unsubscribe( HttpServletRequest request) {
        try {
            Checkmail checkmail =new Checkmail();
            if(!checkmail.resulttest(request.getParameter("email"))){
                request.setAttribute("alert", "<div class='alert danger'>bad format "+request.getParameter("email")+"</div>");
            }else{
                MailControler mail = null;
                try {
                    mail = new MailControler();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {

                    if(mail.deleteemail(request.getParameter("email"))==1){
                        request.setAttribute("msg", "<h1 class='success'>your email is removed "+request.getParameter("email")+"</h1>");
                    }
                    else {
                        request.setAttribute("msg", "<h1 class='warning'>your email not exist in the list "+request.getParameter("email")+"</h1>");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

