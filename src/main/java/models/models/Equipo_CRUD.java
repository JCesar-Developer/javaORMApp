package models.models;

import models.transformers.Equipo;
import models.transformers.Socio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Equipo_CRUD {

    /*-------------------------------------------- INSERT --------------------------------------------*/
    public static void add(EntityManager entityManager, Object equipo) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {

            transaction.begin();  //INICIO DE LA TRANSACCIÓN.

            entityManager.persist(equipo);

            transaction.commit();  //COMMIT Y FIN DE LA TRANSACCIÓN.
            System.out.println("Se ha agregado correctamente el nuevo registro:\n" + equipo);

        } finally {

            if (transaction.isActive()) {
                transaction.rollback();
            }
            //entityManager.close();
            //entityManagerFactory.close();
        }

    }

    /*-------------------------------------------- UPDATE --------------------------------------------*/
    public static void update(EntityManager entityManager, Object equipo) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {

            transaction.begin();  //INICIO DE LA TRANSACCIÓN.

            entityManager.merge(equipo);

            transaction.commit();  //COMMIT Y FIN DE LA TRANSACCIÓN.
            System.out.println("Se ha modificado, correctamente el registro:\n" + equipo);

        } finally {

            if (transaction.isActive()) {
                transaction.rollback();
            }
            //entityManager.close();
            //entityManagerFactory.close();

        }

    }

    /*-------------------------------------------- DELETE --------------------------------------------*/
    public static void delete(EntityManager entityManager, Object equipo) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {

            transaction.begin();  //INICIO DE LA TRANSACCIÓN.

            String equipoString = equipo.toString();
            entityManager.remove(entityManager.contains(equipo) ? equipo : entityManager.merge(equipo));

            transaction.commit();  //COMMIT Y FIN DE LA TRANSACCIÓN.
            System.out.println("Se ha eliminado de la BBDD el registro:\n" + equipoString);

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
    public static Equipo getOne(EntityManager entityManager, Long idEquipo) {

        //TODO: FALTA TRY CATCH, SI NO SE ENCUENTRA EL REGISTRO
        Equipo equipoEncontrado = entityManager.find(Equipo.class, idEquipo);
        return equipoEncontrado;

        /*EntityManager manager = Utils.getEntityManagerFactory().createEntityManager();
        manager.getTransaction().begin();  //Empezamos la transacción
        //FUNCIONES A REALIZAR PARA OBTENER UN MIEMBRO DEL EQUIPO
        Object equipo = new Object();
        equipo = manager.find(Equipo.class, idEquipo);
        //IMPRESIÓN POR CONSOLA PARA VERIFICAR EL RESULTADO
        if (equipo != null) {
            System.out.println("El miembro del equipo solicitado es: " + equipo.toString());
            System.out.println();
        } else {
            System.out.println("Miembro del equipo no encontrado en la base de datos.");
        }
        return (Equipo) equipo;*/
    }

    /*-------------------------------------------- GETALL --------------------------------------------*/
    public static List<Equipo> getAll(EntityManager entityManager) {

        List<Equipo> equipos = (List<Equipo>) entityManager.createQuery("SELECT e FROM Equipo e").getResultList();

        /*//IMPRESIÓN POR CONSOLA PARA VERIFICAR EL RESULTADO
        if (equipos != null) {
            System.out.println("En la base de datos se encuentran los siguientes miembros del equipo:");
            for(Equipo equipo: equipos) {
                System.out.println(equipo.toString());
            }
        } else {
            System.out.println("La base de datos aún no contiene ningún equipo.");
        }*/

        return equipos;

    }

}
