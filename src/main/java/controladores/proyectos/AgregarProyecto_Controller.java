package controladores.proyectos;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.models.Proyecto_CRUD;
import models.transformers.Proyecto;

import javax.persistence.EntityManager;

public class AgregarProyecto_Controller extends Controller_Father {

    //Atributes
    @FXML
    private Label ID_AgregarProyecto;

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
    private TextField tf_financiacion;
    @FXML
    private TextField tf_socioLocal;

    //Class relations
    private EntityManager entityManager;
    Controller_Manager controller_manager = new Controller_Manager();

    public void initialize(){entityManager = Main_Controller.getEntityManager();}

    @FXML
    void btnGuardar(){
        try {
            //Setting each value from the view to the class attributes
            Proyecto proyecto = new Proyecto();
            proyecto.setPais(tf_pais.getText());
            proyecto.setLocalizacion(tf_localizacion.getText());
            proyecto.setFechaInicio(dp_fechaInicio.getValue());
            proyecto.setFechaFinal(dp_fechaFinal.getValue());
            proyecto.setFinanciador(tf_financiador.getText());
            proyecto.setFinanciacionAportada(Double.valueOf(tf_financiacion.getText()));
            proyecto.setSocioLocal(tf_socioLocal.getText());

            //Adding the object to DataBase
            Proyecto_CRUD.add(entityManager, proyecto);
        } finally {closeWindows();}
    }

    @FXML
    void btnSalir(){ this.closeWindows();}

    @FXML
    void btnCancelar(){}

    @Override
    public void closeWindows() {
        String title = "MOSTRAR PROYECTOS";
        String path = "/views/proyectos/MostrarProyecto_View.fxml";
        controller_manager.abrirVista(title, path, ID_AgregarProyecto);
    }
}
