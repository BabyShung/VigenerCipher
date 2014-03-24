import vigenere.FileOperation;
import vigenere.VigenerCipher;
import breaker.Statistics;

public class Test {

	public static void main(String[] args) {

		FileOperation op = new FileOperation();
		
		// true means having spaces for encrypt
		VigenerCipher vc = new VigenerCipher(true);
		Statistics s = new Statistics();
		
		// read from vigenere_nosp.txt
		String ct = op.readFile("vigenere_nosp.txt");

		s.alphabetStatistics(ct);

		s.frequency(ct, 0, 2);
		s.frequency(ct, 0, 3);
		s.frequency(ct, 0, 4);
		s.frequency(ct, 0, 5);
		s.frequency(ct, 0, 6);
		s.frequency(ct, 0, 7);

		String keyword = s.guessingKeyword(ct, 7);//get the keyword
		String decrypttext = vc.decrypt(ct, keyword);// decrpty the ciphertext

		System.out.println("keyword is: " + keyword);
		System.out.println("plaintext is: " +decrypttext);

		op.writeFile("vigenere_nosp_decrypt.txt", decrypttext);
	}

}
