import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class NoteApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> notes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("notes.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                notes.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Could not read notes from file: " + e.getMessage());
        }


        while(true) {
            System.out.println("\n--- Note Application ---");
            System.out.println("1 - Enter a note: ");
            System.out.println("2 - Show Notes");
            System.out.println("3 - Exit");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if(choice == 1) {
                System.out.println("Enter note: ");
                String note = input.nextLine();
                notes.add(note);
                System.out.println("Note added: " + note);

                try{
                    FileWriter writer = new FileWriter("notes.txt",true);
                    writer.write(note+ "\n");
                    writer.close();

                }
                catch(IOException e){
                    System.out.println("An error occured while writing to the file: " + e.getMessage());
                }
            }else if(choice == 2) {
                System.out.println("\n--- Notes ---");
                for(String note : notes) {
                    System.out.println("- "+ note);
                }
            }else if(choice == 3) {
                System.out.println("Exiting the program...");
                break;
            }else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
