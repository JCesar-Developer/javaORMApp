package controladores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class  Main_Controller extends Application {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    @Override
    public void start(Stage stage) throws IOException {

        //TODO: NO ELIMINAR!!!

        entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        FXMLLoader fxmlLoader = new FXMLLoader(Main_Controller.class.getResource("/views/Login_View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("USER AUTHENTICATION");
        //Logo EntreculturasONG añadido como Favicon (para que aparezca en la ventana/pestaña del explorador)
        Image icon = new Image("/icons/logo_ong.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();


        //TODO: NO ELIMINAR!!! - CÓDIGO PARA ARRANCAR LA APP SIN LOGIN
        /*entityManagerFactory  = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();

        FXMLLoader fxmlLoader = new FXMLLoader(Main_Controller.class.getResource("/views/MenuInicio_View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MENÚ PRINCIPAL");
        //Logo EntreculturasONG añadido como Favicon (para que aparezca en la ventana/pestaña del explorador)
        Image icon = new Image("/icons/logo_ong.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        System.out.println("Bienvenido a la APP de PrUOCxy_Server");
        stage.show();*/


    }

    public static void main(String[] args) {
        launch();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

}


