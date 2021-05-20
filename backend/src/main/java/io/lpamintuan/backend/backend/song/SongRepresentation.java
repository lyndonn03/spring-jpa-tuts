package io.lpamintuan.backend.backend.song;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(itemRelation = "song", collectionRelation = "songs")
public class SongRepresentation extends RepresentationModel<SongRepresentation> {
    
    private UUID id;
    private String title;
    private String artist;

}
