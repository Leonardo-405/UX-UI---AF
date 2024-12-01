package login;  // 1. Define o pacote do projeto

// 2. Importa as bibliotecas necessárias para manipulação de banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {  // 3. Define a classe User

    // 4. Método para estabelecer a conexão com o banco de dados
    public Connection conectarBD() {
        Connection conn = null;  // Declara uma variável para a conexão
        try {
            // 5. Carrega o driver do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // 6. Define a URL de conexão, incluindo usuário e senha
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            // 7. Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection(url);
        } catch (Exception e) { 
            // 8. Caso ocorra uma exceção, não faz nada (tratar o erro é recomendado)
        }
        // 9. Retorna a conexão
        return conn;
    }

    // 10. Declara variáveis de instância para armazenar o nome do usuário e o resultado da verificação
    public String nome = "";
    public boolean result = false;

    // 11. Método para verificar se o login e a senha do usuário são válidos
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";  // 12. Variável para armazenar a instrução SQL
        // 13. Estabelece uma conexão com o banco de dados
        Connection conn = conectarBD();
        // 14. Cria a instrução SQL para buscar o nome do usuário com login e senha fornecidos
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        try {
            // 15. Cria um Statement para executar a consulta SQL
            Statement st = conn.createStatement();
            // 16. Executa a consulta e armazena o resultado
            ResultSet rs = st.executeQuery(sql);
            // 17. Verifica se algum registro foi encontrado
            if (rs.next()) {
                result = true;  // 18. Se encontrar, define o resultado como verdadeiro
                nome = rs.getString("nome");  // 19. Armazena o nome do usuário
            }
        } catch (Exception e) {  
            // 20. Caso ocorra uma exceção, não faz nada (tratar o erro é recomendado)
        }
        // 21. Retorna o resultado da verificação
        return result;  
    }
}  // 22. Fim da classe User

