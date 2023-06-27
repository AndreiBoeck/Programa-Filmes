package library;

import javax.annotation.processing.Filer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class User {
    private static Scanner in = new Scanner(System.in);
    private Films read = new Films();
    public void register() throws FileNotFoundException {
        PrintStream file = new PrintStream(new FileOutputStream("Users",true));
        //gêneros preferidos, atores preferidos, diretores preferidos e duração
        System.out.println("Registre seu nome de usuário: ");
        String name = in.nextLine();
        if(exist(name)){
            System.out.println("Nome registrado");
        }
        else {
            System.out.println("Nome de usuário ja está em uso");
            register();
            return;
        }
        System.out.println("Generos preferidos(Separe por virgulas):");
        String gender = in.nextLine();
        System.out.println("Atores preferidos(Separe por virgulas):");
        String actors = in.nextLine();
        System.out.println("Diretores preferidos(Separe por virgulas):");
        String directors = in.nextLine();
        System.out.println("Duração ideal(em minutos):");
        int duration = in.nextInt();
        file.printf("%s, %s, %s, %s, %d\n",name, gender,actors,directors,duration);
    }
    private static boolean exist(String name) throws FileNotFoundException {
        FileReader file = new FileReader("Users");
        Scanner fl = new Scanner(file);
        while(fl.hasNext()){
            if(fl.next().startsWith(name)){
                return false;
            }
        }
        return true;
    }
    public void readUser(String name) throws FileNotFoundException {
        FileReader file = new FileReader("Users");
        Scanner fl = new Scanner(file);
        while (fl.hasNextLine()){
            String line = fl.nextLine();
            String[] pl = line.split(", ");
            if(pl[0].startsWith(name)){
                for (int i = 0; i < pl.length; i++) {
                    switch (i){
                        case 0 -> System.out.print("Nome: ");
                        case 1 -> System.out.print("Generos favoritos: ");
                        case 2 -> System.out.print("Diretores favoritos: ");
                        case 3 -> System.out.print("Duração Ideal: ");
                    }
                    System.out.println(pl[i]);
                }
                return;
            }
        }
        System.out.println("Usuário não encontrado");
    }
    public void getAll() throws FileNotFoundException {//le todos os usuarios
        FileReader file = new FileReader("Users");
        Scanner fl = new Scanner(file);
        while (fl.hasNextLine()){
            String line = fl.nextLine();
            String[] pl = line.split(", ");
                for (int i = 0; i < pl.length; i++) {
                    switch (i){
                        case 0 -> System.out.print("Nome: ");
                        case 1 -> System.out.print("Generos favoritos: ");
                        case 2 -> System.out.print("Diretores favoritos: ");
                        case 3 -> System.out.print("Duração Ideal: ");
                    }
                    System.out.println(pl[i]);
                }
            System.out.println("--------------------------------------------------------------");
        }
    }
    private void recomend(String name) throws FileNotFoundException {
        FileReader users = new FileReader("Users");
        FileReader films = new FileReader("Films");
        Scanner us = new Scanner(users);
        Scanner fl = new Scanner(films);
        while (us.hasNextLine()) {
            String line = us.nextLine();
            String[] pl = line.split(", ");
            String film = fl.nextLine();
            String[] pf =film.split(", ");
            if (pl[0].startsWith(name)) {
                for (int i = 0; i < pl.length; i++) {
                    for (int j = 0; j < pf.length; j++) {
                        if(pl[i].startsWith(pf[j])){
                            read.readOneFilm(pf[0]);
                            break;
                        }
                    }
                }
            }
        }
    }
}
