/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista.iugraficaventanas.cotroladoresvistas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mvc.modelo.dominio.Cliente;
import mvc.vista.iugraficaventanas.IUGraficaVentanas;
import mvc.vista.utilidades.Dialogos;

/**
 *
 * @author bogdan
 */
public class ControladorVentanaPrincipal {
    private ControladorDatosCliente cDatosClienteAC, cDatosClienteMC;
    private ControladorListadoClientes cListadoClientes;
    private ControladorAnadirCliente cAnadirCliente;
    private ControladorMostrarCliente cMostrarCliente;
    /*private ControladorListadoVehiculos cListadoVehiculos;
    private ControladorAnadirVehiculo cAnadirVehiculo;
    private ControladorMostrarVehiculo cMostrarVehiculo;
    private ControladorListadoAlquileres cListadoAlquileres;
    private ControladorAnadirAlquiler cAnadirAlquiler;
    private ControladorMostrarAlquiler cMostrarAlquiler;*/
    private Stage listadoClientes, anadirCliente, mostrarCliente, listadoVehiculos,
            anadirVehiculo, mostrarVehiculo, listadoAlquileres, anadirAlquiler, mostrarAlquiler;

    @FXML
    private Button btListarClientes, btAnadirCliente, btBuscarCliente, btListarVehiculos, btAnadirVehiculo,
            btBuscarVehiculo, btListarAlquileres, btAnadirAlquiler, btBuscarAlquiler;

    @FXML
    private void listarClientes() {
        cListadoClientes.actualizaClientes();
        listadoClientes.showAndWait();
    }

    @FXML
    private void anadirCliente() {
        cDatosClienteAC.setCliente(null);
        anadirCliente.showAndWait();
    }

    @FXML
    private void buscarCliente() {
        String dniCliente = Dialogos.mostrarDialogoTexto("Buscar cliente", "Introduce el DNI del cliente a buscar");
        if (dniCliente != null) {
            Cliente cliente = IUGraficaVentanas.controladorMVC.buscarCliente(dniCliente);
            if (cliente != null) {
                cDatosClienteMC.setCliente(cliente);
                cDatosClienteMC.inhabilitaEdicionCampos();
                cMostrarCliente.setCliente(cliente);
                mostrarCliente.showAndWait();
            } else {
                Dialogos.mostrarDialogoError("Cliente no encontrado", "No existe ningún cliente con ese DNI");
            }
        }
    }
}
