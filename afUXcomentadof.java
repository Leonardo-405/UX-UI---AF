package login;  // Define o pacote do projeto

// Importa as bibliotecas necessárias para manipulação de banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável pela manipulação de usuários no sistema.
 * Contém métodos para conexão ao banco de dados e validação de credenciais de login.
 */
public class User {

    /**
     * Estabelece a conexão com o banco de dados MySQL.
     * 
     * @return Objeto Connection, caso a conexão seja bem-sucedida, ou null em caso de falha.
     */
    public Connection conectarBD() {
        Connection conn = null;  // Declara a variável para armazenar a conexão
        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Define a URL de conexão com o banco, incluindo usuário e senha
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);  // Estabelece a conexão
        } catch (Exception e) {
            // Exibe mensagem de erro no console em caso de falha na conexão
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
        }
        return conn;  // Retorna o objeto de conexão
    }

    /** Nome do usuário autenticado. */
    public String nome = "";

    /** Resultado da verificação de login: true para sucesso, false para falha. */
    public boolean result = false;

    /**
     * Verifica se o login e a senha fornecidos correspondem a um usuário no banco de dados.
     * 
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @return true se o usuário for válido, false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";  // Variável para armazenar a instrução SQL
        Connection conn = conectarBD();  // Estabelece conexão com o banco
        // Define a consulta SQL para buscar o nome do usuário
        sql += "SELECT nome FROM usuarios ";
        sql += "WHERE login = '" + login + "'";
        sql += " AND senha = '" + senha + "';";

        try {
            // Cria um Statement para executar a consulta
            Statement st = conn.createStatement();
            // Executa a consulta e armazena o resultado
            ResultSet rs = st.executeQuery(sql);
            // Verifica se algum registro foi encontrado
            if (rs.next()) {
                result = true;  // Se encontrado, define o resultado como verdadeiro
                nome = rs.getString("nome");  // Armazena o nome do usuário
            }
        } catch (Exception e) {
            // Exibe mensagem de erro no console em caso de falha na execução da consulta
            System.err.println("Erro ao verificar o usuário: " + e.getMessage());
        }
        return result;  // Retorna o resultado da verificação
    }
}
