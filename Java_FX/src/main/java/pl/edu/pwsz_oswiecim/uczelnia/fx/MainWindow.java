package pl.edu.pwsz_oswiecim.uczelnia.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow extends Application {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root123";

    private TextField usernameTextField = new TextField();
    private PasswordField passwordField = new PasswordField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Panel logowania");

        GridPane gridPane = new GridPane();
        Label login_label = new Label("Login:");
        Label pass_label = new Label("Password: ");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets( 15, 15, 15, 15));

        Button loginButton = new Button("Zaloguj");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                login();
            }
        });
        gridPane.add(login_label, 0, 0);
        gridPane.add(usernameTextField, 1, 0);
        gridPane.add(pass_label, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);
        primaryStage.setScene(new Scene(gridPane, 300, 200));
        primaryStage.show();
    }

    private void login (){
        String usernameText = usernameTextField.getText();
        String passwordText = passwordField.getText();

        if (USERNAME.equals(usernameText) && PASSWORD.equals(passwordText)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Logowanie");
            alert.setHeaderText(null);
            alert.setContentText("Logowanie przebiegło pomyślnie!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Logowanie");
            alert.setHeaderText(null);
            alert.setContentText("Logowanie się nie powiodło! Podałeś błędne dane.");
            alert.showAndWait();
        }
    }
}
