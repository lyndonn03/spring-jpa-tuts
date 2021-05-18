package io.lpamintuan.backend.backend.song;

import java.util.List;
import java.util.UUID;

import io.lpamintuan.backend.backend.exceptions.NotFoundException;

public interface SongService {
    public Song addSong(Song song);

    public List<Song> getSongs();

    public Song getSong(UUID id) throws NotFoundException;

    public void deleteSong(UUID id) throws NotFoundException;

    public Song updateSong(Song song) throws NotFoundException;
}
