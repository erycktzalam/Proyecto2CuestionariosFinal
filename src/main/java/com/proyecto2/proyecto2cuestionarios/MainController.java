package com.proyecto2.proyecto2cuestionarios;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
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
    Button btnCancelar;
    @FXML
    Button btnSiguiente;
    @FXML
    Button btnAgregarPregunta;
    @FXML
    Button btnVerificar;
    @FXML
    Button btnModificarPregunta;
    @FXML
    Button btnBorrarPregunta;
    @FXML
    Button btnFinalizarAgregar;
    @FXML
    Button btnClonarCuestionario;
    @FXML
    Button btnPdf;
    @FXML
    Pane panelActivar;
    @FXML
    Pane panelEvaluar;
    @FXML
    Pane panelTop3;
    @FXML
    Pane panelAgregarFormulario;
    @FXML
    Pane panelAgregarPregunta;
    @FXML
    Pane panelVerificarPregunta;
    @FXML
    Pane panelModificarPregunta;
    @FXML
    TextField txtTituloForms;
    @FXML
    TextField txtDescripcionForm;
    @FXML
    TextField txtPreguntaForm;
    @FXML
    TextField txtPuntosForm;
    @FXML
    TextField txtRespuesta1;
    @FXML
    TextField txtRespuesta2;
    @FXML
    TextField txtRespuesta3;
    @FXML
    TextField txtRespuesta4;
    @FXML
    TextField txtModificarPregunta;
    @FXML
    TextField txtModificarPuntos;
    @FXML
    TextField txtPinEvaluacion;
    @FXML
    TextField txtNombreEvaluacion;
    @FXML
    ComboBox<String> listaTiempo;
    @FXML
    ComboBox<String> listaTiempo2;
    @FXML
    CheckBox checkR1;
    @FXML
    CheckBox checkR2;
    @FXML
    CheckBox checkR3;
    @FXML
    CheckBox checkR4;
    @FXML
    TableView<Pregunta> tablePreguntas;
    @FXML
    TableColumn<Pregunta, String> tcPregunta;
    @FXML
    TableColumn<Pregunta, Integer> tcTiempoLimite;
    @FXML
    TableColumn<Pregunta, Integer> tcPunteo;
    @FXML
    TableView<Cuestionario> tableCuestionario;
    @FXML
    TableColumn<Cuestionario, Integer> tcPin;
    @FXML
    TableColumn<Cuestionario, String> tcNombre;
    @FXML
    TableColumn<Cuestionario, String> tcDescripcion;
    @FXML
    Pagination paginacionPreguntas;

    ObservableList<Cuestionario> listaCuestionario;
    ObservableList<Pregunta> listaPreguntas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaTiempo.getItems().add("5");
        listaTiempo.getItems().add("10");
        listaTiempo.getItems().add("15");
        listaTiempo.getItems().add("20");

        listaTiempo2.getItems().add("5");
        listaTiempo2.getItems().add("10");
        listaTiempo2.getItems().add("15");
        listaTiempo2.getItems().add("20");

        listaCuestionario = FXCollections.observableArrayList();
        this.tcPin.setCellValueFactory(new PropertyValueFactory<Cuestionario, Integer>("pin"));
        this.tcNombre.setCellValueFactory(new PropertyValueFactory<Cuestionario, String>("titulo"));
        this.tcDescripcion.setCellValueFactory(new PropertyValueFactory<Cuestionario, String>("descripcion"));

        listaPreguntas = FXCollections.observableArrayList();
        this.tcPregunta.setCellValueFactory(new PropertyValueFactory<Pregunta, String>("pregunta"));
        this.tcTiempoLimite.setCellValueFactory(new PropertyValueFactory<Pregunta, Integer>("tiempo"));
        this.tcPunteo.setCellValueFactory(new PropertyValueFactory<Pregunta, Integer>("puntos"));

    }

    public void onClickMenu(ActionEvent actionEvent) {

        /*if(actionEvent.getSource() == btnActivar){
            panelActivar.toFront();
        }


        if (actionEvent.getSource() == btnClonar) {
            panelClonar.toFront();
        }

         */
        if (actionEvent.getSource() == btnEvaluar) {
            panelEvaluar.toFront();
        }
        if (actionEvent.getSource() == btnTop3) {
            panelTop3.toFront();
        }
        if (actionEvent.getSource() == btnAgregar) {
            panelAgregarFormulario.toFront();
        }

        if (actionEvent.getSource() == btnCancelar) {
            panelActivar.toFront();
        }
        //if (actionEvent.getSource() == btnSiguiente){
        //  panelAgregarPregunta.toFront();
        //}
        if (actionEvent.getSource() == btnAgregarPregunta) {
            panelVerificarPregunta.toFront();
        }
        //if (actionEvent.getSource() == btnVerificar){
        //  panelActivar.toFront();
        //}

    }

    Cuestionario cuestionario;
    Pregunta p;

    Respuesta r1;
    Respuesta r2;
    Respuesta r3;
    Respuesta r4;

    public void onClickSiguienteFormulario(ActionEvent actionEvent) {
        String tituloForms = txtTituloForms.getText();
        String descripcionForms = txtDescripcionForm.getText();
        cuestionario = new Cuestionario(tituloForms, descripcionForms);
        listaCuestionario.add(cuestionario);
        tableCuestionario.setItems(listaCuestionario);
        tablePreguntas.getItems().clear();
        panelAgregarPregunta.toFront();
    }


    public void onClickVerificarPregunta(ActionEvent actionEvent) {
        String pregunta = txtPreguntaForm.getText();
        int tiempo = Integer.parseInt(listaTiempo.getSelectionModel().getSelectedItem());
        int puntos = Integer.parseInt(txtPuntosForm.getText());
        p = new Pregunta(pregunta, tiempo, puntos);
        cuestionario.agregarPreguntas(p);
        listaPreguntas.add(p);
        tablePreguntas.setItems(listaPreguntas);
        String respuesta1 = txtRespuesta1.getText();
        String respuesta2 = txtRespuesta2.getText();
        String respuesta3 = txtRespuesta3.getText();
        String respuesta4 = txtRespuesta4.getText();
        boolean cr1 = checkR1.isSelected();
        boolean cr2 = checkR2.isSelected();
        boolean cr3 = checkR3.isSelected();
        boolean cr4 = checkR4.isSelected();
        r1 = new Respuesta(respuesta1, cr1);
        r2 = new Respuesta(respuesta2, cr2);
        r3 = new Respuesta(respuesta3, cr3);
        r4 = new Respuesta(respuesta4, cr4);
        p.agregarRespuesta(r1);
        p.agregarRespuesta(r2);
        p.agregarRespuesta(r3);
        p.agregarRespuesta(r4);
        txtTituloForms.clear();
        txtDescripcionForm.clear();
        txtPreguntaForm.clear();
        txtPuntosForm.clear();
        txtRespuesta1.clear();
        txtRespuesta2.clear();
        txtRespuesta3.clear();
        txtRespuesta4.clear();
        listaTiempo.getSelectionModel().clearSelection();
        checkR1.setSelected(false);
        checkR2.setSelected(false);
        checkR3.setSelected(false);
        checkR4.setSelected(false);
        panelAgregarPregunta.toFront();
    }

    public void modificarPregunta(ActionEvent actionEvent) {

        Pregunta p = this.tablePreguntas.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una pregunta");
            alert.showAndWait();
        } else {
            panelModificarPregunta.toFront();
        }

    }

    public void modificarPregunta2(ActionEvent actionEvent) {

        Pregunta p = this.tablePreguntas.getSelectionModel().getSelectedItem();

        String pregunta = txtModificarPregunta.getText();
        int tiempo = Integer.parseInt(listaTiempo2.getSelectionModel().getSelectedItem());
        int puntos = Integer.parseInt(txtModificarPuntos.getText());

        p.setPregunta(pregunta);
        p.setTiempo(tiempo);
        p.setPuntos(puntos);

        this.tablePreguntas.refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Pregunta Modificada");
        alert.showAndWait();

        txtModificarPregunta.clear();
        listaTiempo2.getSelectionModel().clearSelection();
        txtModificarPuntos.clear();
        panelAgregarPregunta.toFront();

    }

    public void borrarPregunta(ActionEvent actionEvent) {

        Pregunta p = this.tablePreguntas.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una pregunta");
            alert.showAndWait();
        } else {

            this.listaPreguntas.remove(p);
            this.tablePreguntas.refresh();
        }

    }

    public void finalizarAgregarPregunta(ActionEvent actionEvent) {
        panelActivar.toFront();
    }

    public void activarCuestionario(ActionEvent actionEvent) {
        panelActivar.toFront();
    }

    public void activar(ActionEvent actionEvent) {

        cuestionario = this.tableCuestionario.getSelectionModel().getSelectedItem();

        if (cuestionario == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un cuestionario");
            alert.showAndWait();

        } else if (cuestionario.isRegistrado() && cuestionario.isActivado()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Este cuestionario ya esta activado");
            alert.showAndWait();

        } else {

            int nuevoPin = obtenerNumeroAleatorio();
            cuestionario.setPin(nuevoPin);
            cuestionario.setActivado(true);
            this.tableCuestionario.refresh();

            //mensaje de prueba

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText(cuestionario.toString());
            alert.showAndWait();
        }
    }

    public void ingresarEvaluacion(ActionEvent actionEvent) {
        int pin = Integer.parseInt(txtPinEvaluacion.getText());
        boolean encontrado = false;
        for (int i = 0; i < listaCuestionario.size(); i++) {
            cuestionario = listaCuestionario.get(i);
            if (cuestionario.getPin() == pin) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText(cuestionario.toString());
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Pin de cuestionario incorrecto");
            alert.showAndWait();
        }
    }

    public void menuClonacion(ActionEvent actionEvent) {
        panelActivar.toFront();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("Seleccione el formulario que desea clonar");
        alert.showAndWait();
    }

    public void clonarCuestionario(ActionEvent actionEvent) {

        cuestionario = this.tableCuestionario.getSelectionModel().getSelectedItem();

        if (cuestionario == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un cuestionario");
            alert.showAndWait();

        } else if (!cuestionario.isActivado()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("El cuestionario debe estar activado para poder clonarlo, seleccione otro cuestionario");
            alert.showAndWait();

        } else {

            Cuestionario cuestionarioClonado = new Cuestionario(cuestionario.getTitulo(), cuestionario.getDescripcion());
            cuestionarioClonado.setActivado(true);
            int nuevoPin = obtenerNumeroAleatorio();
            cuestionarioClonado.setPin(nuevoPin);

            listaCuestionario.add(cuestionarioClonado);
            tableCuestionario.setItems(listaCuestionario);

            //obtener preguntas del cuestionario


        }
    }

    public void crearPDF(ActionEvent actionEvent) {

        try (PDDocument document = new PDDocument()) {

            cuestionario = this.tableCuestionario.getSelectionModel().getSelectedItem();

            PDPage page = new PDPage(PDRectangle.A6);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 6);
            contentStream.newLineAtOffset( 20, page.getMediaBox().getHeight() - 52);
            contentStream.showText(cuestionario.toString());
            contentStream.endText();

            contentStream.close();

            document.save("document.pdf");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void comboboxEvent(ActionEvent actionEvent) {
        //revisar si es necesario este evento
    }

    public int obtenerNumeroAleatorio() {
        double seisCifras = 100000 + Math.random() * 900000;
        return (int) seisCifras;
    }



}