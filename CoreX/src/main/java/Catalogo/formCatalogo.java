package Catalogo;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Carrinho.formCarrinho;
import Carrinho.Item;
import java.util.ArrayList;
import java.util.List;

public class formCatalogo extends javax.swing.JFrame {

    public formCatalogo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        BemVindo = new javax.swing.JLabel();
        PainelCatalogo = new javax.swing.JScrollPane();
        ListaProdutos = new javax.swing.JList<>();
        VoltarBtn = new javax.swing.JButton();
        ErroLabel = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        Sair = new javax.swing.JMenu();
        Sobre = new javax.swing.JMenu();

        jScrollPane2.setViewportView(jTextPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BemVindo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        BemVindo.setText("Bem-vindo ao catálogo! Selecione o produto desejado.");

        ListaProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        PainelCatalogo.setViewportView(ListaProdutos);

        VoltarBtn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        VoltarBtn.setText("Voltar");
        VoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBtnActionPerformed(evt);
            }
        });

        ErroLabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        ErroLabel.setText("Erro: Produto selecionado já está no carrinho.");

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
                    .addComponent(BemVindo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelCatalogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VoltarBtn)
                            .addComponent(ErroLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BemVindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(ErroLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VoltarBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_SairMouseClicked

    private void SobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SobreMouseClicked
        //Adicionar página de créditos/sobre/participantes do grupo
    }//GEN-LAST:event_SobreMouseClicked

    private void VoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBtnActionPerformed
        dispose();
    }//GEN-LAST:event_VoltarBtnActionPerformed

    private static List<Produto> produtos = new ArrayList<>();

    public static void construirListaProdutos() {
        produtos.add(new Produto(" - Mouse Razer Deathadder Essential", "Mouse ergonômico projetado paraconforto, com ajuste de DPI e botões auxiliares.", 194f, 1));
        produtos.add(new Produto(" - Processador Intel i7-12700K", "Processador de alto desempenho com soquete LGA 1700, com 12 núcleos, 20 threads, vídeo integrado e clock de 3.6GHz", 1699.99f, 30));
        produtos.add(new Produto(" - Memória RAM Kingston FURY Beast 32GB", "Módulo único de memória RAM para desktop com capacidade de 32GB 3200MT/s DDR4 CL16", 599.99f, 65));
        produtos.add(new Produto(" - Fone de Ouvido Audio Technica ATH-M20x", "Fone de ouvido profissional para monitoramento de áudio de estúdio e mixagem.", 469f, 120));
        produtos.add(new Produto(" - GPU Sapphire Pulse AMD RADEON RX 7900 XT", "Placa de vídeo de alto desempenho projetada para jogos, contando com 20GB de memória virtual GDDR6.", 5882.99f, 16));
        produtos.add(new Produto(" - Webcam Logitech C920s", "Webcam Full HD com microfone embutido e proteção de privacidade.", 429.99f, 300));
    }

    public static void exibirProdutos(formCarrinho Carrinho){
        formCatalogo formCatalogo = new formCatalogo();
        ArrayList<String> itens = new ArrayList<String>();
        formCatalogo.ErroLabel.setVisible(false);
        
        for (int i = 0; i < produtos.size(); i++){
            StringBuilder ProdutoEmLista = new StringBuilder();
            ProdutoEmLista.append(i + 1).append(" ").append(produtos.get(i).getNome()).append("\n").append("Preço: R$")
                    .append(produtos.get(i).getPreco());
            
            itens.add(ProdutoEmLista.toString());
        }
        
        formCatalogo.ListaProdutos.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if (!e.getValueIsAdjusting()){
                    if(produtoJaNoCarrinho(formCatalogo.ListaProdutos.getSelectedIndex(), Carrinho)){
                        formCatalogo.ErroLabel.setVisible(true);
                    }
                    else{
                        formCatalogo.dispose();
                        formExibirProduto formExibirProduto = new formExibirProduto();
                        formExibirProduto.setListaProdutos(formCatalogo.ListaProdutos.getSelectedIndex(), produtos);
                        formExibirProduto.setCarrinho(Carrinho);
                        formExibirProduto.exibirProduto();
                        formExibirProduto.setVisible(true);
                        formExibirProduto.setLocationRelativeTo(null);
                    }
                }
            }
        });
        formCatalogo.ListaProdutos.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return itens.size(); }
            public String getElementAt(int i) { return itens.get(i); }
        });
        formCatalogo.ListaProdutos.setCellRenderer(new RenderizadorListaMultilinha());
        
        formCatalogo.setLocationRelativeTo(null);
        formCatalogo.setVisible(true);
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
            java.util.logging.Logger.getLogger(formCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        construirListaProdutos();
        formCarrinho carrinho = new formCarrinho();
        exibirProdutos(carrinho);
    }

    public static boolean produtoJaNoCarrinho(int codigo, formCarrinho carrinho) {
        Produto produto = produtos.get(codigo);
        for (Item item : carrinho.getItensCarrinho()) {
            if (item.getNome().equals(produto.getNome())) {
                return true; // O produto já está no carrinho
            }
        }
        return false; // O produto não está no carrinho
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BemVindo;
    private javax.swing.JLabel ErroLabel;
    private javax.swing.JList<String> ListaProdutos;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JScrollPane PainelCatalogo;
    private javax.swing.JMenu Sair;
    private javax.swing.JMenu Sobre;
    private javax.swing.JButton VoltarBtn;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables
}
