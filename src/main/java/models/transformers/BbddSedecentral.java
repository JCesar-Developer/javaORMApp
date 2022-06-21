package models.transformers;

import javax.persistence.*;

@Entity
@Table(name = "bbdd_sedecentral", schema = "db_spm", catalog = "")
public class BbddSedecentral {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idONG")
    private Long idOng;

    public Long getIdOng() {
        return idOng;
    }

    public void setIdOng(Long idOng) {
        this.idOng = idOng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BbddSedecentral that = (BbddSedecentral) o;

        if (idOng != null ? !idOng.equals(that.idOng) : that.idOng != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idOng != null ? idOng.hashCode() : 0;
    }
}
