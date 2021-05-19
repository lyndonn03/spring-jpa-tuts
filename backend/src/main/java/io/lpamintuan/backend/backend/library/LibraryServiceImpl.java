package io.lpamintuan.backend.backend.library;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lpamintuan.backend.backend.exceptions.NotFoundException;

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
    public Library updateLibrary(Library library) throws NotFoundException {
        if(library.getId() == null) {
            throw new NotFoundException("Song id is empty. Please make sure that song.id is a valid UUID.");
        }
        if(libraryRepository.existsById(library.getId())) {
           return libraryRepository.save(library); 
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
    
}
