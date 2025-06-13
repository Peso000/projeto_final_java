package repository;

import java.io.*;
import java.util.List;

public class Serializador {

    @SuppressWarnings("unchecked")
    public static <T> List<T> carregar(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> void salvar(List<T> lista, String arquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + arquivo);
        }
    }
}
