/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import model.conexao.ConnectionFactory;
import model.entidades.Produto;

/**
 *
 * @author rapwe
 */
public class ProdutoDAO {

    /**
     * Buscar um produto pelo código
     *
     * @param c Código
     * @return
     * @throws SQLException
     */
    public Produto buscarPeloCodigo(String c) throws SQLException {
        //Comando
        String sql = "SELECT * FROM produto WHERE codigo = ?";

        //Preparar o SQL
        PreparedStatement ps = ConnectionFactory.prepararSQL(sql);

        //Substituir os parametros
        ps.setString(1, c);

        //Executa consulta no bd
        ResultSet resultado = ps.executeQuery();

        //Verificar se tem algum resultado
        if (resultado.next()) {
            //Cria o objeto com o resultado do BD

            Produto p = new Produto(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getDouble("preco"),
                    resultado.getString("codigo"),
                    resultado.getDouble("quantidade"),
                    LocalDate.parse(resultado.getDate("validade").toString())
            );

            return p;
        }

        return null;
    }

    public void salvar(Produto p) throws SQLException {
        String sql = "insert into produto (nome,preco,codigo,quantidade,validade) values (?,?,?,?,?)";
        PreparedStatement ps = ConnectionFactory.prepararSQL(sql);
        ps.setString(1, p.getNome());
        ps.setDouble(2, p.getPreco());
        ps.setString(3, p.getCodigo());
        ps.setDouble(4, p.getQuantidade());
        ps.setString(5, p.getValidade().toString());
        ps.executeUpdate();
        ps.close();
    }
}
