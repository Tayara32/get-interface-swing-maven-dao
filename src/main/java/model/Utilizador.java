package model;

/**
 * Classe que representa um Utilizador do sistema.
 */
public class Utilizador {

    private String utilizador;
    private String palavraChave;

    public Utilizador() {
        // Construtor vazio
    }

    public Utilizador(String utilizador, String palavraChave) {
        this.utilizador = utilizador;
        this.palavraChave = palavraChave;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public boolean isLoginValido() {
        return utilizador != null && !utilizador.isEmpty()
                && palavraChave != null && !palavraChave.isEmpty();
    }
}