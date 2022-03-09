package com.example.radiobuttons;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RadioButtons extends Application {
    protected Text teksti = new Text(150,150,"Tässä on tekstiä");       //Luodaan teksti
        protected BorderPane getPaneeli() {
            BorderPane paneeli = new BorderPane();
            HBox paneeliPainikkeille = new HBox(20);
            paneeliPainikkeille.setPadding(new Insets(5,5,5,5));        //Lisätään radionäppäimet
            RadioButton rbRed = new RadioButton("Punainen");
            RadioButton rbBlack = new RadioButton("Musta");
            RadioButton rbBlue = new RadioButton("Sininen");
            RadioButton rbGreen = new RadioButton("Vihreä");
            paneeliPainikkeille.getChildren().addAll(rbBlack,rbBlue,rbGreen,rbRed);
            paneeli.setTop(paneeliPainikkeille);

            ToggleGroup ryhma = new ToggleGroup();
            rbBlack.setToggleGroup(ryhma);
            rbBlue.setToggleGroup(ryhma);
            rbGreen.setToggleGroup(ryhma);
            rbRed.setToggleGroup(ryhma);

            rbBlue.setOnAction(e -> {           //Asetetaan näppäimille toiminnot
                if(rbBlue.isSelected()) {
                    teksti.setFill(Color.BLUE);
                }
            });
            rbBlack.setOnAction(e -> {
                if(rbBlack.isSelected()) {
                    teksti.setFill(Color.BLACK);
                }
            });
            rbGreen.setOnAction(e -> {
                if(rbGreen.isSelected()) {
                    teksti.setFill(Color.GREEN);
                }
            });
            rbRed.setOnAction(e -> {
                if(rbRed.isSelected()) {
                    teksti.setFill(Color.RED);
                }
            });

            HBox siirto = new HBox(20);     //Lisätään paneeli tekstin siirtonäppäimille ja luodaan näppäimet
            Button vas = new Button("<");
            Button oik = new Button(">");
            siirto.getChildren().addAll(vas, oik);
            siirto.setAlignment(Pos.CENTER);

            BorderPane pane = new BorderPane();
            pane.setBottom(siirto);

            Pane paneelitekstille = new Pane();
            paneelitekstille.getChildren().add(teksti);
            paneeli.setCenter(paneelitekstille);
            paneeli.setBottom(siirto);

            vas.setOnAction(e -> teksti.setX(teksti.getX() - 10 ));     //Asetetaan siirtonäppäimille toiminnot
            oik.setOnAction(e -> teksti.setX(teksti.getX() + 10));
            return paneeli;
    }
    @Override
    public void start(Stage stage) throws Exception {
        Scene pohja = new Scene(getPaneeli(), 400,300);
        stage.setScene(pohja);
        stage.setTitle("Tekstin väritys");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}