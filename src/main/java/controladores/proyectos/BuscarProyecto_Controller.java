package controladores.proyectos;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.models.Proyecto_CRUD;
import models.transformers.Proyecto;

import javax.persistence.EntityManager;
import java.util.List;

public class BuscarProyecto_Controller extends Controller_Father {

    //Class attributes
    @FXML
    private Label ID_BuscarProyecto;
    @FXML
    private TextField tf_id;

    //Class relations
    private EntityManager entityManager;
    private List<Proyecto> projectList;
    Controller_Manager controller_manager = new Controller_Manager();

    public void initialize(){
        entityManager = Main_Controller.getEntityManager();
        this.projectList = Proyecto_CRUD.getAll(entityManager);
    }
    @FXML
    void btnSalir(){this.closeWindows();}

    @FXML
    void btnBuscar() {
        Long idProyecto = Long.valueOf(tf_id.getText());
        Proyecto founded = Proyecto_CRUD.getOne(entityManager, idProyecto);
        int index = projectList.indexOf(founded);
        String title = "MOSTRAR PROYECTOS";
        String path = "/views/proyectos/MostrarProyecto_View.fxml";
        controller_manager.abrirVistaProyecto(title, path, ID_BuscarProyecto, index);
    }

    @Override
    public void closeWindows() {
        String title = "MOSTRAR PROYECTOS";
        String path = "/views/proyectos/MostrarProyecto_View.fxml";
        controller_manager.abrirVista(title, path, ID_BuscarProyecto);
    }
}
