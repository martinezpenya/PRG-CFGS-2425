package es.martinezpenya.ejemplos.UD10.starwars;

public class CharacterFilm {
    private Character character;
    private Film film;

    public CharacterFilm(Character character, Film film) {
        this.character = character;
        this.film = film;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "CharacterFilm{" +
                "character=" + character +
                ", film=" + film +
                '}';
    }
}