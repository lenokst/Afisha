package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {

    @Mock
    AfishaRepository repository;

    @InjectMocks
    AfishaManager manager = new AfishaManager(repository);
    Film first = new Film(1, 1, "Апгрейд", "Боевик", "Url1");
    Film second = new Film(2, 2, "Черная пантера", "Боевик", "Url2");
    Film third = new Film(3, 3, "Реинкарнация", "Триллер", "Url3");
    Film fourth = new Film(4, 4, "Большая игра", "Драма", "Url4");
    Film fifth = new Film(5, 5, "Тренер", "Драма", "Url5");
    Film sixth = new Film(6, 6, "Мотылек", "Драма", "Url6");
    Film seventh = new Film(7, 7, "Талли", "Комедия", "Url7");
    Film eighth = new Film(8, 8, "Анон", "Триллер", "Url8");
    Film ninth = new Film(9, 9, "Фокстрот", "Драма", "Url9");
    Film tenth = new Film(10, 10, "Зло", "Триллер", "Url10");
    Film eleventh = new Film(11, 11, "Закат", "Драма", "Url11");
    Film twelveth = new Film(12, 12, "Код 8", "Боевик", "Url12");

    @Test
    public void shouldSave() {
        Film thirteenth = new Film(13, 13, "Титаник", "Драма", "Url13");
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth, thirteenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(thirteenth);

        manager.addFilm(thirteenth);
        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{thirteenth, twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void get10LastFilms() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth};
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void get5LastFilms() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository,5);

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void getFilmsMoreThan10() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelveth};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository,11);

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void getFilms0() {
        Film[] returned = new Film[]{first};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository, 0);

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void getFilmsLessThan10() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getFilms();
        Film[] expected = new Film[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}
