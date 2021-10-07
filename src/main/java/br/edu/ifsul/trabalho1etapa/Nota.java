
package br.edu.ifsul.trabalho1etapa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jessi
 */
@Entity
@Table(name = "nota")
public class Nota implements  Serializable{
    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @NotNull(message = "A nota 01 deve ser informada")
    @Column(name = "nota1", nullable = false, columnDefinition = "numeric(2,1)")
    private Double nota1; 
    
    @NotNull(message = "A nota 02 deve ser informada")
    @Column(name = "nota2", nullable = false, columnDefinition = "numeric(2,1)")
    private Double nota2;
    
    @NotNull(message = "A média deve ser informada")
    @Column(name = "media", nullable = false, columnDefinition = "numeric(2,1)")
    private Double media; 
    
    @NotNull(message = "O aluno deve ser informado!")
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
    private Aluno aluno;
    
    @NotNull(message = "A disciplina deve ser informada!")
    @ManyToOne
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id", nullable = false)
    private Disciplina disciplina; 
    
    public Nota(){
    
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
}
