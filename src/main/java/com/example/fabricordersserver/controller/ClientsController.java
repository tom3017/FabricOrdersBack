package com.example.fabricordersserver.controller;

import com.example.fabricordersserver.entity.Client;

import com.example.fabricordersserver.service.ClientService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")

@RestController

@RequestMapping("/clients")

public class ClientsController {

    // =========================
    // 서비스 주입
    // =========================
    private final ClientService
            clientService;

    public ClientsController(
            ClientService clientService
    ) {

        this.clientService
                = clientService;
    }

    // =========================
    // 거래처 전체 조회
    // =========================
    @GetMapping
    public List<Client> getClients() {

        return clientService
                .getAllClients();
    }

    // =========================
    // 거래처 등록
    // =========================
    @PostMapping
    public String createClient(

            @RequestBody
            Map<String, String> body
    ) {

        String name = body.get("name");

        return clientService
                .createClient(name);
    }

    // =========================
    // 거래처 수정
    // =========================
    @PutMapping("/{id}")
    public String updateClient(

            @PathVariable
            Long id,

            @RequestBody
            Map<String, String> body
    ) {

        String name = body.get("name");

        return clientService
                .updateClient(id, name);
    }

    // =========================
    // 거래처 삭제
    // =========================
    @DeleteMapping("/{id}")
    public String deleteClient(

            @PathVariable
            Long id
    ) {

        return clientService
                .deleteClient(id);
    }
}