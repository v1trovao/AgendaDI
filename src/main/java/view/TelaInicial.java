package view;

import model.Registro;
import model.Tarefa;
import model.TipoRegistro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelaInicial {
    List<Tarefa> tarefas = new ArrayList<>();
    List<Registro> registros = new ArrayList<>();

    Scanner leitor = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("------ AGENDA -------");

        System.out.println("""
                1 - Novo Registro
                2 - Excluir Registro
                3 - Editar Registro
                4 - Listar Agenda""");
        String opcao = leitor.nextLine();

        switch (opcao) {
            case "1":
                adicionarRegistro();
                break;
            case "2":
                removerTarefa();
                break;
            case "3":
                editarTarefa();
                break;
            case "4":
                listarRegistros();
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

    public void adicionarRegistro() {
        System.out.println("Digite o tipo (TAREFA, EVENTO ou REUNIÃO");
        TipoRegistro tipo = TipoRegistro.valueOf(leitor.nextLine().toUpperCase());
        System.out.print("Titulo: ");
        String titulo = leitor.nextLine();
        System.out.print("Descricao: ");
        String descricao = leitor.nextLine();
        System.out.print("Data: ");
        String data = leitor.nextLine();

        int id = tarefas.size() + 1;
        Registro novoRegistro = new Registro(id, titulo, data, descricao, tipo);
        registros.add(novoRegistro);
    }

    public void listarTarefas() {
        System.out.println("Cheguei aqui");
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }

    public void listarRegistros() {
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro cadastrado.");
        } else {
            for (Registro registro : registros) {
                System.out.println(registro);
            }
        }
    }

    public void removerTarefa() {
    }

    public void removerRegistro() {

    }

    public void editarTarefa() {
    }
}
