package io.lpamintuan.backend.backend.song;

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
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public CollectionModel<SongRepresentation> getAllSongs() {
        return new SongRepresentationAssembler().toCollectionModel(songService.getSongs());
    }

    @GetMapping("/{id}")
    public SongRepresentation getSong(@PathVariable UUID id) throws NotFoundException {
        return new SongRepresentationAssembler().toModel(songService.getSong(id));
    }

    @PostMapping
    public SongRepresentation addSong(@RequestBody @Valid Song song) {
        return new SongRepresentationAssembler().toModel(songService.addSong(song));
    }
    
    @PutMapping("/{id}")
    public SongRepresentation updateSong(@PathVariable UUID id, @RequestBody @Valid Song song) throws NotFoundException {
        return new SongRepresentationAssembler().toModel(songService.updateSong(id, song));
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable UUID id) throws NotFoundException {
        songService.deleteSong(id);
        return;
    }
    
}
