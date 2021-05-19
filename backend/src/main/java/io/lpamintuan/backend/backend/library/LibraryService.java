package io.lpamintuan.backend.backend.library;

import java.util.List;
import java.util.UUID;

import io.lpamintuan.backend.backend.exceptions.NotFoundException;

public interface LibraryService {
    
    public Library addLibrary(Library library);
    public Library updateLibrary(Library library) throws NotFoundException;
    public List<Library> getAllLibraries();
    public Library getLibrary(UUID id) throws NotFoundException;
    public void deleteLibrary(UUID  id) throws NotFoundException;
    
}
