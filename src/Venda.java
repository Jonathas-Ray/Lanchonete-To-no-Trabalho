import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int id;
    private LocalDateTime dataHora;
    private double valorTotal;
    private List<Produto> listaDeItens;

    public Venda() {
        this.id = GeradorID.getNextIdVenda();
        this.dataHora = LocalDateTime.now();
        listaDeItens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataVenda() {
        return dataHora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<Produto> getListaDeItens() {
        return listaDeItens;
    }

    //Rever Adicionar e Remover Produto, produto deve ser encontrado pelo ID
    public void adicionarProduto(int id, int quantidade) {
        Produto produto = MenuDeProdutos.getProdutoById(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        } else {
            for (int i = 0; i < quantidade; i++) {
                listaDeItens.add(produto);
                valorTotal += produto.getPreco();
            }
        }
    }

    public void removerProduto(int id, int quantidade) {
        Produto produto = MenuDeProdutos.getProdutoById(id);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        } else {
            int removidos = 0;
            for (int i = 0; i < listaDeItens.size() && removidos < quantidade; i++) {
                if (listaDeItens.get(i).getId() == id) {
                    listaDeItens.remove(i);
                    valorTotal -= produto.getPreco();
                    removidos++;
                    i--; // Ajusta o índice após a remoção
                }
            }
            if (removidos < quantidade) {
                System.out.println("Apenas " + removidos + " itens foram removidos, pois não havia mais itens do produto na venda.");
            }
        }
    }
}
