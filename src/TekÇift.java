import java.util.Scanner;

public class TekÇift {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int sayi = input.nextInt();

        if(sayi%2==0){
            System.out.println("Sayı çift");
        }
        else{
            System.out.println("Sayı tek");
        }
    }
}

