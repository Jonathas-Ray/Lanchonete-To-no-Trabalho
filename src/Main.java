//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Seja bem vindo ao sistema de vendas!");
        while (true) {
            switch (Input.Int("Escolha uma opção:\n" +
                    "1 - Menu de Produtos\n" +
                    "2 - Menu de Vendas\n" +
                    "3 - Listar Vendas\n" +
                    "4 - Menu do Dev.\n" +
                    "5 - Sair do sistema\n")) {
                case 1:
                    MenuDeProdutos.menuProduto();
                    break;
                case 2:
                    MenuVenda.menuVenda();
                    break;
                case 3:
                    MenuVenda.listarVendas();
                    break;
                case 4:
                    MenuDeTestes.menuTeste();
                    System.out.println("Menu de Testes ainda não implementado.");
                    break;
                case 5:
                    System.out.println("Saindo do sistema de vendas.");
                    System.out.println("Obrigado por usar o sistema de vendas!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}