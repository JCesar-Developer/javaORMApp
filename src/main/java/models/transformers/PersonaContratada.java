package models.transformers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name="idEquipo")
public class PersonaContratada extends Equipo {

    @Column(name = "sueldo")
    private float sueldo;

    //--------------------------------- RELACIONES ENTRE CLASES ---------------------------------//
    //@OneToOne(mappedBy = "personaContratada")
    //private Equipo equipo;

    //--------------------------------------- CONSTRUCTORES ---------------------------------------//
    /**
     * Método constructor vacío
     */
    public PersonaContratada() {

    }

    /**
     * Método constructor con datos básicos de los miembros del equipo
     */
    /*
    public PersonaContratada(String nombre, String apellido1, String apellido2, String dni, String direccion, String localidad,
                       String cp, String provincia, LocalDate fechaNacimiento, String movil, String correo, Sexo sexo,
                       String user, String password, LocalDate fechaAltaMiembroEquipo, Rol rol, Long idOng, float sueldo) {
        super(nombre, apellido1, apellido2, dni, direccion, localidad, cp, provincia, fechaNacimiento, movil, correo, sexo,
                user, password, fechaAltaMiembroEquipo, rol, idOng);
        this.sueldo = sueldo;
    }
    */
    // TODO: METODO CONSTRUCTOR CON DATOS DEL TIPO DE CONTRATO


    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    /*
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
     */

    @Override
    public String toString() {
        return "PersonaContratada{" +
                "id=" + super.getId() +
                ", nombre='" + super.getNombre() + '\'' +
                ", apellido1='" + super.getApellido1() + '\'' +
                ", apellido2='" + super.getApellido2() + '\'' +
                ", dni='" + super.getDni() + '\'' +
                ", direccion='" + super.getDireccion() + '\'' +
                ", localidad='" + super.getLocalidad() + '\'' +
                ", cp='" + super.getCp() + '\'' +
                ", provincia='" + super.getProvincia() + '\'' +
                ", fechaNacimiento=" + super.getFechaNacimiento() +
                ", movil='" + super.getMovil() + '\'' +
                ", correo='" + super.getCorreo() + '\'' +
                ", sexo=" + super.getSexo() +
                ", user='" + super.getUser() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", fechaAltaMiembroEquipo=" + super.getFechaAltaMiembroEquipo() +
                ", rol=" + super.getRol() +
                ", idOng=" + super.getIdOng() +
                ", sueldo=" + sueldo +
                '}';
    }
}
