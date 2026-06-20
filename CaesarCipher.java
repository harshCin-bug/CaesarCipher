import java.util.*;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Caesar Cipher Security Tool ---");
        System.out.println("Select an operation:");
        System.out.println("1. Encrypt a message");
        System.out.println("2. Decrypt a message");
        System.out.print("Enter choice (1 or 2): ");
        
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline character

        // Input validation
        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Exiting program.");
            return;
        }

        System.out.print("Enter the message: ");
        String message = sc.nextLine();
        
        System.out.print("Enter the shift key (integer): ");
        int shift = sc.nextInt();

        // Control Flow based on User Choice
        if (choice == 1) {
            String encrypted = encrypt(message, shift);
            System.out.println("\n[+] Encrypted Ciphertext: " + encrypted);
        } else {
            String decrypted = decrypt(message, shift);
            System.out.println("\n[+] Decrypted Plaintext:  " + decrypted);
        }
    }

    // Method to encrypt the string
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26; // Normalize shift
        char c[]=text.toCharArray();
        for (int i=0; i<c.length; i++) {
            if (Character.isUpperCase(c[i])) {
                char ch = (char) (((((int)c[i] + shift)%65)%26)+65);// Encrypt uppercase letters
                result.append(ch);
            } else if (Character.isLowerCase(c[i])) {
                char ch = (char) (((((int)c[i] + shift)%97)%26)+97);// Encrypt lowercase letters
                result.append(ch);
            } else {
                result.append(c[i]); 
            }
        }
        return result.toString();
    }

    // Method to decrypt by shifting backwards
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }
}
