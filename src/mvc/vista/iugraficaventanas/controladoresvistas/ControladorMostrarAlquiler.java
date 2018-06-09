/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista.iugraficaventanas.controladoresvistas;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.vista.iugraficaventanas.IUGraficaVentanas;
import mvc.vista.utilidades.Dialogos;

/**
 *
 * @author bogdan
 */
public class ControladorMostrarAlquiler {
    private Cliente cliente;
    private Alquiler alquiler;
    private List<Alquiler> alquileresCliente;

    @FXML
    private TextField tfDniCliente, tfMatricula, tfFecha, tfDias, tfPrecio, tfPrecioFijo;

    @FXML
    private Button btCerrar;

    @FXML
    private void initialize() {

    }

    @FXML
    private void cerrarAlquiler() {
        IUGraficaVentanas.controladorMVC.cerrarAlquiler(alquiler.getCliente(), alquiler.getVehiculo());
        Stage propietario = (Stage) btCerrar.getScene().getWindow();
        Dialogos.mostrarDialogoInformacion("Cerrar Alquiler", "Alquiler cerrado satisfactoriamente", propietario);
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
        actualizaAlquiler();
    }

    public void setAlquileresCliente(List<Alquiler> alquileresCliente) {
        this.alquileresCliente = alquileresCliente;
        actualizaAlquiler();
    }

    private void actualizaAlquiler() {
        if (alquiler != null) {
            tfDniCliente.setText(alquiler.getCliente().getDNI());
            tfMatricula.setText(alquiler.getVehiculo().getMatricula());
            tfFecha.setText(alquiler.getFecha().toString());
            tfDias.setText("" + alquiler.getDias());
            tfPrecio.setText("" + alquiler.getPrecio());
            tfPrecioFijo.setText("" + alquiler.getPrecioFijo());
        } else {
            tfDniCliente.setText("");
            tfMatricula.setText("");
            tfFecha.setText("");
            tfDias.setText("");
            tfPrecio.setText("");
            tfPrecioFijo.setText("");
        }
    }

    public void inhabilitaEdicionCampos() {
        tfDniCliente.setDisable(true);
        tfMatricula.setDisable(true);
        tfFecha.setDisable(true);
        tfDias.setDisable(true);
        tfPrecio.setDisable(true);
        tfPrecioFijo.setDisable(true);
    }
}
