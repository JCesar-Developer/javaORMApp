package controladores.socios;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import models.models.Socio_CRUD;
import models.transformers.Socio;

import javax.persistence.EntityManager;
import java.util.List;

public class MostrarSocio_Controller extends Controller_Father {

    // --------------------- ATRIBUTOS DE LA VISTA -------------------- //
    @FXML
    private Label ID_MostrarSocios;

    @FXML
    private Button btnAnterior;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSiguiente;

    @FXML
    private TextField tf_id;

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
    private List<Socio> socios;
    private int socioIndex;
    private Socio socio;

    Controller_Manager controller_mannagger = new Controller_Manager();

    // ---------------------- GETTERS & SETTERS ----------------------- //

    public List<Socio> getSocios() {
        return socios;
    }

    public Socio getSocio() {
        return socio;
    }


    // --------------------------- EVENTOS ---------------------------- //

    /**
     * To initialize the view shows the last client on the BBDD
     */
    public void initialize(){

        entityManager = Main_Controller.getEntityManager();

        //CARGA TODA LA LISTA DE SOCIOS.
        this.socios = Socio_CRUD.getAll(entityManager);

        //Y EN UN PRINCIPIO, MUESTRA SOLO EL ÚLTIMO SOCIO.
        this.socioIndex = socios.size() -1;
        this.socio = socios.get(socioIndex);
        this.mostrarSocio(socio);

    }

    @FXML
    void btnAnterior(ActionEvent event) {
        this.socioIndex--;
        this.socio = socios.get(socioIndex);

        mostrarSocio(socio);
        actualizarBotonesNavegacion();

    }

    @FXML
    void btnSiguiente(ActionEvent event) {
        this.socioIndex++;
        this.socio = socios.get(socioIndex);

        mostrarSocio(socio);
        actualizarBotonesNavegacion();
    }

    @FXML
    void btnGuardar(ActionEvent event) {

        try{

            this.socio.setNombre(tf_nombre.getText());
            this.socio.setApellido1(tf_apellido1.getText());
            this.socio.setApellido2(tf_apellido2.getText());
            this.socio.setDni(tf_nif.getText());
            this.socio.setDireccion(tf_direccion.getText());
            this.socio.setFechaNacimiento(dp_fechaNacimiento.getValue());
            this.socio.setMovil(tf_movil.getText());
            this.socio.setCorreo(tf_correo.getText());
            this.socio.setSexo(tf_sexo.getText().toUpperCase());

            Socio_CRUD.update(entityManager, socio);

        } finally {

            this.btnGuardar.setDisable(true);
            this.btnCancelar.setDisable(true);

        }


    }

    @FXML
    void btnCancelar(ActionEvent event) {

        mostrarSocio(this.socio);
        this.btnGuardar.setDisable(true);
        this.btnCancelar.setDisable(true);

    }

    @FXML
    void btnNuevo(ActionEvent event) {

        String title    = "AGREGAR NUEVO SOCIO";
        String viewPath = "/views/socios/AgregarSocio_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MostrarSocios);

    }

    @FXML
    void btnBorrar(ActionEvent event) {

        //TODO: ACCEDER A ESTA OPCIÓN, SOLO CON PERMISOS DE ADMINISTRACIÓN
        Socio_CRUD.delete(entityManager, this.socio);
        this.initialize();

    }

    @FXML
    void btnBuscar(ActionEvent event) {

        String title    = "BUSCAR SOCIO";
        String viewPath = "/views/socios/BuscarSocio_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MostrarSocios);

    }

    @FXML
    void btnSalir(ActionEvent event) {
        this.closeWindows();
    }

    //ACCIONES KEYEVENT
    @FXML
    void updNombre(KeyEvent event) {
        actualizarBotonesUpdate();
    }

    @FXML
    void updApellido1(KeyEvent event) {
        actualizarBotonesUpdate();
    }

    @FXML
    void updApellido2(KeyEvent event) {
        actualizarBotonesUpdate();
    }

    @FXML
    void updCorreo(KeyEvent event) {
        actualizarBotonesUpdate();
    }

    @FXML
    void updDireccion(KeyEvent event) {
        actualizarBotonesUpdate();
    }

    @FXML
    void updFechaNacimiento(KeyEvent event) {
        actualizarBotonesUpdate();
    }

    @FXML
    void updMovil(KeyEvent event) {
        actualizarBotonesUpdate();
    }

    @FXML
    void updNIF(KeyEvent event) {
        actualizarBotonesUpdate();
    }

    @FXML
    void updSexo(KeyEvent event) {
        actualizarBotonesUpdate();
    }

    // ----------------------- MÉTODOS DE CLASE ----------------------- //
    private void mostrarSocio(Socio socio){

        this.tf_id.setText(socio.getId().toString());
        this.tf_nombre.setText(socio.getNombre());
        this.tf_apellido1.setText(socio.getApellido1());
        this.tf_apellido2.setText(socio.getApellido2());
        this.tf_nif.setText(socio.getDni());
        this.tf_direccion.setText(socio.getDireccion());
        this.dp_fechaNacimiento.setValue(socio.getFechaNacimiento());
        this.tf_movil.setText(socio.getMovil());
        this.tf_correo.setText(socio.getCorreo());
        this.tf_sexo.setText(socio.getSexo()+"");

        //ACTUALIZAR BOTÓNES DE NAVEGACIÓN:
        actualizarBotonesNavegacion();

    }

    public void mostrarSocio(Long id){

        Socio socio = Socio_CRUD.getSocioByID(entityManager, id);
        int index = this.socios.indexOf(socio);

        this.tf_id.setText(socio.getId().toString());
        this.tf_nombre.setText(socio.getNombre());
        this.tf_apellido1.setText(socio.getApellido1());
        this.tf_apellido2.setText(socio.getApellido2());
        this.tf_nif.setText(socio.getDni());
        this.tf_direccion.setText(socio.getDireccion());
        this.dp_fechaNacimiento.setValue(socio.getFechaNacimiento());
        this.tf_movil.setText(socio.getMovil());
        this.tf_correo.setText(socio.getCorreo());
        this.tf_sexo.setText(socio.getSexo()+"");

        //ACTUALIZAR INDEX:
        this.socioIndex = index;

        //ACTUALIZAR BOTÓNES DE NAVEGACIÓN:
        actualizarBotonesNavegacion();

    }

    private void actualizarBotonesNavegacion(){

        try{

            //Si index = 0 -> bloquear botón "Anterior".
            if( socioIndex == 0) {
                btnAnterior.setDisable(true);
            } else btnAnterior.setDisable(false);

            //Si index = size() -1 -> bloquear botón "Siguiente".
            if( socioIndex == socios.size() -1 ){
                btnSiguiente.setDisable(true);
            } else btnSiguiente.setDisable(false);

        } finally {

            this.btnGuardar.setDisable(true);
            this.btnCancelar.setDisable(true);

        }

    }

    private void actualizarBotonesUpdate(){
        this.btnGuardar.setDisable(false);
        this.btnCancelar.setDisable(false);
    }

    public void closeWindows() {

        String title    = "MENÚ PRINCIPAL";
        String viewPath = "/views/MenuInicio_View.fxml";
        controller_mannagger.abrirVista(title, viewPath, ID_MostrarSocios);

    }

}

