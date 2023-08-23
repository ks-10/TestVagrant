package assessment;

import org.junit.Test;

public class TestRunner {

	// ****** Second Approach **********
	static SecondApproach ob = new SecondApproach(3);
	// ****** First Approach ***********
	// static firstApproach ob = new firstApproach(3);

	public static void main(String[] args) {

		// Given example test case
		System.out.println("Test Case 1 : ");
		data1();
		// Test case for repeating nodes
		System.out.println("Test Case 2 : ");
		data2();
		// Test case for exceeding length
		System.out.println("Test Case 3 : ");
		data3();

	}

	@Test
	public static void data1() {

		ob.addSong("U1", "S1");
		ob.addSong("U1", "S2");
		ob.addSong("U1", "S3");
		ob.printSongList("U1");
		// Expected Output
		 // S1 S2 S3
		ob.addSong("U1", "S4");
		ob.printSongList("U1");

		// Expected Output
		 // S2 S3 S4
		ob.addSong("U1", "S2");
		ob.printSongList("U1");

		// Expected Output
		// S3 S4 S2
		
		ob.addSong("U1", "S1");
		ob.printSongList("U1");

		// Expected Output
		// S4 S2 S1

	}

	@Test
	public static void data2() {

		ob.addSong("U1", "S1");
		ob.addSong("U1", "S2");
		ob.addSong("U1", "S3");
		ob.addSong("U1", "S2");
		ob.printSongList("U1");
		// Expected Output
		// S1 S3 S2
	}

	@Test
	public static void data3() {

		ob.addSong("U1", "S1");
		ob.addSong("U1", "S2");
		ob.addSong("U1", "S3");
		ob.addSong("U1", "S4");
		ob.printSongList("U1");
		// Expected Output
		// S2 S3 S4
	}

}
