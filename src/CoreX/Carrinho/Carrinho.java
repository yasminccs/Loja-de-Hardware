package CoreX.Carrinho;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

import CoreX.Catalogo.Catalogo;
import CoreX.Compras.Compra;

public class Carrinho {
    private List<Item> itensCarrinho;

    public Carrinho() {
        this.itensCarrinho = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        this.itensCarrinho.add(item);
    }

    public List<Item> getItensCarrinho() {
        return itensCarrinho;
    }

    // Método que lida com as operações do carrinho
    public void escolherOperacao() {
        if (itensCarrinho.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carrinho vazio. Adicione itens antes de tentar fazer operações.");
            return;
        }

        boolean continuarOperacoes = true;

        while (continuarOperacoes) {
            StringBuilder sb = new StringBuilder();
            float total = 0;

            // Exibir itens do carrinho
            for (int i = 0; i < itensCarrinho.size(); i++) {
                Item item = itensCarrinho.get(i);
                sb.append("Item ").append(i + 1).append(":\n")
                        .append("Produto: ").append(item.getNome()).append("\n")
                        .append("Quantidade: ").append(item.getQuantidade()).append("\n")
                        .append("Valor unitário: R$").append(item.getValorUnitario()).append("\n")
                        .append("Valor total: R$").append(item.calcularValorTotal()).append("\n\n");
                total += item.calcularValorTotal();
            }
            sb.append("Total do carrinho: R$").append(total).append("\n\n");

            // Exibir as operações junto com o carrinho
            sb.append("Escolha uma operação:\n")
                    .append("1 - Alterar Quantidade do item\n")
                    .append("2 - Remover um item\n")
                    .append("3 - Limpar carrinho\n")
                    .append("4 - Continuar comprando\n")
                    .append("5 - Finalizar compra");

            // Solicitar ao usuário a operação a ser realizada
            String input = JOptionPane.showInputDialog(null, sb.toString());
            String op;

            try {
                op = input;
                int index = -1;

                if (op == null) {
                    return;
                }

                switch (op) {
                    case "1":
                        index += Integer.parseInt(JOptionPane.showInputDialog("Digite o número do item que deseja alterar a quantidade:"));
                        int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade para o produto:"));
                        if(novaQuantidade == 0){
                            removerProduto(index);
                        }
                        else if(novaQuantidade < 0){
                            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            alterarQuantidadeProduto(index, novaQuantidade);
                        }
                        break;
                    case "2":
                        index += Integer.parseInt(JOptionPane.showInputDialog("Digite o número do item que deseja remover:"));
                        removerProduto(index);
                        break;
                    case "3":
                        limparCarrinho();
                        break;
                    case "4":
                        continuarOperacoes = false;
                        Catalogo.exibirProdutos(this);
                        break;
                    case "5":
                        if (itensCarrinho.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Carrinho vazio. Adicione itens antes de finalizar a compra.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            new Compra(this);
                            continuarOperacoes = false;
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Operação inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Erro desconhecido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Alterado para usar o índice do item
    public void alterarQuantidadeProduto(int itemIndex, int novaQuantidade) {
        if (itemIndex >= 0 && itemIndex < itensCarrinho.size()) {
            Item item = itensCarrinho.get(itemIndex);
            item.setQuantidade(novaQuantidade);
            JOptionPane.showMessageDialog(null, "Quantidade do produto '" + item.getNome() + "' atualizada.");
        } else {
            JOptionPane.showMessageDialog(null, "Item inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Alterado para usar o índice do item
    public void removerProduto(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < itensCarrinho.size()) {
            Item item = itensCarrinho.remove(itemIndex);
            JOptionPane.showMessageDialog(null, "Produto '" + item.getNome() + "' removido.");
        } else {
            JOptionPane.showMessageDialog(null, "Item inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limparCarrinho() {
        itensCarrinho.clear();
        JOptionPane.showMessageDialog(null, "Carrinho limpo.");
    }
}
