INSERT INTO song (id, title, artist) VALUES
    ('fdca3ce3-ce64-4f4a-8454-38c73a579cd3', 'Breakeven', 'The Script'),
    ('8fb0a135-1381-43c0-bb57-0959dcf795b8', 'Man Who Cant Be Moved', 'The Script'),
    ('6897e589-8d88-48ca-80b0-712b08229840', 'Wasted Nights', 'One ok Rock');

INSERT INTO library (id, name) VALUES
    ('18f8d973-f67b-4914-80d6-d7412e65bdd5', 'My Library #1'),
    ('582d60a8-03c5-4c74-abc4-909649b52e01', 'Sorrow Nights :) ');

INSERT INTO library_content (song_id, library_id) VALUES 
    ('fdca3ce3-ce64-4f4a-8454-38c73a579cd3', '18f8d973-f67b-4914-80d6-d7412e65bdd5'),
    ('6897e589-8d88-48ca-80b0-712b08229840', '18f8d973-f67b-4914-80d6-d7412e65bdd5'),
    ('8fb0a135-1381-43c0-bb57-0959dcf795b8', '582d60a8-03c5-4c74-abc4-909649b52e01');
