package br.edu.ifpb.escola.model.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String professor;
    private String cargaHoraria;

    @Transient
    private List<Estudante> listaEstudantes = new ArrayList<>();

    public Disciplina() {}

    public Disciplina(String nome, String professor, String cargaHoraria) {
        this.nome = nome;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getProfessor() { return professor; }
    public void setProfessor(String professor) { this.professor = professor; }
    public String getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(String cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public List<Estudante> getEstudantes() { return listaEstudantes; }
    
    public void addEstudante(Estudante estudante) {
        this.listaEstudantes.add(estudante);
        estudante.setD(this);
    }
    
    public int getQuantidadeEstudantes() { return listaEstudantes.size(); }
}
