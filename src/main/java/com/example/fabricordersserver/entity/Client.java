package com.example.fabricordersserver.entity;

import jakarta.persistence.*;

@Entity

// =========================
// 테이블명 변경
// =========================
@Table(name = "clients")

public class Client {

    // =========================
    // 거래처 고유 번호
    // =========================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // 거래처명
    // =========================
    @Column(nullable = false, unique = true)
    private String name;

    // =========================
    // 기본 생성자
    // =========================
    public Client() {
    }

    // =========================
    // 생성자
    // =========================
    public Client(String name) {

        this.name = name;
    }

    // =========================
    // id getter
    // =========================
    public Long getId() {

        return id;
    }

    // =========================
    // name getter
    // =========================
    public String getName() {

        return name;
    }

    // =========================
    // name setter
    // =========================
    public void setName(String name) {

        this.name = name;
    }
}