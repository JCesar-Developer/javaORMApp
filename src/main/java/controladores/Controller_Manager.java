package controladores;

import controladores.Listas.ListaSocios_Controller;
import controladores.miembrosEquipo.MostrarMiembroEquipo_Controller;
import controladores.proyectos.MostrarProyecto_Controller;
import controladores.socios.MostrarSocio_Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Controller_Manager {

    /**
     * Opens a new VIEW
     * @param title Put here the title of the new View
     * @param viewPath Put here the Path of the new View
     * @param idReturnView Put here the ID from the current View, to close it when to leave.
     */
    public void abrirVista(String title, String viewPath, Label idReturnView){

        try {

            //Paso 0: Inicializamos un nuevo objeto de tipo renderizador
            Stage stage = new Stage();

            //Paso 1: Importamos la vista de los Inputs.
            FXMLLoader view = new FXMLLoader(getClass().getResource(viewPath));
            Scene scene = new Scene(view.load());

            //Paso 2: Inicializamos el controlador y le entregamos la lista de personas antes de lanzar la vista
            Controller_Father controller = view.getController();

            //Paso 3: Configuramos la vista
            stage.setTitle(title);
            stage.setScene(scene);

            //Paso 4: Lanzamos la vista
            System.out.println("\nVentana, " +title+ " ejecutandose.");
            stage.show();

            //¿?¿?¿?
            stage.setOnCloseRequest( e -> controller.closeWindows() );

            //¿?¿?¿?
            Stage myStage = (Stage) idReturnView.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

    }

    public void abrirVista(String title, String viewPath, Label idReturnView, Long idRegistro){

        try {

            //Paso 0: Inicializamos un nuevo objeto de tipo renderizador
            Stage stage = new Stage();

            //Paso 1: Importamos la vista de los Inputs.
            FXMLLoader view = new FXMLLoader(getClass().getResource(viewPath));
            Scene scene = new Scene(view.load());

            //Paso 2: Inicializamos el controlador y le entregamos la lista de personas antes de lanzar la vista
            MostrarSocio_Controller controller = view.getController();

            //Paso 3: Configuramos la vista
            stage.setTitle(title);
            stage.setScene(scene);

            //Paso 4: Lanzamos la vista
            System.out.println("\nVentana, " +title+ " ejecutandose.");
            stage.show();

            //TODO: ¡AQUÍ EL GET ONE!
            controller.mostrarSocio(idRegistro);

            //¿?¿?¿?
            stage.setOnCloseRequest( e -> controller.closeWindows() );

            //¿?¿?¿?
            Stage myStage = (Stage) idReturnView.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

    }

    public void abrirVistaEquipo(String title, String viewPath, Label idReturnView, Integer index){

        try {

            //Paso 0: Inicializamos un nuevo objeto de tipo renderizador
            Stage stage = new Stage();

            //Paso 1: Importamos la vista de los Inputs.
            FXMLLoader view = new FXMLLoader(getClass().getResource(viewPath));
            Scene scene = new Scene(view.load());

            //Paso 2: Inicializamos el controlador y le entregamos la lista de personas antes de lanzar la vista
            MostrarMiembroEquipo_Controller controller = view.getController();

            //Paso 3: Configuramos la vista
            stage.setTitle(title);
            stage.setScene(scene);

            //Paso 4: Lanzamos la vista
            System.out.println("\nVentana, " +title+ " ejecutandose.");
            stage.show();

            //TODO: ¡AQUÍ EL GET ONE!
            controller.mostrarEquipo(index);

            //¿?¿?¿?
            stage.setOnCloseRequest( e -> controller.closeWindows() );

            //¿?¿?¿?
            Stage myStage = (Stage) idReturnView.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

    }

    public void abrirVistaProyecto(String title, String viewPath, Label idReturnView, Integer index){

        try {

            //Paso 0: Inicializamos un nuevo objeto de tipo renderizador
            Stage stage = new Stage();

            //Paso 1: Importamos la vista de los Inputs.
            FXMLLoader view = new FXMLLoader(getClass().getResource(viewPath));
            Scene scene = new Scene(view.load());

            //Paso 2: Inicializamos el controlador y le entregamos la lista de personas antes de lanzar la vista
            MostrarProyecto_Controller controller = view.getController();

            //Paso 3: Configuramos la vista
            stage.setTitle(title);
            stage.setScene(scene);

            //Paso 4: Lanzamos la vista
            System.out.println("\nVentana, " +title+ " ejecutandose.");
            stage.show();

            //TODO: ¡AQUÍ EL GET ONE!
            controller.showProject(index);

            //¿?¿?¿?
            stage.setOnCloseRequest( e -> controller.closeWindows() );

            //¿?¿?¿?
            Stage myStage = (Stage) idReturnView.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

    }

    public void abrirListaSociosFiltro2(String title, String viewPath, Label idReturnView, List list){

        try {

            //Paso 0: Inicializamos un nuevo objeto de tipo renderizador
            Stage stage = new Stage();

            //Paso 1: Importamos la vista de los Inputs.
            FXMLLoader view = new FXMLLoader(getClass().getResource(viewPath));
            Scene scene = new Scene(view.load());

            //Paso 2: Inicializamos el controlador y le entregamos la lista de personas antes de lanzar la vista
            ListaSocios_Controller controller  = view.getController();

            //Paso 3: Configuramos la vista
            stage.setTitle(title);
            stage.setScene(scene);

            //Paso 4: Lanzamos la vista
            System.out.println("\nVentana, " +title+ " ejecutandose.");
            stage.show();

            //TODO: ¡AQUÍ EL GET ONE!
            controller.mostrarListaExterna(list);

            //¿?¿?¿?
            stage.setOnCloseRequest( e -> controller.closeWindows() );

            //¿?¿?¿?
            Stage myStage = (Stage) idReturnView.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

    }

    public void abrirListaSociosFiltro3(String title, String viewPath, Label idReturnView){

        try {

            //Paso 0: Inicializamos un nuevo objeto de tipo renderizador
            Stage stage = new Stage();

            //Paso 1: Importamos la vista de los Inputs.
            FXMLLoader view = new FXMLLoader(getClass().getResource(viewPath));
            Scene scene = new Scene(view.load());

            //Paso 2: Inicializamos el controlador y le entregamos la lista de personas antes de lanzar la vista
            ListaSocios_Controller controller  = view.getController();

            //Paso 3: Configuramos la vista
            stage.setTitle(title);
            stage.setScene(scene);

            //Paso 4: Lanzamos la vista
            System.out.println("\nVentana, " +title+ " ejecutandose.");
            stage.show();

            //TODO: ¡AQUÍ EL GET ONE!
            controller.mostrarListaTodos();

            //¿?¿?¿?
            stage.setOnCloseRequest( e -> controller.closeWindows() );

            //¿?¿?¿?
            Stage myStage = (Stage) idReturnView.getScene().getWindow();
            myStage.close();

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

    }

}
