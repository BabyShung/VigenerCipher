import vigenere.FileOperation;
import vigenere.VigenerCipher;
import breaker.Statistics;

public class Test {

	public static void main(String[] args) {

		FileOperation op = new FileOperation();
		VigenerCipher vc = new VigenerCipher(true);// true means having spaces
		Statistics s = new Statistics();

		String ct = op.readFile("vigenere_nosp.txt");// read from
														// vigenere_nosp.txt
		// String dt = op.readFile("decrypt.txt");// read from decrypt.txt
		// System.out.println(ct);
		// System.out.println(dt);

		s.alphabetStatistics(ct);

		s.frequency(ct, 0, 2);
		s.frequency(ct, 0, 3);
		s.frequency(ct, 0, 4);
		s.frequency(ct, 0, 5);
		s.frequency(ct, 0, 6);
		s.frequency(ct, 0, 7);

		String keyword = s.guessingKeyword(ct, 7);
		String decrypttext = vc.decrypt(ct, keyword);// decrpty the ciphertext

		System.out.println(keyword);
		System.out.println(decrypttext);

		op.writeFile("vigenere_nosp_decrypt.txt", decrypttext);
	}

}
