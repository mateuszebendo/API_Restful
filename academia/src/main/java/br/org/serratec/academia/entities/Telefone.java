package br.org.serratec.academia.entities;

import jakarta.persistence.*;

@Entity
@Table(name="telefone")
public class Telefone {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="telefoneId")
    private Integer telefoneId;

    @Column(name="numero")
    private int numero;

    @OneToOne
    @JoinColumn(name="instrutorId")
    private Instrutor instrutor;

    public Integer getTelefoneId() {
        return telefoneId;
    }

    public void setTelefoneId(Integer telefoneId) {
        this.telefoneId = telefoneId;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
}
