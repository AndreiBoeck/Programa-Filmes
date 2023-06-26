package library;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Films {
    private static Scanner in = new Scanner(System.in);
    public void registerFilms() throws FileNotFoundException {
        PrintStream registe = new PrintStream("films");
        String name, gender, duration, director, actors;
        double pontuation;
        System.out.print("Nome do filme: ");
        name = in.next();
        //o título, o gênero, a duração em minutos, o diretor, os atore principais e uma pontuação
        System.out.print("Genero: ");
        gender = in.next();
        System.out.print("Duração em minutos: ");
        duration = in.next();
        System.out.print("Diretor: ");
        director = in.next();
        System.out.print("Principais atores(separe por virgulas): ");
        actors = in.next();
        System.out.print("Pontuação: ");
        pontuation = in.nextDouble();
        registe.printf("%s, %s, %s, %s, %s, %b",name, gender, duration, director, actors, pontuation);
        }
    public void readFilms() throws FileNotFoundException {
        FileReader file = new FileReader("films");
        Scanner fl = new Scanner(file);
        String info;
        int counter = 0;
        while(fl.hasNextLine()){
            info = fl.nextLine();
            String[] printInfo = info.split(", ");
            for (int i = 0; i < printInfo.length; i++) {
                switch (i){
                    case 0 -> System.out.printf("Nome: ");
                    case 1 -> System.out.printf("Genero: ");
                    case 2 -> System.out.printf("Duração: ");
                    case 3 -> System.out.printf("Diretor: ");
                    case 4 -> System.out.printf("Atores: ");
                    case 5 -> System.out.printf("Pontuação : ");
                }
                System.out.println(printInfo[i]);
            }
        }
    }
}
