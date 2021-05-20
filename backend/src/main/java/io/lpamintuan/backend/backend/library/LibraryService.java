package io.lpamintuan.backend.backend.library;

import java.util.List;
import java.util.UUID;

import io.lpamintuan.backend.backend.globals.NotFoundException;
import io.lpamintuan.backend.backend.song.Song;

public interface LibraryService {
    
    public Library addLibrary(Library library);
    public Library updateLibrary(UUID id, Library library) throws NotFoundException;
    public List<Library> getAllLibraries();
    public Library getLibrary(UUID id) throws NotFoundException;
    public void deleteLibrary(UUID  id) throws NotFoundException;

    public Song addSong(Song song) throws NotFoundException;
    public void deleteSong(UUID id) throws NotFoundException;
    
}
