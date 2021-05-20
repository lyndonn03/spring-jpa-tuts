package io.lpamintuan.backend.backend.librarycontent;

import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lpamintuan.backend.backend.globals.NotFoundException;
import io.lpamintuan.backend.backend.globals.Views;
import io.lpamintuan.backend.backend.song.Song;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/libraries/content")
public class LibraryContentController {
    
    private final LibraryContentService libraryContentService;

    @Autowired
    public LibraryContentController(LibraryContentService libraryContentService){
        this.libraryContentService = libraryContentService;
    }

    @GetMapping("/{id}")
    @JsonView(Views.Public.class)
    public Set<LibraryContent> getLibraryContents(@PathVariable UUID id) {
        return libraryContentService.getLibraryContents(id);
    }

    @GetMapping("/{id}/song/{songId}")
    @JsonView(Views.Self.class)
    public LibraryContent getLibraryContent(@PathVariable UUID id, @PathVariable UUID  songId ) throws NotFoundException {
        return  libraryContentService.getLibraryContent(id, songId);
    }

    @PostMapping("/{id}")
    public LibraryContent addLibraryContent(@RequestBody @Valid Song song, @PathVariable UUID id) throws NotFoundException {
        return libraryContentService.addLibraryContent(song, id);
    }

    @DeleteMapping("/{id}/song/{songId}")
    public void deleteLibraryContent(@PathVariable UUID id, @PathVariable UUID songId) throws NotFoundException {
        libraryContentService.deleteLibraryContent(id, songId);
    }
    



}
