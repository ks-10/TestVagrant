package assessment;

import java.util.LinkedHashSet;

//Create an in-memory store for recently played songs that can accommodate N songs per user, with a fixed initial capacity.
//This store must have the capability to store a list of song-user pairs, with each song linked to a user.
//It should also be able to fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.

public class firstApproach {
	
	//Maximum number of songs that can be stored
	// Set to store song names
    private int length;
    private LinkedHashSet<String> songs;

    //Constructor to initialize the Songs with a specified maximum length.	
    public firstApproach(int length) {
        this.length = length;
        this.songs = new LinkedHashSet<>();
    }

    // Adding a song to the collection
     //  -If the song is already present, remove the existing entry and adds it again at the end.
    // - If the collection is full, remove the oldest song and adds the new song at the end.
    public void addSong(String song) {
    	if (song == null) return; 

    	// If the song is already in the set, remove
        if (songs.contains(song)) {
            songs.remove(song);  
        } 
        // If maximum length is reached, remove the first song
        else if (songs.size() == length) {
            String firstSong = songs.stream().findFirst().orElse(null);
            if (firstSong != null) {
                songs.remove(firstSong);
            }
        }
        // Add the new song to the set
        songs.add(song);      
        
    }

    //Printing all the songs in insertion order.
    public void print() {
        for (String songName : songs) {
            System.out.print(songName + " ");
        }
        System.out.println();
    }

   
}
