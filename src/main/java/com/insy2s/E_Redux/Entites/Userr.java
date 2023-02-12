package com.insy2s.E_Redux.Entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Userr   {

  @Id
  @NotBlank
  @Email
  @Column(unique=true)
  @Size(max = 50)
  private String userName;
  private String firstName;
  private String lastName;
  @NotBlank
  @Size(min=6, max = 100)
  private String password;
  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JoinTable(
    name = "users_roles", 
    joinColumns = @JoinColumn(name = "user_Username"), 
    inverseJoinColumns = @JoinColumn(name = "role_Name"))
  private Set<Role>  role;

 

 
}