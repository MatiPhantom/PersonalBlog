package com.personalblog.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private static final int COUNT = 1;

    private int id;
    private String title;
    private String content;
    private LocalDate publishedDate;





}
