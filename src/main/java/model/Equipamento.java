// Declara o pacote onde a classe está inserida (model), indicando que esta é uma classe do modelo de dados
package model;


import java.time.LocalDate;

// Declaração da classe Equipamento, que representa um equipamento físico ou digital na aplicação
public class Equipamento {

    // Atributo que guarda o nome do equipamento (ex: "Portátil HP", "Switch 24 portas", etc.)
    private  String nome;

    // Atributo que guarda o estado do equipamento, do tipo enum Estado (ex: ATIVO, REPARACAO, RESERVADO)
    private  Estado estado;

    // Atributo que indica a sala onde o equipamento está localizado (ex: "Sala 2.1")
    private  String sala;

    // Atributo que representa o responsável associado ao equipamento, do tipo Utilizador
    private  Utilizador responsavel;

    //Atributo que representa o número de sério do equipamento
    private  String numeroSerie;

    //Atributo que representa a data de aquisição do equipamento
    private  LocalDate dataAquisicao;


    // Construtor vazio (necessário para algumas bibliotecas e frameworks, como o JDBC)
    public Equipamento() {
    }

    // Construtor da classe que inicializa todos os atributos do equipamento ao ser criado
    public Equipamento(String nome, Estado estado, String sala, Utilizador responsavel, String numeroSerie, LocalDate dataAquisicao) {
        this.nome = nome;
        this.estado = estado;
        this.numeroSerie = numeroSerie;
        this.dataAquisicao = dataAquisicao;
        this.sala = sala;
        this.responsavel = responsavel;

    }

    // Método que devolve o nome do equipamento
    public String getNome() {
        return nome;
    }

    // Método que devolve o estado atual do equipamento
    public Estado getEstado() {
        return estado;
    }

    // Método que devolve a sala onde o equipamento se encontra
    public String getSala() {
        return sala;
    }

    // Método que devolve o responsável atribuído ao equipamento
    public Utilizador getResponsavel() {
        return responsavel;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setResponsavel(Utilizador responsavel) {
        this.responsavel = responsavel;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }
}
