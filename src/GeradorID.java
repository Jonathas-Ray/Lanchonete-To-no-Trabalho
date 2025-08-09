import java.util.concurrent.atomic.AtomicInteger;

public final class GeradorID {
    private static final AtomicInteger CONTADOR = new AtomicInteger(0);

    private GeradorID() {
        // Para impedir instanciação
    }

    /** Gera e retorna o próximo ID único (thread-safe). */
    public static int getNextId() {
        return CONTADOR.incrementAndGet();
    }
}
