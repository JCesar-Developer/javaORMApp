package models.tests;

import models.models.Equipo_CRUD;
import models.transformers.Colaborador;
import models.transformers.Equipo;
import models.transformers.PersonaContratada;
import models.transformers.Voluntario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class test_Equipo {

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

            //--- TESTEO DE LOS CRUD DE EQUIPO ---//

            //---------- CRUD ADD [OK] ----------//

            //--- Testeo clase Voluntario ---//
            /*Voluntario voluntario1 = new Voluntario();

            voluntario1.setNombre("Arantxa");
            voluntario1.setApellido1("Iturralde");
            voluntario1.setApellido2("Faz");
            voluntario1.setDni("65367129V");
            voluntario1.setDireccion("Avda. del Mar, 3");
            voluntario1.setLocalidad("Tuineje");
            voluntario1.setCp("35620");
            voluntario1.setProvincia("Las Palmas");
            voluntario1.setFechaNacimiento(LocalDate.of(1992,03,12));
            voluntario1.setMovil("623695250");
            voluntario1.setCorreo("arantxa@gmail.com");
            voluntario1.setSexo(Equipo.Sexo.M);
            voluntario1.setUser("aiturralde");
            voluntario1.setPassword("pass3");
            voluntario1.setFechaAltaMiembroEquipo(LocalDate.of(2018,07,22));
            voluntario1.setRol(Equipo.Rol.USUARIO);
            voluntario1.setIdOng(1L);
            voluntario1.setHorasPorSemana(20);

            Equipo_CRUD.add(voluntario1);*/

            //--- Testeo clase Colaborador ---//
            /*Colaborador colaborador1 = new Colaborador();

            colaborador1.setNombre("Marco");
            colaborador1.setApellido1("Bescós");
            colaborador1.setApellido2("Faz");
            colaborador1.setDni("65335229V");
            colaborador1.setDireccion("Paseo Pamplona, 3, 5ºC");
            colaborador1.setLocalidad("Zaragoza");
            colaborador1.setCp("50005");
            colaborador1.setProvincia("Zaragoza");
            colaborador1.setFechaNacimiento(LocalDate.of(1985,07,03));
            colaborador1.setMovil("622213450");
            colaborador1.setCorreo("marco@gmail.com");
            colaborador1.setSexo(Equipo.Sexo.H);
            colaborador1.setUser("mbescos");
            colaborador1.setPassword("pass4");
            colaborador1.setFechaAltaMiembroEquipo(LocalDate.of(2020,05,10));
            colaborador1.setRol(Equipo.Rol.USUARIO);
            colaborador1.setIdOng(1L);
            colaborador1.setTipoColaboracion("Campañas");

            Equipo_CRUD.add(colaborador1);*/

            //--------- CRUD UPDATE [OK] ---------//

             //LA BÚSQUEDA DEL MIEMBRO DEL EQUIPO SE REALIZA POR FUERA
             /*Voluntario voluntario = entityManager.find(Voluntario.class, 17L);*/

            //Se cambian los datos del socio.
            /*voluntario.setNombre("Arantxa");
            voluntario.setCorreo("arantxa@gmail.com");
            voluntario.setUser("aiturralde");
            voluntario.setHorasPorSemana(25);

            Equipo_CRUD.update(voluntario);*/


            //--------- CRUD DELETE [OK] ---------//

            /*PersonaContratada personaContratada = entityManager.find(PersonaContratada.class, 19L);
            Equipo_CRUD.delete(personaContratada);*/


            //--------- CRUD GETONE [OK] ---------//
            //Equipo_CRUD.getOne(18L);

            //--------- CRUD GETALL [OK] ---------//
            //Equipo_CRUD.getAll();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
