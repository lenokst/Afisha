package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager manager = new Manager();
    private Film first = new Film(1, 1, "Апгрейд", "Боевик", "Url1");
    private Film second = new Film(2, 2, "Черная пантера", "Боевик", "Url2");
    private Film third = new Film(3, 3, "Реинкарнация", "Триллер", "Url3");
    private Film fourth = new Film(4, 4, "Большая игра", "Драма", "Url4");
    private Film fifth = new Film(5, 5, "Тренер", "Драма", "Url5");
    private Film sixth = new Film(6, 6, "Мотылек", "Драма", "Url6");
    private Film seventh = new Film(7, 7, "Талли", "Комедия", "Url7");
    private Film eighth = new Film(8, 8, "Анон", "Триллер", "Url8");
    private Film ninth = new Film(9, 9, "Фокстрот", "Драма", "Url9");
    private Film tenth = new Film(10, 10, "Зло", "Триллер", "Url10");
    private Film eleventh = new Film(11, 11, "Закат", "Драма", "Url11");
    private Film twelveth = new Film(12, 12, "Код 8", "Боевик", "Url12");

    @BeforeEach
    void addFilm() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
    }

    @Test
    public void getLastFilms() {
        Manager manager = new Manager(4);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelveth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{twelveth, eleventh, tenth, ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void get5LastFilms() {
        Manager manager = new Manager(5);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getFilmsMoreThan10() {
        Manager manager = new Manager(11);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelveth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{twelveth,eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getFilms0() {
        Manager manager = new Manager(0);
        manager.addFilm(first);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getFilmsLessThan0() {
        Manager manager = new Manager(-1);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getFilmsLessThan10() {
        Manager manager = new Manager(8);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}