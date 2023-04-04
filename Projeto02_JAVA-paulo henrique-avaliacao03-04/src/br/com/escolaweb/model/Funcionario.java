// Paulo Henrique

package br.com.escolaweb.model;

import java.util.List;

public class Funcionario extends Pessoa {
    private String cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void add(List<Funcionario> funcionario) {
    }
}
