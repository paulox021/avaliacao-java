
package br.com.escolaweb.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.escolaweb.model.Funcionario;
import br.com.escolaweb.util.Encrypt;

public class FuncionarioService extends DAO {

    public void add(Funcionario funcionarios) throws Exception {
        String id = Encrypt.sha256(funcionarios.getEmail(), true);
        String cargo = String.valueOf(new Date().getTime());
        funcionarios.setId(id);
        funcionarios.setCargo(cargo);
        // Pessoa
        PessoaService pessoaService = new PessoaService();
        pessoaService.add(funcionarios);
        // Funcionario
        String sql = "insert into funcionario (_id, _id_pessoa, cargo) values (?, ?, ?)";
        Conectar();
        PreparedStatement stman = conn.prepareStatement(sql);
        stman.setString(1, Encrypt.sha256(funcionarios.getId()));
        stman.setString(2, funcionarios.getId());
        stman.setString(3, cargo);
        stman.execute();
        stman.close();
    }

    public List<Funcionario> getAll() throws SQLException {
        List<Funcionario> funcionario = new ArrayList<>();
        String sql = "SELECT pessoa._id, pessoa.nome, pessoa.email, pessoa.data_nasc, pessoa.cadastro, pessoa.ativo, aluno.cargo, aluno._id as _id_aluno FROM aluno, pessoa WHERE aluno._id_pessoa = pessoa._id;";
        Conectar();
        PreparedStatement stman = conn.prepareStatement(sql);
        ResultSet result = stman.executeQuery();
        while (result.next()) {
            Funcionario funcionarios = new Funcionario();
            funcionarios.setId(result.getString("_id"));
            funcionarios.setNome(result.getString("nome"));
            funcionarios.setEmail(result.getString("email"));
            funcionarios.setCargo(result.getString("cargo"));
            funcionarios.add(funcionario);
        }
        stman.close();
        return funcionario;
    }
}
