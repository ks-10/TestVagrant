package assessment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class SecondApproach {
	private final int size;
	private Map<String, LinkedList<String>> playList;

	public SecondApproach(int length) {
		this.size = length;
		this.playList = new HashMap<>();
	}

	public void addSong(String user, String song) {
		playList.putIfAbsent(user, new LinkedList<String>());
		LinkedList<String> playlist = playList.get(user);

		// Removing the song if it already exists in the list
		playlist.remove(song);

		if (playlist.size() >= size) {
			playlist.removeFirst();
		}
		// Adding the new song to the playlist
		playlist.add(song);
	}

	// Printing the song
	public List<String> printSongList(String user) {
		System.out.println(playList.getOrDefault(user, new LinkedList<String>()));
		return playList.getOrDefault(user, new LinkedList<String>());
	}

}