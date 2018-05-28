import java.util.ArrayList;
import java.util.List;
import entities.Aluno;
import entities.Telefone;
import repository.AlunoRepository;


public class AlunoRepositoryTeste {
    public static void main(String[] args) {
        AlunoRepository dao = new AlunoRepository();

        //Cria uma aluno.
        Aluno aluno = new Aluno();
        aluno.setNome("Rafael");
        aluno.setMatricula(123456L);

        //Cria o telefone residencial do aluno.
        Telefone telefone = new Telefone();
        telefone.setTipo("RES");
        telefone.setNumero(12345678);
        //Cria o telefone celular do aluno.
        Telefone telefone2 = new Telefone();
        telefone2.setTipo("CEL");
        telefone2.setNumero(87654321);

        //Cria uma lista de telefones e guarda dentro do aluno.
        List<Telefone> telefones = new ArrayList<Telefone>();
        telefones.add(telefone);
        telefones.add(telefone2);
        aluno.setTelefones(telefones);

        System.out.println("Salva as informações do aluno.");
        aluno = dao.salvar(aluno);
//
//        System.out.println("Consulta o aluno que foi salvo.");
//        Aluno alunoConsultado = dao.consultarPorId(aluno.getId());
//        System.out.println(aluno.getNome());
//        for(Telefone tel : aluno.getTelefones()) {
//            System.out.println(tel.getTipo() + " - " + tel.getNumero());
//        }
//
//        //Cria o telefone comercial do aluno.
//        Telefone telefone3 = new Telefone();
//        telefone3.setTipo("COM");
//        telefone3.setNumero(55554444);
//        //Adiciona o novo telefone a lista de telefone do aluno.
//        alunoConsultado.getTelefones().add(telefone3);
//
//        System.out.println("Atualiza as informações do aluno.");
//        alunoConsultado = dao.salvar(alunoConsultado);
//        System.out.println(alunoConsultado.getNome());
//        for(Telefone tel : alunoConsultado.getTelefones()) {
//            System.out.println(tel.getTipo() + " - " + tel.getNumero());
//        }
//
//        System.out.println("Apaga o registro do aluno.");
//        dao.apagar(alunoConsultado.getId());
    }
}