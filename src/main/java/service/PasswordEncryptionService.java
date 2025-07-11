package service;

// importa a biblioteca BCrypt para cifrar passwords
import org.mindrot.jbcrypt.BCrypt;

/**
 * Serviço responsável para validar palavras-chave
 *
 * Utiliza a biblioteca BCrypt para garantir a segurança
 */
public class PasswordEncryptionService {


    /**
     * Verifica se uma password em texto simples corresponde ao hash guardado
     *
     * @param plainText password fornecida pelo utilizador
     * @param hashed hash previamente armazenado na base de dados
     * @return true se coincidir, false caso contrário
     */
    public static boolean verifyPassword(String plainText, String hashed) {
        // compara o texto simples com o hash
        return BCrypt.checkpw(plainText, hashed);
    }
}