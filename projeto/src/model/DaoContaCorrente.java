package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoContaCorrente extends Dao {

    private static List<ContaCorrente> contasCorrentes = new ArrayList<>();

    static {
        try {
            FileInputStream fis = new FileInputStream("objetos.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            contasCorrentes = (List<ContaCorrente>) ois.readObject();
            ois.close();

        } catch (FileNotFoundException e) {
            System.out.println("Não foi localizado o arquivo de persistência");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void salvarContaCorrente(ContaCorrente contaCorrente) {
        contasCorrentes.add(contaCorrente);
        salvar();
    }

    public static List<ContaCorrente> buscarTodasContasCorrentes() {
        return contasCorrentes;
    }
}
