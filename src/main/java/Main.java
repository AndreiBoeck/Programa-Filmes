import library.Films;
import library.User;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void createUser() throws FileNotFoundException {
        User user = new User();
        Scanner in = new Scanner(System.in);
        int input;
        do{
            input = in.nextInt();
            switch (input){
                case 0 -> System.out.println("Carregando pagina anterior");
                case 1 -> user.register();
            }
        }
        while(input != 0);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Films films = new Films();
        User user = new User();
        Scanner in = new Scanner(System.in);
        int inputUser;
        do{
            System.out.println("Escolha o que deseja:\n [0] Sair");
            inputUser = in.nextInt();
            switch (inputUser){
                case 0 -> System.out.println("Obrigado, volte sempre!");
                case 1 -> {
                    System.out.println("Carregando pagina");
                    createUser();
                }
                default -> System.out.println("Opção Inválida");
            }

        }
        while (inputUser != 0);
    }
}
