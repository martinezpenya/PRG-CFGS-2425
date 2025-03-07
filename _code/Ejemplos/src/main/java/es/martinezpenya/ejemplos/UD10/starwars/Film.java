package es.martinezpenya.ejemplos.UD10.starwars;

public class Film {
    private int id;
    private String episode;
    private String title;

    public Film(int id, String episode, String title) {
        this.id = id;
        this.episode = episode;
        this.title = title;
    }

    public Film(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", episode='" + episode + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}