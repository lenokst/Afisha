package ru.netology.repository;

import ru.netology.domain.Film;

public class AfishaRepository {
    private Film[] items = new Film[0];

    public void save(Film item) {
        int length = items.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Film[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Film findById(int id) {
        for (Film item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeAll() {
        items = new Film[0];
    }
}
