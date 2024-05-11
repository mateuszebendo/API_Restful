package br.org.serratec.biblioteca.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="TB_PERFIL")
public class PerfilEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="perfilId")
    private UUID perfilId;
    @Column(name="nome")
    private String nome;
    @Column(name="descricao")
    private String descricao;

    public PerfilEntity(UUID perfilId, String nome, String descricao) {
        this.perfilId = perfilId;
        this.nome = nome;
        this.descricao = descricao;
    }

    public UUID getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(UUID perfilId) {
        this.perfilId = perfilId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
