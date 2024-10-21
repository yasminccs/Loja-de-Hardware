package Catalogo;

import Carrinho.formCarrinho;
import Carrinho.Item;
import java.util.ArrayList;
import java.util.List;

public class formExibirProduto extends javax.swing.JFrame {

    public formExibirProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NomeLabel = new javax.swing.JLabel();
        Separador = new javax.swing.JSeparator();
        PrecoLabel = new javax.swing.JLabel();
        QuantidadeLabel = new javax.swing.JLabel();
        Separador2 = new javax.swing.JSeparator();
        AddCarrinhoBtn = new javax.swing.JButton();
        VoltarBtn = new javax.swing.JButton();
        DescScrollPane = new javax.swing.JScrollPane();
        DescText = new javax.swing.JTextArea();
        ProdAddLabel = new javax.swing.JLabel();
        CarrinhoBtn = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        Sair = new javax.swing.JMenu();
        Sobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        NomeLabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        NomeLabel.setText("Nome:");

        PrecoLabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        PrecoLabel.setText("Preço: ");

        QuantidadeLabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        QuantidadeLabel.setText("Quantidade:");

        AddCarrinhoBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        AddCarrinhoBtn.setText("Adicionar ao carrinho");
        AddCarrinhoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCarrinhoBtnActionPerformed(evt);
            }
        });

        VoltarBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        VoltarBtn.setText("Voltar");
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });

        DescText.setEditable(false);
        DescText.setColumns(20);
        DescText.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        DescText.setLineWrap(true);
        DescText.setRows(5);
        DescText.setWrapStyleWord(true);
        DescScrollPane.setViewportView(DescText);

        ProdAddLabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        ProdAddLabel.setText("Produto adicionado ao carrinho.");

        CarrinhoBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        CarrinhoBtn.setText("Carrinho");
        CarrinhoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarrinhoBtnActionPerformed(evt);
            }
        });

        Sair.setText("Sair");
        Sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SairMouseClicked(evt);
            }
        });
        MenuBar.add(Sair);

        Sobre.setText("Sobre");
        Sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SobreMouseClicked(evt);
            }
        });
        MenuBar.add(Sobre);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Separador2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(QuantidadeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PrecoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(224, 224, 224))
                    .addComponent(Separador, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DescScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddCarrinhoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VoltarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CarrinhoBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ProdAddLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(PrecoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QuantidadeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProdAddLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddCarrinhoBtn)
                    .addComponent(VoltarBtn)
                    .addComponent(CarrinhoBtn))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_SairMouseClicked

    private void SobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SobreMouseClicked
        //Adicionar página de créditos/sobre/participantes do grupo
    }//GEN-LAST:event_SobreMouseClicked

    private void AddCarrinhoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCarrinhoBtnActionPerformed
        if (produto.getEstoque() <= 0) {
                ProdAddLabel.setText("Erro: Produto indisponível.");
                ProdAddLabel.setVisible(true);
        }else if(!formCatalogo.produtoJaNoCarrinho(indexProduto,carrinho)){
            produto.setEstoque(produto.getEstoque() - 1);
            Item item = new Item(produto.getNome(), 1, produto.getPreco());
            carrinho.adicionarItem(item); // Adiciona o item ao carrinho
            ProdAddLabel.setVisible(true);
            QuantidadeLabel.setText("Quantidade em estoque: " + produto.getEstoque());
        }
        else{
            ProdAddLabel.setText("Erro: Produto Já no carrinho.");
            ProdAddLabel.setVisible(true);
        }
    }//GEN-LAST:event_AddCarrinhoBtnActionPerformed

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        formCatalogo.exibirProdutos(carrinho);
        dispose();
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private void CarrinhoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarrinhoBtnActionPerformed
        carrinho.setVisible(true);
        dispose();
    }//GEN-LAST:event_CarrinhoBtnActionPerformed

    private static List<Produto> produtos = new ArrayList<>();
    private static Produto produto;
    private static formCarrinho carrinho;
    private static int indexProduto;
    
    public void setListaProdutos(int codigo, List<Produto> listaProdutos){
        produtos = listaProdutos;
        produto = produtos.get(codigo);
        indexProduto = codigo;
    }
    
    public void setCarrinho(formCarrinho carrinhoNovo){
        carrinho = carrinhoNovo;
    }
    
    public void exibirProduto() {
        ProdAddLabel.setVisible(false);
        
        NomeLabel.setText("Nome: " + produto.getNome());
        DescText.setText("Descrição: " + produto.getDescricao());
        PrecoLabel.setText("Preço: " + produto.getPreco());
        QuantidadeLabel.setText("Quantidade em estoque: " + produto.getEstoque());
    }
    
    
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formExibirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formExibirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formExibirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formExibirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        formExibirProduto form = new formExibirProduto();
        form.setVisible(true);
        form.setLocationRelativeTo(null);

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCarrinhoBtn;
    private javax.swing.JButton CarrinhoBtn;
    private javax.swing.JScrollPane DescScrollPane;
    private javax.swing.JTextArea DescText;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JLabel PrecoLabel;
    private javax.swing.JLabel ProdAddLabel;
    private javax.swing.JLabel QuantidadeLabel;
    private javax.swing.JMenu Sair;
    private javax.swing.JSeparator Separador;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JMenu Sobre;
    private javax.swing.JButton VoltarBtn;
    // End of variables declaration//GEN-END:variables
}
