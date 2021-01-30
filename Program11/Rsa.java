import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

class Rsa {

    static BigInteger a, b, n, phi_n, x, y;
    static SecureRandom secureRandom;
    static int bitLength = 64;

    static String encrypt(String msg) {
        return new BigInteger(msg.getBytes()).modPow(x, n).toString();
    }

    static String decrypt(String cipher) {
        BigInteger bi = new BigInteger(cipher).modPow(y, n);
        return new String(bi.toByteArray());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        secureRandom = new SecureRandom();

        a = BigInteger.probablePrime(bitLength, secureRandom);
        b = BigInteger.probablePrime(bitLength, secureRandom);
        n = a.multiply(b);
        phi_n = a.subtract(BigInteger.ONE).multiply(b.subtract(BigInteger.ONE));

        x = BigInteger.probablePrime(bitLength / 2, secureRandom);
        while (x.gcd(phi_n).compareTo(BigInteger.ONE) != 0 && x.compareTo(phi_n) < 0) {
            x = x.add(BigInteger.ONE);
        }

        y = x.modInverse(phi_n);

        System.out.println("A assigned as: " + a);
        System.out.println("B assigned as: " + b);
        System.out.println("N assigned as: " + n);
        System.out.println("PHI_N assigned as: " + phi_n);

        System.out.println("\nEnter Message");
        String msg = scanner.nextLine();

        String encryptedMessage = encrypt(msg);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);

    }
}
