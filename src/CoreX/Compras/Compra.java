package CoreX.Compras;



import CoreX.Carrinho.Carrinho;
import CoreX.Carrinho.Item;
import CoreX.Usuario.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Compra {

    private JPanel painelPrincipal;
    private JLabel labelResumoVenda, labelLoginVerificado, labelEndereco;
    private JTextField campoEndereco;
    private JButton botaoFinalizar;
    private boolean loginVerificado;
    private Carrinho carrinho;

    public Compra(Carrinho carrinho) {
        this.carrinho = carrinho;
        // Verifica se o login foi feito anteriormente
        loginVerificado = Usuario.cliente.getNome() != null && Usuario.cliente.getSenha() != null;

        criarPainel(); // Cria a interface de compra
    }

    public void criarPainel() {
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(5, 1));

        StringBuilder resumo = new StringBuilder("<html>Resumo da venda:<br>");
        for (Item item : carrinho.getItensCarrinho()) {
            resumo.append("Produto: ").append(item.getNome()).append(", Quantidade: ").append(item.getQuantidade())
                    .append(", Valor: R$").append(item.calcularValorTotal()).append("<br>");
        }
        resumo.append("</html>");
        labelResumoVenda = new JLabel(resumo.toString());
        painelPrincipal.add(labelResumoVenda);

        // Verificação de login
        labelLoginVerificado = new JLabel("Login Verificado: " + (loginVerificado ? "Sim" : "Não"));
        painelPrincipal.add(labelLoginVerificado);

        // Campo endereço
        labelEndereco = new JLabel("Insira seu Endereço (Rua e Número):");
        painelPrincipal.add(labelEndereco);

        campoEndereco = new JTextField();
        painelPrincipal.add(campoEndereco);

        // Botão de finalizar compra
        botaoFinalizar = new JButton("Finalizar Compra");
        botaoFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginVerificado) {
                    // Se o login estiver verificado, tenta finalizar a compra
                    validarEndereco();
                } else {
                    // Se o login não estiver verificado, exibe a mensagem de alerta
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja realizar o login agora?", "Atenção", JOptionPane.OK_CANCEL_OPTION);

                    if (resposta == JOptionPane.OK_OPTION) {
                        // Redireciona para a tela de login/cadastro
                        Usuario.escolherOp();

                        // Atualiza a variável após a tentativa de login
                        loginVerificado = Usuario.cliente.getNome() != null && Usuario.cliente.getSenha() != null;

                        // Atualiza a label para refletir o status de login
                        labelLoginVerificado.setText("Login Verificado: " + (loginVerificado ? "Sim" : "Não"));

                        if (loginVerificado) {
                            JOptionPane.showMessageDialog(null, "Login realizado com sucesso. Agora você pode finalizar a compra.");
                        }
                    }
                }
            }
        });
        painelPrincipal.add(botaoFinalizar);

        // Mostra o painel de finalização de compra
        Object[] opcoes = {"Cancelar"};
        int resultado = JOptionPane.showOptionDialog(null, painelPrincipal, "Finalização de Compra",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (resultado == JOptionPane.CLOSED_OPTION || resultado == 0) {
            JOptionPane.showMessageDialog(null, "Compra cancelada!\n", "Cancelamento", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Valida o endereço
    public void validarEndereco() {
        String endereco = campoEndereco.getText();
        if (endereco.matches(".+\\d+")) {
            perguntarNovaCompra();
        } else {
            JOptionPane.showMessageDialog(null, "Endereço inválido! Insira um endereço no formato 'Rua, Número'.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Pergunta se o usuário quer fazer uma nova compra
    public void perguntarNovaCompra() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realizar uma nova compra?", "Nova Compra", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            campoEndereco.setText(""); // Vai limpar o campo para uma nova compra ser feita
        } else {
            JOptionPane.showMessageDialog(null, "Compra finalizada! Obrigado!");
            System.exit(0); // Vai fechar o programa
        }
    }
}
