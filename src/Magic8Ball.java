/*
Title: Magic8Ball.java
Author: Brynn Haley
Date: October 10th 2020
Description: Represents a magic 8 ball that can be shaken to return a random response from a finite set of responses.
 */

import java.util.Random;

public class Magic8Ball {
	//number of unique possible answers. Can be changed to add more potential answers in the future.
	public final int NUM_OF_ANSWERS = 4;

	//Shake the magic 8 ball, returning a pseudo-random result.
	public int shake() {
		Random random = new Random();
		return random.nextInt(NUM_OF_ANSWERS);
	}
}
