import java.util.Scanner;

public class EnBuyuk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("1. sayıyı gir: ");
        int sayi1 = input.nextInt();

        System.out.print("2. sayıyı gir: ");
        int sayi2 = input.nextInt();

        System.out.print("3. sayıyı gir: ");
        int sayi3 = input.nextInt();

        if (sayi1 == sayi2 && sayi1 == sayi3) {
            System.out.println("Tüm sayılar eşit.");
        } else if (sayi1 >= sayi2 && sayi1 >= sayi3) {
            System.out.println("1. sayı en büyük: " + sayi1);
        } else if (sayi2 >= sayi1 && sayi2 >= sayi3) {
            System.out.println("2. sayı en büyük: " + sayi2);
        } else {
            System.out.println("3. sayı en büyük: " + sayi3);
        }
    }
}
