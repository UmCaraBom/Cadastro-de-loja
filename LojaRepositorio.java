package cadastrolojas;

//repositorio de cadastro de lojas em arquivo texto 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LojaRepositorio {

    public static void salvar(Loja loja) {
        try {
            FileWriter fw = new FileWriter("lojas.txt", true);
            fw.write(loja.getId() + ";" + loja.getNome() + ";" + loja.getEndereco() + ";" + loja.getTelefone() + ";" + loja.getEmail() + ";" + loja.getCnpj() + ";" + loja.getRazaoSocial() + ";" + loja.getNomeFantasia() + "");

            fw.close();
        } catch (IOException e) {}
    }

    public static List<Loja> listar() {
        List<Loja> lojas = new ArrayList<Loja>();
        try {
            File file = new File("lojas.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");
                Loja loja = new Loja(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]);
                lojas.add(loja);
            }
            scanner.close();
        } catch (FileNotFoundException e) {}
        return lojas;
    }

    public static Loja buscar(int id) {
        Loja loja = null;
        try {
            File file = new File("lojas.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");
                if (Integer.parseInt(dados[0]) == id) {
                    loja = new Loja(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {}
        return loja;
    }

    public static void atualizar(int id) {
        try {
            File file = new File("lojas.txt");
            Scanner scanner = new Scanner(file);
            List<Loja> lojas = new ArrayList<Loja>();
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");
                if (Integer.parseInt(dados[0]) == id) {
                    Loja loja = new Loja(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]);
                    lojas.add(loja);
                }
            }
            scanner.close();
            FileWriter fw = new FileWriter("lojas.txt", true);
            for (Loja loja : lojas) {
                fw.write(loja.getId() + ";" + loja.getNome() + ";" + loja.getEndereco() + ";" + loja.getTelefone() + ";" + loja.getEmail() + ";" + loja.getCnpj() + ";" + loja.getRazaoSocial() + ";" + loja.getNomeFantasia() + "");
            }
            fw.close();
        } catch (FileNotFoundException e) {} catch (IOException e) {}
    }

    public static void excluir(int id) {
        try {
            File file = new File("lojas.txt");
            Scanner scanner = new Scanner(file);
            List<Loja> lojas = new ArrayList<Loja>();
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");
                if (Integer.parseInt(dados[0]) != id) {
                    Loja loja = new Loja(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]);
                    lojas.add(loja);
                }
            }
            scanner.close();
            FileWriter fw = new FileWriter("lojas.txt", true);
            for (Loja loja : lojas) {
                fw.write(loja.getId() + ";" + loja.getNome() + ";" + loja.getEndereco() + ";" + loja.getTelefone() + ";" + loja.getEmail() + ";" + loja.getCnpj() + ";" + loja.getRazaoSocial() + ";" + loja.getNomeFantasia() + "");
            }
            fw.close();
        } catch (FileNotFoundException e) {} catch (IOException e) {}
    }
}