import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private String caminhoImagem;

    public Produto(String nome, double preco, String descricao, String caminhoImagemOrigem) {
        this.id = GeradorID.getNextId();
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.caminhoImagem = copiarImagemParaProjeto(caminhoImagemOrigem, nome);
    }

    public Produto(String nome, double preco, String descricao) {
        this.id = GeradorID.getNextId();
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Produto(String nome, double preco) {
        this.id = GeradorID.getNextId();
        this.nome = nome;
        this.preco = preco;
        this.descricao = "Sem descrição";
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

    private String copiarImagemParaProjeto(String caminhoImagemOrigem, String nomeProduto) {
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

            return destino.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getCaminhoImagem() {
        return caminhoImagem;
    }
}
