package Carrinho;

public class Item {
    public String nome;
    private int quantidade;
    public float valorUnitario;

    // Construtor padrão
    public Item() {
        this.nome = "";
        this.quantidade = 1; // ou um valor padrão que você preferir
        this.valorUnitario = 0.0f; // valor inicial padrão
    }

    // Construtor com parâmetros
    public Item(String nome, int quantidade, float valorUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    // Método para calcular o valor total do item
    public float calcularValorTotal() {
        return valorUnitario * quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        double valorTotal = 0.0;
        valorTotal += this.calcularValorTotal();
        return valorTotal;
    }
}