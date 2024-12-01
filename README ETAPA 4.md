# Sistema de Login em Java com MySQL

Este repositório contém um projeto básico de autenticação de usuários, desenvolvido em **Java**, com integração a um banco de dados **MySQL**. O objetivo principal é validar o login e a senha de um usuário armazenados no banco de dados, retornando o nome do usuário autenticado, caso as credenciais sejam válidas.

## Funcionalidades

- **Conexão ao Banco de Dados**: O projeto utiliza o driver JDBC para conectar-se a um banco de dados MySQL.
- **Validação de Login e Senha**: O método `verificarUsuario` realiza a consulta ao banco de dados para verificar se o login e senha fornecidos correspondem a um registro existente.
- **Retorno do Nome do Usuário**: Se o login for bem-sucedido, o sistema retorna o nome do usuário autenticado.

## Estrutura do Projeto

### Classe `User`
Esta classe é responsável por realizar toda a manipulação com o banco de dados. Ela contém:

- **Variáveis de Instância**:
  - `String nome`: Armazena o nome do usuário autenticado.
  - `boolean result`: Indica o resultado da validação (true para sucesso, false para falha).

- **Métodos**:
  1. `conectarBD`: Estabelece uma conexão com o banco de dados.
  2. `verificarUsuario`: Valida as credenciais de login e senha, realizando uma consulta SQL.

## Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Banco de Dados**: MySQL
- **Driver JDBC**: `com.mysql.cj.jdbc.Driver`
- **Gerador de Documentação**: JavaDoc

## Pré-requisitos

1. **Java Development Kit (JDK)** instalado (Java 8 ou superior).
2. **Servidor MySQL** configurado.
3. **Banco de Dados**:
   - Crie um banco chamado `test`.
   - Adicione uma tabela `usuarios` com colunas `nome`, `login` e `senha`.
   - Insira registros de teste, como:

     ```sql
     INSERT INTO usuarios (nome, login, senha) VALUES ('Leonardo', 'leonardo123', 'senha123');
     ```

## Como Executar

1. **Clone o Repositório**:
   ```bash
   git clone <URL-do-repositório>
   cd <nome-do-repositório>

