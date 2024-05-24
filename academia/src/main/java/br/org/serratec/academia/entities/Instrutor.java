package br.org.serratec.academia.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Instrutor")
public class Instrutor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "instrutorId")
    private Integer instrutorID;

    @Column(name="rg")
    private String rg;

    @Column(name="nomeInstrutor")
    private String nomeInstutor;

    @OneToOne(mappedBy ="instrutor")
    private Telefone telefone;

    @OneToMany(mappedBy = "instrutor")
    private List<Turma> turmas;

    public Integer getInstrutorID() {
        return instrutorID;
    }

    public void setInstrutorID(Integer instrutorID) {
        this.instrutorID = instrutorID;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeInstutor() {
        return nomeInstutor;
    }

    public void setNomeInstutor(String nomeInstutor) {
        this.nomeInstutor = nomeInstutor;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
