import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private ArrayList<String> caminhoImagens = new ArrayList<>();

    public Produto(String nome, double preco, String descricao, String caminhoImagemOrigem) {
        this.id = GeradorID.getNextId();
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        adicionarImagemAoProduto(caminhoImagemOrigem, nome);
    }

    public Produto(String nome, double preco, String descricao) {
        this.id = GeradorID.getNextId();
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    protected void adicionarImagemAoProduto(String caminhoImagemOrigem, String nomeProduto) {
        try {
            Path pastaDestino = Paths.get("src", "imagens");
            if (!Files.exists(pastaDestino)) {
                Files.createDirectories(pastaDestino);
            }

            // Pega extensão original
            String extensao = "";
            int i = caminhoImagemOrigem.lastIndexOf('.');
            if (i > 0 && i < caminhoImagemOrigem.length() - 1) {
                extensao = caminhoImagemOrigem.substring(i).toLowerCase();
            } else {
                extensao = ".img"; // extensão padrão
            }

            // Limpa o nome para usar no arquivo
            String nomeLimpo = nomeProduto.trim().replaceAll("[^a-zA-Z0-9_-]", "_");

            Path destino = pastaDestino.resolve(nomeLimpo + extensao);

            // Evita sobrescrever arquivo existente, adicionando sufixo (_1, _2, ...)
            int contador = 1;
            while (Files.exists(destino)) {
                String novoNome = nomeLimpo + "_" + contador + extensao;
                destino = pastaDestino.resolve(novoNome);
                contador++;
            }

            // Copia o arquivo
            Files.copy(Paths.get(caminhoImagemOrigem), destino);

            // Adiciona caminho da imagem à lista
            this.caminhoImagens.add(destino.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCaminhoImagens(String caminhoImagemOrigem) {
        adicionarImagemAoProduto(caminhoImagemOrigem, this.nome);
    }

    public boolean removerImagem(int indice) {
        if (indice >= 0 && indice < caminhoImagens.size()) {
            try {
                // Apaga o arquivo fisicamente
                Path caminhoArquivo = Paths.get(caminhoImagens.get(indice));
                if (Files.exists(caminhoArquivo)) {
                    Files.delete(caminhoArquivo);
                }

                // Remove da lista
                caminhoImagens.remove(indice);

                System.out.println("Imagem removida com sucesso!");
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro ao remover a imagem.");
                return false;
            }
        } else {
            System.out.println("Não foi encontrada imagem no índice especificado.");
            return false;
        }
    }

    public ArrayList<String> getCaminhoImagens() {
        return caminhoImagens;
    }

    @Override
    public String toString() {
        return "{ " + id + "   ------   " + nome + "   ------   " + preco + " }\n";
    }

    public String getCompleteDescription() {
        return "Nome: " + nome + "\n" +
                "Preço: " + preco + "\n" +
                "Descrição: " + descricao + "\n" +
                "Imagens: " + caminhoImagens.toString();
    }
}
