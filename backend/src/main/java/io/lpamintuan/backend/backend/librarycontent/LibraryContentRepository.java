package io.lpamintuan.backend.backend.librarycontent;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryContentRepository extends JpaRepository<LibraryContent, LibraryContentKey> {
    Set<LibraryContent> findAllByIdLibraryId(UUID libraryId);
    
    Boolean existsByIdLibraryId(UUID libraryId);

    Optional<LibraryContent> findByIdLibraryIdAndIdSongId(UUID libraryId, UUID songId);
}
