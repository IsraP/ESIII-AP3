package modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "IPSS_crime")
@ToString
@Getter
@Setter
public class Crime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "tipo")
    String tipo;

    @Column(name = "data_hora")
    LocalDateTime data_hora;

    @Column(name = "local")
    String local;

    @ManyToMany(mappedBy = "crimes")
    List<Vitima> vitimas;

    @ManyToMany(mappedBy = "crimes")
    List<Criminoso> criminosos;

    public Crime() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Vitima> getVitimas() {
        return vitimas;
    }

    public void setVitimas(List<Vitima> vitimas) {
        this.vitimas = vitimas;
    }

    public List<Criminoso> getCriminosos() {
        return criminosos;
    }

    public void setCriminosos(List<Criminoso> criminosos) {
        this.criminosos = criminosos;
    }

    public Crime(String tipo, LocalDateTime data_hora, String local, List<Vitima> vitimas, List<Criminoso> criminosos) {
        this.tipo = tipo;
        this.data_hora = data_hora;
        this.local = local;
        this.vitimas = vitimas;
        this.criminosos = criminosos;
    }
}
