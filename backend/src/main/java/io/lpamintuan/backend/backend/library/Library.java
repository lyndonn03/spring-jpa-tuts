package io.lpamintuan.backend.backend.library;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.lpamintuan.backend.backend.librarycontent.LibraryContent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Library {
   
    @Id
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<LibraryContent> contents;

    public Library(String name) {
        this.name = name;
    }

    @PrePersist
    public void setId() {
        this.id = UUID.randomUUID();
    }

}
