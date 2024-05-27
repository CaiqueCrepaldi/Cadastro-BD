/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Produto {
    
    private int id;
    private String descricao;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void cadastrar() throws SQLException {      
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("INSERT INTO produtos (descricao, preco) VALUES (?, ?)");
        comando.setString(1, descricao);
        comando.setDouble(2, preco);
        comando.execute();
        con.close();    
    }

    public Connection getConexao() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/aula_ioo"; 
            String USER = "root"; 
            String PASSWORD = ""; 

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) { 
            System.out.println(ex);
            return null;
        }
    }
}
