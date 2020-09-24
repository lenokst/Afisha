package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository;
    private AfishaManager manager = new AfishaManager();
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

    @BeforeEach
    void manageAdd() {
        repository = new AfishaRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    void shouldSave() {
        Film eleventh = new Film(11, 11, "Just Mercy", "Drama", "Url11");
        repository.save(eleventh);
        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.removeById(1);

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        Film actual = repository.findById(6);
        assertEquals(sixth, actual);
    }

    @Test
    void findById2() {
        Film actual = repository.findById(15);
        assertEquals(null, actual);
    }

    @Test
    void removeAll() {
        repository.removeAll();

        Film[] actual = repository.findAll();
        Film[] expected = new Film[0];
        assertArrayEquals(expected, actual);
    }
}