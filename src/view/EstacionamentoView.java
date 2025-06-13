package view;

import controller.ClienteController;
import controller.EstacionamentoController;
import controller.VeiculoController;
import model.Cliente;
import model.Veiculo;

import java.util.List;
import java.util.Scanner;

public class EstacionamentoView {
    private static final Scanner sc = new Scanner(System.in);
    private static final ClienteController clienteCtrl = new ClienteController();
    private static final VeiculoController veiculoCtrl = new VeiculoController();
    private static final EstacionamentoController estacionamentoCtrl = new EstacionamentoController();

    public static void main(String[] args) {
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== Sistema Estacionamento ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Telefone Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("5 - Cadastrar Veículo");
            System.out.println("6 - Listar Veículos");
            System.out.println("7 - Remover Veículo");
            System.out.println("8 - Registrar Entrada Estacionamento");
            System.out.println("9 - Listar Entradas");
            System.out.println("10 - Remover Entrada");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> atualizarTelefoneCliente();
                case 4 -> removerCliente();
                case 5 -> cadastrarVeiculo();
                case 6 -> listarVeiculos();
                case 7 -> removerVeiculo();
                case 8 -> registrarEntrada();
                case 9 -> listarEntradas();
                case 10 -> removerEntrada();
                case 0 -> {
                    System.out.println("Saindo...");
                    rodando = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        clienteCtrl.cadastrar(nome, cpf, telefone);
        System.out.println("Cliente cadastrado!");
    }

    private static void listarClientes() {
        List<Cliente> clientes = clienteCtrl.listar();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    private static void atualizarTelefoneCliente() {
        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        System.out.print("Novo telefone: ");
        String tel = sc.nextLine();

        clienteCtrl.atualizarTelefone(cpf, tel);
        System.out.println("Telefone atualizado!");
    }

    private static void removerCliente() {
        System.out.print("CPF do cliente a remover: ");
        String cpf = sc.nextLine();

        clienteCtrl.removerPorCpf(cpf);
        System.out.println("Cliente removido!");
    }

    private static void cadastrarVeiculo() {
        System.out.print("Tipo (1-Carro, 2-Moto): ");
        int tipo = Integer.parseInt(sc.nextLine());
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        if (tipo == 1) veiculoCtrl.cadastrarCarro(placa, modelo);
        else if (tipo == 2) veiculoCtrl.cadastrarMoto(placa, modelo);
        else System.out.println("Tipo inválido.");

        System.out.println("Veículo cadastrado!");
    }

    private static void listarVeiculos() {
        List<Veiculo> veiculos = veiculoCtrl.listar();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (Veiculo v : veiculos) {
            System.out.println(v);
        }
    }

    private static void removerVeiculo() {
        System.out.print("Placa do veículo a remover: ");
        String placa = sc.nextLine();

        veiculoCtrl.removerPorPlaca(placa);
        System.out.println("Veículo removido!");
    }

    private static void registrarEntrada() {
        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        Cliente cliente = clienteCtrl.buscarCliente(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Placa do veículo: ");
        String placa = sc.nextLine();
        Veiculo veiculo = veiculoCtrl.buscarPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        estacionamentoCtrl.registrarEntrada(cliente, veiculo);
        System.out.println("Entrada registrada!");
    }

    private static void listarEntradas() {
        var registros = estacionamentoCtrl.listarRegistros();
        if (registros.isEmpty()) {
            System.out.println("Nenhuma entrada registrada.");
            return;
        }
        int i = 0;
        for (var e : registros) {
            System.out.println(i + " - " + e);
            i++;
        }
    }

    private static void removerEntrada() {
        listarEntradas();
        System.out.print("Índice da entrada a remover: ");
        int idx = Integer.parseInt(sc.nextLine());
        estacionamentoCtrl.removerRegistro(idx);
        System.out.println("Entrada removida!");
    }
}
