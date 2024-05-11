package br.org.serratec.biblioteca.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="TB_USUARIO")
public class UsuarioEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="usuarioID")
    private UUID usuarioID;
    @Column(name="usuarioNome")
    private String usuarioNome;
    @Column(name="usuarioEmail", unique=true)
    private String usuarioEmail;
    @Column(name="usuarioSenha")
    private String usuarioSenha;

    @OneToOne
    @JoinColumn(name="perfilId")
    private PerfilEntity perfilId;

    public UsuarioEntity(UUID usuarioID, String usuarioNome, String usuarioEmail, String usuarioSenha, PerfilEntity perfilId) {
        this.usuarioID = usuarioID;
        this.usuarioNome = usuarioNome;
        this.usuarioEmail = usuarioEmail;
        this.usuarioSenha = usuarioSenha;
        this.perfilId = perfilId;
    }

    public UUID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(UUID usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

    public PerfilEntity getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(PerfilEntity perfilId) {
        this.perfilId = perfilId;
    }
}
