package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import my.*;
import jdbc.DataInteraction;
import org.json.JSONException;

/**
 * Created by ALN on 2017/6/20.
 */
@WebServlet("/FindNotReadFriendsServlet")
public class FindNotReadFriendsServlet extends HttpServlet {
    private Account user=new Account();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("gb2312");
        PrintWriter out = response.getWriter();
        user.setAccountid(request.getParameter("accountid"));

        try{
            String findUnreadFriends = DataInteraction.findUnreadFriends(user);
            out.print(findUnreadFriends);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
