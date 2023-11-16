package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoAgencia extends Dao<Agencia> {

	private static List<Agencia> agencias = new ArrayList<>();

    static {
        try {
            FileInputStream fis = new FileInputStream("objetos.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            agencias = (List<Agencia>) ois.readObject();
            ois.close();

        } catch (FileNotFoundException e) {
            System.out.println("Não foi localizado o arquivo de persistência");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void salvarAgencia(Agencia agencia) {
        agencias.add(agencia);
        salvar();
    }

    public static List<Agencia> buscarTodasAgencias() {
        return agencias;
    }
}
