package io.lpamintuan.backend.backend.librarycontent;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


import io.lpamintuan.backend.backend.globals.Views;
import io.lpamintuan.backend.backend.library.Library;
import io.lpamintuan.backend.backend.song.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryContent {
    
    @EmbeddedId
    @JsonIgnore
    private LibraryContentKey id;

    @ManyToOne
    @MapsId("songId")
    @JoinColumn(name = "song_id")
    Song song;

    @ManyToOne
    @MapsId("libraryId")
    @JoinColumn(name = "library_id")
    @JsonView(Views.Self.class)
    Library library;

    public  LibraryContent(Song song, Library library) {
        this.song = song;
        this.library = library;
    }

    
}
