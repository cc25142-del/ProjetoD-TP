import java.util.Scanner;

public class BrincandoComMatematica {

    static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        seletorDeOpcoes();
        System.out.println("\nPrograma encerrado.");
    }
    public static void seletorDeOpcoes() {
        int opcao;
        do {
            System.out.println("\n===== Brincando com a Matemática =====");
            System.out.println("1 - Série Matemática (Aproximação do Seno)");
            System.out.println("2 - Cálculo de MMC (Mínimo Múltiplo Comum)");
            System.out.println("3 - Classificação de Números (Perfeito, Abundante ou Insuficiente)");
            System.out.println("4 - Verificação de Números Primos em um intervalo");
            System.out.println("5 - Processar lista de valores digitados");
            System.out.println("0 - Terminar programa");
            opcao = lerInteiro("\nSua opção: ");

            switch (opcao) {
                case 1: calcularSenoPorSerie();        break;
                case 2: calcularMmc();                  break;
                case 3: classificarNumerosNoIntervalo();break;
                case 4: verificarPrimosNoIntervalo();   break;
                case 5: processarListaDeValores();      break;
                case 0:
                        break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
private static int lerInteiro(String mensagem) {
        int valor = 0;
        boolean valido = false;
        do {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(leitor.nextLine().trim());
                valido = true;
            } catch (NumberFormatException erroDeConversao) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
            }
        } while (!valido);
        return valor;
    }

    private static int lerInteiroPositivo(String mensagem) {
        int valor;
        do {
            valor = lerInteiro(mensagem);
            if (valor <= 0)
                System.out.println("O valor deve ser positivo!");
        } while (valor <= 0);
        return valor;
    }

    private static double lerDouble(String mensagem) {
        double valor = 0;
        boolean valido = false;
        do {
            System.out.print(mensagem);
            try {
                valor = Double.parseDouble(leitor.nextLine().trim().replace(",", "."));
                valido = true;
            } catch (NumberFormatException erroDeConversao) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        } while (!valido);
        return valor;
    }