package projeto;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import projeto.Produto;


public class Principal {
    public static void main(String[] args) throws SQLException {
        Produto p = new Produto();
        

        String descricao = JOptionPane.showInputDialog(null, "Digite a descrição do produto:", "Cadastro de Produto", JOptionPane.PLAIN_MESSAGE);
        p.setDescricao(descricao);


        String precoStr = JOptionPane.showInputDialog(null, "Digite o preço do produto:", "Cadastro de Produto", JOptionPane.PLAIN_MESSAGE);
        double preco = Double.parseDouble(precoStr);
        p.setPreco(preco);

        p.cadastrar();
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
    }
}
