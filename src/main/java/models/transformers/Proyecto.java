package models.transformers;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "proyecto", schema = "db_spm")
public class Proyecto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdProyecto")
    private Long idProyecto;
    @Basic
    @Column(name = "Pais")
    private String pais;
    @Basic
    @Column(name = "Localizacion")
    private String localizacion;
    @Basic
    @Column(name = "FechaInicio")
    private LocalDate fechaInicio;
    @Basic
    @Column(name = "FechaFinal")
    private LocalDate fechaFinal;
    @Basic
    @Column(name = "Financiador")
    private String financiador;
    @Basic
    @Column(name = "FinanciacionAportada")
    private double financiacionAportada;
    @Basic
    @Column(name = "SocioLocal")
    private String socioLocal;
    @Basic
    @Column(name = "idLinea")
    private Integer idLinea;
    @Basic
    @Column(name = "idONG")
    private Integer idOng;

    //---------------------RELACIONES ENTRE CLASES----------------------//

    @OneToMany(mappedBy = "proyecto", cascade = {CascadeType.ALL}) //all CRUD methods will affect to its related classes
    private List<Equipo> listaEquipo = new ArrayList<>();


    public Proyecto(Long idProyecto, String pais, String localizacion, LocalDate fechaInicio, LocalDate fechaFinal, String financiador,
                    Double financiacionAportada, String socioLocal, ArrayList<Equipo> listaEquipo) {
        this.idProyecto = idProyecto;
        this.pais = pais;
        this.localizacion = localizacion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.financiador = financiador;
        this.financiacionAportada = financiacionAportada;
        this.socioLocal = socioLocal;
        this.listaEquipo = listaEquipo;
    }

    public Proyecto() {

    }

    public List<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(List<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getFinanciador() {
        return financiador;
    }

    public void setFinanciador(String financiador) {
        this.financiador = financiador;
    }

    public double getFinanciacionAportada() {
        return financiacionAportada;
    }

    public void setFinanciacionAportada(double financiacionAportada) {
        this.financiacionAportada = financiacionAportada;
    }

    public String getSocioLocal() {
        return socioLocal;
    }

    public void setSocioLocal(String socioLocal) {
        this.socioLocal = socioLocal;
    }

    public Integer getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public Integer getIdOng() {
        return idOng;
    }

    public void setIdOng(Integer idOng) {
        this.idOng = idOng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proyecto that = (Proyecto) o;
        return idProyecto == that.idProyecto && Double.compare(that.financiacionAportada, financiacionAportada) == 0 && Objects.equals(pais, that.pais) && Objects.equals(localizacion, that.localizacion) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(fechaFinal, that.fechaFinal) && Objects.equals(financiador, that.financiador) && Objects.equals(socioLocal, that.socioLocal) && Objects.equals(idLinea, that.idLinea) && Objects.equals(idOng, that.idOng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProyecto, pais, localizacion, fechaInicio, fechaFinal, financiador, financiacionAportada, socioLocal, idLinea, idOng);
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "idProyecto=" + idProyecto +
                ", pais='" + pais + '\'' +
                ", localizacion='" + localizacion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", financiador='" + financiador + '\'' +
                ", financiacionAportada=" + financiacionAportada +
                ", socioLocal='" + socioLocal + '\'' +
                ", idLinea=" + idLinea +
                ", idOng=" + idOng +
                ", listaEquipo=" + listaEquipo +
                '}';
    }
}
