package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.AccountBeans;

/**
 * Servlet implementation class AccountDAO2
 */
@WebServlet("/AccountSearch")
public class AccountSearch extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountSearch() {
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
        // TODO Auto-generated method stub
        String loginId = request.getParameter("loginId");
        String pass = request.getParameter("pass");

        // login.jspから受け取ったログインIDとpassをビーンズにセット
        AccountBeans ab = new AccountBeans();
        ab.setLoginId(loginId);
        ab.setPass(pass);

        // アカウントの有無を検索
        // 検索したアカウント情報を取得
        AccountDAO ad = new AccountDAO();
        AccountBeans returnAb = ad.findAccount(ab);

        if(returnAb != null) {
            // セッションにアカウント情報＆ロールを登録
            HttpSession session = request.getSession();
            session.setAttribute("account", returnAb);

            RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
            rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}