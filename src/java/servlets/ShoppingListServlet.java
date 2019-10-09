/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
            case "landing": // welcome page
                req.setAttribute("message", "Welcome! Please enter a username.");
                url = "/WEB-INF/register.jsp";
                break;
                
            case "register":
                String username = req.getParameter("username");
                session.setAttribute("username", username);

                url = "/WEB-INF/shoppingList.jsp";
                break;
                
            case "add":
                req.setAttribute("message", "Add"); // test
                
                // singleton arraylist
                ArrayList<String> items = 
                        (ArrayList<String>) session.getAttribute("items");
                if (items == null)
                {
                    items = new ArrayList<>();
                }
                        
                String item = req.getParameter("item");
                items.add(item);
                
                session.setAttribute("items", items);
                
                url = "/WEB-INF/shoppingList.jsp";
                break;
                
            case "delete":
                req.setAttribute("message", "Delete"); // test
                
                
                
                url = "/WEB-INF/shoppingList.jsp";
                break;
                
            case "logout":
                req.setAttribute("message", "Logout successful."); // test
                
                session.invalidate();
                
                url = "/WEB-INF/register.jsp";
                break; 
                
            default: // should never happen
                req.setAttribute("message", "ERROR");
                url = "/WEB-INF/register.jsp";
                break;
        }
        
        context.getRequestDispatcher(url).forward(req, res);
    }
}