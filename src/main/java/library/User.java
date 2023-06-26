package library;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class User {
    private static PrintStream file;

    static {
        try {
            file = new PrintStream("Users");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Scanner in = new Scanner(System.in);
    public void register() throws FileNotFoundException {
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
    public void readUser(){

    }
}
