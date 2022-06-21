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
import models.models.Socio_CRUD;
import models.transformers.Socio;

import javax.persistence.EntityManager;
import java.util.List;

public class ListaSocios_Controller extends Controller_Father {

    // --------------------- ATRIBUTOS DE LA VISTA -------------------- //

    @FXML
    private Label ID_ListaSocios;

    @FXML
    private TableView<Socio> tbl_listaSocios;

    @FXML
    private TableColumn col_dni;

    @FXML
    private TableColumn col_nombre;

    @FXML
    private TableColumn col_apellido1;

    @FXML
    private TableColumn col_apellido2;

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
    private TableColumn col_cuentaBancaria;
   @FXML
    private TableColumn col_tipoCuota;

    private ObservableList<Socio> obserbableListSocios;

    // ------------------- RELACIONES ENTRE CLASES -------------------- //

    private EntityManager entityManager;
    private List<Socio> socios;
    private Socio socioSeleccionado;

    Controller_Manager controller_manager = new Controller_Manager();

    // ---------------------- GETTERS & SETTERS ----------------------- //


    // --------------------------- EVENTOS ---------------------------- //

    public void initialize(){

        this.entityManager = Main_Controller.getEntityManager();
        obserbableListSocios = FXCollections.observableArrayList();

        this.col_dni.setCellValueFactory(new PropertyValueFactory("dni"));
        this.col_nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.col_apellido1.setCellValueFactory(new PropertyValueFactory("Apellido1"));
        this.col_apellido2.setCellValueFactory(new PropertyValueFactory("Apellido2"));
        this.col_direccion.setCellValueFactory(new PropertyValueFactory("direccion"));
        this.col_fechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        this.col_movil.setCellValueFactory(new PropertyValueFactory("movil"));
        this.col_correo.setCellValueFactory(new PropertyValueFactory("correo"));
        this.col_sexo.setCellValueFactory(new PropertyValueFactory("sexo"));
        this.col_cuentaBancaria.setCellValueFactory(new PropertyValueFactory("cuentaBancaria"));
        this.col_tipoCuota.setCellValueFactory(new PropertyValueFactory("tipoCuota"));

        //FILTRO 1 == "filtroEspecífico"
        // -> metodo1()

        //FILTRO 2 == "pasandoListaExterna"
        // -> metodo2()

        //FILTRO 3 == "todos"
        //this.socios = Socio_CRUD.getAll(entityManager);
        //for (Socio s : socios) this.obserbableListSocios.add(s);
        //this.tbl_listaSocios.setItems(obserbableListSocios);

    }

    //FILTRO 1 == "filtroEspecífico"
    // -> metodo1()

    //FILTRO 2 == "pasandoListaExterna"
    public void mostrarListaExterna(List<Socio> sociosExternos){

        this.socios = sociosExternos;
        for (Socio s : socios) this.obserbableListSocios.add(s);
        this.tbl_listaSocios.setItems(obserbableListSocios);

    }

    //FILTRO 3 == "todos"
    public void mostrarListaTodos(){

        this.socios = Socio_CRUD.getAll(entityManager);
        for (Socio s : socios) this.obserbableListSocios.add(s);
        this.tbl_listaSocios.setItems(obserbableListSocios);

    }


    @FXML
    private void seleccionarRegistro(MouseEvent event) {

        if (event.getClickCount() == 2){

            this.socioSeleccionado = this.tbl_listaSocios.getSelectionModel().getSelectedItem();
            System.out.println("Se ha seleccionado el socio: " + this.socioSeleccionado);

            Long idSocio = socioSeleccionado.getId();

            String title    = "MOSTRAR SOCIO";
            String viewPath = "/views/socios/MostrarSocio_View.fxml";
            controller_manager.abrirVista(title, viewPath, ID_ListaSocios, idSocio);

        }

    }

    @FXML
    public void btnSalir(ActionEvent event) {
        this.closeWindows();
    }

    @Override
    public void closeWindows() {

        String title    = "MENU LISTADOS";
        String viewPath = "/views/MenuListados_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_ListaSocios);

    }

}

/*  CÓDIGO DESCARTADO:
    ------------------
    obserbableListSocios = FXCollections.observableArrayList();

    this.col_id.setCellValueFactory(new PropertyValueFactory("id"));
    this.col_nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
    this.col_apellido1.setCellValueFactory(new PropertyValueFactory("apellido1"));
    this.col_apellido2.setCellValueFactory(new PropertyValueFactory("apellido2"));

    socio = Socio_CRUD.getOne(entityManager, 13L);

    this.obserbableListSocios.add(socio);
    this.tbl_listaSocios.setItems(obserbableListSocios);
*/