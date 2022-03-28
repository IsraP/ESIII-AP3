package modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "IPSS_vitima")
@ToString
@Getter
@Setter
public class Vitima {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "nome")
    String nome;

    @Column(name = "cpf")
    String cpf;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "IPSS_crime_vitima",
            joinColumns = { @JoinColumn(name = "id_vitima") },
            inverseJoinColumns = { @JoinColumn(name = "id_crime") }
    )
    List<Crime> crimes;

    public Vitima() { }

    public Vitima(String nome, String cpf, List<Crime> crimes) {
        this.nome = nome;
        this.cpf = cpf;
        this.crimes = crimes;
    }

}