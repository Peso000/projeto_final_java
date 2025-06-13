package controller;

import model.Cliente;
import repository.Serializador;
import utils.Log;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes;
    private final String arquivo = "clientes.dat";

    public ClienteController() {
        clientes = Serializador.carregar(arquivo);
        if (clientes == null) clientes = new ArrayList<>();
    }

    public void cadastrar(String nome, String cpf, String telefone) {
        clientes.add(new Cliente(nome, cpf, telefone));
        salvar();
        Log.registrar("Cliente cadastrado: " + cpf);
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public void atualizarTelefone(String cpf, String novoTelefone) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                c.setTelefone(novoTelefone);
                salvar();
                Log.registrar("Telefone atualizado para cliente: " + cpf);
                return;
            }
        }
    }

    public void removerPorCpf(String cpf) {
        clientes.removeIf(c -> c.getCpf().equals(cpf));
        salvar();
        Log.registrar("Cliente removido: " + cpf);
    }

    // Polimorfismo por sobrecarga - buscar por CPF
    public Cliente buscarCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    // Polimorfismo por sobrecarga - buscar por nome
    public List<Cliente> buscarClientePorNome(String nome) {
        List<Cliente> encontrados = new ArrayList<>();
        for (Cliente c : clientes) {
            if (c.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(c);
            }
        }
        return encontrados;
    }

    private void salvar() {
        Serializador.salvar(clientes, arquivo);
    }
}
