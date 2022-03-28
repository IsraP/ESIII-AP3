package modelo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "IPSS_arma")
@ToString
@Getter
@Setter
public class Arma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "nome")
    String nome;

    @Column(name = "tipo")
    String tipo;

    @OneToOne()
    @JoinColumn(name = "id_crime", referencedColumnName = "id")
    Crime crime;

    public Arma() { }

    public Arma(String nome, String tipo, Crime crime) {
        this.nome = nome;
        this.tipo = tipo;
        this.crime = crime;
    }
}
