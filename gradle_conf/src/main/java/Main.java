import ohtu.Multiplier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Multiplier kolme = new Multiplier(3);
        System.out.print("Millä kerrotaan?");
        int luku = sc.nextInt();

        System.out.print("Luku kolme kerrottuna luvulla " + luku + " on " + kolme.multipliedBy(luku));
    }
}