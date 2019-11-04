package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GroupDao;
import dao.UserDao;
import model.Group;
import model.Message;
import model.User;

/**
 * Servlet implementation class CreateGroup
 */
@WebServlet("/crtgrp")
public class CreateGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao uDao = new UserDao();
		List<User>users = uDao.findAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher("crtgrp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gname = request.getParameter("gname");
		String[] usl = request.getParameterValues("chk");
		List<User> ul = new ArrayList<>();
		UserDao uDao = new UserDao();
		for(String s: usl) {
			User u = uDao.findi(s);
			ul.add(u);
		}
		List<Message> ml = new ArrayList<>();
		User sessionuser = (User)request.getSession().getAttribute("user");
		String createdBy = sessionuser.getName();
		Group g = new Group(gname,createdBy,ul,ml);
		GroupDao gDao = new GroupDao();
		gDao.create(g);
		response.sendRedirect("dspgrp");
	}

}
