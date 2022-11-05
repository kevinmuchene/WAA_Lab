package com.example.labs.domain;

import lombok.*;

import javax.persistence.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String content;
    String author;
}
