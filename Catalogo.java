package Loja;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

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

public class Catalogo {

    //Criação da lista de produtos
    static List<Produto> produtos = new ArrayList<>();
    
    //Método para preencher a lista de produtos
    public static void ConstruirListaProdutos(){
        Produto mouseRazer = new Produto();
        mouseRazer.setNome("Mouse Razer Deathadder Essential");
        mouseRazer.setDescricao("Mouse ergonômico projetado para conforto, com ajuste de DPI e botões auxiliares.");
        mouseRazer.setPreco(194f);
        mouseRazer.setEstoque(1);
        produtos.add(mouseRazer);
        
        Produto cpuIntel = new Produto();
        cpuIntel.setNome("Processador Intel i7-12700K");
        cpuIntel.setDescricao("Processador de alto desempenho com soquete LGA 1700, com 12 núcleos, 20 threads, vídeo integrado e clock de 3.6GHz");
        cpuIntel.setPreco(1699.99f);
        cpuIntel.setEstoque(30);
        produtos.add(cpuIntel);
        
        Produto ramKingston = new Produto();
        ramKingston.setNome("Memória RAM Kingston FURY Beast 32GB");
        ramKingston.setDescricao("Módulo único de memória RAM para desktop com capacidade de 32GB 3200MT/s DDR4 CL16");
        ramKingston.setPreco(599.99f);
        ramKingston.setEstoque(65);
        produtos.add(ramKingston);
        
        Produto foneAT = new Produto();
        foneAT.setNome("Fone de Ouvido Audio Technica ATH-M20x");
        foneAT.setDescricao("Fone de ouvido profissional para monitoramento de áudio de estúdio e mixagem.");
        foneAT.setPreco(469f);
        foneAT.setEstoque(120);
        produtos.add(foneAT);
        
        Produto gpuAMD = new Produto();
        gpuAMD.setNome("GPU Sapphire Pulse AMD RADEON RX 7900 XT");
        gpuAMD.setDescricao("Placa de vídeo de alto desempenho projetada para jogos, contando com 20GB de memória virtual GDDR6.");
        gpuAMD.setPreco(5882.99f);
        gpuAMD.setEstoque(16);
        produtos.add(gpuAMD);
        
        Produto camLogi = new Produto();
        camLogi.setNome("Webcam Logitech C920s");
        camLogi.setDescricao("Webcam Full HD com microfone embutido e proteção de privacidade.");
        camLogi.setPreco(429.99f);
        camLogi.setEstoque(300);
        produtos.add(camLogi);
    }
    
    //Método para listar os produtos da loja, e pedir uma seleção do usuário.
    public static void ExibirProdutos(){
        //Cria um StringBuilder com todos os produtos na lista de Produtos, seus nomes e preços
        StringBuilder listaProdutosStrB = new StringBuilder();
        for(int i = 0; i < produtos.size(); i++){
            listaProdutosStrB.append(i + " " + produtos.get(i).getNome() + "\n");
            listaProdutosStrB.append("Preço: R$" + produtos.get(i).getPreco() + "\n\n");
        }
        
        int codigo;
        String op;
        do{
            op = JOptionPane.showInputDialog(null, listaProdutosStrB.toString() + "\nDigite o código do produto desejado.", 
                    "Selecione", JOptionPane.INFORMATION_MESSAGE);
            
            if(op != null && !"".equals(op)){
                codigo = Integer.parseInt(op);
                try{
                    //Executa a função ExibirProduto e passa o item escolhido pelo usuário
                    ExibirProduto(codigo);
                }catch(IndexOutOfBoundsException e){
                    //Ocorre quando o usuário digita um código de produto inválido
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if("".equals(op)){
                //Ocorre quando o usuário não digita nada e aperta enter
                JOptionPane.showMessageDialog(null, "Selecione uma opção.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }while("".equals(op));
    }
    
    //Método chamado quando o usuário seleciona um item, e exibe detalhes sobre ele.
    public static void ExibirProduto(int codigo){
        StringBuilder exibicaoItemDesejado = new StringBuilder();

        exibicaoItemDesejado.append("Nome: " + produtos.get(codigo).getNome() + "\n");
        exibicaoItemDesejado.append("Descrição: " + produtos.get(codigo).getDescricao() + "\n");
        exibicaoItemDesejado.append("Preço: R$" + produtos.get(codigo).getPreco() + "\n");
        exibicaoItemDesejado.append("Quantidade: " + produtos.get(codigo).getEstoque() + "\n");

        int op = JOptionPane.showConfirmDialog(null, exibicaoItemDesejado + "\nDeseja adicionar ao carrinho?", 
            "Adicionar ao carrinho?", JOptionPane.YES_NO_OPTION);

        switch(op){
            //Usuário apertou "Sim":
            case 0:
                if(produtos.get(codigo).getEstoque() <= 0){
                    JOptionPane.showMessageDialog(null, "Produto indisponível.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    produtos.get(codigo).setEstoque(produtos.get(codigo).getEstoque() - 1);
                    //Adicionar ao array do carrinho
                    
                    op = JOptionPane.showConfirmDialog(null, "Produto adicionado ao carrinho.\nDeseja ir ao carrinho?",
                            "Produto adicionado", JOptionPane.YES_NO_OPTION);
                    
                    switch(op){
                        //Usuário apertou "Sim":
                        case 0:
                            //Ir para a interface do carrinho
                            
                        //Usuário apertou "Não":
                        case 1:
                            ExibirProdutos();
                    }
                }
            //Usuário apertou "Não":
            case 1:
                ExibirProdutos();
        }
    }
    
    public static void main(String[] args) {
        
        ConstruirListaProdutos();
        
        ExibirProdutos();
    }
    
}
