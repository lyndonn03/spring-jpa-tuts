package io.lpamintuan.backend.backend.library;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lpamintuan.backend.backend.exceptions.NotFoundException;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryService.addLibrary(library);
    }

    @GetMapping("/{id}")
    public Library getLibrary(@PathVariable UUID id) throws NotFoundException {
        return libraryService.getLibrary(id);
    }

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable UUID id, @RequestBody Library library) throws NotFoundException {
        return libraryService.updateLibrary(library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable UUID id) throws NotFoundException {
        libraryService.deleteLibrary(id);
    }
    
    
}
