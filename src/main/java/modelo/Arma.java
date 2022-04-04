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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }
}
