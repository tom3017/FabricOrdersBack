package com.example.fabricordersserver.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    // 제조사 고유 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제조사명
    @Column(nullable = false, unique = true)
    private String name;

    // 기본 생성자
    public Manufacturer() {
    }

    // 생성자
    public Manufacturer(String name) {
        this.name = name;
    }

    // id getter
    public Long getId() {
        return id;
    }

    // name getter
    public String getName() {
        return name;
    }

    // name setter
    public void setName(String name) {
        this.name = name;
    }
}