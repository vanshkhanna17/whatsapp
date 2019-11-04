package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
import model.Utility;

/**
 * Servlet implementation class Account
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("uname");
		String password= request.getParameter("password");
		try{password = Utility.hashPassword(password);}
		catch(Exception e){
			System.out.println(e.getMessage());
			}
		UserDao uDao = new UserDao();
		User u = uDao.find(email);
//		System.out.println(password);
//		System.out.println(u.getPassword());
//	
//		System.out.println(u.getPassword().equals(password));
		if(u.getPassword().equals(password)) {
			request.getSession().setAttribute("user", u);
			response.sendRedirect("afterlogin.jsp");
		}
		else {
			request.setAttribute("wrongpasss", true);
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}
	}

}
