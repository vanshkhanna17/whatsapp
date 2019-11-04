package controller;

import java.io.IOException;
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
 * Servlet implementation class DisplayGroup
 */
@WebServlet("/dspgrp")
public class DisplayGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GroupDao gDao = new GroupDao();
		List<Group> groups = gDao.findAll();
		request.setAttribute("groups", groups);
		request.getRequestDispatcher("group.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gname = request.getParameter("btn");
		GroupDao gDao = new GroupDao();
		Group g = gDao.find(gname);
		List<Message> ml = g.getMl();
		request.setAttribute("grp", g);
		request.getRequestDispatcher("group.jsp").forward(request, response);
	}

}
