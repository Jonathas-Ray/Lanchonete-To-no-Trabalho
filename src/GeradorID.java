import java.util.concurrent.atomic.AtomicInteger;

public final class GeradorID {
    private static final AtomicInteger CONTADOR_Produto = new AtomicInteger(0);
    private static final AtomicInteger CONTADOR_Venda = new AtomicInteger(0);

    private GeradorID() {
        // Para impedir instanciação
    }

    /** Gera e retorna o próximo ID único (thread-safe). */
    public static int getNextIdProduto() {
        return CONTADOR_Produto.incrementAndGet();
    }

    public static int getNextIdVenda() {
        return CONTADOR_Venda.incrementAndGet();
    }
}
