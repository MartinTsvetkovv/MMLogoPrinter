import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Printer printer = new ConsolePrinter();
        try {
            LogoCreator creator = new MMLogoCreator(n, "*", "-", printer);
            creator.createLogo();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
