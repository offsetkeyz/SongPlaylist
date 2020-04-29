import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Playlist {

    private String playlistTitle;
    protected ArrayList<Song> newPlaylist;
    protected ArrayList<Song> newPlaylistCopy;

    /**
     * Constructor for the Playlist.
     */
    public Playlist() {
        newPlaylist = new ArrayList<Song>();
    }

    /**
     * Reads a file.
     * First line is the title, and the remaining lines
     * elements are separated by commas.
     *
     * @param fileNameIn file name
     * @throws FileNotFoundException if file not found
     */
    public void readFile(String fileNameIn)
            throws FileNotFoundException {

        Scanner scan;
            scan = new Scanner(new File(fileNameIn));
        String wholeLine; // string for the whole line
        playlistTitle = scan.nextLine();

        while (scan.hasNextLine()) {
        wholeLine = scan.nextLine(); // Scans the whole line as a string.

        Scanner scanner = new Scanner(wholeLine);
        scanner.useDelimiter(",");

        String songNameIn = scanner.next().trim();
        String artist = scanner.next().trim();
        // String timeIn = scanner.next();
        int time = Integer.parseInt(scanner.next().trim());

        addSong(songNameIn, artist, time);
        }

        scan.close();

    }

    /**
     * Returns the indexOf a song in the playlist.
     * @param songIn String in
     * @return int for index
     */
    public int indexOf(String songIn) {
        int index;
        Song song1 = this.findSongByTitle(songIn);
        index = newPlaylist.indexOf(song1);
        return index;
    }

    /**
     * Finds a song by it's title.
     * @param songTitle title of song
     * @return Song
     */
    public Song findSongByTitle(String songTitle) {
        for (Song song : newPlaylist) {
            if (song.getSongName().equalsIgnoreCase(songTitle.trim())) {
                return song;
            }
        }
        return null;
    }

    /**
     * Adds a song to the playlist.
     *
     * @param songNameIn songs name
     * @param artistIn   artists name
     * @param lengthIn   song length
     */
    public void addSong(String songNameIn, String artistIn, int lengthIn) {
        Song songTemp = new Song(songNameIn, artistIn, lengthIn);
        newPlaylist.add(songTemp);
    }

    /**
     * Removes a song by title.
     * @param songNameIn song title
     * @return boolean if it worked
     */ //FIXME
    public boolean removeSong(String songNameIn) {
        boolean itWorked = false;
        if(!(this.findSongByTitle(songNameIn) == null)) {
//            int s = newPlaylist.indexOf(songNameIn);
            newPlaylist.remove(songNameIn);
            itWorked = true;
        }
        return itWorked;
    }

    /**
     * Given two song titles, this method swaps the songs.
     *
     * @param song1In song 1
     * @param song2In song 2
     * @return boolean itWorked
     */
    public boolean swapSongs(String song1In, String song2In) throws NullPointerException {
        boolean itWorked = false;
        int tempSong;
        int song1 = this.indexOf(song1In);
        Song s1 = newPlaylist.get(song1);
        int song2 = this.indexOf(song2In);
        Song s2 = newPlaylist.get(song2);

        if (!(song1 == -1 | song2 == -1)) {
            //puts song1 in song2
            newPlaylist.set(song2, s1);

            newPlaylist.set(song1, s2);

            itWorked = true;
        }
        return itWorked;
    }

    public ArrayList<Song> listByLengthAscending() { //FIXME make this code work
        Collections.sort(newPlaylistCopy, new songLengthComparator());
        return newPlaylistCopy;

    }



    /**
     * Puts info in a String.
     *
     * @return String
     */
    public String toString() {
        String info = playlistTitle + "\n\n";

        // prints all songs in the ArrayList
        for (int i = 0; i < newPlaylist.size(); i++) {
            info += (i + 1) + ". " + newPlaylist.get(i).toString();
            info += "\n";
        }

        return info;
    }


}
