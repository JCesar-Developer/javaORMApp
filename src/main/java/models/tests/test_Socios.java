package models.tests;

import models.transformers.BbddOng;

import models.models.Socio_CRUD;
import models.transformers.BbddOng;
import models.transformers.Socio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class test_Socios {

    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {

        /* CREACIÓN DEL GESTOR DE PERSISTENCIA (EM) */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Transacciones con EntityManager:
        //-> persist            ->  Insertar datos.
        //-> merge              ->  Modificar datos.
        //-> remove             ->  Eliminar datos.
        //-> find               ->  Obtener un dato.
        //-> getTransaction     ->  Nos permite insertar múltiples elementos.
        //-> createQuery        ->  Nos permite hacer nuestras propias consultas a la BBDD.
        //-> CreateNamedQuery   ->  Nos permite encapsular nuestras consultas para usarlas luego.

        EntityTransaction transaction = entityManager.getTransaction();

        try {

            //--- TESTEO DE LOS CRUD DE SOCIO ---//

            //---------- CRUD ADD [OK] ----------//
            /*
            Socio socio1 = new Socio();

            socio1.setNombre("Tina");
            socio1.setApellido1("López");
            socio1.setApellido2("Del Monte");
            socio1.setCorreo("matilde@gmail.com");
            socio1.setDni("65367129V");
            socio1.setMovil("623695250");
            socio1.setSexo(Socio.Sexo.H);
            socio1.setDireccion("Avda. del Mar, 3, Puerto del Rosario");
            socio1.setFechaAltaSocio(LocalDate.of(2012,07,22));
            socio1.setFechaNacimiento(LocalDate.of(1992,03,12));
            socio1.setCuentaBancaria("ES2636525652116659822754");
            socio1.setTipoCuota(Socio.TipoCuota.MENSUAL);
            socio1.setIdOng(1L);

            Socio_CRUD.add(socio1);
            */

            //--------- CRUD UPDATE [OK] ---------//

            /* LA BÚSQUEDA DEL SOCIO, SE REALIZA POR FUERA
            Socio socio = entityManager.find(Socio.class, 7L);

            //Se cambian los datos del socio.
            socio.setNombre("LauritaxD");
            socio.setApellido1("Del barrio");
            socio.setApellido2("De los maleantes");

            Socio_CRUD.update(socio);
             */

            //--------- CRUD DELETE [OK] ---------//
            /*
            Socio socio = entityManager.find(Socio.class, 5L);
            Socio_CRUD.delete(socio);
            */

            //--------- CRUD GETONE [OK] ---------//
            //Socio_CRUD.getOne(7L);

            //--------- CRUD GETALL [OK] ---------//
            //Socio_CRUD.getAll();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}

/* CÓDIGOS DESCARTADOS
    transaction.begin();

    BbddOng bbddOng = new BbddOng();

    bbddOng.setNombreSede("Sede Julito");
    bbddOng.setUbicacion("Barcelona");

    entityManager.persist(bbddOng);

    transaction.commit();
*/
