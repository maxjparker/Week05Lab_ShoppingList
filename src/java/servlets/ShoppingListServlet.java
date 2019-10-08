/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 657306
 */
@WebServlet(name = "ShoppingListServlet", urlPatterns = {"/ShoppingList"})
public class ShoppingListServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        switch (action)
        {
            case "register":
                request.setAttribute("sysMsg", "Action = register!");
                break;
            case "add":
                request.setAttribute("sysMSg", "Action = add!");
                break;
            case "delete":
                request.setAttribute("sysMSg", "Action = delete!");
                break;
            case "logout":
                request.setAttribute("sysMSg", "Action = logout!");
                break;
            default:
                request.setAttribute("sysMsg", "Action = unknown :(");
                break;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
}