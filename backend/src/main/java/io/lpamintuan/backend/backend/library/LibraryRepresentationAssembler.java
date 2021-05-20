package io.lpamintuan.backend.backend.library;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import io.lpamintuan.backend.backend.librarycontent.LibraryContentController;
import io.lpamintuan.backend.backend.song.SongController;

public class LibraryRepresentationAssembler  extends RepresentationModelAssemblerSupport<Library, LibraryRepresentation> {

    public LibraryRepresentationAssembler() {
        super(LibraryController.class, LibraryRepresentation.class);
    }

    @Override
    public LibraryRepresentation toModel(Library entity) {
        LibraryRepresentation libraryRepresentation = super.createModelWithId(entity.getId(), entity);
        libraryRepresentation.add(
            WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(LibraryContentController.class)
                .getLibraryContents(entity.getId())
            ).withRel("libraryContents")
        );
        libraryRepresentation.setId(entity.getId());
        libraryRepresentation.setName(entity.getName());
        return libraryRepresentation;
    }

    @Override
    public CollectionModel<LibraryRepresentation> toCollectionModel(Iterable<? extends Library> entities) {
        CollectionModel<LibraryRepresentation> collection = super.toCollectionModel(entities);
        collection.add(
            WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(LibraryController.class)
                .getAllLibraries()
            ).withSelfRel()
        );
        collection.add(
            WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SongController.class)
                .getAllSongs()
            ).withRel("songs")
        );
        return collection;
    }
    
}
