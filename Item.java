package Loja;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Produto{
    String nome;
    String descricao;
    float preco;
    int estoque;
    
    public Produto(){
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setPreco(float preco){
        this.preco = preco;
    }
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }
    public String getNome(){
        return nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public float getPreco(){
        return preco;
    }
    public int getEstoque(){
        return estoque;
    }
}

public class Item {

    static List<Produto> produtos = new ArrayList<>();
    
    public static void ConstruirListaProdutos(){
        //Produtos placeholder
        Produto mouse = new Produto();
        mouse.setNome("Mouse Razer");
        mouse.setDescricao("É um mouse garai");
        mouse.setPreco(10.5f);
        mouse.setEstoque(1);
        produtos.add(mouse);
        
        Produto cpu = new Produto();
        cpu.setNome("Processador intel");
        cpu.setDescricao("è uma cpu da intel garai");
        cpu.setPreco(1950f);
        cpu.setEstoque(30);
        produtos.add(cpu);
        
        Produto ram = new Produto();
        ram.setNome("RAM 32GB");
        ram.setDescricao("é ram pragarai");
        ram.setPreco(439.99f);
        ram.setEstoque(60);
        produtos.add(ram);
    }
    
    public static void ExibirProdutos(){
        StringBuilder listaProdutosStrB = new StringBuilder();
        
        for(int i = 0; i < produtos.size(); i++){
            
            listaProdutosStrB.append(i + " " + produtos.get(i).getNome() + "\n");
            listaProdutosStrB.append("Preço: R$" + produtos.get(i).getPreco() + "\n\n");
        }
        
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(listaProdutosStrB.toString() + "\nDigite o código do produto desejado."));
        
        ExibirItem(codigo);
    }
    
    public static void ExibirItem(int codigo){
        do{
            StringBuilder exibicaoItemDesejado = new StringBuilder();
        
            exibicaoItemDesejado.append("Nome: " + produtos.get(codigo).getNome() + "\n");
            exibicaoItemDesejado.append("Descrição: " + produtos.get(codigo).getDescricao() + "\n");
            exibicaoItemDesejado.append("Preço: R$" + produtos.get(codigo).getPreco() + "\n");
            exibicaoItemDesejado.append("Quantidade: " + produtos.get(codigo).getEstoque() + "\n");
        
            String op = JOptionPane.showInputDialog(exibicaoItemDesejado + "\nDeseja adicionar ao carrinho? S/N");

            if(op.equalsIgnoreCase("s")){
                if(produtos.get(codigo).getEstoque() <= 0){
                    JOptionPane.showMessageDialog(null, "Produto indisponível.");
                }
                else{
                    produtos.get(codigo).setEstoque(produtos.get(codigo).getEstoque() - 1);
                    //Adicionar ao array do carrinho
                    do{
                        op = JOptionPane.showInputDialog("Produto adicionado ao carrinho.\nDeseja ir ao carrinho? S/N");
                        if(op.equalsIgnoreCase("s")){
                           //Ir para a interface do carrinho
                        }
                        else if(op.equalsIgnoreCase("n")){
                            ExibirProdutos();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                        }
                    }while(true);
                }
            }
            else if(op.equalsIgnoreCase("n")){
                ExibirProdutos();
            }
            else{
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }while(true);
    }
    
    public static void main(String[] args) {
        
        ConstruirListaProdutos();
        
        ExibirProdutos();
    }
    
}
