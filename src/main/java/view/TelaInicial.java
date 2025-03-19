package view;

import model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelaInicial {
    List<Tarefa> tarefas = new ArrayList<>();
    Scanner leitor = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("------ AGENDA -------");
        System.out.println("Contexto: Lista de Tarefas");
        System.out.println("""
                1 - Adicionar Tarefa
                2 - Remover Tarefa
                3 - Editar Tarefa
                4 - Listar Tarefas""");
        String opcao = leitor.nextLine();

        switch (opcao) {
            case "1":
                adicionarTarefa();
                break;
            case "2":
                removerTarefa();
                break;
            case "3":
                editarTarefa();
                break;
            case "4":
                listarTarefas();
                break;

        }
    }

    public void adicionarTarefa() {
        System.out.print("Titulo: ");
        String titulo = leitor.nextLine();
        System.out.print("Descricao: ");
        String descricao = leitor.nextLine();
        System.out.print("Data: ");
        String data = leitor.nextLine();
        System.out.print("Hora: ");
        double hora = leitor.nextDouble();
        leitor.nextLine(); // Consome a quebra de linha deixada pelo nextDouble()

        int id = tarefas.size() + 1;
        Tarefa tarefa = new Tarefa(titulo, descricao, data, id, hora);
        tarefas.add(tarefa);

        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        System.out.println("Cheguei aqui");
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        }
        else {
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }

    public void removerTarefa() {}

    public void editarTarefa() {}
}
