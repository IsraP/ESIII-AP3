package modelo;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "IPSS_criminoso")
@ToString
@Getter
@Setter
public class Criminoso{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "nome")
    String nome;

    @Column(name = "foto")
    String foto;

    @Column(name = "cpf")
    String cpf;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "IPSS_crime_criminoso",
            joinColumns = { @JoinColumn(name = "id_criminoso") },
            inverseJoinColumns = { @JoinColumn(name = "id_crime") }
    )
    List<Crime> crimes;

    public Criminoso() { }

    public Criminoso(String nome, String foto, String cpf, List<Crime> crimes) {
        this.nome = nome;
        this.foto = foto;
        this.cpf = cpf;
        this.crimes = crimes;
    }

}