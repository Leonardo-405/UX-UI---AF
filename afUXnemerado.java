package login;  // 1

// 2
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {  // 3

    // 4
    public Connection conectarBD() {
        Connection conn = null;  
        try {
            // 5
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // 6
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            // 7
            conn = DriverManager.getConnection(url);
        } catch (Exception e) { 
            // 8
        }
        // 9
        return conn;
    }

    // 10
    public String nome = "";
    public boolean result = false;

    // 11
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";  // 12
        // 13
        Connection conn = conectarBD();
        // 14
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            // 15
            Statement st = conn.createStatement();
            // 16
            ResultSet rs = st.executeQuery(sql);
            // 17
            if (rs.next()) {
                result = true;  // 18
                nome = rs.getString("nome");  // 19
            }
        } catch (Exception e) {  
            // 20
        }
        // 21
        return result;  
    }
}  // 22




