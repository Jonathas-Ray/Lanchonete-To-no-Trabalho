public class MenuDeTestes {
    public static void menuTeste() {
        boolean Continue = true;
        while (Continue) {
            switch (Input.Int("Escolha uma opção:\n" +
                    "1 - Adicionar Produto (Hamburgão)\n" +
                    "2 -Voltar ao menu principal\n")) {
                case 1:
                    Produto hamburgao = new Produto(
                            "Hamburgão",
                            19.99,
                            "Um hamburgão delicioso com queijo, alface e tomate."
                    );
                    MenuDeProdutos.produtos.add(hamburgao);
                    System.out.println("Hamburgão adicionado com sucesso!");
                    break;
                case 2:
                    Continue = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
