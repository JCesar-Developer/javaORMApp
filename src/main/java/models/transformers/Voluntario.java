package models.transformers;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name="idEquipo")
public class Voluntario extends Equipo /*implements Serializable*/ {
    //@Basic
    @Column(name = "horasPorSemana")
    private float horasPorSemana;

    //--------------------------------- RELACIONES ENTRE CLASES ---------------------------------//
    //@OneToOne(mappedBy = "voluntario"/*, fetch = FetchType.LAZY*/) // Borrar fetch si queremos que haga getVoluntario directamente
    //private Equipo equipo;

    //--------------------------------------- CONSTRUCTORES ---------------------------------------//
    /**
     * Método constructor vacío
     */
    public Voluntario() {

    }

    /**
     * Método constructor con datos básicos de los miembros del equipo
     */
    /*
    public Voluntario(String nombre, String apellido1, String apellido2, String dni, String direccion, String localidad,
                      String cp, String provincia, LocalDate fechaNacimiento, String movil, String correo, Sexo sexo,
                      String user, String password, LocalDate fechaAltaMiembroEquipo, Rol rol, Long idOng, float horasPorSemana) {
        super(nombre, apellido1, apellido2, dni, direccion, localidad, cp, provincia, fechaNacimiento, movil, correo, sexo,
                user, password, fechaAltaMiembroEquipo, rol, idOng);
        this.horasPorSemana = horasPorSemana;
    }
    */
    // TODO: METODO CONSTRUCTOR CON DATOS DEL TIPO DE CONTRATO


    //------------------------------------ GETTERS Y SETTERS ------------------------------------//

    public float getHorasPorSemana() {
        return horasPorSemana;
    }

    public void setHorasPorSemana(float horasPorSemana) {
        this.horasPorSemana = horasPorSemana;
    }

    /*
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo idEquipo) {
        this.equipo = idEquipo;
    }
     */

    @Override
    public String toString() {
        return "Voluntario{" +
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
                ", horasPorSemana=" + horasPorSemana +
                '}';
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voluntario that = (Voluntario) o;

        if (horasPorSemana != null ? !horasPorSemana.equals(that.horasPorSemana) : that.horasPorSemana != null)
            return false;
        if (idEquipo != null ? !idEquipo.equals(that.idEquipo) : that.idEquipo != null) return false;

        return true;
    }*/

    /*@Override
    public int hashCode() {
        int result = horasPorSemana != null ? horasPorSemana.hashCode() : 0;
        result = 31 * result + (idEquipo != null ? idEquipo.hashCode() : 0);
        return result;
    }*/

}
