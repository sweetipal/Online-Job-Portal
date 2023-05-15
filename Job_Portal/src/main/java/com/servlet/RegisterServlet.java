package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.UserDAo;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			String name = req.getParameter("name");
			String qua = req.getParameter("em");
			String email = req.getParameter("ps");
			String ps = req.getParameter("qua");
			UserDAo dao = new UserDAo(DBConnect.getConn());

			User u = new User(name, email, ps, qua, "User");
			HttpSession session = req.getSession();

			boolean f = dao.addUser(u);
			if (f) {
				session.setAttribute("succMsg", "Registration Successfully..");
				resp.sendRedirect("signup.jsp");
			} else {
				session.setAttribute("succMsg", "Somthing wrong on server..");
				resp.sendRedirect("signup.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
