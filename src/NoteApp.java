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


        while (true) {
            System.out.println("\n--- Note Application ---");
            System.out.println("1 - Enter a note");
            System.out.println("2 - Show notes");
            System.out.println("3 - Exit");
            System.out.println("4 - Delete a note"); // ✅ Yeni eklendi
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter note: ");
                String note = input.nextLine();
                notes.add(note);
                System.out.println("Note added: " + note);

                try {
                    FileWriter writer = new FileWriter("notes.txt", true);
                    writer.write(note + "\n");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file: " + e.getMessage());
                }

            } else if (choice == 2) {
                System.out.println("\n--- Notes ---");
                if (notes.isEmpty()) {
                    System.out.println("No notes yet.");
                } else {
                    for (int i = 0; i < notes.size(); i++) {
                        System.out.println((i + 1) + " - " + notes.get(i));
                    }
                }

            } else if (choice == 3) {
                System.out.println("Exiting the program...");
                break;

            } else if (choice == 4) {
                if (notes.isEmpty()) {
                    System.out.println("No notes to delete.");
                } else {
                    System.out.println("\n--- Notes ---");
                    for (int i = 0; i < notes.size(); i++) {
                        System.out.println((i + 1) + " - " + notes.get(i));
                    }

                    System.out.print("Enter the number of the note to delete: ");
                    int index = input.nextInt();
                    input.nextLine();

                    if (index < 1 || index > notes.size()) {
                        System.out.println("Invalid number!");
                    } else {
                        String removedNote = notes.remove(index - 1);
                        System.out.println("Deleted: " + removedNote);

                        // Dosyayı güncelle
                        try {
                            FileWriter writer = new FileWriter("notes.txt", false); // overwrite mode
                            for (String note : notes) {
                                writer.write(note + "\n");
                            }
                            writer.close();
                        } catch (IOException e) {
                            System.out.println("Error while updating file: " + e.getMessage());
                        }
                    }
                }

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}