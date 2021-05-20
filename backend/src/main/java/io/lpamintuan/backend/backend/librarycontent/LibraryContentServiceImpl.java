package io.lpamintuan.backend.backend.librarycontent;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lpamintuan.backend.backend.globals.NotFoundException;
import io.lpamintuan.backend.backend.library.Library;
import io.lpamintuan.backend.backend.library.LibraryRepository;
import io.lpamintuan.backend.backend.song.Song;

@Service
public class LibraryContentServiceImpl implements LibraryContentService {

    private final LibraryContentRepository libraryContentRepository;
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryContentServiceImpl(LibraryContentRepository libraryContentRepository,  LibraryRepository libraryRepository) {
        this.libraryContentRepository = libraryContentRepository;
        this.libraryRepository = libraryRepository;
    }

    @Override
    public LibraryContent addLibraryContent(Song song, UUID id) throws NotFoundException {
        Optional<Library> library = libraryRepository.findById(id);
        if(song.getId() == null || song.getId().toString().isEmpty())
            throw new NotFoundException("Song", "null");
        if(library.isPresent()) {
            LibraryContent newContent = new LibraryContent(song, library.get());
            newContent.setId(new LibraryContentKey(library.get().getId(), song.getId()));
            return libraryContentRepository.save(newContent);
        }
        throw new NotFoundException("Library", id);
    }

    @Override
    public Set<LibraryContent> getLibraryContents(UUID id) {
        return libraryContentRepository.findAllByIdLibraryId(id);
    }

    @Override
    public LibraryContent getLibraryContent(UUID libraryId, UUID songId) throws NotFoundException {
        if(!libraryRepository.existsById(libraryId)) 
            throw new NotFoundException("Library", libraryId);

        Optional<LibraryContent> content = libraryContentRepository.findById(new  LibraryContentKey(libraryId, songId));
        if(content.isPresent()) 
            return content.get();

        throw new NotFoundException("Library Content", songId);
    }

    @Override
    public void deleteLibraryContent(UUID id, UUID songId) throws NotFoundException {
        LibraryContentKey key = new LibraryContentKey(id, songId);
        if(libraryContentRepository.existsById(key)) {
            libraryContentRepository.deleteById(key);
            return;
        }
        throw new NotFoundException("Library Content", songId);
    }
    

}
