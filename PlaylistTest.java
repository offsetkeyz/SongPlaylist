import org.junit.Assert;
import org.junit.Test;

public class PlaylistTest {

//    @Test
//    void readFile() {
//    }
//
//    @Test
//    void findSongByTitle() {
//    }
//
//    @Test
//    void addSong() {
//    }
//
//    @Test
//    void removeSong() {
//    }

    @Test
    public void swapSongs() {
        Playlist playlist = new Playlist();
        playlist.addSong("Crash My Car", "COIN", 316);
        playlist.addSong("Fred Astaire", "Jukebox", 2255);
        playlist.addSong("Daphne Blue", "The Band", 5555);
        playlist.addSong("Kombucha", "Winnetka", 3246);
        playlist.swapSongs("Crash My Car", "Kombucha");

        Assert.assertEquals("Index of Crash My Car", playlist.indexOf("Crash My Car"), 3);

    }

//    @Test
//    void listByLengthAscending() {
//    }
}