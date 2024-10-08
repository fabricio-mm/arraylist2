import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestaArrayList2 {
    public static void main(String[] args) {
        ArrayList<Contato> listaContatos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Verificar quantidade de contatos");
            System.out.println("3. Imprimir contatos");
            System.out.println("4. Obter contato de uma posição específica");
            System.out.println("5. Verificar se existe o contato");
            System.out.println("6. Adicionar contato em qualquer posição");
            System.out.println("7. Duplicar tamanho do vetor");
            System.out.println("8. Remover contato");
            System.out.println("9. Pesquisar por nome");
            System.out.println("10. Pesquisar por e-mail");
            System.out.println("11. Pesquisar por telefone");
            System.out.println("12. Ordenar por nome");
            System.out.println("13. Ordenar por e-mail");
            System.out.println("14. Ordenar por telefone");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    listaContatos.add(new Contato(nome, email, telefone));
                    break;

                case 2:
                    System.out.println("Quantidade de contatos: " + listaContatos.size());
                    break;

                case 3:
                    imprimirContatos(listaContatos);
                    break;

                case 4:
                    System.out.print("Digite a posição: ");
                    int posicao = scanner.nextInt();
                    if (posicao >= 0 && posicao < listaContatos.size()) {
                        System.out.println(listaContatos.get(posicao));
                    } else {
                        System.out.println("Posição inválida.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o nome do contato: ");
                    String nomeContato = scanner.nextLine();
                    boolean existe = listaContatos.stream().anyMatch(contato -> contato.getNome().equals(nomeContato));
                    if (existe) {
                        System.out.println("Contato existe.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    telefone = scanner.nextLine();
                    System.out.print("Posição: ");
                    posicao = scanner.nextInt();
                    if (posicao >= 0 && posicao <= listaContatos.size()) {
                        listaContatos.add(posicao, new Contato(nome, email, telefone));
                    } else {
                        System.out.println("Posição inválida.");
                    }
                    break;

                case 7:
                    listaContatos.ensureCapacity(listaContatos.size() * 2);
                    System.out.println("Tamanho do vetor duplicado.");
                    break;

                case 8:
                    System.out.print("Digite o nome do contato a ser removido: ");
                    nomeContato = scanner.nextLine();
                    listaContatos.removeIf(contato -> contato.getNome().equals(nomeContato));
                    System.out.println("Contato removido, se existia.");
                    break;

                case 9:
                    System.out.print("Digite o nome: ");
                    nomeContato = scanner.nextLine();
                    listaContatos.stream()
                            .filter(contato -> contato.getNome().equalsIgnoreCase(nomeContato))
                            .forEach(System.out::println);
                    break;

                case 10:
                    System.out.print("Digite o e-mail: ");
                    String emailContato = scanner.nextLine();
                    listaContatos.stream()
                            .filter(contato -> contato.getEmail().equalsIgnoreCase(emailContato))
                            .forEach(System.out::println);
                    break;

                case 11:
                    System.out.print("Digite o telefone: ");
                    String telefoneContato = scanner.nextLine();
                    listaContatos.stream()
                            .filter(contato -> contato.getTelefone().equals(telefoneContato))
                            .forEach(System.out::println);
                    break;

                case 12:
                    Collections.sort(listaContatos, Contato.compararPorNome());
                    System.out.println("Contatos ordenados por nome.");
                    break;

                case 13:
                    Collections.sort(listaContatos, Contato.compararPorEmail());
                    System.out.println("Contatos ordenados por e-mail.");
                    break;

                case 14:
                    Collections.sort(listaContatos, Contato.compararPorTelefone());
                    System.out.println("Contatos ordenados por telefone.");
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void imprimirContatos(ArrayList<Contato> listaContatos) {
        if (listaContatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            for (Contato contato : listaContatos) {
                System.out.println(contato);
            }
        }
    }
}
