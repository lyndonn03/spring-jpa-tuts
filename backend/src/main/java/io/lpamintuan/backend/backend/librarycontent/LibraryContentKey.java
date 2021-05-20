package io.lpamintuan.backend.backend.librarycontent;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@Data
@NoArgsConstructor
public class LibraryContentKey implements Serializable {

    @Column(name = "library_id")
    private UUID libraryId;

    @Column(name = "song_id")
    private UUID songId; 

    public LibraryContentKey(UUID libraryId, UUID songId) {
        this.libraryId = libraryId;
        this.songId = songId;
    }

}
