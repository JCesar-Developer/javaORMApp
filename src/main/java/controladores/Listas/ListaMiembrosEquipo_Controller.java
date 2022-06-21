package controladores.Listas;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import models.models.Equipo_CRUD;
import models.transformers.Equipo;

import javax.persistence.EntityManager;
import java.util.List;

public class ListaMiembrosEquipo_Controller extends Controller_Father {


    @FXML
    private Label ID_ListaEquipo;
    @FXML
    private TableView<Equipo> tbl_listaEquipos;
    @FXML
    private TableColumn col_nombre;
    @FXML
    private TableColumn col_apellido1;
    @FXML
    private TableColumn col_apellido2;
    @FXML
    private TableColumn col_dni;
    @FXML
    private TableColumn col_direccion;
    @FXML
    private TableColumn col_fechaNacimiento;
    @FXML
    private TableColumn col_movil;
    @FXML
    private TableColumn col_correo;
    @FXML
    private TableColumn col_sexo;
    @FXML
    private TableColumn col_miembroEquipo;
    @FXML
    private TableColumn col_rol;



    private ObservableList<Equipo> observableEquipoList;
    private EntityManager entityManager;
    private List<Equipo> equipoList;
    private Equipo equipoSeleccionado;
    Controller_Manager controller_manager = new Controller_Manager();

    public void initialize(){
        this.entityManager = Main_Controller.getEntityManager();
        observableEquipoList = FXCollections.observableArrayList();
        this.col_nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.col_apellido1.setCellValueFactory(new PropertyValueFactory("apellido1"));
        this.col_apellido2.setCellValueFactory(new PropertyValueFactory("apellido2"));
        this.col_dni.setCellValueFactory(new PropertyValueFactory("dni"));
        this.col_direccion.setCellValueFactory(new PropertyValueFactory("direccion"));
        this.col_fechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        this.col_movil.setCellValueFactory(new PropertyValueFactory("movil"));
        this.col_correo.setCellValueFactory(new PropertyValueFactory("correo"));
        this.col_sexo.setCellValueFactory(new PropertyValueFactory("sexo"));
        this.col_miembroEquipo.setCellValueFactory(new PropertyValueFactory("tipoDeEquipo"));
        this.col_rol.setCellValueFactory(new PropertyValueFactory("rol"));

        this.equipoList = Equipo_CRUD.getAll(entityManager);
        System.out.println("Imprimo la lista antes de entrar en obserbable: \n" + equipoList);
        for (Equipo e : equipoList) this.observableEquipoList.add(e);
        System.out.println("Imprimo lista ahora obserbable: \n" + observableEquipoList);
        this.tbl_listaEquipos.setItems(observableEquipoList);
    }

    @FXML
    private void seleccionarRegistro(MouseEvent event){
        if (event.getClickCount() == 2){
            this.equipoSeleccionado = this.tbl_listaEquipos.getSelectionModel().getSelectedItem();
            System.out.println("Se ha seleccionado el miembro de equipo: " + this.equipoSeleccionado);
            int index = equipoList.indexOf(equipoSeleccionado);

            String title = "MOSTRAR MIEMBRO EQUIPO";
            String path = "/views/miembrosEquipo/MostrarMiembroEquipo_View.fxml";
            controller_manager.abrirVistaEquipo(title, path, ID_ListaEquipo, index);

        }
    }
    @FXML
    void btnSalir(ActionEvent event) {
        this.closeWindows();
    }

    @Override
    public void closeWindows() {
        String title    = "MENU LISTADOS";
        String viewPath = "/views/MenuListados_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_ListaEquipo);
    }
}
