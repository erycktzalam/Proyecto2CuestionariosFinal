package com.proyecto2.proyecto2cuestionarios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MainController {
    @FXML
    Button btnActivar;
    @FXML
    Button btnClonar;
    @FXML
    Button btnEvaluar;
    @FXML
    Button btnTop3;
    @FXML
    Button btnAgregar;
    @FXML
    Pane panelActivar;
    @FXML
    Pane panelClonar;
    @FXML
    Pane panelEvaluar;
    @FXML
    Pane panelTop3;
    @FXML
    Pane panelAgregar;

    public void onClickMenu (ActionEvent actionEvent){

        if(actionEvent.getSource() == btnActivar){
            panelActivar.toFront();
        }
        if(actionEvent.getSource() == btnClonar){
            panelClonar.toFront();
        }
        if(actionEvent.getSource() == btnEvaluar){
            panelEvaluar.toFront();
        }
        if(actionEvent.getSource() == btnTop3){
            panelTop3.toFront();
        }
        if (actionEvent.getSource() == btnAgregar){
            panelAgregar.toFront();
        }

    }
}