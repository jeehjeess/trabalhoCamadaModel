
package br.edu.ifsul.trabalho1etapa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author jessica
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id; 
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false) 
    private String nome; 
    
    @NotBlank(message = "A sigla deve ser informada")
    @Length(max = 10, message = "A sigla não pode ter mais que {max} caracteres")
    @Column(name = "sigla", length = 10, nullable = false) 
    private String sigla; 
    
    @NotBlank(message = "A descrição deve ser informada")
    @Column(name = "descricao", columnDefinition = "text", nullable = false)
    private String descricao; 
    
    @NotNull(message = "O Status deve ser informado")
    @Column(name = "ativo", columnDefinition = "boolean")
    private Boolean ativo; 
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O início das atividades deve ser informado")
    @Column(name = "inicioAtividade", nullable = false)
    private Calendar inicioAtividades; 
    
    @NotNull(message = " A instituição deve ser informada!")
    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "id", nullable = false)
    private Instituicao instituicao;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<Disciplina> disciplinas = new ArrayList<>();
    
   public Curso(){
   
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getInicioAtividades() {
        return inicioAtividades;
    }

    public void setInicioAtividades(Calendar inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
    public void adicionarDisciplina(Disciplina obj){
        obj.setCurso(this);
        this.disciplinas.add(obj);
    }
    public void removerDisciplina(int index){
        this.disciplinas.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
