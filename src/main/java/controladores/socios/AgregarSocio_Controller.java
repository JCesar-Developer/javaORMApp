package controladores.socios;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.models.Socio_CRUD;
import models.transformers.Socio;

import javax.persistence.EntityManager;

public class AgregarSocio_Controller extends Controller_Father {

    // --------------------- ATRIBUTOS DE LA VISTA -------------------- //
    @FXML
    private Label ID_AgregarSocios;

    @FXML
    private TextField tf_nombre;

    @FXML
    private TextField tf_apellido1;

    @FXML
    private TextField tf_apellido2;

    @FXML
    private TextField tf_nif;

    @FXML
    private TextField tf_direccion;

    @FXML
    private DatePicker dp_fechaNacimiento;

    @FXML
    private TextField tf_movil;

    @FXML
    private TextField tf_correo;

    @FXML
    private TextField tf_sexo;

    // ------------------- RELACIONES ENTRE CLASES -------------------- //

    private EntityManager entityManager;

    Controller_Manager controller_mannagger = new Controller_Manager();

    // ---------------------- GETTERS & SETTERS ----------------------- //

    // --------------------------- EVENTOS ---------------------------- //

    public void initialize(){

        entityManager = Main_Controller.getEntityManager();

    }

    @FXML
    void btnGuardar(ActionEvent event) {

        try{

            Socio socio = new Socio();

            socio.setNombre(this.tf_nombre.getText());
            socio.setApellido1(tf_apellido1.getText());
            socio.setApellido2(tf_apellido2.getText());
            socio.setDni(tf_nif.getText());
            socio.setDireccion(tf_direccion.getText());
            socio.setFechaNacimiento(dp_fechaNacimiento.getValue());
            socio.setMovil(tf_movil.getText());
            socio.setCorreo(tf_correo.getText());
            socio.setSexo(tf_sexo.getText().toUpperCase());

            Socio_CRUD.add(entityManager, socio);

            //String fecha = dp_fechaNacimiento.getValue().toString();
            //System.out.println(fecha);

        } finally {

            closeWindows();

        }

    }

    @FXML
    void btnCancelar(ActionEvent event) {

    }

    @FXML
    void btnSalir(ActionEvent event) {
        this.closeWindows();
    }

    @Override
    public void closeWindows() {

        String title    = "MOSTRAR SOCIO";
        String viewPath = "/views/socios/MostrarSocio_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_AgregarSocios);

    }

}