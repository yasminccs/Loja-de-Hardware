package CoreX.Catalogo;

import CoreX.Carrinho.Carrinho;
import CoreX.Carrinho.Item;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;



public class Catalogo {
    private static List<Produto> produtos = new ArrayList<>();

    public static void construirListaProdutos() {
        produtos.add(new Produto(" - Mouse Razer Deathadder Essential", "Mouse ergonômico projetado paraconforto, com ajuste de DPI e botões auxiliares.", 194f, 1));
        produtos.add(new Produto(" - Processador Intel i7-12700K", "Processador de alto desempenho com soquete LGA 1700, com 12 núcleos, 20 threads, vídeo integrado e clock de 3.6GHz", 1699.99f, 30));
        produtos.add(new Produto(" - Memória RAM Kingston FURY Beast 32GB", "Módulo único de memória RAM para desktop com capacidade de 32GB 3200MT/s DDR4 CL16", 599.99f, 65));
        produtos.add(new Produto(" - Fone de Ouvido Audio Technica ATH-M20x", "Fone de ouvido profissional para monitoramento de áudio de estúdio e mixagem.", 469f, 120));
        produtos.add(new Produto(" - GPU Sapphire Pulse AMD RADEON RX 7900 XT", "Placa de vídeo de alto desempenho projetada para jogos, contando com 20GB de memória virtual GDDR6.", 5882.99f, 16));
        produtos.add(new Produto(" - Webcam Logitech C920s", "Webcam Full HD com microfone embutido e proteção de privacidade.", 429.99f, 300));
    }

    public static void exibirProdutos(Carrinho carrinho) {
        StringBuilder listaProdutosStrB = new StringBuilder();
        listaProdutosStrB.append("BEM-VINDO(A) AO CATÁLOGO\n\n");
        for (int i = 1; i < produtos.size(); i++) {
            listaProdutosStrB.append(i).append(" ").append(produtos.get(i).getNome()).append("\n")
                    .append("Preço: R$").append(produtos.get(i).getPreco()).append("\n\n");
        }

        int codigo;
        String op;

        do {
            op = JOptionPane.showInputDialog(null, listaProdutosStrB.toString() + "\nDigite o código do produto desejado.",
                    "Selecione", JOptionPane.INFORMATION_MESSAGE);

            if (op != null && !"".equals(op)) {
                try {
                    codigo = Integer.parseInt(op);
                    //exibirProduto(codigo, carrinho);
                    if (produtoJaNoCarrinho(codigo, carrinho)) { // Verifica se o produto já está no carrinho
                        JOptionPane.showMessageDialog(null, "Este produto já está no carrinho.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        exibirProduto(codigo, carrinho);
                    }
                    return; // Volta ao menu principal
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else if ("".equals(op)) {
                JOptionPane.showMessageDialog(null, "Selecione uma opção.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while ("".equals(op));
    }

    public static void exibirProduto(int codigo, Carrinho carrinho) {
        Produto produto = produtos.get(codigo);
        StringBuilder exibicaoItemDesejado = new StringBuilder();

        exibicaoItemDesejado.append("Nome: ").append(produto.getNome()).append("\n")
                .append("Descrição: ").append(produto.getDescricao()).append("\n")
                .append("Preço: R$").append(produto.getPreco()).append("\n")
                .append("Quantidade em estoque: ").append(produto.getEstoque()).append("\n");

        int op = JOptionPane.showConfirmDialog(null, exibicaoItemDesejado + "\nDeseja adicionar ao carrinho?",
                "Adicionar ao carrinho?", JOptionPane.YES_NO_OPTION);

        if (op == 0) { // Sim
            if (produto.getEstoque() <= 0) {
                JOptionPane.showMessageDialog(null, "Produto indisponível.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                produto.setEstoque(produto.getEstoque() - 1);
                Item item = new Item(produto.getNome(), 1, produto.getPreco());
                carrinho.adicionarItem(item); // Adiciona o item ao carrinho
                JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho.");
            }
        }
    }

    private static boolean produtoJaNoCarrinho(int codigo, Carrinho carrinho) {
        Produto produto = produtos.get(codigo);
        for (Item item : carrinho.getItensCarrinho()) {
            if (item.getNome().equals(produto.getNome())) {
                return true; // O produto já está no carrinho
            }
        }
        return false; // O produto não está no carrinho
    }
}