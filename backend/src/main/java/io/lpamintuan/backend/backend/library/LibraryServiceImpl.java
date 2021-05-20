package io.lpamintuan.backend.backend.library;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lpamintuan.backend.backend.globals.NotFoundException;
import io.lpamintuan.backend.backend.song.Song;

@Service
public class LibraryServiceImpl implements LibraryService {

    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Library addLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library updateLibrary(UUID id, Library library) throws NotFoundException {
        if(libraryRepository.existsById(id)) {
            library.setId(id);
            libraryRepository.updateLibraryBId(id, library.getName()); 
            return library;
        }
        throw new NotFoundException("Library", library.getId());
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @Override
    public Library getLibrary(UUID id) throws NotFoundException {
        Optional<Library> library = libraryRepository.findById(id);
        if(library.isEmpty())
            throw new NotFoundException("Library", id);
        return library.get();
    }

    @Override
    public void deleteLibrary(UUID id) throws NotFoundException {
        if(libraryRepository.existsById(id)) {
            libraryRepository.deleteById(id);
            return;
        }
        throw new NotFoundException("Library", id);
    }

    @Override
    public Song addSong(Song song) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteSong(UUID id) throws NotFoundException {
        
    }
    
}
