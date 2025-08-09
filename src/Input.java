
import java.util.Scanner;

public class Input {

    // https//www.gihub.com/Jonathas-Ray/
    private static Scanner scanner = new Scanner(System.in);
    
    public static int Int(String output) {
        System.out.println(output);
        int value = 0;
        while (true) {
            if (!(scanner.hasNextInt())) {
                scanner.nextLine(); //Apaga o conteúdo do Buffer
                System.out.println("O tipo do valor não está correto, insira novamente\n");
            } else {
                value = scanner.nextInt();
                scanner.nextLine(); //Apaga a quebra de linha do Buffer
                return value;
            }
        }
    }
    
    public static int Int() {
        int value = 0;
        while (true) {
            if (!(scanner.hasNextInt())) {
                scanner.nextLine(); //Apaga o conteúdo do Buffer
                System.out.println("O tipo do valor não está correto, insira novamente\n");
            } else {
                value = scanner.nextInt();
                scanner.nextLine(); //Apaga a quebra de linha do Buffer
                return value;
            }
        }
    }

    public static double Double(String output) {
        System.out.println(output);
        Double value;
        while (true) {
            if (!(scanner.hasNextDouble())) {
                scanner.nextLine(); //Apaga o conteúdo do Buffer
                System.out.println("O tipo do valor não está correto, insira novamente\n");
            } else {
                value = scanner.nextDouble();
                scanner.nextLine(); //Apaga a quebra de linha do Buffer
                return value;
            }
        }
    }
    
    public static double Double() {
        Double value;
        while (true) {
            if (!(scanner.hasNextDouble())) {
                scanner.nextLine(); //Apaga o conteúdo do Buffer
                System.out.println("O tipo do valor não está correto, insira novamente\n");
            } else {
                value = scanner.nextDouble();
                scanner.nextLine(); //Apaga a quebra de linha do Buffer
                return value;
            }
        }
    }

    public static String String(String output) {
        System.out.println(output);
        String value;
        do {
            value = scanner.nextLine();
            if (value.isBlank()) {
                System.out.println("Valor inválido");
            } else {
                return value;
            }
        } while (true);
    }
    
    public static String String() {
        String value;
        do {
            value = scanner.nextLine();
            if (value.isBlank()) {
                System.out.println("Valor inválido");
            } else {
                return value;
            }
        } while (true);
    }
}