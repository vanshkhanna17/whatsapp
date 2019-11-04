package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.Message;
import model.User;
import model.Utility;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String uname=fname+" "+lname;
		String email = request.getParameter("uname");
		String password= request.getParameter("password");
		List<Message> ml = new ArrayList<Message>();
		try{password = Utility.hashPassword(password);}
		catch(Exception e){
			System.out.println(e.getMessage());
			}
		User u =new User(uname,email,password,ml);
		UserDao uDao = new UserDao();
		uDao.create(u);
		request.getSession().setAttribute("user", u);
		response.sendRedirect("afterlogin.jsp");
	}

}
