package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {

    @Mock
    AfishaRepository repository;

    @InjectMocks
    AfishaManager manager = new AfishaManager(repository);
    PurchaseItem first = new PurchaseItem(1, 1, "Апгрейд", "Боевик", "Url1");
    PurchaseItem second = new PurchaseItem(2, 2, "Черная пантера", "Боевик", "Url2");
    PurchaseItem third = new PurchaseItem(3, 3, "Реинкарнация", "Триллер", "Url3");
    PurchaseItem fourth = new PurchaseItem(4, 4, "Большая игра", "Драма", "Url4");
    PurchaseItem fifth = new PurchaseItem(5, 5, "Тренер", "Драма", "Url5");
    PurchaseItem sixth = new PurchaseItem(6, 6, "Мотылек", "Драма", "Url6");
    PurchaseItem seventh = new PurchaseItem(7, 7, "Талли", "Комедия", "Url7");
    PurchaseItem eighth = new PurchaseItem(8, 8, "Анон", "Триллер", "Url8");
    PurchaseItem ninth = new PurchaseItem(9, 9, "Фокстрот", "Драма", "Url9");
    PurchaseItem tenth = new PurchaseItem(10, 10, "Зло", "Триллер", "Url10");
    PurchaseItem eleventh = new PurchaseItem(11, 11, "Закат", "Драма", "Url11");
    PurchaseItem twelveth = new PurchaseItem(12, 12, "Код 8", "Боевик", "Url12");

    @Test
    public void shouldSave() {
        PurchaseItem thirteenth = new PurchaseItem(13, 13, "Титаник", "Драма", "Url13");
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth, thirteenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(thirteenth);

        manager.addFilm(thirteenth);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{thirteenth, twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void get10LastFilms() {
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth};
        doReturn(returned).when(repository).findAll();

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void get5LastFilms() {
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository,5);

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void getFilmsMoreThan10() {
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository,11);

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void getFilms0() {
        PurchaseItem[] returned = new PurchaseItem[]{first};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository, 0);

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void getFilmsLessThan10() {
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}