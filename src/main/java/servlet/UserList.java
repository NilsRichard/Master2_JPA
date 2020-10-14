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

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@WebServlet(name = "userList", urlPatterns = {"/userList"})
public class UserList extends HttpServlet {
    private UserKBDao dao;

    public UserList() {
        super();
        this.dao = new UserKBDao();
    }

    private static final long serialVersionUID = -5931952924171092053L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.print("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + "    <title>Document</title>\r\n" + "</head>\r\n" + "<body>\r\n"
                + "    <h1>Liste des utilisateurs</h1>\r\n" + "\r\n" + "    <ul>\r\n");

        for (UserKB user : dao.findAll()) {
            p.print("<li>\r\n" + "            " + user.getFirstName() + ", " + user.getLastName() + ", "
                    + user.getEmail() + "\r\n" + "        </li>");
        }

        p.print("    </ul>\r\n" + "</body>\r\n" + "</html>");

        p.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
