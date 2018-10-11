package ui.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author rapwe
 */
public class Main extends Application {

    public void start(Stage stage) throws IOException {
        //Parent principal = FXMLLoader.load(getClass().getResource("/ui/produto/cadastro/cadastro.fxml"));
        Parent principal = FXMLLoader.load(getClass().getResource("principal.fxml"));

        Scene cena = new Scene(principal);

        stage.setScene(cena);
        stage.setTitle("Projeto Exemplo");
        stage.getIcons().add(new Image("/images/formula.png"));
        //stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
