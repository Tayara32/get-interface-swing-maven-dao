// Declara que esta classe pertence ao pacote "model", onde ficam as classes do modelo de dados
package model;

// Declaração da classe Estado, que representa o estado de um equipamento (ex: Ativo, Em Reparação, Reservado)
public class Estado {

    // Identificador numérico do estado (ex: 1, 2, 3), pode ser usado para guardar na base de dados
    private final int id;

    // Descrição textual do estado (ex: "Ativo", "Em Reparação", "Reservado")
    private final String descricao;

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
}
