package controladores.proyectos;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import  javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import models.models.Proyecto_CRUD;
import models.transformers.Proyecto;
import javax.persistence.EntityManager;
import java.util.List;

public class MostrarProyecto_Controller extends Controller_Father {

    @FXML
    private Label ID_MostrarProyecto;

    //Class attributes
    @FXML
    private TextField tf_idProyecto;
    @FXML
    private TextField tf_pais;
    @FXML
    private TextField tf_localizacion;
    @FXML
    private DatePicker dp_fechaInicio;
    @FXML
    private DatePicker dp_fechaFinal;
    @FXML
    private TextField tf_financiador;
    @FXML
    private TextField tf_financiacionAportada;
    @FXML
    private TextField tf_socioLocal;
    @FXML
    private Button btnAnterior;
    @FXML
    private Button btnSiguiente;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;



    //Class relations
    private EntityManager entityManager;
    private List<Proyecto> projectList;
    private int projectIndex;
    private Proyecto project;
    Controller_Manager controller_manager = new Controller_Manager();

    //Getters & setters

    public List<Proyecto> getProjectList(){return projectList;}
    public Proyecto getProyecto() {return project;}

    //Methods
    public void initialize(){
        entityManager = Main_Controller.getEntityManager();
        this.projectList = Proyecto_CRUD.getAll(entityManager);
        //Show last project added
        this.projectIndex = projectList.size() - 1;
        this.project = projectList.get(projectIndex);
        this.showProject(project);
    }

    @FXML
    void btnAnterior(ActionEvent event){
        this.projectIndex--;
        this.project = projectList.get(projectIndex);
        showProject(project);
        actualizarBotonesNavegacion();
    }

    @FXML
    void btnSiguiente(ActionEvent event){
        this.projectIndex++;
        this.project = projectList.get(projectIndex);
        showProject(project);
        actualizarBotonesNavegacion();
    }

    @FXML
    void btnGuardar(){
        try {
            this.project.setPais(tf_pais.getText());
            this.project.setLocalizacion(tf_localizacion.getText());
            this.project.setFechaInicio(dp_fechaInicio.getValue());
            this.project.setFechaFinal(dp_fechaFinal.getValue());
            this.project.setFinanciador(tf_financiador.getText());
            this.project.setFinanciacionAportada(Double.parseDouble(tf_financiacionAportada.getText()));
            this.project.setSocioLocal(tf_socioLocal.getText());
            Proyecto_CRUD.update(entityManager, project);
        } finally {
            this.btnGuardar.setDisable(true);
            this.btnCancelar.setDisable(true);
        }
    }

    @FXML
    void btnCancelar(){
        showProject(this.project);
        this.btnGuardar.setDisable(true);
        this.btnCancelar.setDisable(true);
    }

    @FXML
    void btnNuevo(){
        String title    = "AGREGAR NUEVO PROYECTO";
        String viewPath = "/views/proyectos/AgregarProyecto_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_MostrarProyecto);
    }

    @FXML
    void btnBorrar(){
        Proyecto_CRUD.delete(entityManager, this.project);
        this.initialize();
    }

    @FXML
    void btnBuscar(){
        String title    = "BUSCAR PROYECTO";
        String viewPath = "/views/proyectos/BuscarProyecto_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_MostrarProyecto);
    }

    @FXML
    void btnSalir(){this.closeWindows();}

    //Key Event
    @FXML
    void updPais(KeyEvent event) {actualizarBotonesUpdate();}
    @FXML
    void updLocalizacion(KeyEvent event) {actualizarBotonesUpdate();}
    @FXML
    void updFechaInicio(KeyEvent event) {actualizarBotonesUpdate();}
    @FXML
    void updFechaFin(KeyEvent event) {actualizarBotonesUpdate();}
    @FXML
    void updFinanciador(KeyEvent event) {actualizarBotonesUpdate();}
    @FXML
    void updFinanciado(KeyEvent event) {actualizarBotonesUpdate();}
    @FXML
    void updSocioLocal(KeyEvent event) {actualizarBotonesUpdate();}

    private void showProject(Proyecto project){
        this.tf_idProyecto.setText(String.valueOf(project.getIdProyecto()));
        this.tf_pais.setText(project.getPais());
        this.tf_localizacion.setText(project.getLocalizacion());
        this.dp_fechaInicio.setValue(project.getFechaInicio());
        this.dp_fechaFinal.setValue(project.getFechaFinal());
        this.tf_financiador.setText(project.getFinanciador());
        this.tf_financiacionAportada.setText(String.valueOf(project.getFinanciacionAportada()));
        this.tf_socioLocal.setText(project.getSocioLocal());
        //Update buttons so it does not allow going further de last/first project added
        actualizarBotonesNavegacion();
    }

    public void showProject(Integer projectIndex){

        Proyecto proyecto = projectList.get(projectIndex);

        this.tf_idProyecto.setText(String.valueOf(proyecto.getIdProyecto()));
        this.tf_pais.setText(proyecto.getPais());
        this.tf_localizacion.setText(proyecto.getLocalizacion());
        this.dp_fechaInicio.setValue(proyecto.getFechaInicio());
        this.dp_fechaFinal.setValue(proyecto.getFechaFinal());
        this.tf_financiador.setText(proyecto.getFinanciador());
        this.tf_financiacionAportada.setText(String.valueOf(proyecto.getFinanciacionAportada()));
        this.tf_socioLocal.setText(proyecto.getSocioLocal());

        //Index update
        this.projectIndex = projectIndex;
        // Update buttons so it does not allow going further de last/first project added
        actualizarBotonesNavegacion();
    }

    @FXML
    private void actualizarBotonesNavegacion(){
        try {
            //When showing the first project, disable 'btnAnterior'
            if (projectIndex == 0){
                btnAnterior.setDisable(true);
            } else btnAnterior.setDisable(false);

            //When showing the last project, disable 'btnSiguiente'
            if (projectIndex == projectList.size() -1){
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

    @Override
    public void closeWindows() {
        String title = "MENÚ PRINCIPAL";
        String path = "/views/MenuInicio_View.fxml";
        controller_manager.abrirVista(title, path, ID_MostrarProyecto);
    }
}