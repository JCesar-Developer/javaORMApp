package controladores.miembrosEquipo;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.models.Equipo_CRUD;
import models.models.Socio_CRUD;
import models.transformers.Equipo;
import models.transformers.Socio;

import javax.persistence.EntityManager;
import java.util.List;

public class BuscarMiembroEquipo_Controller extends Controller_Father {

    MostrarMiembroEquipo_Controller mostrarController;

    // --------------------- ATRIBUTOS DE LA VISTA -------------------- //
    @FXML
    private Label ID_BuscarMiembroEquipo;

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
    private List<Equipo> equipos;

    // ---------------------- GETTERS & SETTERS ----------------------- //


    // --------------------------- EVENTOS ---------------------------- //

    public void initialize(){

        entityManager = Main_Controller.getEntityManager();
        this.equipos = Equipo_CRUD.getAll(entityManager);

    }

    @FXML
    void btnBuscar(ActionEvent event) {

        //En principio, buscaremos sólo por ID
        Long idEquipo = Long.valueOf(tf_id.getText());
        Equipo equipoEncontrado = Equipo_CRUD.getOne(entityManager, idEquipo);

        int index = equipos.indexOf(equipoEncontrado);
        String title    = "MOSTRAR MIEMBRO DE EQUIPO";
        String viewPath = "/views/miembrosEquipo/MostrarMiembroEquipo_View.fxml";
        controller_manager.abrirVistaEquipo(title, viewPath, ID_BuscarMiembroEquipo, index);


        //TODO: CAMBIAR PARA QUE BUSQUE CON CUALQUIER ATRIBUTO

    }

    @FXML
    void btnSalir(ActionEvent event) {
        this.closeWindows();
    }

    @Override
    public void closeWindows() {

        String title    = "MOSTRAR MIEMBRO DE EQUIPO";
        String viewPath = "/views/miembrosEquipo/MostrarMiembroEquipo_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_BuscarMiembroEquipo);

    }
}
