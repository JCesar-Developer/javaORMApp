package controladores.InterfacesPrincipales;

//TODO: He intantado importar el tema de GLUON, pero no lo he conseguido.
//import com.gluonhq.charm.glisten.control.TextField;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.models.Equipo_CRUD;
import models.transformers.Equipo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;


public class Login_Controller extends Controller_Father {

    // ---------- ATRIBUTOS ----------//

    @FXML
    public AnchorPane raiz;

    private Boolean admin = false;

    Stage stage;

    Login_Controller loginController;

    private EntityManager entityManager;

    Controller_Manager controller_manager = new Controller_Manager();

    // ---------- ATRIBUTOS DE LA VISTA ----------//

    @FXML
    private Label ID_Login;

    @FXML
    private TextField password_user;

    @FXML
    private TextField username_user;

    @FXML
    private Button accept_login;

    @FXML
    private Button cancel_login;

    private List<Equipo> equipos;

    // --------------------------- MÉTODOS ---------------------------- //

    public void initialize(){

        entityManager = Main_Controller.getEntityManager();
        this.equipos = Equipo_CRUD.getAll(entityManager);
    }


    // --------------------------- EVENTOS ---------------------------- //

    @FXML
    public void userLogin(ActionEvent event) {

        //Si uno de los campos está vacío
        if(username_user.getText().isEmpty() || password_user.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Login Failed");
            alert.setContentText("Debe introducir un nombre de usuario y un password válidos. Por favor, inténtelo de nuevo.");
            alert.showAndWait();
        } else {
            //Buscamos si el usuario introducido está en la base de datos
            Query query = entityManager.createQuery("SELECT e FROM Equipo e WHERE e.user = :userBuscado");
            query.setParameter("userBuscado", this.username_user.getText());

            try {
                Equipo usuarioEncontrado = (Equipo) query.getSingleResult();

                //Si se encuentra el usuario en la BBDD
                if (usuarioEncontrado != null) {
                    System.out.println("User encontrado: " + usuarioEncontrado);

                    //Comprobamos si coincide el password
                    Query query2 = entityManager.createQuery("SELECT e FROM Equipo e WHERE e.password = :passBuscado");
                    query2.setParameter("passBuscado", this.password_user.getText());
                    String passEncontrado = usuarioEncontrado.getPassword();

                    if (password_user.getText().equals(passEncontrado)) {
                        System.out.println("Password correcto: " + passEncontrado);

                        //TODO: DAR PERMISOS EN FUNCIÓN DE USUSARIO O ADMINISTRADOR
                        //Recuperamos el rol del usuario solicitado
                        if (usuarioEncontrado.getRol().equals(true)) {
                            System.out.println("El usuario es un Administrador!");
                            this.admin = true;

                        } else if (usuarioEncontrado.getRol().equals(false)) {
                            System.out.println("El usuario no es Administrador.");
                            this.admin = false;

                        } else {
                            System.out.println("No ha leído bien el Rol.");
                        }

                        //TODO: GUARDAR/PASAR EL VALOR DE ADMIN
                        /*Stage stage = (Stage) this.raiz.getScene().getWindow();
                        stage.setUserData(admin);
                        System.out.println("Se han guardado los datos.");*/

                        //enviarDatos(event);
                        //System.out.println("Se han enviado los datos.");

                        try {

                            //Guardamos los datos
                            Stage myStage = (Stage) this.ID_Login.getScene().getWindow();
                            myStage.setUserData(this.admin);
                            System.out.println("Se ha guardado el valor de admin: " + admin);
                            //myStage.close();
                            //TODO: ENVIAR DATOS

                            //Se carga la vista de menú inicio
                            String title    = "MENÚ PRINCIPAL";
                            String viewPath = "/views/MenuInicio_View.fxml";
                            controller_manager.abrirVista(title, viewPath, ID_Login);

                        } catch (Exception ex) {
                            System.out.println("Ha ocurrido un error.");
                        }
                    } else {
                        //Si el password es incorrecto
                        System.out.println("Password incorrecto.");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Login Failed");
                        alert.setContentText("Password incorrecto. Por favor, inténtelo de nuevo.");
                        alert.showAndWait();
                    }
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Login Failed");
                alert.setContentText("El usuario no se encuentra registrado en la Base de Datos o se ha producido un error.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void accept_login(ActionEvent event) {

    }

    @FXML
    void cancel_login(ActionEvent event) {

    }

    @FXML
    public void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancel_login.getScene().getWindow();
        stage.close();
        //TODO: CERRAR ENTITYMANAGER
        entityManager.close();
    }

    @Override
    public void closeWindows() {

    }

}


/* CÓDIGOS DESCARTADOS

    /*@FXML
    private void enviarDatos(Event event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            Parent root = FXMLLoader.load(Login_Controller.class.getClassLoader().getResource("/views/MenuInicio_View.fxml"));
            stage.setUserData(this.admin);
            Scene scene = new Scene(root);
            stage.setTitle("MENÚ PRINCIPAL");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }

    }*/




    /*@FXML
    public Stage recuperarDatos() {
        Stage stage = (Stage) this.raiz.getScene().getWindow();
        Stage stagePasada = (Stage) stage.getUserData();
        System.out.println("Se ha recuperado el siguiente dato --> stage = " + stage);
        return stagePasada;
    }*/

    /*@FXML
    public void recuperarDatos() {

        Stage myStage = (Stage) this.raiz.getScene().getWindow();
        //Stage myStage = (Stage) this.ID_Login.getScene().getWindow();
        this.admin = (Boolean) myStage.getUserData();
        System.out.println("Se ha recuperado el siguiente dato --> admin = " + admin);

    }*/

