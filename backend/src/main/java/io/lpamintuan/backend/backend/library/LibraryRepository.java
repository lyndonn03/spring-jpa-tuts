package io.lpamintuan.backend.backend.library;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, UUID> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE library SET name = :name WHERE id = :id", nativeQuery = true)
    public int updateLibraryBId(UUID id, String name);

}
