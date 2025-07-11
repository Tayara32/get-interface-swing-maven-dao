package model;

public class Utilizador {

    private int id;
    private String utilizador;
    private String palavraChave;
    private String nome;
    private int perfil_id;

    public Utilizador() {}

    public Utilizador(String utilizador, String palavraChave) {
        this.utilizador = utilizador;
        this.palavraChave = palavraChave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(int perfil_id) {
        this.perfil_id = perfil_id;
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
    /**
     * Obtém o nome completo do utilizador
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do utilizador
     *
     * @param nome texto do nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


}