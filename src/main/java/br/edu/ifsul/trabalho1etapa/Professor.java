
package br.edu.ifsul.trabalho1etapa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author jessica
 */
@Entity
@Table(name = "professor")
public class Professor  extends Aluno{
  
    @NotBlank(message = " A titulação deve ser informada!")
    @Length(max = 50, message = "A titulação não pode ter mais que {max} caracteres")
    @Column(name = "titulacao", nullable = false)
    private String titulacao; 
    
    @NotBlank(message = " O Tópico de Interesse deve ser informado!")
    @Column(name = "topicoInteresse", columnDefinition = "text", nullable = false)
    private String topicoInteresse; 
    
    @NotNull(message = "A especialidade deve ser informada!!")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false )
    private Especialidade especialidade; 
    
    public Professor(){
    
    } 

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTopicoInteresse() {
        return topicoInteresse;
    }

    public void setTopicoInteresse(String topicoInteresse) {
        this.topicoInteresse = topicoInteresse;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }


    
    
}
