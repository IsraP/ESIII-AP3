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

    public Crime(String tipo, LocalDateTime data_hora, String local, List<Vitima> vitimas, List<Criminoso> criminosos) {
        this.tipo = tipo;
        this.data_hora = data_hora;
        this.local = local;
        this.vitimas = vitimas;
        this.criminosos = criminosos;
    }
}
