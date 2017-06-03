package homework.Unit1.Task6;

import java.util.Scanner;

/**
 * Created by hp on 25.04.2017.
 */
public class Main {
    static Notepad notepad;
    static Scanner scanner;
    static String input;
    static String start = "Choose action:" +
            "\n1. Create new notepad" +
            "\n2. Add note" +
            "\n3. Edit note" +
            "\n4. Delete note" +
            "\n5. Display all notes" +
            "\nType \"quit\" to exit";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println(start);
            input = scanner.nextLine();

            if ("q".equals(input)) {
                System.out.println("Exit!");
                break;
            }
            if ("1".equals(input)) {
                if (notepad != null) {
                    System.out.println("Are you sure you want to create new homework.Unit1.Task6.Notepad?" +
                            "Old one will be deleted (y/n)");
                    input = scanner.nextLine();
                    if ("n".equals(input)) continue;
                    else if ("y".equals(input)) {
                        createNotepad();
                        continue;
                    } else continue;
                }
                createNotepad();

            }
            if ("2".equals(input)) {
                if (notepad == null) {
                    System.out.println("homework.Unit1.Task6.Notepad isn't created yet");
                } else {
                    noteCreation();
                }
            }
            if ("3".equals(input)) {
                if (notepad == null) {
                    System.out.println("homework.Unit1.Task6.Notepad isn't created yet");
                } else {
                    noteEdition();
                }
            }
            if ("4".equals(input)) {
                if (notepad == null) {
                    System.out.println("homework.Unit1.Task6.Notepad isn't created yet");
                } else {
                    deleteNote();
                }
            }
            if ("5".equals(input)) {
                if (notepad == null) {
                    System.out.println("homework.Unit1.Task6.Notepad isn't created yet");
                } else {
                    display();
                }
            }
            if ("quit".equals(input)) {
                System.out.println("Bye!");
                break;
            }
        }

        scanner.close();
    }

    public static void createNotepad() {
        System.out.println("Enter number of pages:");
        input = scanner.nextLine();
        try {
            notepad = new Notepad(Integer.parseInt(input));
            sep();
            System.out.println("homework.Unit1.Task6.Notepad's created!");
            sep();
        } catch (Exception e) {
            System.out.println("Input a number!");
            createNotepad();
        }
    }

    public static void noteCreation() {
        System.out.println("What page would you like to put a note at?(1-" + notepad.numberOfPages + ")");
        input = scanner.nextLine();
        try {
            int tmp1 = Integer.parseInt(input);
            if (tmp1 > notepad.numberOfPages || tmp1 <= 0) {
                System.out.println("Page doesn't exist");
                noteCreation();
            if (notepad.notes[tmp1 - 1] != null) {
                sep();
                System.out.println("homework.Unit1.Task6.Note is already there. Want to replace it? (y/n)");
                sep();
                String tmp2 = scanner.nextLine();
                if ("y".equals(tmp2)) {
                    notepad.deleteNote(tmp1);
                } else {
                    noteCreation();
                }
            }
            } else {
                System.out.println("Enter header:");
                String tmp2 = scanner.nextLine();
                System.out.println("Your note:");
                input = scanner.nextLine();
                notepad.createNote(tmp1, tmp2, input);
                sep();
                System.out.println("homework.Unit1.Task6.Note's added to page " + tmp1);
                sep();
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number");
            noteCreation();
        }
    }

    public static void display() {
        notepad.displayHeaders();
        System.out.println("Select a note to display:");
        input = scanner.nextLine();
        try {
            sep();
            notepad.displayNote(Integer.parseInt(input));
            sep();
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number");
            display();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Selected page doesn't exist");
            display();
        }
    }

    public static void noteEdition() {
        notepad.displayForEdition();
        System.out.println("Select the note to edit:");
        input = scanner.nextLine();
        try {
            int tmp1 = Integer.parseInt(input);
            if (tmp1 > notepad.numberOfPages || tmp1 <= 0 || notepad.notes[tmp1 - 1] == null) {
                System.out.println("Page doesn't exist");
                noteEdition();
            } else {
                System.out.println("Edit header:");
                String tmp2 = scanner.nextLine();
                System.out.println("Edit note:");
                input = scanner.nextLine();
                notepad.editNote(tmp1, tmp2, input);
                sep();
                System.out.println("homework.Unit1.Task6.Note is edited");
                sep();
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number");
            noteEdition();
        }
    }

    public static void deleteNote() {
        notepad.displayForEdition();
        System.out.println("Select the note to delete:");
        input = scanner.nextLine();
        try {
            int tmp1 = Integer.parseInt(input);
            if (tmp1 > notepad.numberOfPages || tmp1 <= 0 || notepad.notes[tmp1 - 1] == null) {
                System.out.println("Page doesn't exist");
                deleteNote();
            } else {
                notepad.deleteNote(tmp1);
                sep();
                System.out.println("homework.Unit1.Task6.Note has been deleted!");
                sep();
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number");
            deleteNote();
        }
    }

    public static void sep() {
        System.out.println("=========================");
    }

}
