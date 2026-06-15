package br.edu.ifpb.escola.model.entity; 

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int matricula;
    private String nome;
    private int idade;
    private String contato;

    // CORREÇÃO AQUI: Anotações adicionadas para mapear a chave estrangeira no banco
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplinaMatriculada;

    // OBRIGATÓRIO PARA O JPA: Construtor vazio
    public Estudante() {
    }

    public Estudante(int matricula, String nome, int idade, String contato) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.contato = contato;
        this.disciplinaMatriculada = null;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
    public Disciplina getD() { return disciplinaMatriculada; }
    public void setD(Disciplina disciplina) { this.disciplinaMatriculada = disciplina; }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nome: " + nome + " | Idade: " + idade + " | Contato: " + contato;
    }
}
