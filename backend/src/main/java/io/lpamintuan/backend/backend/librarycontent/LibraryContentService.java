package io.lpamintuan.backend.backend.librarycontent;

import java.util.Set;
import java.util.UUID;

import io.lpamintuan.backend.backend.globals.NotFoundException;
import io.lpamintuan.backend.backend.song.Song;


public interface LibraryContentService {
    
    public LibraryContent addLibraryContent(Song song, UUID id) throws NotFoundException;
    public Set<LibraryContent> getLibraryContents(UUID id);
    public LibraryContent getLibraryContent(UUID libraryId, UUID songId) throws NotFoundException;
    public void deleteLibraryContent(UUID id, UUID songId) throws NotFoundException;

}
