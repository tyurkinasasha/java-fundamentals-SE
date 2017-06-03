package homework.Unit1.Task6;

/**
 * Created by hp on 25.04.2017.
 */
public class Notepad {
    int numberOfPages;
    Note[] notes;

    public Notepad(int n) {
        this.numberOfPages = n;
        notes = new Note[n];
    }

    public void createNote(int page, String header, String content) {
        notes[page - 1] = new Note(header, content);
    }

    public void displayHeaders() {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] == null) {
                System.out.println((i + 1) + ". Empty");
            } else {
                System.out.println((i + 1) + ". " + notes[i].header);
            }
        }
    }

    public void displayNote(int i) {
        if (notes[i - 1] == null) {
            System.out.println("The page is empty");
        } else {
            System.out.println("homework.Unit1.Task6.Note " + notes[i - 1].header + " : " + notes[i - 1].content);
        }
    }

    public void displayForEdition() {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] != null) {
                System.out.println((i + 1) + ". " + notes[i].header);
            }
        }
    }
    public void editNote(int page,String newHeader,String newContent){
        notes[page-1].header=newHeader;
        notes[page-1].content=newContent;
    }
    public void deleteNote(int i){
        notes[i-1]=null;
    }
}
