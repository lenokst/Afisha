package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class Manager {
    private PurchaseItem[] items = new PurchaseItem[0];
    private int countFilms = 10;

    public Manager() {
    }

    public Manager(int countFilms) {
        this.countFilms = countFilms;
    }

    public void addFilm(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] getFilm() {
        if (items.length < countFilms) {
            countFilms = items.length;
        }
        PurchaseItem[] result = new PurchaseItem[countFilms];
        for (int i = 0; i < countFilms; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
