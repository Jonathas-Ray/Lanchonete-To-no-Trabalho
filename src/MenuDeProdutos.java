import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MenuDeProdutos {
    public static List<Produto> produtos = new ArrayList<>();

    public static void menuProduto() {
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
            case 2:
                atualizarProduto();
                break;
            case 3:
                deletarProduto();
                break;
            case 4:
                listarProdutos();
                break;
            case 5:
                limparConsole();
                menuProduto();
                break;
            case 6:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                menuProduto();
                break;
        }
    }

    public static void cadastrarProduto() {
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
                // Aqui você usa o construtor que já trata a imagem
                novoProduto = new Produto(nome, preco, descricao, caminhoImagem);
            }
        }

        produtos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso:");
        System.out.println(novoProduto); //Serve para verificar se o produto foi adicionado corretamente
        menuProduto();
    }

    public static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de Produtos:\n(ID -- Nome -- Preço)\n");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
        int escolha = Input.Int("Digite um indice para ver a descrição completa de um produto ou -1 para voltar ao menu: ");
        if (escolha == -1) {
            menuProduto();
        } else if (escolha >= 0 && escolha < produtos.size()) {
            Produto produtoEscolhido = produtos.get(escolha);
            System.out.println(produtoEscolhido.getCompleteDescription());
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void atualizarProduto() {
        boolean continuarAtualizandoProdutos = true;

        while (continuarAtualizandoProdutos) {
            limparConsole();
            listarProdutos();
            int indice = Input.Int(
                    "Digite o índice do produto que deseja atualizar (ou -1 para voltar ao menu): "
            );

            if (indice == -1) {
                continuarAtualizandoProdutos = false; // sai do laço externo
                break;
            }

            if (indice >= 0 && indice < produtos.size()) {
                Produto produto = produtos.get(indice);

                boolean continuarEditandoAtributos = true;
                while (continuarEditandoAtributos) {

                    switch (Input.Int(
                            "\nO que deseja alterar?\n" +
                                    "1 - Nome\n" +
                                    "2 - Preço\n" +
                                    "3 - Descrição\n" +
                                    "4 - Adicionar Imagem\n" +
                                    "5 - Remover Imagem\n" +
                                    "6 - Sair da edição deste produto\n" +
                                    "Escolha uma opção: "
                    )) {
                        case 1:
                            String novoNome = Input.String(
                                    "Digite o novo nome (ou deixe em branco para manter '" + produto.getNome() + "'): "
                            );
                            if (!novoNome.isBlank()) {
                                produto.setNome(novoNome);
                                System.out.println("Nome atualizado com sucesso!");
                            }
                            break;

                        case 2:
                            double novoPreco = Input.Double(
                                    "Digite o novo preço (ou -1 para manter " + produto.getPreco() + "): "
                            );
                            if (novoPreco >= 0) {
                                produto.setPreco(novoPreco);
                                System.out.println("Preço atualizado com sucesso!");
                            }
                            break;

                        case 3:
                            String novaDescricao = Input.String(
                                    "Digite a nova descrição (ou deixe em branco para manter '" + produto.getDescricao() + "'): "
                            );
                            if (!novaDescricao.isBlank()) {
                                produto.setDescricao(novaDescricao);
                                System.out.println("Descrição atualizada com sucesso!");
                            }
                            break;

                        case 4:
                            String caminhoImagem = Input.String("Digite o caminho da nova imagem do produto: ");
                            if (!Files.exists(Paths.get(caminhoImagem))) {
                                System.out.println("Caminho da imagem inválido. Tente novamente.");
                            } else {
                                produto.addCaminhoImagens(caminhoImagem);
                                System.out.println("Imagem adicionada com sucesso!");
                            }
                            break;

                        case 5:
                            if (produto.getCaminhoImagens().isEmpty()) {
                                System.out.println("Nenhuma imagem para remover.");
                            } else {
                                System.out.println("Imagens atuais:");
                                List<String> imagens = produto.getCaminhoImagens();
                                for (int i = 0; i < imagens.size(); i++) {
                                    System.out.println(i + ": " + imagens.get(i));
                                }
                                int indiceRemover = Input.Int("Digite o índice da imagem que deseja remover (ou -1 para cancelar): ");
                                if (indiceRemover == -1) {
                                    System.out.println("Remoção de imagem cancelada.");
                                } else if (produto.removerImagem(indiceRemover)) {
                                    System.out.println("Imagem removida com sucesso!");
                                } else {
                                    System.out.println("Índice inválido. Nenhuma imagem foi removida.");
                                }
                            }
                            break;

                        case 6:
                            continuarEditandoAtributos = false; // sai do laço interno
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            } else {
                System.out.println("Índice inválido.");
            }
        }
        menuProduto();
    }

    public static void deletarProduto() {
        listarProdutos();
        int indice = Input.Int("Digite o índice do produto que deseja deletar (ou -1 para voltar ao menu): ");
        if (indice == -1) {
            menuProduto();
        } else if (indice >= 0 && indice < produtos.size()) {
            Produto produtoRemover = produtos.get(indice);
            if (!produtoRemover.getCaminhoImagens().isEmpty()) {
                for (int i = 0; i < produtoRemover.getCaminhoImagens().size(); i++) {
                    produtoRemover.removerImagem(i);
                }
            }
            produtos.remove(indice);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
        menuProduto();
    }

    public static void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Produto getProdutoById(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }

}
