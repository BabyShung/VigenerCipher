import vigenere.FileOperation;
import vigenere.VigenerCipher;
import breaker.Statistics;

public class Test {

	public static void main(String[] args) {

		FileOperation op = new FileOperation();
		VigenerCipher vc = new VigenerCipher(true);// true means having spaces
		Statistics s = new Statistics();

		String ct = op.readFile("vigenere_nosp.txt");// read from plaintext1.txt
		System.out.println(ct);
		s.alphabetStatistics(ct);
		
		s.frequency(ct, 0, 5);

	}

}
