package models.transformers;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "socio")
public class Socio implements Serializable {

    //private static final long serialVersionUID = 1L;
    public enum TipoCuota { MENSUAL, TRIMESTRAL, ANUAL }
    private enum Sexo { M, H, X }

    //---------------------------- ATRIBUTOS ----------------------------//
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idSocio")
    private Long idSocio;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellido1")
    private String apellido1;
    @Column (name = "apellido2")
    private String apellido2;
    @Column (name = "dni")
    private String dni;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "cp")
    private String cp;
    @Column(name = "provincia")
    private String provincia;
    //@Temporal(TemporalType.DATE) ----> @Temporal sólo se usa en DATE, no en LOCALDATE
    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "movil")
    private String movil;
    @Column(name = "correo")
    private String correo;
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoCuota")
    private TipoCuota tipoCuota;
    @Column(name = "fechaAlta")
    private LocalDate fechaAlta;
    @Column(name = "fechaBaja")
    private LocalDate fechaBaja;
    @Column(name = "cuentaBancaria")
    private String cuentaBancaria;

    //--------------------- RELACIONES ENTRE CLASES ---------------------//
    @Column(name = "idONG")
    private Long idOng;
    //private IngresoPrivado_Transformer ingreso;
    //private ArrayList<Proyecto_Transformer> proyectosAsignados;

    //-------------------------- CONSTRUCTORES --------------------------//
    /**
     *
     */
    public Socio() {
    }

    /**
     *
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param dni
     * @param direccion
     * @param fechaNacimiento
     * @param movil
     * @param correo
     * @param sexo
     */
    public Socio(String nombre, String apellido1, String apellido2, String dni, String direccion,
                 LocalDate fechaNacimiento, String movil, String correo, Sexo sexo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.movil = movil;
        this.correo = correo;
        this.sexo = sexo;
    }

    /**
     *
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param dni
     * @param direccion
     * @param fechaNacimiento
     * @param movil
     * @param correo
     * @param sexo
     * @param tipoCuota
     * @param fechaAlta
     * @param cuentaBancaria
     */
    public Socio(String nombre, String apellido1, String apellido2, String dni, String direccion,
                 LocalDate fechaNacimiento, String movil, String correo, Sexo sexo, TipoCuota tipoCuota,
                 LocalDate fechaAlta, String cuentaBancaria) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.movil = movil;
        this.correo = correo;
        this.sexo = sexo;
        this.tipoCuota = tipoCuota;
        this.fechaAlta = fechaAlta;
        this.cuentaBancaria = cuentaBancaria;
        this.idOng = 1L;
    }

    //------------------------ GETTERS & SETTERS ------------------------//

    public Long getId() {
        return idSocio;
    }

    public void setId(Long id) {
        this.idSocio = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {

        switch(sexo) {
            case "H":
                this.sexo = Sexo.H;
                break;
            case "M":
                this.sexo = Sexo.M;
                break;
            default:
                this.sexo = Sexo.X;
                break;
        }

    }

    public TipoCuota getTipoCuota() {
        return tipoCuota;
    }

    public void setTipoCuota(TipoCuota tipoCuota) {
        this.tipoCuota = tipoCuota;
    }

    public LocalDate getFechaAltaSocio() {
        return fechaAlta;
    }

    public void setFechaAltaSocio(LocalDate fechaAltaSocio) {
        this.fechaAlta = fechaAltaSocio;
    }

    public LocalDate getFechaBajaSocio() {
        return fechaBaja;
    }

    public void setFechaBajaSocio(LocalDate fechaBajaSocio) {
        this.fechaBaja = fechaBajaSocio;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Long getIdOng() {
        return idOng;
    }

    public void setIdOng(Long idOng) {
        this.idOng = idOng;
    }

    //------------------------- MÉTODOS DE CLASE ------------------------//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Socio socio = (Socio) o;

        if (idSocio != null ? !idSocio.equals(socio.idSocio) : socio.idSocio != null) return false;
        if (nombre != null ? !nombre.equals(socio.nombre) : socio.nombre != null) return false;
        if (apellido1 != null ? !apellido1.equals(socio.apellido1) : socio.apellido1 != null) return false;
        if (apellido2 != null ? !apellido2.equals(socio.apellido2) : socio.apellido2 != null) return false;
        if (dni != null ? !dni.equals(socio.dni) : socio.dni != null) return false;
        if (cuentaBancaria != null ? !cuentaBancaria.equals(socio.cuentaBancaria) : socio.cuentaBancaria != null)
            return false;
        if (fechaAlta != null ? !fechaAlta.equals(socio.fechaAlta) : socio.fechaAlta != null) return false;
        if (fechaBaja != null ? !fechaBaja.equals(socio.fechaBaja) : socio.fechaBaja != null) return false;
        if (tipoCuota != null ? !tipoCuota.equals(socio.tipoCuota) : socio.tipoCuota != null) return false;
        if (idOng != null ? !idOng.equals(socio.idOng) : socio.idOng != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSocio != null ? idSocio.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido1 != null ? apellido1.hashCode() : 0);
        result = 31 * result + (apellido2 != null ? apellido2.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (cuentaBancaria != null ? cuentaBancaria.hashCode() : 0);
        result = 31 * result + (fechaAlta != null ? fechaAlta.hashCode() : 0);
        result = 31 * result + (fechaBaja != null ? fechaBaja.hashCode() : 0);
        result = 31 * result + (tipoCuota != null ? tipoCuota.hashCode() : 0);
        result = 31 * result + (idOng != null ? idOng.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "idSocio=" + idSocio +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", cp='" + cp + '\'' +
                ", provincia='" + provincia + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", movil='" + movil + '\'' +
                ", correo='" + correo + '\'' +
                ", sexo=" + sexo +
                ", tipoCuota=" + tipoCuota +
                ", fechaAlta=" + fechaAlta +
                ", fechaBaja=" + fechaBaja +
                ", cuentaBancaria='" + cuentaBancaria + '\'' +
                ", idOng=" + idOng +
                '}';
    }
}
