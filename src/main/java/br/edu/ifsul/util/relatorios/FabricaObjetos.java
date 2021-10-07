package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.trabalho1etapa.Curso;
import br.edu.ifsul.trabalho1etapa.Disciplina;
import br.edu.ifsul.trabalho1etapa.Especialidade;
import br.edu.ifsul.trabalho1etapa.Instituicao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 *
 * @author jessi
 */
public class FabricaObjetos {
    
    public static List<Curso> carregaEspecialidade(){
        List<Curso> lista = new ArrayList<>();
        Curso c = new Curso();
        c.setId(1);
        c.setNome("Direito");
        //c.setAtivo(true);
       // c.setSigla("DT");
        //c.setInicioAtividades(Calendar.getInstance());
       // c.setDescricao("O melhor curso da cidade");
        //Instituicao i = new Instituicao();
       // i.setNome("IFSUL");
        //c.setInstituicao(i);
       // Disciplina d = new Disciplina();
        
        //d.setId(1);
        //d.setNome("Algebra");
       // d.setCargaHoraria(2.0);
       // d.setConhecimentosMinimos("Matematica Discreta");
        
       // c.adicionarDisciplina(d);
        
        
        lista.add(c);
        return lista;
    
    }
}
