package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager manager = new Manager();
    private PurchaseItem first = new PurchaseItem(1, 1, "Апгрейд", "Боевик", "Url1");
    private PurchaseItem second = new PurchaseItem(2, 2, "Черная пантера", "Боевик", "Url2");
    private PurchaseItem third = new PurchaseItem(3, 3, "Реинкарнация", "Триллер", "Url3");
    private PurchaseItem fourth = new PurchaseItem(4, 4, "Большая игра", "Драма", "Url4");
    private PurchaseItem fifth = new PurchaseItem(5, 5, "Тренер", "Драма", "Url5");
    private PurchaseItem sixth = new PurchaseItem(6, 6, "Мотылек", "Драма", "Url6");
    private PurchaseItem seventh = new PurchaseItem(7, 7, "Талли", "Комедия", "Url7");
    private PurchaseItem eighth = new PurchaseItem(8, 8, "Анон", "Триллер", "Url8");
    private PurchaseItem ninth = new PurchaseItem(9, 9, "Фокстрот", "Драма", "Url9");
    private PurchaseItem tenth = new PurchaseItem(10, 10, "Зло", "Триллер", "Url10");
    private PurchaseItem eleventh = new PurchaseItem(11, 11, "Закат", "Драма", "Url11");
    private PurchaseItem twelveth = new PurchaseItem(12, 12, "Код 8", "Боевик", "Url12");

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
    public void get10LastFilms() {
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelveth);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
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
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{sixth, fifth, fourth, third, second};
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
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{twelveth,eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getFilms0() {
        Manager manager = new Manager(0);
        manager.addFilm(first);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getFilmsLessThan10() {
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}