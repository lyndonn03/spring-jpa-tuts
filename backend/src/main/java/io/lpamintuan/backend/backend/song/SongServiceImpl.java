package io.lpamintuan.backend.backend.song;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lpamintuan.backend.backend.globals.NotFoundException;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSong(UUID id) throws NotFoundException {
        Optional<Song> song = songRepository.findById(id);
        if(song.isPresent())
            return song.get();
        throw new NotFoundException("Song", id);
    }

    @Override
    public void deleteSong(UUID id) throws NotFoundException {
        if(songRepository.existsById(id)) {
            songRepository.deleteById(id); 
            return;      
        }
        throw new NotFoundException("Song", id);
    }

    @Override
    public Song updateSong(Song song) throws NotFoundException {
        if(song.getId() == null)
            throw new NotFoundException("Song id is empty. Please make sure that song.id is a valid UUID.");
        if(songRepository.existsById(song.getId())) {
            return songRepository.save(song); 
        }
        throw new NotFoundException("Song", song.getId());
    }

   
    
}
