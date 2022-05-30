package com.example.ass.controller;

import com.example.ass.dao.ManagerDao;
import com.example.ass.model.Manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersion = 1;

    private ManagerDao dao;

    public void init(){
        ManagerDao ManagerDao = new ManagerDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);

                case "/insert":
                    insertManager(request, response);
                case ".delete":
                    deleteManager(request, response);
                case "/edit":
                    editManager(request, response);
                    break;
                case "/update":
                    updateManager(request, response);
                    break;
                default:
                    listManager(request, response);
                    break;
            }
        }catch (SQLException e){
            throw new ServletException();
        }
    }

    private void listManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException{
        List<Manager> list = ManagerDao.getAllManager();
        request.setAttribute("manager", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("formlist.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home2.jsp");
        dispatcher.forward(request, response);
    }

    private void editManager(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List existingManager = ManagerDao.getManagerId(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home2.jsp");
        request.setAttribute("manager", existingManager);
        dispatcher.forward(request, response);
    }

    private void insertManager(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Manager manager = new Manager(name, email, address, phone);
        ManagerDao.insertManager(manager);
        response.sendRedirect("list");
    }

    private void updateManager(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        Manager manager = new Manager();
        ManagerDao.updateManager(manager);
        response.sendRedirect("list");
    }

    private void deleteManager(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ManagerDao.deleteManager(id);
        response.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
