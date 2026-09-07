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

    public static void calcularSenoPorSerie() {
        System.out.println("\nSérie Matemática (Aproximação do Seno)\n");
 
        int grausDoAngulo = lerInteiro("Ângulo em graus: ");
        int numeroDeTermos = lerInteiroPositivo("Número de termos da série: ");
 
        double anguloEmRadianos = grausDoAngulo * Math.PI / 180.0;
        double potenciaAcumulada = anguloEmRadianos;   
        double fatorialAcumulado = 1;                  
        double somatoria = 0;
        int sinal = 1;
 
        for (int n = 0; n < numeroDeTermos; n++) {
            somatoria += sinal * (potenciaAcumulada / fatorialAcumulado);
 
            int expoenteAtual = 2 * n + 1;              
            potenciaAcumulada *= anguloEmRadianos * anguloEmRadianos; 
            fatorialAcumulado *= (expoenteAtual + 1) * (expoenteAtual + 2); 
            sinal *= -1;
        }
 
        System.out.printf("\nAproximação de sen(%d°) com %d termos: %.6f%n",
                grausDoAngulo, numeroDeTermos, somatoria);
        System.out.printf("Valor real (Math.sin): %.6f%n", Math.sin(anguloEmRadianos));
    }
 

    // 2. Cálculo de MMC (sem usar MDC)

    public static void calcularMmc() {
        System.out.println("\nCálculo de MMC (Mínimo Múltiplo Comum)\n");
 
        int primeiroNumero  = lerInteiroPositivo("Digite o primeiro número : ");
        int segundoNumero   = lerInteiroPositivo("Digite o segundo número  : ");
 
        int multiplo = Math.max(primeiroNumero, segundoNumero);
        boolean achouMmc = false;
 
        while (!achouMmc) {
            if (multiplo % primeiroNumero == 0 && multiplo % segundoNumero == 0)
                achouMmc = true;
            else
                multiplo++;
        }
 
        System.out.println("\nO MMC entre " + primeiroNumero + " e " + segundoNumero
                + " é: " + multiplo);
    }
 

    // 3. Classificação de Números (Perfeito, Abundante, Deficiente)

    public static void classificarNumerosNoIntervalo() {
        System.out.println("\nClassificação de Números (Perfeito, Abundante ou Insuficiente)\n");
 
        int numeroInicial = lerInteiroPositivo("Digite o início do intervalo : ");
        int numeroFinal;
        do {
            numeroFinal = lerInteiroPositivo("Digite o fim do intervalo    : ");
            if (numeroFinal < numeroInicial)
                System.out.println("O fim do intervalo deve ser maior ou igual ao início!");
        } while (numeroFinal < numeroInicial);
 
        int quantosPerfeitos = 0, quantosAbundantes = 0, quantosDeficientes = 0;
 
        for (int numeroAtual = numeroInicial; numeroAtual <= numeroFinal; numeroAtual++) {
            int somaDosDivisores = 0;
 
            for (int divisor = 1; divisor < numeroAtual; divisor++)
                if (numeroAtual % divisor == 0)
                    somaDosDivisores += divisor;
 
            String classificacao;
            if (somaDosDivisores == numeroAtual) {
                classificacao = "Perfeito";
                quantosPerfeitos++;
            } else if (somaDosDivisores > numeroAtual) {
                classificacao = "Abundante";
                quantosAbundantes++;
            } else {
                classificacao = "Deficiente/Insuficiente";
                quantosDeficientes++;
            }
 
            System.out.println(numeroAtual + " -> " + classificacao
                    + " (soma dos divisores = " + somaDosDivisores + ")");
        }
 
        System.out.println("\nTotal de perfeitos    : " + quantosPerfeitos);
        System.out.println("Total de abundantes   : " + quantosAbundantes);
        System.out.println("Total de deficientes  : " + quantosDeficientes);
    }
 

    // 4.Verificação de Números Primos em um intervalo

    public static void verificarPrimosNoIntervalo() {
        System.out.println("\nVerificação de Números Primos em um intervalo\n");
 
        int numeroInicial = lerInteiroPositivo("Digite o início do intervalo : ");
        int numeroFinal;
        do {
            numeroFinal = lerInteiroPositivo("Digite o fim do intervalo    : ");
            if (numeroFinal < numeroInicial)
                System.out.println("O fim do intervalo deve ser maior ou igual ao início!");
        } while (numeroFinal < numeroInicial);
 
        System.out.println("\nNúmeros primos encontrados:");
        int quantosPrimos = 0;
 
        for (int numeroAtual = numeroInicial; numeroAtual <= numeroFinal; numeroAtual++) {
            if (numeroAtual < 2)
                continue; // 0 e 1 não são primos
 
            boolean ehPrimo = true;
            for (int divisor = 2; divisor <= numeroAtual / 2 && ehPrimo; divisor++)
                if (numeroAtual % divisor == 0)
                    ehPrimo = false;
 
            if (ehPrimo) {
                System.out.print(numeroAtual + "  ");
                quantosPrimos++;
            }
        }
 
        if (quantosPrimos == 0)
            System.out.println("(nenhum número primo encontrado no intervalo)");
        else
            System.out.println("\n\nTotal de primos encontrados: " + quantosPrimos);
    }
 

    // 5. Processar lista de valores digitados


    public static void processarListaDeValores() {
        System.out.println("\nProcessar lista de valores digitados\n");
        System.out.println("Digite os valores reais um a um. Digite 0 (zero) para encerrar.\n");
 
        double somaDosValores = 0;
        double produtorioDosValores = 1;
        double somaDosInversos = 0;      // para média harmônica
        double maiorValor = -Double.MAX_VALUE;
        double menorValor = Double.MAX_VALUE;
        int quantosValores = 0;
        boolean existeValorNaoPositivo = false; 
 
        double valorDigitado;
        do {
            valorDigitado = lerDouble("Valor (0 para parar): ");
 
            if (valorDigitado != 0) {
                somaDosValores += valorDigitado;
                produtorioDosValores *= valorDigitado;
                somaDosInversos += 1.0 / valorDigitado;
 
                if (valorDigitado > maiorValor) maiorValor = valorDigitado;
                if (valorDigitado < menorValor) menorValor = valorDigitado;
                if (valorDigitado <= 0) existeValorNaoPositivo = true;
 
                quantosValores++;
            }
        } while (valorDigitado != 0);
 
        if (quantosValores == 0) {
            System.out.println("\nNenhum valor foi digitado.");
            return;
        }
 
        double mediaAritmetica = somaDosValores / quantosValores;
        double mediaHarmonica  = quantosValores / somaDosInversos;
 
        System.out.println("\n--- Resultados ---");
        System.out.println("Produtório           : " + produtorioDosValores);
        System.out.println("Soma                 : " + somaDosValores);
        System.out.printf ("Média aritmética     : %.4f%n", mediaAritmetica);
        System.out.println("Maior valor          : " + maiorValor);
        System.out.println("Menor valor          : " + menorValor);
        System.out.printf ("Média harmônica      : %.4f%n", mediaHarmonica);
 
        if (existeValorNaoPositivo) {
            System.out.println("Média geométrica     : não calculada (há valor <= 0 na lista)");
        } else {
            double mediaGeometrica = Math.pow(produtorioDosValores, 1.0 / quantosValores);
            System.out.printf("Média geométrica     : %.4f%n", mediaGeometrica);
        }
    }

 