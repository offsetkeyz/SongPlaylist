public class Song {
    protected String artistName;
    protected String songName;
    protected int songLength;

    public Song (String songNameIn, String artistNameIn, int songLengthIn) {
        songName = songNameIn;
        artistName = artistNameIn;
        songLength = songLengthIn;

    }

    public int getSongLength() {
        return songLength;
    }

    public void setSongLength(int songLength1) {
        this.songLength = songLength1;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String toString() {

        String songLength = Integer.toString(this.getSongLength());
        StringBuilder sb = new StringBuilder(songLength);
        sb.insert(1, ".");
//        sb.insert(4, ":");
        String info = "Song Title: " + this.getSongName()
                    + "\nArtist: " + this.getArtistName()
                    + "\nLength: " + sb.toString()
                    + "\n";


        return info;
    }
}
