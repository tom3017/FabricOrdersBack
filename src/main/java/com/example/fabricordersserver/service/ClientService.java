package com.example.fabricordersserver.service;

import com.example.fabricordersserver.entity.Client;

import com.example.fabricordersserver.repository.ClientRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    // =========================
    // Repository 주입
    // =========================
    private final ClientRepository
            clientRepository;

    public ClientService(
            ClientRepository clientRepository
    ) {

        this.clientRepository
                = clientRepository;
    }

    // =========================
    // 거래처 전체 조회
    // =========================
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

    // =========================
    // 거래처 등록
    // =========================
    public String createClient(String name) {

        if (name == null || name.trim().isEmpty()) {

            return "EMPTY_NAME";
        }

        if (clientRepository.existsByName(name)) {

            return "DUPLICATE_NAME";
        }

        Client client
                = new Client(name.trim());

        clientRepository.save(client);

        return "SUCCESS";
    }

    // =========================
    // 거래처 수정
    // =========================
    public String updateClient(

            Long id,
            String name
    ) {

        Client client
                = clientRepository
                .findById(id)
                .orElse(null);

        if (client == null) {

            return "NOT_FOUND";
        }

        if (name == null || name.trim().isEmpty()) {

            return "EMPTY_NAME";
        }

        client.setName(name.trim());

        clientRepository.save(client);

        return "SUCCESS";
    }

    // =========================
    // 거래처 삭제
    // =========================
    public String deleteClient(Long id) {

        if (!clientRepository.existsById(id)) {

            return "NOT_FOUND";
        }

        clientRepository.deleteById(id);

        return "SUCCESS";
    }
}