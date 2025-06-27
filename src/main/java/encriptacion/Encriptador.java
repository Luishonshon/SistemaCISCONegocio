package encriptacion;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author luishonshon
 */
public class Encriptador {

    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

    public Encriptador() {
    }
    
    /**
     * Método que recibe un string y lo hashea
     *
     * @param contraseña
     * @return
     */
    public static String hashContraseña(String contraseña) {
        byte[] salt = generateSalt();
        byte[] hash = pbkdf2(contraseña.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
    }

    /**
     * Método que recibe dos String, una contraseña que hashea y la compara con
     * el otro string que es una contraseña ya hasheada.
     *
     * @param contraseña
     * @param contraseñaHasheada
     * @return
     */
    public static boolean verificarContraseña(String contraseña, String contraseñaHasheada) {
        String[] parts = contraseñaHasheada.split(":");
        if (parts.length != 2) {
            return false;
        }

        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] hash = Base64.getDecoder().decode(parts[1]);
        byte[] testHash = pbkdf2(contraseña.toCharArray(), salt, ITERATIONS, KEY_LENGTH);

        return slowEquals(hash, testHash);
    }

    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int keyLength) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error al generar hash con PBKDF2", e);
        }
    }

    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }
}
