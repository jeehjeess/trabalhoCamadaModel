
package br.edu.ifsul.trabalho1etapa;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "instituicao")
public class Instituicao implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_instituicao", sequenceName = "seq_instituicao_id", allocationSize = 1)
    @GeneratedValue (generator = "seq_instituicao", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 80, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 80, nullable = false)    
    private String nome; 
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O ano de Fundação deve ser informado")
    @Column(name = "anoFundacao", nullable = false)
    private Calendar anoFundacao; 
    
    
    public Instituicao(){
    
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

    public Calendar getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(Calendar anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Instituicao other = (Instituicao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
