package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserKBDao;
import domain.UserKB;

@WebServlet(name = "useradd", urlPatterns = { "/userAdd" })
public class UserAdd extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1483384336025226873L;
	
	private UserKBDao dao;

	public UserAdd() {
		super();
		this.dao = new UserKBDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		UserKB newUser = new UserKB(request.getParameter("firstname"), request.getParameter("lastname"),
				request.getParameter("email"));
		
		dao.save(newUser);

		PrintWriter out = response.getWriter();

		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>firstname: "
				+ newUser.getFirstName() + "\n" + " <LI>Lastname: " + newUser.getLastName() + "\n" + " <LI>Email: "
				+ newUser.getEmail() + "\n" + "</UL>\n" + "</BODY></HTML>");

		out.flush();
	}
}
