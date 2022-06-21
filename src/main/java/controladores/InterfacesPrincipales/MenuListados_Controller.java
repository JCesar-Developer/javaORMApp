package controladores.InterfacesPrincipales;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuListados_Controller extends Controller_Father {

    // ------------------- DECLARACIÓN DE ATRIBUTOS ------------------- //

    @FXML
    private Label ID_MenuListados;

    Controller_Manager controller_mannagger = new Controller_Manager();

    // ---------------------- GETTERS & SETTERS ----------------------- //


    // ----------------------- MÉTODOS DE CLASE ----------------------- //

    @FXML
    void btnListadoSocios(ActionEvent event) {

        String title    = "LISTADO DE SOCIOS";
        String viewPath = "/views/listas/Lista_Socios.fxml";
        controller_mannagger.abrirListaSociosFiltro3(title, viewPath, ID_MenuListados);

    }


    @FXML
    void btnListadoEquipo(ActionEvent event) {

        String title    = "LISTADO DE MIEMBROS DE EQUIPO";
        String viewPath = "/views/listas/Lista_MiembrosEquipo.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MenuListados);

    }

    @FXML
    void btnListadoProyectos(ActionEvent event) {

        String title    = "LISTADO DE PROYECTOS";
        String viewPath = "/views/listas/Lista_Proyectos.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MenuListados);

    }

    @FXML
    void btnSalir(ActionEvent event) {
        this.closeWindows();
    }

    @Override
    public void closeWindows() {

        String title    = "MENÚ PRINCIPAL";
        String viewPath = "/views/MenuInicio_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MenuListados);

    }
}
