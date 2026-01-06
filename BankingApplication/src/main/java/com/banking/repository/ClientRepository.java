package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
