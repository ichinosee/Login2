package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import la.bean.AccountBeans;

public class AccountRegisterDAO {
    // データベース接続に使用する情報
        Class.forName("org.postgresql.Driver");
			String url = "*********";
			String user = "********";
			String pass = "*******";
			//データベースの接続
			con = DriverManager.getConnection(url, user, pass);

    public  AccountRegisterDAO(AccountBeans ab) {

        try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {

            String sql = "INSERT INTO account (loginId, pass, name, roleId) VALUES (?, ?, ?, ?)";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, ab.getLoginId());
            ps.setString(2, ab.getPass());
            ps.setString(3, ab.getName());
            ps.setInt(4, ab.getRole());

            int r = ps.executeUpdate();

            if(r != 0) {
                System.out.println("新規登録成功！");
            } else {
                System.out.println("新規登録失敗( ﾉД`)ｼｸｼｸ…");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
