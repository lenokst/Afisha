package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseItem {
    private int id;
    private int filmId;
    private String filmName;
    private String filmGenre;
    private String urlIMG;
}
