package br.com.escolaweb.controller;

import br.com.escolaweb.model.Funcionario;
import br.com.escolaweb.services.FuncionarioService;

public class FuncionarioController {
    public static void cadastrar(Funcionario funcionarios) throws Exception {
        if (funcionarios.getNome().equals(null)) {
            throw new Exception("Nome embranco!");
        }

        if (funcionarios.getEmail().equals(null)) {
            throw new Exception("E-mail embranco!");
        } else if (funcionarios.getEmail().indexOf("@") == -1
                || funcionarios.getEmail().indexOf(".") == -1) {
            throw new Exception("E-mail invalida!");
        }

        if (funcionarios.getSenha().equals(null)) {
            throw new Exception("Senha embranco!");
        } else if (funcionarios.getEmail().length() < 8) {
            throw new Exception("Senha invalida!");
        }

        // if (aluno.getDataNasc().equals(null)) {
        // throw new Exception("Data de nascimento embranco!");
        // }

        FuncionarioService funcionarioservice = new FuncionarioService();
        funcionarioservice.add(funcionarios);

    }
}
