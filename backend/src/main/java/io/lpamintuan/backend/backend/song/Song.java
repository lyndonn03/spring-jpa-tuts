package io.lpamintuan.backend.backend.song;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.ReadOnlyProperty;

import io.lpamintuan.backend.backend.librarycontent.LibraryContent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "song")
public class Song {

    @Id
    private UUID id;

    @NotBlank(message = "Title field must not be null.")
    private String title;

    @NotBlank(message = "Artist field must not be null.")
    private String artist; 

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    @ReadOnlyProperty
    private List<LibraryContent> libraries;
    
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @PrePersist
    public void setId() {
        this.id = UUID.randomUUID();
    }

}
