package io.lpamintuan.backend.backend.librarycontent;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.lpamintuan.backend.backend.song.Song;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Relation(itemRelation = "libraryContent", collectionRelation = "libraryContents")
public class LibraryContentRepresentation extends RepresentationModel<LibraryContentRepresentation> {

    private Song song;
    
}
