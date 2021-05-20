package io.lpamintuan.backend.backend.library;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lpamintuan.backend.backend.globals.NotFoundException;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public LibraryRepresentation createLibrary(@RequestBody @Valid Library library) {
        return new LibraryRepresentationAssembler(). toModel(libraryService.addLibrary(library));
    }

    @GetMapping("/{id}")
    public LibraryRepresentation getLibrary(@PathVariable UUID id) throws NotFoundException {
        return new LibraryRepresentationAssembler().toModel(libraryService.getLibrary(id));
    }

    @GetMapping
    public CollectionModel<LibraryRepresentation> getAllLibraries() {
        List<Library> libraries = libraryService.getAllLibraries();
        CollectionModel<LibraryRepresentation> collection = new LibraryRepresentationAssembler().toCollectionModel(libraries);
        return collection;
    }

    @PutMapping("/{id}")
    public LibraryRepresentation updateLibrary(@PathVariable UUID id, @RequestBody @Valid Library library) throws NotFoundException {
        return new LibraryRepresentationAssembler().toModel(libraryService.updateLibrary(id, library));
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable UUID id) throws NotFoundException {
        libraryService.deleteLibrary(id);
    }
    
    
}
