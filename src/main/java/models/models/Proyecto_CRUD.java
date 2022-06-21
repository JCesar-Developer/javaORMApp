package models.models;

import models.transformers.Proyecto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Proyecto_CRUD {

    //Insert method
    public static void add(EntityManager entityManager, Proyecto proyecto){

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin(); //Starting transaction. ADDING STUFF AFTER THIS
                entityManager.persist(proyecto); //adding entity here
            transaction.commit(); //Sending information through ORM
            System.out.println("Se ha agregado correctamente el nuevo registro:\n" + proyecto + "\n");

        } finally {
            if (transaction.isActive()) {
                transaction.rollback(); //closing transaction
            }
        }
    }

    //Update method
    public static void update(EntityManager entityManager, Proyecto proyecto){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); //Starting transaction. UPDATING STUFF AFTER THIS
                entityManager.merge(proyecto);
            transaction.commit();//Sending information through ORM
            System.out.println("Se ha modificado correctamente el registro: " + proyecto + "\n");

        }finally {
            if (transaction.isActive()){
                transaction.rollback();//Closing transaction
            }
        }
    }

    //Delete method
    public static void delete(EntityManager entityManager, Proyecto proyecto){
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin(); //Starting transaction. DELETING STUFF AFTER THIS
                String proyectoString = proyecto.toString();
                entityManager.remove(entityManager.contains(proyecto) ? proyecto : entityManager.merge(proyecto)); //Deleting object
            transaction.commit(); //Sending informatin through ORM
            System.out.printf("Se ha eliminado corectamente el registro:" + proyectoString + "\n");

        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
        }
    }

    //Get one method
    public static Proyecto getOne(EntityManager entityManager, Long idProyecto){
        Proyecto founded = entityManager.find(Proyecto.class, idProyecto);
        return founded;
    }

    //Get all method
    public static List<Proyecto> getAll(EntityManager entityManager){
        List<Proyecto> listaProyectos = (List<Proyecto>) entityManager.createQuery("SELECT e FROM Proyecto e").getResultList();
        return listaProyectos;
    }

}
