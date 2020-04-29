import java.util.Comparator;

public class songLengthComparator implements Comparator<Song> {

    public int compare(Song s1, Song s2) {
        if(s1.getSongLength() < s2.getSongLength()) {
            return -1;
        }
        else if (s1.getSongLength() > s2.getSongLength()) {
            return 1;
        }
        else {
            return 0;
        }
    }

}
