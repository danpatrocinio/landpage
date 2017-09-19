package org.javaavancado.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "interessados")
public class Interessados {

    @Id
    @SequenceGenerator(name="interessados_id_seq", sequenceName="interessados_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="interessados_id_seq")
    private Long id;
    private String nome;
    private String email;
    @Column(name = "data_cadastro")
    private Timestamp dataCadastro;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getDataCadastro() { return dataCadastro;  }

    public void setId(Long id) { this.id = id; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataCadastro(Timestamp dataCadastro) { this.dataCadastro = dataCadastro; }
}