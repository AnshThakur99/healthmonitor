package com.example.healthmonitor.demo.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phone;

    // Assuming a patient is created by a user (optional relationship)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
}