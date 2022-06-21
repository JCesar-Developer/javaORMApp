package controladores.miembrosEquipo;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import models.models.Equipo_CRUD;
import models.transformers.Equipo;
import javax.persistence.EntityManager;

public class AgregarMiembroEquipo_Controller extends Controller_Father {

    // --------------------- ATRIBUTOS DE LA VISTA -------------------- //

    @FXML
    private Label ID_AgregarMiembroEquipo;

    @FXML
    private ComboBox<?> cb_tipoContrato;

    @FXML
    private TextField dp_atributoPorContratoOutput;

    @FXML
    private DatePicker dp_fechaAlta;

    @FXML
    private DatePicker dp_fechaBaja;

    @FXML
    private DatePicker dp_fechaNacimiento;

    @FXML
    private ImageView fotoSi;

    @FXML
    private TextField tf_apellido1;

    @FXML
    private TextField tf_apellidos2;

    @FXML
    private TextField tf_atributoPorContratoInput;

    @FXML
    private TextField tf_correoElectronico;

    @FXML
    private TextField tf_cp;

    @FXML
    private TextField tf_direccion;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_localidad;

    @FXML
    private TextField tf_nif;

    @FXML
    private TextField tf_nombre;

    @FXML
    private TextField tf_provincia;

    @FXML
    private TextField tf_proyecto;

    @FXML
    private TextField tf_sexo;

    @FXML
    private TextField tf_telefono;

    // ------------------- RELACIONES ENTRE CLASES -------------------- //

    private EntityManager entityManager;

    Controller_Manager controller_manager = new Controller_Manager();

    // ---------------------- GETTERS & SETTERS ----------------------- //


    // --------------------------- EVENTOS ---------------------------- //

    public void initialize(){

        entityManager = Main_Controller.getEntityManager();

    }

    @FXML
    void btnGuardar(ActionEvent event) {

        try{

            Equipo equipo = new Equipo();

            equipo.setNombre(this.tf_nombre.getText());
            equipo.setApellido1(tf_apellido1.getText());
            equipo.setApellido2(tf_apellidos2.getText());
            equipo.setDni(tf_nif.getText());
            equipo.setDireccion(tf_direccion.getText());
            equipo.setFechaNacimiento(dp_fechaNacimiento.getValue());
            equipo.setMovil(tf_telefono.getText());
            equipo.setCorreo(tf_correoElectronico.getText());
            //TODO: DA ERROR POR SER TIPO ENUM --> getContextMenu() ????
            //equipo.setSexo(sexo.getText().toUpperCase());

            Equipo_CRUD.add(entityManager, equipo);

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

        String title    = "MOSTRAR MIEMBRO DE EQUIPO";
        String viewPath = "/views/miembrosEquipo/MostrarMiembroEquipo_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_AgregarMiembroEquipo);

    }

}
