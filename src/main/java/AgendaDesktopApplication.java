import model.Tarefa;
import view.TelaInicial;

import java.util.Scanner;

public class AgendaDesktopApplication {
    public Tarefa[] tarefas;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner leitura = new Scanner(System.in);
        TelaInicial tela = new TelaInicial();
        boolean continuar = true;

        while (continuar) {
            tela.exibirMenu();

            // Mudar o teor da mensagem, adequada no contexto da agenda
            System.out.println("\nDeseja realizar outra consulta? ('SAIR' para encerrar)");
            String opcao = leitura.nextLine();

            if (opcao.equalsIgnoreCase("SAIR")) {
                System.out.println("Encerrando o programa...");
                continuar = false;
            }
        }
    }
}
