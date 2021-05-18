package io.lpamintuan.backend.backend.song;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Song {

    @Id
    private UUID id;
    private String title;
    private String artist; 
    
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

}
