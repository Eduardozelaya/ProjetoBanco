package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Dao<T extends Serializable> {
    private static String arquivo = "objetos.bin";
    private static List<T> objetos = carregar();


    static {
        carregar();
    }

    public static void carregar() {
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            objetos = (List<T>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("Não foi localizado o arquivo de persistência");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void salvar() {
        try {
            FileOutputStream fos = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objetos);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void adicionarObjeto(T objeto) {
        objetos.add(objeto);
        salvar();
    }

    public static List<T> buscarTodos() {
        return objetos;
    }
    
    private static List<T> carregar() {
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Não foi localizado o arquivo de persistência");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
