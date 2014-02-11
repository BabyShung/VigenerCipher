public class Test {

	public static void main(String[] args) {
		
		FileOperation op = new FileOperation();
		VigenerCipher vc = new VigenerCipher(true);//true means having spaces
		
		//PART1
		final String key = "badday";
		String plaintext = op.readFile("plaintext1.txt");//read from plaintext1.txt
		String cipher = vc.encrypt(plaintext, key,"plaintext1_processed.txt");//encrypt the string
		op.writeFile("ciphertext1.txt",cipher);//write the ciphertext into ciphertext1.txt
		
		System.out.println("Encrypted: " + cipher);
		System.out.println("Decrypted: " + vc.decrypt(cipher, key));//decrypt algo

		//PART2
		final String key2 = "goodday";
		vc.setHasSpaces(false);//not want spaces
		String plaintext2 = op.readFile("plaintext2.txt");
		String cipher2 = vc.encrypt(plaintext2, key2,"plaintext2_processed.txt");//encrypt the string
		op.writeFile("ciphertext2.txt",cipher2);//write the ciphertext into ciphertext2.txt
		
		System.out.println("Encrypted: " + cipher2);
		System.out.println("Decrypted: " + vc.decrypt(cipher2, key2));//decrypt algo
	}

}
