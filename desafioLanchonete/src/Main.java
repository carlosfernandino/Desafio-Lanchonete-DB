import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Float> produtos = new HashMap<>();
        produtos.put("cafe", 3.0f);
        produtos.put("suco", 6.20f);
        produtos.put("sanduiche", 6.50f);
        produtos.put("salgado", 7.25f);
        produtos.put("combo1", 9.50f);
        produtos.put("combo2", 7.50f);

        float carrinho = 0.0f;

        while(true){

            System.out.print("Digite o nome do produto (ou 'sair' para finalizar a compra): ");
            String produtoEscolhido = scanner.nextLine();

            if (produtoEscolhido.equalsIgnoreCase("sair")){
                break;
            }

            if (produtos.containsKey(produtoEscolhido)){

                float precoProduto = produtos.get(produtoEscolhido);
                String chantily;

                if (produtoEscolhido.equalsIgnoreCase("cafe")) {

                    do {
                        System.out.println("Adicionar chantily? (s/n)");
                        chantily = scanner.nextLine();

                        if (chantily.equalsIgnoreCase("s")) {
                            precoProduto += 1.50f;
                        }
                    }while(chantily.equalsIgnoreCase("s"));
                }

                if (produtoEscolhido.equalsIgnoreCase("sanduiche")) {
                    String queijo;

                    do {
                        System.out.println("Adicionar queijo? (s/n)");
                        queijo = scanner.nextLine();

                        if (queijo.equalsIgnoreCase("s")) {
                            precoProduto += 2.00f;
                        }

                    }while(queijo.equalsIgnoreCase("s"));
                }

                carrinho += precoProduto;
                System.out.println("Produto adicionado ao carrinho: " + produtoEscolhido + " (Preço: " + precoProduto + " reais)");

            }else{
                System.out.println("Item inválido!");
            }

        }

        if (carrinho == 0.0f) {

            System.out.println("Quantidade inválida. Não há itens no carrinho de compra!");

        } else {
            System.out.println("Valor total do carrinho: " + carrinho + " reais");

            System.out.println("\nSelecione o método de pagamento: ");
            System.out.println("1- Dinheiro");
            System.out.println("2- Débito");
            System.out.println("3- Crédito");

            String formaPagamento = scanner.nextLine();
            float valorTotalCompra = 0.00f;
            String valorFormatado = String.format("%.2f", valorTotalCompra);

            switch (formaPagamento){

                case "1":
                    valorTotalCompra = (float) (carrinho * 0.95);
                    valorFormatado = String.format("%.2f", valorTotalCompra);
                    System.out.println("Valor final da compra: R$"+valorFormatado);
                    break;

                case "2":
                    valorTotalCompra = carrinho;
                    valorFormatado = String.format("%.2f", valorTotalCompra);
                    System.out.println("Valor final da compra: R$"+valorFormatado);
                    break;

                case "3":
                    valorTotalCompra = (float) (carrinho * 1.03);
                    valorFormatado = String.format("%.2f", valorTotalCompra);
                    System.out.println("Valor final da compra: R$"+valorFormatado);
                    break;

                default:
                    System.out.println("Forma de pagamento inválida!");
            }
        }
    }
}