// Declara que esta classe pertence ao pacote "model", onde ficam as classes do modelo de dados
package model;

// Declaração da classe Estado, que representa o estado de um equipamento (ex: Ativo, Em Reparação, Reservado)
public class Estado {

    // Identificador numérico do estado (ex: 1, 2, 3), pode ser usado para guardar na base de dados
    private int id;

    // Descrição textual do estado (ex: "Ativo", "Em Reparação", "Reservado")
    private String descricao;


    // Construtor vazio necessário para DAO (ex: new Estado(); seguido de setters)
    public Estado() {}


    // Construtor da classe que recebe o id e a descrição do estado
    public Estado(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Método que devolve o ID do estado
    public int getId() {
        return id;
    }

    // Método que devolve a descrição do estado
    public String getDescricao() {
        return descricao;
    }

    // Este método é chamado automaticamente quando se tenta converter o objeto para String
    // Por exemplo, ao preencher uma JComboBox, será mostrada a descrição do estado
    @Override
    public String toString() {
        return descricao;
    }

    public void setId(int estadoId) {
    }

    public void setDescricao(String estadoDesc) {
    }
}
