package br.org.serratec.academia.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Turma")
public class Turma {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="turmaId")
    private Integer turmaId;

    @Column(name="nomeDisciplina")
    private String nomeDisciplina;

    @Column(name="diaSemana")
    private String diaSemana;

    @ManyToOne
    @JoinColumn(name="instrutorId")
    private Instrutor instrutor;

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
}
