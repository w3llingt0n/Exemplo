/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.produto.cadastro;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import exception.ProdutoExistenteException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import model.entidades.Produto;
import model.produto.ProdutoBO;

/**
 * FXML Controller class
 *
 * @author rapwe
 */
public class CadastroController implements Initializable {

    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField codigo;
    @FXML
    private JFXTextField nome;
    @FXML
    private JFXTextField preco;
    @FXML
    private JFXTextField quantidade;
    @FXML
    private JFXDatePicker validade;
    @FXML
    private JFXComboBox<String> comboBusca;
    @FXML
    private JFXTextField txtPesquisar;
    @FXML
    private TableView<Produto> tabela;
    private ProdutoBO pBO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pBO = new ProdutoBO();
    }

    @FXML
    private void salvar(ActionEvent event) {
        Produto p = new Produto(
                0,
                nome.getText(),
                Double.parseDouble(preco.getText()),
                codigo.getText(),
                Double.parseDouble(quantidade.getText()),
                validade.getValue()
        );
        try {
            pBO.salvar(p);
            limpaCampos();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Sucesso");
            a.setHeaderText(null);
            a.setContentText("Produto salvo com sucesso.");
            a.showAndWait();
        } catch (SQLException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("ERRO");
            a.setHeaderText(null);
            a.setContentText(ex.getMessage());
            a.showAndWait();
        } catch (ProdutoExistenteException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("ERRO");
            a.setHeaderText(null);
            a.setContentText("Erro ao conectar-se ao banco de dados.");
            a.showAndWait();
        }
    }

    private void limpaCampos() {
        nome.clear();
        preco.clear();
        codigo.clear();
        quantidade.clear();
        validade.setValue(null);
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void excluir(ActionEvent event) {
    }

}
