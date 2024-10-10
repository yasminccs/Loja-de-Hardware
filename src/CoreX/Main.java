package CoreX;

import CoreX.Carrinho.Carrinho;
import CoreX.Catalogo.Catalogo;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Carrinho carrinho = new Carrinho();

        catalogo.construirListaProdutos();

        boolean continuar = true;

        do {
            String escolha = JOptionPane.showInputDialog("Escolha uma opção:\n1 - Ir para o catálogo\n2 - Ver Carrinho\n3 - Sair");

            if (escolha == null) {
                JOptionPane.showMessageDialog(null, "Sistema encerrado.");
                System.exit(0);
            }

            switch (escolha) {
                case "1":
                    Catalogo.exibirProdutos(carrinho);
                    break;
                case "2":
                    carrinho.escolherOperacao();  // Aqui você chama o método que exibe o carrinho e as operações
                    break;
                case "3":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Erro: Nenhuma opção foi selecionada. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (continuar);
        JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema!");
    }
}

