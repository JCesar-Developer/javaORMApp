package models.transformers;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "equipo")
public /*abstract*/ class Equipo /*implements Serializable*/ {

    //private static final long serialVersionUID = 2L;

    //TODO: RESTAURAR
    public enum Rol { USUARIO, ADMINISTRADOR }
    public enum Sexo { M, H }
    public enum TipoDeEquipo { COLABORADOR, PERSONACONTRATADA, VOLUNTARIO, VOLUNTARIOINTERNACIONAL }

    //------------------------------------ ATRIBUTOS DE CLASE ------------------------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipo")
    private Long id;
    //private static final AtomicLong count = new AtomicLong(0L);
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
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
    //@Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "usuario")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "altaMiembroEquipo")
    private LocalDate fechaAltaMiembroEquipo;
    //@Temporal(TemporalType.DATE)
    @Column(name = "bajaMiembroEquipo")
    private LocalDate fechaBajaMiembroEquipo;
    @Column(name = "rol")
    //@Enumerated(EnumType.STRING)
    private Boolean rol;
    @Column(name = "idONG")
    private Long idOng;
    @Column(name = "tipoDeEquipo")
    @Enumerated(EnumType.STRING)
    private TipoDeEquipo tipoDeEquipo;

    //--------------------------------- RELACIONES ENTRE CLASES ---------------------------------//
    /*
    @OneToOne(cascade =  {CascadeType.ALL})

    @JoinColumn(name = "tipoDeEquipo", insertable = false, updatable = false)
    private Voluntario voluntario;
    @OneToOne(cascade =  {CascadeType.ALL})
    @JoinColumn(name = "tipoDeEquipo", insertable = false, updatable = false)
    private Colaborador colaborador;
    @OneToOne(cascade =  {CascadeType.ALL})
    @JoinColumn(name = "tipoDeEquipo", insertable = false, updatable = false)
    private VoluntarioInternacional voluntarioInternacional;
    @OneToOne(cascade =  {CascadeType.ALL})
    @JoinColumn(name = "tipoDeEquipo", insertable = false, updatable = false)
    private PersonaContratada personaContratada;
    */


    @ManyToOne(fetch = FetchType.LAZY) //Lazy so it does not load the whole 'proyecto' data related
    @JoinColumn(name = "idProyecto") //This class related data will be loaded in idProyecto Column
    private Proyecto proyecto;

    //--------------------------------------- CONSTRUCTORES ---------------------------------------//

    /**
     * Método constructor vacío
     */
    public Equipo() {

    }



    /**
     * Método constructor con datos básicos de los miembros del equipo
     */
    /*
    public Equipo(String nombre, String apellido1, String apellido2, String dni, String direccion, String localidad,
                  String cp, String provincia, LocalDate fechaNacimiento, String movil, String correo, Sexo sexo,
                  String user, String password, LocalDate fechaAltaMiembroEquipo, Rol rol, Long idOng) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.direccion = direccion;
        this.localidad = localidad;
        this.cp = cp;
        this.provincia = provincia;
        this.fechaNacimiento = fechaNacimiento;
        this.movil = movil;
        this.correo = correo;
        this.sexo = sexo;
        this.user = user;
        this.password = password;
        this.fechaAltaMiembroEquipo = fechaAltaMiembroEquipo;
        this.rol = rol;
        this.idOng = idOng;
    }
    */
    // TODO: METODO CONSTRUCTOR CON DATOS DEL TIPO DE CONTRATO


    /**
     * Método constructor con datos del tipo de contrato del miembro del equipo
     */
    /*
    public Equipo(String nombre, String apellido1, String apellido2, String dni, String direccion, String localidad,
                  String cp, String provincia, LocalDate fechaNacimiento, String movil, String correo, Sexo sexo,
                  String user, String password, LocalDate fechaAltaMiembroEquipo, Rol rol, Long idOng,
                  TipoDeEquipo tipoDeEquipo, Long idProyecto) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.direccion = direccion;
        this.localidad = localidad;
        this.cp = cp;
        this.provincia = provincia;
        this.fechaNacimiento = fechaNacimiento;
        this.movil = movil;
        this.correo = correo;
        this.sexo = sexo;
        this.user = user;
        this.password = password;
        this.fechaAltaMiembroEquipo = fechaAltaMiembroEquipo;
        this.rol = rol;
        this.idOng = idOng;
        this.tipoDeEquipo = tipoDeEquipo;
        //this.idProyecto = idProyecto;
    }
     */

    //------------------------------------ GETTERS Y SETTERS ------------------------------------//


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaAltaMiembroEquipo() {
        return fechaAltaMiembroEquipo;
    }

    public void setFechaAltaMiembroEquipo(LocalDate fechaAltaMiembroEquipo) {
        this.fechaAltaMiembroEquipo = fechaAltaMiembroEquipo;
    }

    public LocalDate getFechaBajaMiembroEquipo() {
        return fechaBajaMiembroEquipo;
    }

    public void setFechaBajaMiembroEquipo(LocalDate fechaBajaMiembroEquipo) {
        this.fechaBajaMiembroEquipo = fechaBajaMiembroEquipo;
    }

    public Boolean getRol() {
        return rol;
    }

    public void setRol(Boolean rol) {
        this.rol = rol;
    }

    public Long getIdOng() {
        return idOng;
    }

    public void setIdOng(Long idOng) {
        this.idOng = idOng;
    }

/*    public String getTipoDeEquipo() {
        return tipoDeEquipo;
    }

    public void setTipoDeEquipo(String tipoDeEquipo) {
        this.tipoDeEquipo = tipoDeEquipo;
    }*/

    public TipoDeEquipo getTipoDeEquipo() {
        return tipoDeEquipo;
    }

    public void setTipoDeEquipo(TipoDeEquipo tipoDeEquipo) {
        this.tipoDeEquipo = tipoDeEquipo;
    }

    /*public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

/*    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public VoluntarioInternacional getVoluntarioInternacional() {
        return voluntarioInternacional;
    }

    public void setVoluntarioInternacional(VoluntarioInternacional voluntarioInternacional) {
        this.voluntarioInternacional = voluntarioInternacional;
    }

    public PersonaContratada getPersonaContratada() {
        return personaContratada;
    }

    public void setPersonaContratada(PersonaContratada personaContratada) {
        this.personaContratada = personaContratada;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }
    */


    //------------------------------------ MÉTODOS DE CLASE ------------------------------------//
    //setAsignarMiembroEquipoAProyecto
    //setAsignarMiembroEquipoADelegacion


    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
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
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", fechaAltaMiembroEquipo=" + fechaAltaMiembroEquipo +
                ", fechaBajaMiembroEquipo=" + fechaBajaMiembroEquipo +
                ", rol=" + rol +
                ", idOng=" + idOng +
                ", tipoDeEquipo=" + tipoDeEquipo +
                /*", idProyecto=" + idProyecto +*/
                '}';
    }
}
