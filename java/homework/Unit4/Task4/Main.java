package homework.Unit4.Task4;

import java.io.IOException;

import static homework.Unit4.Task4.Serializer.deserialize;
import static homework.Unit4.Task4.Serializer.serialize;

//works but needs tests and refactoring
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FilmCollection fc=new FilmCollection();
        fc.addFilm("Unknown",1950,"Mike","Ellison","Heidi","Liza");
        System.out.println(fc.findByActor("Liza"));
        Film film=fc.findFilm("Unknown");
        System.out.println(film.getActorList());
        fc.addFilm("UN2",1960,"Mike","Freddy","Liza","Olsen");
        System.out.println(fc.findByActor("Liza"));
        System.out.println(fc.findByActor("Mike"));

        serialize("java\\homework\\Unit4\\Task4\\fc1.ser",fc);
        FilmCollection fc2=(FilmCollection) deserialize("java\\homework\\Unit4\\Task4\\fc1.ser");
        System.out.println(fc2.findByActor("Mike"));
        fc2.removeFilm("UN2");
        System.out.println(fc2.getGlobalFilmList());
    }
}

