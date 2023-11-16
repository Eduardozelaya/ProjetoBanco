package controller;

import model.Agencia;
import model.DaoAgencia;
import model.ModelException;

public class CtrlIncluirAgencia {

    public void incluirAgencia(String codigo, String bairro, String cidade, String uf) {
        try {
            Agencia agencia = new Agencia(codigo, bairro, cidade, uf);
            DaoAgencia daoAgencia = new DaoAgencia();
            daoAgencia.salvarAgencia(agencia);
        } catch (ModelException e) {
            // Lida com exceções relacionadas à validação do modelo
            System.out.println("Erro ao incluir agência: " + e.getMessage());
        }
    }
}
