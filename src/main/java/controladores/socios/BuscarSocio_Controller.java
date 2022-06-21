package controladores.socios;

import controladores.Controller_Father;
import controladores.Controller_Manager;
import controladores.Main_Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.models.Socio_CRUD;
import models.transformers.Socio;


import javax.persistence.EntityManager;
import java.util.List;

public class BuscarSocio_Controller extends Controller_Father {

    // --------------------- ATRIBUTOS DE LA VISTA -------------------- //
    @FXML
    private Label ID_BuscarSocios;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_nombre;

    @FXML
    private TextField tf_apellido1;

    @FXML
    private TextField tf_apellido2;

    @FXML
    private TextField tf_NIF;

    @FXML
    private TextField tf_movil;

    @FXML
    private TextField tf_correo;

    // ------------------- RELACIONES ENTRE CLASES -------------------- //

    //@PersistenceContext
    private EntityManager entityManager;

    private List<Socio> socios;
    private Socio       socioEncontrado;
    private int         contadorDeParámetros = 0;
    private enum        opc { a, b, c, d, e, f, g }
    private opc         opcion;

    Controller_Manager controller_manager = new Controller_Manager();

    // ---------------------- GETTERS & SETTERS ----------------------- //

    // ----------------------- MÉTODOS DE CLASE ----------------------- //

    public void initialize(){

        entityManager = Main_Controller.getEntityManager();
        this.socios = Socio_CRUD.getAll(entityManager);

    }

    @FXML
    void btnBuscar(ActionEvent event) {

        try {

            int totalParametros = this.getContadorDeParámetros();

            //ENTRAMOS A LA CONSULTA
            if ( totalParametros == 1 ) {

                List<Socio> sociosEncontrados;

                if ( opcion == opc.a ) {
                    socioEncontrado = Socio_CRUD.getSocioByID(entityManager, Long.valueOf(tf_id.getText()));

                    if ( socioEncontrado != null ) {

                        Long idSocioEncontrado = socioEncontrado.getId();
                        String title    = "MOSTRAR SOCIO";
                        String viewPath = "/views/socios/MostrarSocio_View.fxml";
                        controller_manager.abrirVista(title, viewPath, ID_BuscarSocios, idSocioEncontrado);

                    } else {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("El registro solicitado, no existe en la BBDD. " +
                                "Porfavor, prueba nuevamente.");
                        alert.showAndWait();

                    }

                }
                if ( opcion == opc.b ) {

                    sociosEncontrados = Socio_CRUD.getSocioByNombre(entityManager, tf_nombre.getText());
                    this.realizarBusqueda(sociosEncontrados);

                }
                if ( opcion == opc.c ) {

                    sociosEncontrados = Socio_CRUD.getSocioByApellido1(entityManager, tf_apellido1.getText());
                    this.realizarBusqueda(sociosEncontrados);

                }
                if ( opcion == opc.d ) {

                    sociosEncontrados = Socio_CRUD.getSocioByApellido2(entityManager, tf_apellido2.getText());
                    this.realizarBusqueda(sociosEncontrados);

                }
                if ( opcion == opc.e ) {

                    sociosEncontrados = Socio_CRUD.getSocioByNIF(entityManager, tf_NIF.getText());
                    this.realizarBusqueda(sociosEncontrados);

                }
                if ( opcion == opc.f ) {

                    sociosEncontrados = Socio_CRUD.getSocioByMovil(entityManager, tf_movil.getText());
                    this.realizarBusqueda(sociosEncontrados);

                }
                if ( opcion == opc.g ) {

                    sociosEncontrados = Socio_CRUD.getSocioByCorreo(entityManager, tf_correo.getText());
                    this.realizarBusqueda(sociosEncontrados);

                }

            //ALERTA SI SE ESCRIBE MÁS DE UN PARÁMETRO
            } else if ( this.getContadorDeParámetros() > 1 )  {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("¡ERROR! Solo se puede realizar una búsqueda con un parámetro."+
                                     "Porfavor, prueba nuevamente.");
                alert.showAndWait();

            //ALERTA SI NO SE ESCRIBE NINGUN PARÁMETRO
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Porfavor, introduzca un parámetro de búsqueda");
                alert.showAndWait();

            }

        } finally {

            //SE REINICIA EL CONTADORS A 0
            this.contadorDeParámetros = 0;

        }

    }

    private void realizarBusqueda(List<Socio> sociosEncontrados) {

        if ( sociosEncontrados.size() == 0 ){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El registro solicitado, no existe en la BBDD. " +
                    "Porfavor, prueba nuevamente.");
            alert.showAndWait();

        } else if ( sociosEncontrados.size() == 1 ) {

            socioEncontrado = sociosEncontrados.get(0);

            Long socioID = socioEncontrado.getId();
            String title    = "MOSTRAR SOCIO";
            String viewPath = "/views/socios/MostrarSocio_View.fxml";
            controller_manager.abrirVista(title, viewPath, ID_BuscarSocios, socioID);

        } else {

            //TODO: MOSTRAR LISTA
            String title    = "LISTADO DE BUSCAR SOCIOS";
            String viewPath = "/views/listas/Lista_Socios.fxml";
            controller_manager.abrirListaSociosFiltro2(title, viewPath, ID_BuscarSocios, sociosEncontrados);

        }

    }

    private int getContadorDeParámetros(){

        if (tf_id.getText() != "") {
            this.contadorDeParámetros += 1;
            this.opcion = opc.a;
        }

        if (tf_nombre.getText() != "") {
            this.contadorDeParámetros += 1;
            this.opcion = opc.b;
        }
        if (tf_apellido1.getText() != "") {
            this.contadorDeParámetros += 1;
            this.opcion = opc.c;
        }
        if (tf_apellido2.getText() != "")  {
            this.contadorDeParámetros += 1;
            this.opcion = opc.d;
        }
        if (tf_NIF.getText() != "") {
            this.contadorDeParámetros += 1;
            this.opcion = opc.e;
        }
        if (tf_movil.getText() != "") {
            this.contadorDeParámetros += 1;
            this.opcion = opc.f;
        }
        if (tf_correo.getText() != "") {
            this.contadorDeParámetros += 1;
            this.opcion = opc.g;
        }

        return this.contadorDeParámetros;

    }

    @FXML
    private void btnSalir(ActionEvent event) {
        this.closeWindows();
    }

    @Override
    public void closeWindows() {

        String title    = "MOSTRAR SOCIO";
        String viewPath = "/views/socios/MostrarSocio_View.fxml";
        controller_manager.abrirVista(title, viewPath, ID_BuscarSocios);

    }
}
