package com.banking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private KycStatus kycStatus = KycStatus.PENDING;

    private double accountBalance = 0;
}

enum KycStatus {
    PENDING, VERIFIED, REJECTED
}
