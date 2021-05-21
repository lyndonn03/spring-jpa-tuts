package io.lpamintuan.backend.backend.user;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
@AllArgsConstructor
public class Role {
    
    @Id
    @Enumerated(EnumType.STRING)
    private ERole name;

}
