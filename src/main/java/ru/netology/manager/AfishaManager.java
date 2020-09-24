package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AfishaManager {
    private AfishaRepository repository;
    private int countFilms = 10;

    public AfishaManager(int countFilms) {
        this.countFilms = countFilms;
    }

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void addFilm(Film item) {
        repository.save(item);
    }

    public Film[] getFilms() {
        Film[] items = repository.findAll();
        if (items.length < countFilms) {
            countFilms = items.length;
        }
        Film[] result = new Film[countFilms];
        for (int i = 0; i < countFilms; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
