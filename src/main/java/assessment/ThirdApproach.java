package assessment;

import java.util.HashMap;

class DllNode {
    String song;
    DllNode prev;
    DllNode next;

    public DllNode(String song) {
        this.song = song;
    }
}

class UserPlayedSongs {
    HashMap<String, DllNode> songAssigned;
    DllNode head;
    DllNode tail;
    int limit;

    public UserPlayedSongs(int limit) {
        songAssigned = new HashMap<>();
        this.limit = limit;
    }

    public void playSong(String song) {
        DllNode node = songAssigned.get(song);

        if (node != null) {
            // Song already exists, just update the position
            removeNode(node);
        } else {
            // Create a new node for the song
            node = new DllNode(song);
            songAssigned.put(song, node);

            if (songAssigned.size() > limit) {
                // If we exceed the limit, remove the least recently played song
                songAssigned.remove(head.song);
                removeNode(head);
            }
        }

        addNode(node);
    }

    public void removeNode(DllNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    public void addNode(DllNode node) {
        node.prev = tail;
        node.next = null;

        if (tail != null) {
            tail.next = node;
        }

        tail = node;

        if (head == null) {
            head = node;
        }
    }

    public void printSongList() {
        DllNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.song +" ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
