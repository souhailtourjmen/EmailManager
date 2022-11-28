package com.example.emailmanager.Controler;

import com.example.emailmanager.Metier.AddMail;
import com.example.emailmanager.modele.Email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FormMail", value = "/FormMail")
public class FormMail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/layout/FormMail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AddMail mail = null;
        try {
            mail = new AddMail(request.getParameter("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/layout/FormMail.jsp").forward(request, response);
    }
}
