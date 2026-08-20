package com.rev.sp.boot.sp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Account number cannot be blank.")
    private String accountNumber;
    @NotBlank(message = "Customer name cannot be blank.")
    @Size(min = 2, max = 50, message = "Customer name must be a valid size.")
    private String customerName;
    @NotBlank(message = "Email cannot be blank.")
    @Email(message = "Must enter a valid email.")
    private String customerEmail;
    @NotBlank(message = "Account type cannot be blank.")
    private String accountType;
    @NotBlank(message = "Branch cannot be blank.")
    private String branch;
    @PositiveOrZero(message = "Balance cannot be less than 0.")
    private double balance;
}
