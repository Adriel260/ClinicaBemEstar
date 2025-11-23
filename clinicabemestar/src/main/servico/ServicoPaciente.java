package com.clinicabemestar.servico;

import com.clinicabemestar.modelo.Paciente;
import com.clinicabemestar.enums.TipoPaciente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ServicoPaciente {
    private Map<String, Paciente> pacientes;

    public ServicoPaciente() {
        this.pacientes = new HashMap<>();
    }

    public Paciente cadastrarPaciente(String nome, String cpf, String email, String telefone,
                                       String endereco, TipoPaciente tipoPaciente, String nomeConvenio) {
        String id = UUID.randomUUID().toString();
        String numeroMatricula = "PAC" + System.currentTimeMillis();
        Paciente paciente = new Paciente(id, nome, cpf, email, telefone, endereco, numeroMatricula, tipoPaciente, nomeConvenio);
        this.pacientes.put(id, paciente);
        return paciente;
    }

    public Paciente buscarPorId(String id) {
        return this.pacientes.get(id);
    }

    public Paciente buscarPorCpf(String cpf) {
        for (Paciente paciente : this.pacientes.values()) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente buscarPorMatricula(String numeroMatricula) {
        for (Paciente paciente : this.pacientes.values()) {
            if (paciente.getNumeroMatricula().equals(numeroMatricula)) {
                return paciente;
            }
        }
        return null;
    }

    public List<Paciente> buscarPorTipo(TipoPaciente tipo) {
        List<Paciente> resultado = new ArrayList<>();
        for (Paciente paciente : this.pacientes.values()) {
            if (paciente.getTipoPaciente() == tipo) {
                resultado.add(paciente);
            }
        }
        return resultado;
    }

    
    public void atualizarPaciente(String id, String email, String telefone, String endereco, TipoPaciente tipoPaciente) {
        Paciente paciente = this.pacientes.get(id);
        if (paciente != null) {
            paciente.setEmail(email);
            paciente.setTelefone(telefone);
            paciente.setEndereco(endereco);
            paciente.setTipoPaciente(tipoPaciente);
        }
    }

   
    public List<Paciente> listarTodosPacientes() {
        return new ArrayList<>(this.pacientes.values());
    }

   
    public void removerPaciente(String id) {
        this.pacientes.remove(id);
    }

    
    public double calcularValorComDesconto(double valorBase, TipoPaciente tipoPaciente) {
        double desconto = tipoPaciente.getDesconto();
        return valorBase * (1 - desconto);
    }

    
    public void adicionarConsultaAoHistorico(String idPaciente, String consultaId) {
        Paciente paciente = this.pacientes.get(idPaciente);
        if (paciente != null) {
            paciente.adicionarConsultaAoHistorico(consultaId);
        }
    }


    public List<String> obterHistoricoConsultas(String idPaciente) {
        Paciente paciente = this.pacientes.get(idPaciente);
        if (paciente != null) {
            return paciente.getHistoricoConsultas();
        }
        return new ArrayList<>();
    }


    public void adicionarDivida(String idPaciente, double valor) {
        Paciente paciente = this.pacientes.get(idPaciente);
        if (paciente != null) {
            paciente.adicionarDivida(valor);
        }
    }

    public void pagarDivida(String idPaciente, double valor) {
        Paciente paciente = this.pacientes.get(idPaciente);
        if (paciente != null) {
            paciente.pagarDivida(valor);
        }
    }

    public double obterSaldoDevedor(String idPaciente) {
        Paciente paciente = this.pacientes.get(idPaciente);
        if (paciente != null) {
            return paciente.getSaldoDevedor();
        }
        return 0.0;
    }
}

