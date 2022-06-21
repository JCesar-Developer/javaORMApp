package models.transformers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name="idEquipo")
public class VoluntarioInternacional extends Equipo {

    @Column(name = "pais")
    private String pais;

    //--------------------------------- RELACIONES ENTRE CLASES ---------------------------------//
//    @OneToOne(mappedBy = "voluntarioInternacional")
//    private Equipo equipo;

    //--------------------------------------- CONSTRUCTORES ---------------------------------------//
    /**
     * Método constructor vacío
     */
    public VoluntarioInternacional() {

    }

    /**
     * Método constructor con datos básicos de los miembros del equipo
     */
    /*
    public VoluntarioInternacional(String nombre, String apellido1, String apellido2, String dni, String direccion, String localidad,
                       String cp, String provincia, LocalDate fechaNacimiento, String movil, String correo, Sexo sexo,
                       String user, String password, LocalDate fechaAltaMiembroEquipo, Rol rol, Long idOng, String pais) {
        super(nombre, apellido1, apellido2, dni, direccion, localidad, cp, provincia, fechaNacimiento, movil, correo, sexo,
                user, password, fechaAltaMiembroEquipo, rol, idOng);
        this.pais = pais;
    }

    // TODO: METODO CONSTRUCTOR CON DATOS DEL TIPO DE CONTRATO
    */

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
        return "VoluntarioInternacional{" +
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
                ", pais='" + pais + '\'' +
                '}';
    }
}
