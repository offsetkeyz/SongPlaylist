import javax.swing.*;
import java.io.FileNotFoundException;

/**
 * Driver class for the Playlist.
 *
 * @Author Colin McAllister
 * @Version April 27, 2020
 * Quarantine Edition
 */
public class PlaylistDriver {
    /**
     * Main method for Playlist.
     * @param args passes in file name
     * @throws FileNotFoundException if file not found
     */
    public static void main(String[] args)
                throws FileNotFoundException {
        Playlist newPlaylist = new Playlist();
        String input = "";

        String[] options = {"Read In a File", "Add Song", "Swap Two Songs", "Print Playlist", "Exit"};

        do { // prompts until user selects "Exit"
            input = (String) JOptionPane.showInputDialog(null, "Select an Action: ",
                    "Input", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            System.out.println(input);
            if (input == null) { //if user presses "Cancel"
                System.out.println("User has pressed cancel");
                return;
            }
            switch(input) {
                case "Read In a File":
                    String fileName;
                    try {
                        fileName = JOptionPane.showInputDialog("Please enter your file-name: ");
                        newPlaylist.readFile(fileName);
                    }
                    catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "File could not be found. " +
                                "Please try again");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, "File has been read in.");
                    break;

                case "Add Song":
                    int sLength = 0;
                    String songNameIn = JOptionPane.showInputDialog("Please enter the song name: ");
                    String bandNameIn = JOptionPane.showInputDialog("Please enter the artist's name: ");
                    String songLengthIn = JOptionPane.showInputDialog("Please enter the length of the song" +
                            " in this format mmss ");
                    // if the song length is wrong, break
                    if (songLengthIn.length() > 4 | songLengthIn.length() < 3) {
                        JOptionPane.showMessageDialog(null, "Song not added. " +
                                "Incorrect format. " +
                                "\nExample: If the song is 3 minutes and 14 seconds, enter \"0314\".");
                        break;
                    }
                    try {
                        sLength = Integer.parseInt(songLengthIn);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    newPlaylist.addSong(songNameIn, bandNameIn, sLength);
                    break;

                case "Swap Two Songs": //TODO
                    String song1 = JOptionPane.showInputDialog("Please enter the first song name: ");
                    String song2 = JOptionPane.showInputDialog("Please enter the second song name: ");
                    boolean itWorked = newPlaylist.swapSongs(song1, song2);
                    if (itWorked) {
                        JOptionPane.showMessageDialog(null, "Songs were swapped! " +
                                "Print the playlist to check.");
                    } else {
                        JOptionPane.showMessageDialog(null, "One or both of your songs " +
                                "couldn't be found. Please try again.");
                    }
                    break;

                case "Print Playlist":
                    //TODO Print title of playlist
                    JOptionPane.showMessageDialog(null, newPlaylist, "Playlist",
                            JOptionPane.PLAIN_MESSAGE);
                    break;

            }
        } while (!(input.equals("Exit")));

//        newPlaylist.readFile(args[0]);

//        System.out.println(altGood);

    }
}
