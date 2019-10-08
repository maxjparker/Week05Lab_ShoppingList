/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
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
@WebServlet(name = "ShoppingListServlet", urlPatterns = {"/shoppingList"})
public class ShoppingListServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doEverything(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doEverything(request, response);
    }
    
    
    
    protected void doEverything(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        
        String action = req.getParameter("action");
        if (action == null)
        { // singleton
            action = "landing";
        }
        switch (action)
        {
            case "register":
                String username = req.getParameter("username");
                session.setAttribute("username",username);
                String msg = "Session for "+username+" created.";
                req.setAttribute("sysMsg", msg);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(req, res);
                break;
            case "add":
                req.setAttribute("sysMsg", "Action = add!");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req, res);
                break;
            case "delete":
                req.setAttribute("sysMsg", "Action = delete!");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req, res);
                break;
            case "logout":
                req.setAttribute("sysMsg", "Action = logout!");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req, res);
                break;
            case "landing":
                req.setAttribute("sysMsg", "Action = homepage!");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req, res);
                break;
            default:
                req.setAttribute("sysMsg", "Action = unknown :(");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req, res);
                break;
        }
    }
}