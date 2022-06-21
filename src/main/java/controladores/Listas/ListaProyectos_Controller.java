package controladores.Listas;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.models.Proyecto_CRUD;
import models.transformers.Proyecto;

import javax.persistence.EntityManager;
import java.util.List;

public class ListaProyectos_Controller extends Controller_Father {

    @FXML
    private Label ID_ListaProyectos;
    @FXML
    private TableView<Proyecto> tbl_listaProyectos;
    @FXML
    private TableColumn col_id;
    @FXML
    private TableColumn col_pais;
    @FXML
    private TableColumn col_localizacion;
    @FXML
    private TableColumn col_fechaInicio;
    @FXML
    private TableColumn col_fechaFin;
    @FXML
    private TableColumn col_financiador;
    @FXML
    private TableColumn col_financiacion;
    @FXML
    private TableColumn col_socioLocal;

    private ObservableList<Proyecto> obserbableProjectList;
    private EntityManager entityManager;
    private List<Proyecto> projectList;
    private Proyecto selectedProject;

    //To close window
    Controller_Manager controller_manager = new Controller_Manager();

    public void initialize(){
        //Class relations
        this.entityManager = Main_Controller.getEntityManager();
        //Elements
        obserbableProjectList = FXCollections.observableArrayList();
        //Setting values to each cell from each row in each column
        this.col_id.setCellValueFactory(new PropertyValueFactory("IdProyecto"));
        this.col_pais.setCellValueFactory(new PropertyValueFactory("Pais"));
        this.col_localizacion.setCellValueFactory(new PropertyValueFactory("Localizacion"));
        this.col_fechaInicio.setCellValueFactory(new PropertyValueFactory("FechaInicio"));
        this.col_fechaFin.setCellValueFactory(new PropertyValueFactory("FechaFinal"));
        this.col_financiador.setCellValueFactory(new PropertyValueFactory("Financiador"));
        this.col_financiacion.setCellValueFactory(new PropertyValueFactory("FinanciacionAportada"));
        this.col_socioLocal.setCellValueFactory(new PropertyValueFactory("SocioLocal"));


        this.projectList = Proyecto_CRUD.getAll(entityManager);
        System.out.println("Hola" + projectList);
        for (Proyecto p : projectList) this.obserbableProjectList.add(p);
        System.out.println(obserbableProjectList);
        this.tbl_listaProyectos.setItems(obserbableProjectList);
    }

    @FXML
    private void seleccionarRegistro(MouseEvent event) {
        if (event.getClickCount()==2){ //when double clicked an element from the table
            this.selectedProject = this.tbl_listaProyectos.getSelectionModel().getSelectedItem();
            System.out.println("Se ha seleccionado el proyecto: " + this.selectedProject + "\n");
            int index = projectList.indexOf(selectedProject);

            //Opening the selected item in another view
            String title = "MOSTRAR PROYECTO";
            String viewPath = "/views/proyectos/MostrarProyecto_View.fxml";
            controller_manager.abrirVistaProyecto(title, viewPath, ID_ListaProyectos, index);
        }
    }

    @FXML
    public void btnSalir(ActionEvent event) {this.closeWindows();}

    @Override
    public void closeWindows() {
        String title = "MENU LISTADOS";
        String viewPath = "/views/MenuListados_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_ListaProyectos);
    }
}
