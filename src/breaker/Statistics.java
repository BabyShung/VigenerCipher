package breaker;

import java.util.Arrays;

public class Statistics {

	public int[] frequency(String ct, int startPosition, int guessingkeyLength) {
		int[] bucket = new int[26];
		int index;
		int length = ct.length();
		for (int i = startPosition; i < length - 1; i += guessingkeyLength) {
			index = ct.charAt(i) - 'a';
			bucket[index]++;
		}
		System.out.println("GuessingkeyLength: " + guessingkeyLength);
		System.out
				.println("-------------------------------------------------------------");
		print(bucket, true);
		max(bucket);

		double minP = bucket[0] / (double) length * (guessingkeyLength * 100);
		double maxP = bucket[bucket.length - 1] / (double) length
				* (guessingkeyLength * 100);
		System.out.println("min:" + bucket[0]);
		System.out.println("max:" + bucket[bucket.length - 1]);
		System.out.println("minProb:" + minP);
		System.out.println("maxProb:" + maxP);
		System.out.println("maxProb-minProb: " + (maxP - minP));
		System.out.println();
		return bucket;
	}

	public String guessingKeyword(String ct, int guessingkeyLength) {

		final char highestFrequencyLetter = 'e';// magic character
		StringBuilder sb = new StringBuilder();
		int index;
		int length = ct.length();

		for (int k = 0; k < guessingkeyLength; k++) {
			int[] bucket = new int[26];

			for (int i = k; i < length - 1; i += guessingkeyLength) {
				index = ct.charAt(i) - 'a';
				bucket[index]++;
			}
			char maxFChar = getMaxCharacter(bucket);
			System.out.println(maxFChar);
			
			int newV = (maxFChar - highestFrequencyLetter) % 26 ;
			if(newV<0)
				newV+=26;
			
			char key = (char) (newV + 97);
			sb.append(key);
		}
		
		
		return sb.toString();
	}

	private char getMaxCharacter(int[] bucket) {
		int maxIndex = 0;
		for (int i = 1; i < bucket.length; i++) {
			if (bucket[i] > bucket[maxIndex])
				maxIndex = i;
		}
		char maxFChar = (char) (maxIndex + 'a');
		return maxFChar;

	}

	public int[] alphabetStatistics(String ct) {

		int[] bucket = new int[26];
		int index;
		int length = ct.length();
		for (int i = 0; i < length - 1; i++) {
			index = ct.charAt(i) - 'a';
			bucket[index]++;
		}
		print(bucket, true);
		max(bucket);
		return bucket;
	}

	private void max(int[] bucket) {
		Arrays.sort(bucket);
		System.out.println("-----------left to right, increasing-----------");
		print(bucket, false);

	}

	private void print(int[] bucket, boolean withIndex) {

		for (int i = 0; i < bucket.length; i++) {

			System.out.print(bucket[i]);
			if (bucket[i] / 100 == 0)// 2 digits
				System.out.print("  ");
			else
				System.out.print(" ");
		}
		System.out.println();
		if (withIndex) {
			for (int i = 0; i < bucket.length; i++) {
				char tmp = (char) ('a' + i);
				System.out.print(tmp);
				System.out.print("   ");
			}
		}
		System.out.println();
	}

}
