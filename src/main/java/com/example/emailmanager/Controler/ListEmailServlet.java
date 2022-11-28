package com.example.emailmanager.Controler;

import com.example.emailmanager.Metier.GetfileList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListEmailServlet", value = "/ListEmailServlet")
public class ListEmailServlet extends HttpServlet {
    GetfileList emlist = new GetfileList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getmails(emlist, request);
        this.getServletContext().getRequestDispatcher("/WEB-INF/layout/ListEmail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("email").equals("")){
            request.setAttribute("msg", "<h1 class='warning'>Please fill in your email address</h1>");
        }else{
            if (request.getParameter("sb").equals("subscribe")) {
                subscribe(emlist, request);
            } else if (request.getParameter("sb").equals("unsubscribe")) {
                unsubscribe(emlist, request);
                request.setAttribute("msg", "<h1 class='success'>your email is removed</h1>");
            }
            try {
                request.setAttribute("emlist", emlist.getList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        this.getServletContext().getRequestDispatcher("/WEB-INF/layout/ListEmail.jsp").forward(request, response);

    }


    public void getmails(GetfileList emlist, HttpServletRequest request) {
        try {
            emlist.getboitsmail();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            request.setAttribute("emlist",emlist.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void subscribe(GetfileList emlist, HttpServletRequest request) {
        try {
            request.setAttribute("msg", "<h1 class='success'>"+emlist.addmail(request.getParameter("email"))+"</h1>");
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    public void unsubscribe(GetfileList emlist, HttpServletRequest request) {
        try {
            request.setAttribute("msg", "<h1 class='success'>"+emlist.search_and_remove(request.getParameter("email"))+"</h1>");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

