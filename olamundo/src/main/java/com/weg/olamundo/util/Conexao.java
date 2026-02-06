package com.weg.olamundo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3307/escola?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "mysqlPW";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void main(String[] args) {
        try(Connection conn = conectar()) {
            if (conn != null) {
                System.out.println("Conexão realizada com sucesso!");
            } else {
                System.out.println("Conexão falhou");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
