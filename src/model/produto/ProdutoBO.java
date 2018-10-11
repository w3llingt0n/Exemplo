/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.produto;

import java.sql.SQLException;
import model.entidades.Produto;

/**
 *
 * @author rapwe
 */
public class ProdutoBO {

    private ProdutoDAO dao;

    public ProdutoBO() {
        dao = new ProdutoDAO();
    }

    public void salvar(Produto p) throws SQLException{
        if (dao.buscarPeloCodigo(p.getCodigo()) != null) {
            
        } else {
            dao.salvar(p);
        }
    }
}
