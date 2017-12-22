
package br.ufpi.pdsi2.test;
//Bruno Lopes de Alcantara
import org.fpij.jitakyoei.facade.AppFacade;
import org.fpij.jitakyoei.facade.AppFacadeImpl;
import org.fpij.jitakyoei.model.beans.Aluno;
import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.view.AppView;
import org.fpij.jitakyoei.view.MainAppView;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestesCadastroAluno {
    
    AppView view = new MainAppView();
    AppFacade facade = new AppFacadeImpl(view);
    
    @Test 
    public void testCpfInvalidos(){
        
        Filiado filiado = new Filiado();
        filiado.setCpf("12345678999");
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);
        
        facade.createAluno(aluno);
    }
    
    @Test(expected=Exception.class)
    public void test_CPF_Null_Invalido() throws Exception{

        String cpf = null;
        Filiado filiado = new Filiado();
        filiado.setCpf(cpf);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);
        
        facade.createAluno(aluno);
    }
   
    @Test
    public void test_Cpf_Valido()throws Exception {
        
        String cpf= "16876445457";
        Filiado filiado = new Filiado();
        filiado.setCpf(cpf);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);
        
        facade.createAluno(aluno);
        String cpfCadastrado = facade.searchAluno(aluno).get(0).getFiliado().getCpf();
        assertEquals("Cpf não sao iguais",cpf,cpfCadastrado);
    }
    
    @Test
    public void test_CPF_11_Digitos_Validos() throws Exception{
		
        String cpf = "16876445457";
        Filiado filiado = new Filiado();
        filiado.setCpf(cpf);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);

        facade.createAluno(aluno);
        String cpfcadastrado = facade.searchAluno(aluno).get(0).getFiliado().getCpf();
        assertEquals("Não são iguais", cpf, cpfcadastrado);
    }
    
    
    @Test(expected=Exception.class)
    public void test_Nome_Branco_Invalido() throws Exception {

        String nome = null;
        Filiado filiado = new Filiado();
        filiado.setNome(nome);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);

        facade.createAluno(aluno);
    }
	
    @Test(expected=Exception.class)
    public void test_Nome_Simbolo_Invalido() throws Exception {

        String nome = "%$@!#/";
        Filiado filiado = new Filiado();
        filiado.setNome(nome);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);

        facade.createAluno(aluno);
    }

    @Test
    public void test_Nome_Valido() {

        String nome = "Bruno Lopes";
        Filiado filiado = new Filiado();
        filiado.setNome(nome);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);

        facade.createAluno(aluno);
        String nomecadastrado = facade.searchAluno(aluno).get(0).getFiliado().getNome();
        assertEquals("O nome não são iguais", nome, nomecadastrado);
	
    }
	
    @Test(expected=Exception.class)
    public void test_Tel1_Invalido() throws Exception{

        String telefone1 = "lkshrgjnalshgjnasjk";
        Filiado filiado = new Filiado();
        filiado.setTelefone1(telefone1);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);

        facade.createAluno(aluno);
    }
	
    @Test
    public void test_Tel1_Valido() throws Exception{

        String tel1 = "88988375906";
        Filiado filiado = new Filiado();
        filiado.setTelefone1(tel1);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);
        
        facade.createAluno(aluno);
        String tel_Cadastrado = facade.searchAluno(aluno).get(0).getFiliado().getTelefone1();
        assertEquals("O Telefone não são iguais", tel1, tel_Cadastrado);
    }

    @Test(expected=Exception.class)
    public void test_Obs_Invalido() throws Exception {

        String obs = "$!@#*+";
        Filiado filiado = new Filiado();
        filiado.setNome(obs);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);

        facade.createAluno(aluno);
    }

    @Test
    public void test_Obs_Valido() {

        String obs = "Observação";
        Filiado filiado = new Filiado();
        filiado.setObservacoes(obs);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);

        facade.createAluno(aluno);
        String observacoescadastrado = facade.searchAluno(aluno).get(0).getFiliado().getObservacoes();
        assertEquals("Não são iguais", obs, observacoescadastrado);
    }
	
    @Test(expected=Exception.class)
    public void test_Rg_Cbj_Invalido() throws Exception {

        String cbj = "!@#$%¨&*/**-+";
        Filiado filiado = new Filiado();
        filiado.setRegistroCbj(cbj);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);

        facade.createAluno(aluno);
    }

    @Test
    public void test_Rg_CBJ_Valido() {

        String cbj = "6595";
        Filiado filiado = new Filiado();
        filiado.setRegistroCbj(cbj);
        Aluno aluno = new Aluno();
        aluno.setFiliado(filiado);
        
        facade.createAluno(aluno);
        String codigocadastrado = facade.searchAluno(aluno).get(0).getFiliado().getRegistroCbj();
        assertEquals("Não são iguais", cbj, codigocadastrado);
    }
}
