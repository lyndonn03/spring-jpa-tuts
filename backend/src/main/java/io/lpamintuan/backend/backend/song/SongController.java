package io.lpamintuan.backend.backend.song;

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
    public List<Song> getAllSongs() {
        return songService.getSongs();
    }

    @GetMapping("/{id}")
    public Song getSong(@PathVariable UUID id) throws NotFoundException {
        return songService.getSong(id);
    }

    @PostMapping
    public Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }
    
    @PutMapping("/{id}")
    public Song updateSong(@PathVariable UUID id, @RequestBody Song song) throws NotFoundException {
        return songService.updateSong(id, song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable UUID id) throws NotFoundException {
        songService.deleteSong(id);
        return;
    }
    
}
