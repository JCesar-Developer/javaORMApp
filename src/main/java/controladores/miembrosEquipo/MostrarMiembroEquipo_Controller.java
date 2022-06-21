package controladores.miembrosEquipo;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javax.persistence.EntityManager;
import java.util.List;
import javafx.scene.input.KeyEvent;
import models.models.Equipo_CRUD;
import models.transformers.Equipo;


public class MostrarMiembroEquipo_Controller extends Controller_Father {

    // --------------------- ATRIBUTOS DE LA VISTA -------------------- //
    @FXML
    private Label ID_MostrarMiembroEquipo;

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

    //--- BOTONES ACTIVOS ---//
    @FXML
    private Button btnAnterior;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSiguiente;

    // ------------------- RELACIONES ENTRE CLASES -------------------- //

    private EntityManager entityManager;
    private List<Equipo> equipos;
    private int equipoIndex;
    private Equipo equipo;

    Controller_Manager controller_manager = new Controller_Manager();

    // ---------------------- GETTERS & SETTERS ----------------------- //

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    // --------------------------- EVENTOS ---------------------------- //

    /**
     * To initialize the view shows the last client on the BBDD
     */
    public void initialize(){

        entityManager = Main_Controller.getEntityManager();

        //CARGA TODA LA LISTA DE MIEMBROS DE EQUIPO.
        this.equipos = Equipo_CRUD.getAll(entityManager);

        //Y EN UN PRINCIPIO, MUESTRA SOLO EL ÚLTIMO MIEMBRO DE EQUIPO.
        this.equipoIndex = equipos.size() -1;
        this.equipo = equipos.get(equipoIndex);
        this.mostrarEquipo(equipo);
        //BORRAR
        System.out.println("EquipoIndex = " + equipoIndex);
    }

    @FXML
    void btnAnterior(ActionEvent event) {
        this.equipoIndex--;
        this.equipo = equipos.get(equipoIndex);

        mostrarEquipo(equipo);
        actualizarBotonesNavegacion();

    }

    @FXML
    void btnSiguiente(ActionEvent event) {
        this.equipoIndex++;
        this.equipo = equipos.get(equipoIndex);

        mostrarEquipo(equipo);
        actualizarBotonesNavegacion();
    }

    @FXML
    void btnGuardar(ActionEvent event) {

        try{

            this.equipo.setNombre(tf_nombre.getText());
            this.equipo.setApellido1(tf_apellido1.getText());
            this.equipo.setApellido1(tf_apellidos2.getText());
            this.equipo.setDni(tf_nif.getText());
            this.equipo.setDireccion(tf_direccion.getText());
            this.equipo.setLocalidad(tf_localidad.getText());
            this.equipo.setCp(tf_cp.getText());
            this.equipo.setProvincia(tf_provincia.getText());
            this.equipo.setFechaNacimiento(dp_fechaNacimiento.getValue());
            this.equipo.setMovil(tf_telefono.getText());
            this.equipo.setCorreo(tf_correoElectronico.getText());
            this.equipo.setSexo(tf_sexo.getText().toUpperCase());
            //USUARIO, PASSWORD Y ROL NO SON CAMPOS DE LA VISTA
            this.equipo.setFechaAltaMiembroEquipo(dp_fechaAlta.getValue());
            this.equipo.setFechaBajaMiembroEquipo(dp_fechaBaja.getValue());

            //this.equipo.setTipoDeEquipo(Equipo.TipoDeEquipo.valueOf(tf_atributoPorContratoInput.getText().toUpperCase()));

            Equipo_CRUD.update(entityManager, equipo);

        } finally {

            this.btnGuardar.setDisable(true);
            this.btnCancelar.setDisable(true);

        }
    }

    @FXML
    void btnCancelar(ActionEvent event) {

        mostrarEquipo(this.equipo);
        this.btnGuardar.setDisable(true);
        this.btnCancelar.setDisable(true);

    }

    @FXML
    void btnNuevo(ActionEvent event) {

        String title    = "AGREGAR NUEVO MIEMBRO DE EQUIPO";
        String viewPath = "/views/miembrosEquipo/AgregarMiembroEquipo_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_MostrarMiembroEquipo);

    }

    @FXML
    void btnBorrar(ActionEvent event) {

        //TODO: ACCEDER A ESTA OPCIÓN, SOLO CON PERMISOS DE ADMINISTRACIÓN
        Equipo_CRUD.delete(entityManager, this.equipo);
        this.initialize();

    }

    @FXML
    void btnBuscar(ActionEvent event) {

        String title    = "BUSCAR MIEMBRO DE EQUIPO";
        String viewPath = "/views/miembrosEquipo/BuscarMiembroEquipo_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_MostrarMiembroEquipo);

    }

    public void closeWindows() {

        String title    = "MENÚ PRINCIPAL";
        String viewPath = "/views/MenuInicio_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_MostrarMiembroEquipo);

    }


    @FXML
    void btnSalir(ActionEvent event) {
        this.closeWindows();
    }

    //--- ACCIONES KEYEVENT ---//

    @FXML
    void updApellido1(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updApellido2(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updAtributoContrato(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updCP(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updDireccion(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updFechaAlta(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updFechaBaja(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updFechaNacimiento(ActionEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updLocalidad(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updMovil(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updNIF(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updNombre(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updProvincia(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updProyecto(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updSexo(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    @FXML
    void updUpdate(KeyEvent event) {
        this.actualizarBotonesUpdate();
    }

    // ----------------------- MÉTODOS DE CLASE ----------------------- //

    private void mostrarEquipo(Equipo equipo){

        //System.out.println(equipo);

        this.tf_id.setText(equipo.getId()+"");
        this.tf_nombre.setText(equipo.getNombre());
        this.tf_apellido1.setText(equipo.getApellido1());
        this.tf_apellidos2.setText(equipo.getApellido2());
        this.tf_nif.setText(equipo.getDni());
        this.tf_direccion.setText(equipo.getDireccion());
        this.tf_localidad.setText(equipo.getLocalidad());
        this.tf_cp.setText(equipo.getCp());
        this.tf_provincia.setText(equipo.getProvincia());
        this.dp_fechaNacimiento.setValue(equipo.getFechaNacimiento());
        this.tf_telefono.setText(equipo.getMovil());
        this.tf_sexo.setText(equipo.getSexo()+"");
        this.tf_correoElectronico.setText(equipo.getCorreo());
        this.dp_fechaAlta.setValue(equipo.getFechaAltaMiembroEquipo());
        this.dp_fechaBaja.setValue(equipo.getFechaBajaMiembroEquipo());
        //TODO: ARREGLAR TIPO DE CONTRATO cb_tipoContrato
        //if (cb_tipoContrato != null) { this.cb_tipoContrato.setContextMenu(equipo.getTipoDeEquipo()); }

        /*if (dp_fechaAlta != null) { this.dp_fechaAlta.setValue(equipo.getFechaAltaMiembroEquipo()); }
        if (dp_fechaBaja != null) { this.dp_fechaBaja.setValue(equipo.getFechaBajaMiembroEquipo()); }
        if (tf_proyecto != null) { this.tf_proyecto.setText(String.valueOf(equipo.getIdProyecto())); }*/

        actualizarBotonesNavegacion();
    }

    public void mostrarEquipo(Integer index){

        Equipo equipo = equipos.get(index);

        this.tf_id.setText(equipo.getId().toString());
        this.tf_nombre.setText(equipo.getNombre());
        this.tf_apellido1.setText(equipo.getApellido1());
        this.tf_apellidos2.setText(equipo.getApellido2());
        this.tf_nif.setText(equipo.getDni());
        this.tf_direccion.setText(equipo.getDireccion());
        this.dp_fechaNacimiento.setValue(equipo.getFechaNacimiento());
        this.tf_telefono.setText(equipo.getMovil());
        this.tf_correoElectronico.setText(equipo.getCorreo());
        this.tf_sexo.setText(equipo.getSexo()+"");
        this.dp_fechaAlta.setValue(equipo.getFechaAltaMiembroEquipo());
        this.dp_fechaBaja.setValue(equipo.getFechaBajaMiembroEquipo());
        //TODO: ARREGLAR TIPO DE CONTRATO cb_tipoContrato
        //if (cb_tipoContrato != null) { this.cb_tipoContrato.setContextMenu(equipo.getTipoDeEquipo()); }

        /*if (dp_fechaAlta != null) { this.dp_fechaAlta.setValue(equipo.getFechaAltaMiembroEquipo()); }
        if (dp_fechaBaja != null) { this.dp_fechaBaja.setValue(equipo.getFechaBajaMiembroEquipo()); }
        if (tf_proyecto != null) { this.tf_proyecto.setText(String.valueOf(equipo.getIdProyecto())); }*/

        //ACTUALIZAR INDEX:
        this.equipoIndex = index;

        //ACTUALIZAR BOTÓNES DE NAVEGACIÓN:
        actualizarBotonesNavegacion();

    }

    private void actualizarBotonesNavegacion(){

        try{

            //Si index = 0 -> bloquear botón "Anterior".
            if( equipoIndex == 0) {
                btnAnterior.setDisable(true);
            } else {
                btnAnterior.setDisable(false);
            }

            //Si index = size() -1 -> bloquear botón "Siguiente".
            if( equipoIndex == equipos.size() -1 ){
                //System.out.println("Este es el último registro.");
                btnSiguiente.setDisable(true);
            } else {
                btnSiguiente.setDisable(false);
            }

        } finally {

            this.btnGuardar.setDisable(true);
            this.btnCancelar.setDisable(true);

        }

    }

    private void actualizarBotonesUpdate(){
        this.btnGuardar.setDisable(false);
        this.btnCancelar.setDisable(false);
    }

}
