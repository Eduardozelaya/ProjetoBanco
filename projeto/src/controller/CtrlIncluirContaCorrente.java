package controller;

import model.ContaCorrente;
import model.DaoContaCorrente;
import model.ModelException;

public class CtrlIncluirContaCorrente {

    public void incluirContaCorrente(String numero, String diaAbertura, String nomeCorrentista, int saldoInicial) {
        try {
            ContaCorrente contaCorrente = new ContaCorrente(numero, diaAbertura, nomeCorrentista, saldoInicial);
            DaoContaCorrente daoContaCorrente = new DaoContaCorrente();
            daoContaCorrente.salvarContaCorrente(contaCorrente);
        } catch (ModelException e) {
            // Lida com exceções relacionadas à validação do modelo
            System.out.println("Erro ao incluir conta corrente: " + e.getMessage());
        }
    }
}
