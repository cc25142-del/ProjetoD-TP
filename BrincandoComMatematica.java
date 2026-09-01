import java.util.Scanner;
import java.lang.System.out;

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