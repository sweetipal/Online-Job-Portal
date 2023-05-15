package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAo;

@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			JobDAo dao = new JobDAo(DBConnect.getConn());
			boolean f = dao.deleteJobs(id);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Job delete Successfully..");
				resp.sendRedirect("view_jobs.jsp");
			} else {
				session.setAttribute("succMsg", "Somthing wrong on server..");
				resp.sendRedirect("view_jobs.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
