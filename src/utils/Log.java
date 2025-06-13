package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final String arquivo = "log.txt";

    public static void registrar(String mensagem) {
        try (FileWriter fw = new FileWriter(arquivo, true)) {
            fw.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " - " + mensagem + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao registrar log");
        }
    }
}
