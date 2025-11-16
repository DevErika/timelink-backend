package com.timelink.timelink.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.*;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email format is invalid")
    @Column(unique = true, nullable = false)
    private String email; 

    @NotBlank
    private String password; 

    private String address;

    private String postalCode; 

    private String bio;
    
    @Builder.Default
    private Integer credits = 0; 

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; 


}
