package io.lpamintuan.backend.backend.song;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID> {

    @Transactional
    @Modifying 
    @Query(value = "UPDATE song SET title = :title, artist = :artist WHERE id = :id", nativeQuery = true)
    public int updateSongDetailsById(UUID id, String title, String artist);

}
