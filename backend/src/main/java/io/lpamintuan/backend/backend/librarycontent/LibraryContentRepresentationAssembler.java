package io.lpamintuan.backend.backend.librarycontent;

import java.util.UUID;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import io.lpamintuan.backend.backend.globals.NotFoundException;
import io.lpamintuan.backend.backend.song.SongController;

public class LibraryContentRepresentationAssembler extends RepresentationModelAssemblerSupport<LibraryContent, LibraryContentRepresentation> {

    
    public LibraryContentRepresentationAssembler() {
        super(LibraryContentController.class, LibraryContentRepresentation.class);
    }

    @Override
    public LibraryContentRepresentation toModel(LibraryContent entity) {
        LibraryContentRepresentation model = super.instantiateModel(entity);
        try {
            model.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(LibraryContentController.class)
                .getLibraryContent(entity.getId().getLibraryId(), entity.getId().getSongId() )
            ).withSelfRel());
            model.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SongController.class)
                .getSong(entity.getSong().getId())
            ).withRel("song"));
            
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        model.setSong(entity.getSong());
        return model;
    }

    public CollectionModel<LibraryContentRepresentation> toCollectionModel(
            Iterable<? extends LibraryContent> entities, UUID entityId) {
        
        CollectionModel<LibraryContentRepresentation> collection = super.toCollectionModel(entities);
        collection.add(
            WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(LibraryContentController.class)
                .getLibraryContents(entityId)
            ).withSelfRel()
        );
        return collection;
    }

    
}
