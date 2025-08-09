import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MenuDeProdutos {
    public List<Produto> produtos = new ArrayList<>();

    public void menuProduto() {
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Atualizar Produto");
        System.out.println("4 - Deletar Produto");
        System.out.println("5 - Sair");
        int opcao = Input.Int("Escolha uma opção: ");
        switch (opcao) {
            case 1:
                cadastrarProduto();
                break;
//            case 2:
//                listarProdutos();
//                break;
//            case 3:
//                atualizarProduto();
//                break;
//            case 4:
//                deletarProduto();
//                break;
//            case 5:
//                System.out.println("Saindo...");
//                System.exit(0);
//                break;
//            default:
//                System.out.println("Opção inválida, tente novamente.");
//                menu();
//                break;
        }
    }

    public void cadastrarProduto() {
        String nome = Input.String("Digite o nome do produto: ");
        double preco = Input.Double("Digite o preço do produto: ");
        String descricao = Input.String("Digite a descrição do produto: ");
        String caminhoImagem = Input.String("Digite o caminho da imagem do produto (opcional): ");

        Produto novoProduto;
        if (caminhoImagem.isBlank()) {
            novoProduto = new Produto(nome, preco, descricao);
        } else {
            if (!Files.exists(Paths.get(caminhoImagem))) {
                System.out.println("Caminho da imagem inválido. Produto será cadastrado sem imagem.");
                novoProduto = new Produto(nome, preco, descricao);
            } else {
                novoProduto = new Produto(nome, preco, descricao, caminhoImagem);
                if (novoProduto.getCaminhoImagem() == null) {
                    System.out.println("Erro ao copiar a imagem. Produto cadastrado sem imagem.");
                }
            }
        }

        produtos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

}
