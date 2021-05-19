package io.lpamintuan.backend.backend.library;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Library {
   
    @Id
    private UUID id;

    private String name;

    public Library(String name) {
        this.name = name;
    }

    @PrePersist
    public void setId() {
        this.id = UUID.randomUUID();
    }

}
