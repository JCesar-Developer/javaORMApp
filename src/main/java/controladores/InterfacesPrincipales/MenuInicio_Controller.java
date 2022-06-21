package controladores.InterfacesPrincipales;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.models.Equipo_CRUD;


public class MenuInicio_Controller extends Controller_Father {

    // ------------------- DECLARACIÓN DE ATRIBUTOS ------------------- //

    private Boolean admin = false;

    Login_Controller login_controller;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

    @FXML
    private ImageView imageView5;

    @FXML
    private ImageView imageView6;

    @FXML
    private Label ID_MenuInicio;

    @FXML
    public AnchorPane raiz;

    Controller_Manager controller_mannagger = new Controller_Manager();

    // ---------------------- GETTERS & SETTERS ----------------------- //


    // ----------------------- MÉTODOS DE CLASE ----------------------- //

    @FXML
    void btnSocios(ActionEvent event) {
        Image image = new Image("/icons/socio.png");
        imageView1.setImage(image);

        String title    = "MOSTRAR SOCIO";
        String viewPath = "/views/socios/MostrarSocio_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MenuInicio);

    }

    @FXML
    void btnGestionEquipo(ActionEvent event) {
        Image image = new Image("/icons/eeee.png");
        imageView2.setImage(image);

        String title = "MOSTRAR MIEMBROS DEL EQUIPO";
        String viewPath = "/views/miembrosEquipo/MostrarMiembroEquipo_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MenuInicio);
    }

    @FXML
    void btnProyectos(ActionEvent event) {
        Image image = new Image("/icons/conta.png");
        imageView4.setImage(image);
        String title = "MOSTRAR PROYECTOS";
        String viewPath = "/views/proyectos/MostrarProyecto_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MenuInicio);
    }

    @FXML
    void btnAgenda(ActionEvent event) {
        Image image = new Image("/icons/agenda.png");
        imageView3.setImage(image);

    }

    @FXML
    void btnContactos(ActionEvent event) {

        Image image = new Image("/icons/contactos.png");
        imageView5.setImage(image);
    }

    @FXML
    void btnListados(ActionEvent event) {
        Image image = new Image("/icons/list.png");
        imageView6.setImage(image);
        String title    = "MENU LISTADOS";
        String viewPath = "/views/MenuListados_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MenuInicio);

    }

    @FXML
    void btnSalir(ActionEvent event) {

        String title    = "USER AUTHENTICATION";
        String viewPath = "/views/Login_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MenuInicio);
    }

    @Override
    public void closeWindows() {

    }
}

/* CÓDIGOS DESCARTADOS

//        try {
//
//            //Paso 0: Inicializamos un nuevo objeto de tipo renderizador
//            Stage stage = new Stage();
//
//            //Paso 1: Importamos la vista de los Inputs.
//            FXMLLoader view = new FXMLLoader(getClass().getResource("/views/socios/MostrarSocio_View.fxml"));
//            Scene scene = new Scene(view.load());
//
//            //Paso 2: Inicializamos el controlador y le entregamos la lista de personas antes de lanzar la vista
//            MostrarSocio_Controller controller = view.getController();
//
//            //Paso 3: Configuramos la vista
//            stage.setTitle("MENÚ DE SOCIOS");
//            stage.setScene(scene);
//
//            //Paso 4: Lanzamos la vista
//            System.out.println("\nVentana, mostrarSocio ejecutandose.");
//            stage.show();
//
//            //¿?¿?¿?
//            stage.setOnCloseRequest( e -> controller.closeWindows() );
//
//            //¿?¿?¿?
//            Stage myStage = (Stage) this.ID_MenuInicio.getScene().getWindow();
//            myStage.close();
//
//        } catch (IOException e) {
//
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setTitle("Error");
//            alert.setContentText(e.getMessage());
//            alert.showAndWait();
//
//        }

 */

    /*@FXML
    public void recuperarDatos(Login_Controller loginController, Boolean admin) {

        Stage myStage = (Stage) this.raiz.getScene().getWindow();
        //Stage myStage = (Stage) this.ID_MenuInicio.getScene().getWindow();
        this.admin = (Boolean) myStage.getUserData();
        System.out.println("Se ha recuperado el siguiente dato --> admin = " + admin);

    }*/