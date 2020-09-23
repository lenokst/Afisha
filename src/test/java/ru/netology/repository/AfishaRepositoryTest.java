package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository;
    private AfishaManager manager = new AfishaManager();
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
        PurchaseItem eleventh = new PurchaseItem(11, 11, "Just Mercy", "Drama", "Url11");
        repository.save(eleventh);
        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.removeById(1);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        PurchaseItem actual = repository.findById(6);
        assertEquals(sixth, actual);
    }

    @Test
    void findById2() {
        PurchaseItem actual = repository.findById(15);
        assertEquals(null, actual);
    }

    @Test
    void removeAll() {
        repository.removeAll();

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[0];
        assertArrayEquals(expected, actual);
    }
}