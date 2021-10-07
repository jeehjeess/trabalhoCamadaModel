package br.edu.ifsul.trabalho1etapa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author jessica
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @NotBlank(message = " A descrição deve ser informada!")
    @Column(name = "descricao", columnDefinition = "text", nullable = false)
    private String descricao;

    @NotNull(message = "A carga horária deve ser informada")
    @Column(name = "cargaHoraria", nullable = false, columnDefinition = "numeric(4,2)")
    private Double cargaHoraria;

    @NotBlank(message = " O conhecimentos mínimos devem ser informados!")
    @Column(name = "conhecimentosMinimos", columnDefinition = "text", nullable = false)
    private String conhecimentosMinimos;
    
    @NotNull(message = "o curso deve ser informado")
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false)
    private Curso curso;
    
    @ManyToMany
    @JoinTable(name = "alunos",
            joinColumns = 
                    @JoinColumn(name = "id_disciplina", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false))
    private List<Aluno> alunos = new ArrayList<>();
    
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();

    public Disciplina() {

    }
    public void adicionarNota(Nota obj){
        obj.setDisciplina(this);
        this.notas.add(obj);
    }
    public void removerNota(int index){
        this.notas.remove(index);
    
    }
     public void adicionarAluno(Aluno obj){
        
        obj.setDisciplina(this);
        this.alunos.add(obj);
    }
    public void removerAluno(int index){
        this.alunos.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

}
