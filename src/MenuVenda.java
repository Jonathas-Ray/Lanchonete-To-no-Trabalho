import java.util.ArrayList;
import java.util.List;

public class MenuVenda {
    protected static List<Venda> vendas = new ArrayList<>();

    public static void menuVenda() {
        int opcao = 0;
        Venda vendaAtual = new Venda();
        while (opcao != 5) {
            System.out.println("Menu de Vendas:");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Remover Produto");
            System.out.println("3 - Exibir Venda Atual");
            System.out.println("4 - Finalizar Venda");
            System.out.println("5 - Sair sem finalizar");

            opcao = Input.Int("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    MenuDeProdutos.listarProdutos();
                    vendaAtual.adicionarProduto(vendaAtual);
                    break;
                case 2:
                    listarProdutosVenda(vendaAtual);
                    vendaAtual.removerProduto(vendaAtual);
                    break;
                case 3:
                    System.out.println("Venda atual: " + vendaAtual.getId());
                    System.out.println("Data da venda: " + vendaAtual.getDataVenda());
                    System.out.println("Valor total: R$ " + vendaAtual.getValorTotal());
                    listarProdutosVenda(vendaAtual);
                    break;
                case 4:
                    vendas.add(vendaAtual);
                    System.out.println("Venda finalizada com sucesso! Valor total: R$ " + vendaAtual.getValorTotal());
                    opcao = 5; // Sai do loop após finalizar a venda
                case 5:
                    System.out.println("Saindo do menu de vendas.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void listarProdutosVenda(Venda venda) {
        System.out.println("Produtos na venda:");
        for (Produto produto : venda.getListaDeItens()) {
            System.out.println(produto);
        }
    }

    public static void listarVendas(){
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("Vendas registradas:");
            for (Venda venda : vendas) {
                System.out.println("ID: " + venda.getId() + " | Data: " + venda.getDataVenda() + " | Valor Total: R$ " + venda.getValorTotal());
            }
            if(Input.Int("Deseja ver os detalhes de uma venda específica? (1 - Sim, 2 - Não): ") == 1) {
                int idVenda = Input.Int("Digite o ID da venda: ");
                Venda vendaEspecifica = vendas.stream().filter(v -> v.getId() == idVenda).findFirst().orElse(null);
                if (vendaEspecifica != null) {
                    System.out.println("Detalhes da Venda ID: " + vendaEspecifica.getId());
                    System.out.println("Data da Venda: " + vendaEspecifica.getDataVenda());
                    System.out.println("Valor Total: R$ " + vendaEspecifica.getValorTotal());
                    listarProdutosVenda(vendaEspecifica);
                } else {
                    System.out.println("Venda não encontrada.");
                }
            }
        }
    }
}
