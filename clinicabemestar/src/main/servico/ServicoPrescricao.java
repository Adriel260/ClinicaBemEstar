package com.clinicabemestar.servico;

import com.clinicabemestar.modelo.Prescricao;
import com.clinicabemestar.modelo.Consulta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ServicoPrescricao {
    private Map<String, Prescricao> prescricoes;

    public ServicoPrescricao() {
        this.prescricoes = new HashMap<>();
    }

    public Prescricao criarPrescricao(Consulta consulta, String descricao, String instrucoes) {
        String id = UUID.randomUUID().toString();
        Prescricao prescricao = new Prescricao(id, consulta, descricao);
        prescricao.setInstrucoes(instrucoes);
        this.prescricoes.put(id, prescricao);
  
        consulta.setPrescricao(prescricao);

        return prescricao;
    }

    public Prescricao buscarPorId(String id) {
        return this.prescricoes.get(id);
    }

    public Prescricao buscarPorConsulta(String idConsulta) {
        for (Prescricao prescricao : this.prescricoes.values()) {
            if (prescricao.getConsulta().getId().equals(idConsulta)) {
                return prescricao;
            }
        }
        return null;
    }

    public void adicionarMedicamento(String idPrescricao, String medicamento) {
        Prescricao prescricao = this.prescricoes.get(idPrescricao);
        if (prescricao != null) {
            prescricao.adicionarMedicamento(medicamento);
        }
    }

    public List<Prescricao> listarPrescricoesPaciente(String idPaciente) {
        List<Prescricao> resultado = new ArrayList<>();
        for (Prescricao prescricao : this.prescricoes.values()) {
            if (prescricao.getConsulta().getPaciente().getId().equals(idPaciente)) {
                resultado.add(prescricao);
            }
        }
        return resultado;
    }

    public List<Prescricao> listarPrescricoesMedico(String idMedico) {
        List<Prescricao> resultado = new ArrayList<>();
        for (Prescricao prescricao : this.prescricoes.values()) {
            if (prescricao.getConsulta().getMedico().getId().equals(idMedico)) {
                resultado.add(prescricao);
            }
        }
        return resultado;
    }

    public List<Prescricao> listarTodasPrescricoes() {
        return new ArrayList<>(this.prescricoes.values());
    }

    public void removerPrescricao(String id) {
        this.prescricoes.remove(id);
    }

    public void atualizarDescricao(String idPrescricao, String novaDescricao) {
        Prescricao prescricao = this.prescricoes.get(idPrescricao);
        if (prescricao != null) {
            prescricao.setDescricao(novaDescricao);
        }
    }

    public void atualizarInstrucoes(String idPrescricao, String novasInstrucoes) {
        Prescricao prescricao = this.prescricoes.get(idPrescricao);
        if (prescricao != null) {
            prescricao.setInstrucoes(novasInstrucoes);
        }
    }
}
