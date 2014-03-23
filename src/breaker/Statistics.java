package breaker;

import java.util.Arrays;

public class Statistics {

	public int[] frequency(String ct,int startPosition,int guessingkeyLength){
		int[] bucket = new int[26];
		int index;
		int length = ct.length();
		for (int i = startPosition; i < length - 1; i+=guessingkeyLength) {
			index = ct.charAt(i) - 'a';
			bucket[index]++;
		}
		System.out.println("-----------guessingkeyLength: "+guessingkeyLength);
		print(bucket,true);
		max(bucket);
		return bucket;
	}
	
	public int[] alphabetStatistics(String ct) {

		int[] bucket = new int[26];
		int index;
		int length = ct.length();
		for (int i = 0; i < length - 1; i++) {
			index = ct.charAt(i) - 'a';
			bucket[index]++;
		}
		print(bucket,true);
		max(bucket);
		return bucket;
	}

	private void max(int[] bucket) {
		Arrays.sort(bucket);
		System.out.println("-----------left to right, increasing-----------");
		print(bucket,false);

	}

	private void print(int[] bucket, boolean withIndex) {
		
		for (int i = 0; i < bucket.length; i++) {

			System.out.print(bucket[i]);
			if(bucket[i]/100==0)//2 digits
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
