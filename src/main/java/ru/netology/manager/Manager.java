package ru.netology.manager;

import ru.netology.domain.Film;

public class Manager {
    private Film[] items = new Film[0];
    private int countFilms;

    public Manager() {
    }

    public Manager(int countFilms) {
        this.countFilms = countFilms;
    }

    public void addFilm(Film item) {
        int length = items.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Film[] getFilms() {
        int length = countFilms;
        if (countFilms < 0) {
            length = 0;
        }
        if (length > countFilms) {
            countFilms = length;
        }
        Film[] result = new Film[countFilms];
        for (int i = 0; i < countFilms; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
