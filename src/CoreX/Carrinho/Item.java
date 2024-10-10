package CoreX.Carrinho;

public class Item {
    public String nome;
    private int quantidade;
    public float valor_unitario;

    // Construtor padrão
    public Item() {
        this.nome = "";
        this.quantidade = 1; // ou um valor padrão que você preferir
        this.valor_unitario = 0.0f; // valor inicial padrão
    }

    // Construtor com parâmetros
    public Item(String nome, int quantidade, float valor_unitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValorUnitario() {
        return valor_unitario;
    }

    // Método para calcular o valor total do item
    public float calcularValorTotal() {
        return valor_unitario * quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}