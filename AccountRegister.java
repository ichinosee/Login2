package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.dao.AccountRegisterDAO;
import la.bean.AccountBeans;

/**
 * Servlet implementation class AccountRegister
 */
@WebServlet("/AccountRegister")
public class AccountRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String loginId = request.getParameter("loginId");
        String pass = request.getParameter("pass");
        int role = Integer.parseInt(request.getParameter("role"));

        // register.jspから受け取った値をビーンズにセット
        AccountBeans ab = new AccountBeans();
        ab.setName(name);
        ab.setLoginId(loginId);
        ab.setPass(pass);
        ab.setRole(role);

        // アカウントをDBに登録
        AccountRegisterDAO ard = new AccountRegisterDAO(ab);

        // セッションにアカウント情報を保存
        HttpSession session = request.getSession();
        session.setAttribute("account", ab);

        RequestDispatcher rd = request.getRequestDispatcher("registerSuccess.jsp");
        rd.forward(request, response);

    }

}
