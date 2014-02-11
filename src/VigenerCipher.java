/**
 * 
 * For this homework I picked the Vigener Cipher. The algorithm basically use a
 * short key (in the sample I used a key of length 6) and let the key repeatedly
 * occur when encrypting every letter. We might think of it as a way of stream
 * cipher. So at first, the algorithm lowercase all the letters. Then in the
 * loop, it is operating like a stream cipher. for every letter, it will
 * calculate the encrypted one with the correspondent key letter. The decryption
 * is almost the same.
 * 
 * @author haozheng
 * 
 */

public class VigenerCipher {

	private boolean hasSpaces; // for having spaces or not
	private FileOperation op;
	
	public VigenerCipher(boolean hasSpaces) {
		this.hasSpaces = hasSpaces;
		op = new FileOperation();
	}

	public void setHasSpaces(boolean na){
		hasSpaces = na;
	}
	
	public String encrypt(String text, String key, String filename) {
		if (text == null)
			return null;

		StringBuilder sb = new StringBuilder();
		if (hasSpaces) // choosing different regular expression based on
						// hasSpaces
			text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		else
			text = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
		
		//write the processed text
		op.writeFile(filename, text);
		
		key = key.toLowerCase(); // lowercase key if possible
		char c;
		for (int i = 0, j = 0; i < text.length(); i++) { // for the whole loop
			c = text.charAt(i);

			if (c == ' ') {
				sb.append(c);
				continue;
			}
			// encrypt the letter with the key
			sb.append((char) ((c + key.charAt(j) - 2 * 'a') % 26 + 'a'));
			j = ++j % key.length();// reusing the key

		}
		return sb.toString();
	}

	public String decrypt(String text, String key) {
		if (text == null)
			return null;
		StringBuilder sb = new StringBuilder();

		if (hasSpaces) // choosing different regular expression based on
						// hasSpaces
			text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		else
			text = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
		key = key.toLowerCase();
		char c;
		for (int i = 0, j = 0; i < text.length(); i++) {
			c = text.charAt(i);

			if (c == ' ') {
				sb.append(c);
				continue;
			}
			// decrypt the letter with the key
			sb.append((char) ((c - key.charAt(j) + 26) % 26 + 'a'));
			j = ++j % key.length();// reusing the key

		}
		return sb.toString();
	}
}
