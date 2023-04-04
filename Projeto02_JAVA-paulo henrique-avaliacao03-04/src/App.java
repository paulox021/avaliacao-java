import javax.swing.JOptionPane;

//import br.com.escolaweb.controller.AlunoController;
import br.com.escolaweb.controller.FuncionarioController;
import br.com.escolaweb.model.Aluno;
import br.com.escolaweb.model.Funcionario;

public class App {
    public static void main(String[] args) {
        try {
            //Aluno aluno = new Aluno();
            Funcionario funcionarios = new Funcionario();
            funcionarios.setNome("Ana Lúcia");
            funcionarios.setEmail("ana@email.com");
            funcionarios.setSenha("123456");
            FuncionarioController.cadastrar(funcionarios);
            JOptionPane.showMessageDialog(null, "Cadastrado!");
        } catch (Exception e) {
            System.err.println("Erro >>> " + e);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + e.getMessage());
        }
    }
}
