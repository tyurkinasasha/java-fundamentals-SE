package homework.Unit4.Task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmCollection implements Serializable {
    public Map<String, Film> getGlobalFilmList() {
        return globalFilmList;
    }

    public Map<String, Actor> getGlobalActorList() {
        return globalActorList;
    }

    private Map<String, Film> globalFilmList;
    private Map<String, Actor> globalActorList;

    public FilmCollection() {
        this.globalFilmList = new HashMap<>();
        this.globalActorList = new HashMap<>();
    }

    public void addFilm(String name, int year, String... names) {
        Film film = new Film(name, names, year);
        globalFilmList.put(film.name,film);
        for (Actor act : film.getActorList()) {
            globalActorList.putIfAbsent(act.name, act);
            globalActorList.get(act.name).getFilmList().add(film);
        }
    }

    public void removeFilm(String filmName) {
        List<Actor> list = globalFilmList.get(filmName).getActorList();
        for (Actor act : list) {
            List<Film> filmList = act.getFilmList();
            for (int i = 0; i < filmList.size(); i++) {
                if (act.getFilmList().get(i).name.equals(filmName)) {
                    filmList.remove(i);
                }
            }
        }
        globalFilmList.remove(filmName);

    }

    public List<Film> findByActor(String actorName) {
        return globalActorList.get(actorName).getFilmList();
    }

    public Film findFilm(String filmName) {
        return globalFilmList.get(filmName);
    }
}

class Film implements Serializable{
    String name;
    private List<Actor> actorList;
    int year;

    public Film(String name, String[] list, int year) {
        this.name = name;
        this.actorList = setActors(list);
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    private List<Actor> setActors(String[] names) {
        List<Actor> actorList = new ArrayList<>();
        for (String actorName : names) {
            actorList.add(new Actor(actorName));
        }
        return actorList;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

}

class Actor implements Serializable{
    String name;
    private List<Film> filmList;

    public Actor(String name) {
        this.name = name;
        this.filmList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }

    public List<Film> getFilmList() {
        return filmList;
    }
}

