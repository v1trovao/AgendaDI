package view;

// Camada view interagindo diretamente com o model?
import model.Registro;
import model.Tarefa;
import model.TipoRegistro;

// Utilitarios de leitura e manipulacao de arrays na view msm?
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelaInicial {

    // Separar a persistência de dados em local separado
    List<Registro> registros = new ArrayList<>();

    Scanner leitor = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("------ AGENDA -------");

        // Deixar mais claro para o usuário oq ele pode fazer na tela
        // Como finalizar o programa?
        System.out.println("""
                1 - Novo Registro
                2 - Excluir Registro
                3 - Editar Registro
                4 - Listar Agenda""");
        String opcao = leitor.nextLine();

        // Se possivel, tentar separar cada caso em uma view específica (ex.: JanelaAdicionarRegistro)
        switch (opcao) {
            case "1":
                adicionarRegistro();
                break;
            case "2":
                removerRegistro();
                break;
            case "3":
                editarRegistro();
                break;
            case "4":
                listarRegistros();
                break;

        }
    }

    public void adicionarRegistro() {

        // Tratamento de excecção para entradas diferentes
        // É melhor o usuário escrever o tipo ou selecionar por numero?
        // 1 - Tarefa, 2 - Evento e 3 - Reunião
        System.out.println("Digite o tipo (TAREFA, EVENTO ou REUNIÃO");
        TipoRegistro tipo = TipoRegistro.valueOf(leitor.nextLine().toUpperCase());
        System.out.print("Titulo: ");
        String titulo = leitor.nextLine();
        System.out.print("Descricao: ");
        String descricao = leitor.nextLine();
        System.out.print("Data: ");
        String data = leitor.nextLine();

        // Essa lógica poderia estar na camada de serviço?
        int id = registros.size() + 1;
        Registro novoRegistro = new Registro(id, titulo, data, descricao, tipo);
        registros.add(novoRegistro);
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

    public void removerRegistro() {

        // Essa verificação é melhor estruturada na view ou em service?
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro cadastrado.");
        }
        else {
            System.out.println("Remoção de Registro");
            listarRegistros();
            System.out.println("Digite o ID do registro que deseja remover");
            System.out.println(registros.size()); // Vai imprimir o tamanho da lista?

            // Leitura com nextInt() e nextLine() para lidar com o /n
            // Talvez fosse interessante usar a leitura de string, e depois converter pra int?
            int opcao = leitor.nextInt();
            leitor.nextLine();

            if (opcao > 0) {
                // Considerar os casos
                // Remover um registro, e atualizar indíces dos demais registros

                // Remover primeiro elemento da lista
                if (opcao == 1) {
                    registros.remove(0);
                    for (Registro registro : registros) {
                        registro.setId(registro.getId() - 1);
                    }
                }
                // Remover elemento no meio da lista
                else if (opcao <= registros.size()-1){

                    registros.remove(opcao-1);

                    // Fazendo a atualização dos índices a partir da posição do removido
                    for (int i = opcao; i <= registros.size(); i++) {
                        registros.get(i-1).setId(registros.get(i-1).getId() - 1);
                    }
                }

                // Remover ultimo elemento da lista
                else {
                    registros.remove(registros.size()-1);
                }

                System.out.println("Registro removido com sucesso!");


            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    public void editarRegistro() {
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro cadastrado.");
        } else {
            System.out.println("Selecione o registro que deseja editar");
            listarRegistros();
            int opcao = leitor.nextInt();
            leitor.nextLine();
            if (opcao > 0 && opcao <= registros.size()) {
                // Alterar múltiplos campos, mas deixando o usuario
                // escolher qual alterar e qual manter
                Registro registro = registros.get(opcao-1);
                System.out.print(registro.getTitulo());
                String titulo = leitor.nextLine();
                registro.setTitulo(titulo);

                System.out.println("Registro editado com sucesso!");
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}
