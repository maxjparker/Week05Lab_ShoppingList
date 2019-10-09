/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletContext;
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
        
        String url = "/WEB-INF/register.jsp";
        ServletContext context = getServletContext();
        
        String action = (String) req.getParameter("action");
        if (action == null)
        {
            action = "landing";
        }
        
        if (req.getParameter("logout") != null)
        {
            action = "logout";
        }

        switch (action)
        {
            case "register":
                req.setAttribute("message", "Register");
                url = "/WEB-INF/shoppingList.jsp";
                break;
                
            case "add":
                req.setAttribute("message", "Add");
                url = "/WEB-INF/shoppingList.jsp";
                break;
                
            case "delete":
                url = "/WEB-INF/shoppingList.jsp";
                break;
                
            case "logout":
                req.setAttribute("message", "Logout");
                url = "/WEB-INF/register.jsp";
                break; 
                
            case "landing":
                req.setAttribute("message", "Landing");
                url = "/WEB-INF/register.jsp";
                break;
                
            default:
                req.setAttribute("message", "default");
                url = "/WEB-INF/register.jsp";
                break;
        }
        
        context.getRequestDispatcher(url).forward(req, res);
    }
}