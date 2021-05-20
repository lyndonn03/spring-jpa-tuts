package io.lpamintuan.backend.backend.song;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class SongRepresentationAssembler extends RepresentationModelAssemblerSupport<Song, SongRepresentation> {

    public SongRepresentationAssembler() {
        super(SongController.class, SongRepresentation.class);
    }

    @Override
    public SongRepresentation toModel(Song entity) {
        SongRepresentation song = super.createModelWithId(entity.getId(), entity);
        song.add(WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(SongController.class)
            .getAllSongs()
        ).withRel("songs"));
        song.setId(entity.getId());
        song.setTitle(entity.getTitle());
        song.setArtist(entity.getArtist());
        return song;
    }
    
    @Override
    public CollectionModel<SongRepresentation> toCollectionModel(Iterable<? extends Song> entities) {
        CollectionModel<SongRepresentation> collection = super.toCollectionModel(entities);
        return collection;
    }
}
