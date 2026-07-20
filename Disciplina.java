package br.edu.ifpb.escola.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private int cod;

    private String nome;
    private String professor;
    private String cargaHoraria;

    @OneToMany(mappedBy = "disciplinaMatriculada", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Estudante> estudantes = new ArrayList<>();

    public Disciplina() {}

    public Disciplina(String nome, String professor, String cargaHoraria) {
        this.nome = nome;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getCod() { return cod; }
    public void setCod(int cod) { this.cod = cod; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getProfessor() { return professor; }
    public void setProfessor(String professor) { this.professor = professor; }

    public String getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(String cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    public List<Estudante> getEstudantes() { return estudantes; }
    public void setEstudantes(List<Estudante> estudantes) { this.estudantes = estudantes; }

    public void addEstudante(Estudante estudante) {
        this.estudantes.add(estudante);
        estudante.setD(this);
    }

    public int getQuantidadeEstudantes() {
        return estudantes.size();
    }
}
