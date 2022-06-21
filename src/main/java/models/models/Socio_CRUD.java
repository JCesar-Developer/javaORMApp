package models.models;

import models.transformers.Socio;

import javax.persistence.*;
import java.util.List;

public class Socio_CRUD {

    /*-------------------------------------------- INSERT --------------------------------------------*/
    public static void add(EntityManager entityManager, Socio socio) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {

            transaction.begin();  //INICIO DE LA TRANSACCIÓN.

                entityManager.persist(socio);

            transaction.commit();  //COMMIT Y FIN DE LA TRANSACCIÓN.
            System.out.println("Se ha agregado correctamente, el nuevo registro:\n" + socio);

        } finally {

            if (transaction.isActive()) {
                transaction.rollback();
            }
            //entityManager.close();
            //entityManagerFactory.close();

        }

    }

    /*-------------------------------------------- UPDATE --------------------------------------------*/
    public static void update(EntityManager entityManager, Socio socio) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {

            transaction.begin();  //INICIO DE LA TRANSACCIÓN.

                entityManager.merge(socio);

            transaction.commit();  //COMMIT Y FIN DE LA TRANSACCIÓN.
            System.out.println("Se ha modificado, correctamente, el registro:\n" + socio);

        } finally {

            if (transaction.isActive()) {
                transaction.rollback();
            }
            //entityManager.close();
            //entityManagerFactory.close();

        }

    }

    /*-------------------------------------------- DELETE --------------------------------------------*/
    public static void delete(EntityManager entityManager, Socio socio) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {

        transaction.begin();  //INICIO DE LA TRANSACCIÓN.

            String socioString = socio.toString();
            entityManager.remove(entityManager.contains(socio) ? socio : entityManager.merge(socio));

        transaction.commit();  //COMMIT Y FIN DE LA TRANSACCIÓN.
        System.out.println("Se ha eliminado de la BBDD el registro:\n" + socioString);

        } finally {

            if (transaction.isActive()) {
                transaction.rollback();
            }
            //entityManager.close();
            //entityManagerFactory.close();

        }

    }

    /*-------------------------------------------- GETONE --------------------------------------------*/
    // -> Entra un dato por consola --> WHERE --> LISTA
    public static Socio getSocioByID(EntityManager entityManager, Long idSocio) {

        Socio socioEncontrado = entityManager.find(Socio.class, idSocio);
        return socioEncontrado;

    }

    public static List<Socio> getSocioByNombre(EntityManager entityManager, String tf_nombre) {

        Query query = entityManager.createQuery("SELECT s FROM Socio s WHERE s.nombre = :nombreBuscado");
        query.setParameter("nombreBuscado", tf_nombre);
        List<Socio> socios = (List<Socio>) query.getResultList();
        return socios;

    }

    public static List<Socio> getSocioByApellido1(EntityManager entityManager, String tf_apellido1) {

        Query query = entityManager.createQuery("SELECT s FROM Socio s WHERE s.apellido1 = :apellidoBuscado");
        query.setParameter("apellidoBuscado", tf_apellido1);
        List<Socio> socios = (List<Socio>) query.getResultList();
        return socios;

    }

    public static List<Socio> getSocioByApellido2(EntityManager entityManager, String tf_apellido2) {

        Query query = entityManager.createQuery("SELECT s FROM Socio s WHERE s.apellido2 = :apellidoBuscado");
        query.setParameter("apellidoBuscado", tf_apellido2);
        List<Socio> socios = (List<Socio>) query.getResultList();
        return socios;

    }


    public static List<Socio> getSocioByNIF(EntityManager entityManager, String tf_NIF) {

        Query query = entityManager.createQuery("SELECT s FROM Socio s WHERE s.dni = :nifBuscado");
        query.setParameter("nifBuscado", tf_NIF);
        List<Socio> socios = (List<Socio>) query.getResultList();
        return socios;

    }

    public static List<Socio> getSocioByMovil(EntityManager entityManager, String tf_movil) {

        Query query = entityManager.createQuery("SELECT s FROM Socio s WHERE s.movil = :movilBuscado");
        query.setParameter("movilBuscado", tf_movil);
        List<Socio> socios = (List<Socio>) query.getResultList();
        return socios;

    }

    public static List<Socio> getSocioByCorreo(EntityManager entityManager, String tf_correo) {

        Query query = entityManager.createQuery("SELECT s FROM Socio s WHERE s.correo = :correoBuscado");
        query.setParameter("correoBuscado", tf_correo);
        List<Socio> socios = (List<Socio>) query.getResultList();
        return socios;

    }

    /*-------------------------------------------- GETALL --------------------------------------------*/
    public static List<Socio> getAll(EntityManager entityManager) {

        List<Socio> socios = (List<Socio>) entityManager.createQuery("SELECT s FROM Socio s").getResultList();
        return socios;

    }
}
