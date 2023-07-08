

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    ProdutosDAO(){
     this.conn = new conectaDAO().connectDB();
    }
    
    public void cadastrarProduto (ProdutosDTO produto){
       
      String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)";
     
      try {
      PreparedStatement stmt = this.conn.prepareStatement(sql);
      stmt.setString(1, produto.getNome());
      stmt.setDouble(2, produto.getValor());                      
      stmt.setString(3, produto.getStatus());
      stmt.execute();
      } catch (Exception e) {
      System.out.println("Erro ao inserir filme: " + e.getMessage());
      }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

