package models.transformers;

import javax.persistence.*;

@Entity
@Table(name = "bbdd_ong", schema = "db_spm", catalog = "")
public class BbddOng {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idONG")
    private Long idOng;
    @Basic
    @Column(name = "nombreSede")
    private String nombreSede;
    @Basic
    @Column(name = "ubicacion")
    private String ubicacion;

    public Long getIdOng() {
        return idOng;
    }

    public void setIdOng(Long idOng) {
        this.idOng = idOng;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BbddOng bbddOng = (BbddOng) o;

        if (idOng != null ? !idOng.equals(bbddOng.idOng) : bbddOng.idOng != null) return false;
        if (nombreSede != null ? !nombreSede.equals(bbddOng.nombreSede) : bbddOng.nombreSede != null) return false;
        if (ubicacion != null ? !ubicacion.equals(bbddOng.ubicacion) : bbddOng.ubicacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOng != null ? idOng.hashCode() : 0;
        result = 31 * result + (nombreSede != null ? nombreSede.hashCode() : 0);
        result = 31 * result + (ubicacion != null ? ubicacion.hashCode() : 0);
        return result;
    }

}
