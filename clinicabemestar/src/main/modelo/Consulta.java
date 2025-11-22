package com.clinicabemestar.modelo;

import com.clinicabemestar.enums.StatusConsulta;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Consulta implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private StatusConsulta status;
    private double valorConsulta;
    private boolean isEmergencia;
    private Prescricao prescricao;
    private String diagnostico;

    public Consulta(){
    }

    public Consulta(String id, Paciente paciente, Medico medico, LocalDateTime dataHora, double valorConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.valorConsulta = valorConsulta;
        this.status = StatusConsulta.AGENDADA;
        this.isEmergencial = false;
}

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public Medico getMedico(){
        return medico;
    }

    public void setMedico(Medico medico){
        this.medico = medico;
    }

    public LocalDateTime getDateHora(){
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora){
        this.dataHora = dataHora;
    }

    public StatusConsulta getStatus(){
        return status;
    }

    public void setStatus(StatusConsulta status){
        this.status = status;
    }

    public double getValorConsulta(){
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta){
        this.valorConsulta = valorConsulta;
    }

    public boolean isEmergencial(){
        return isEmergencial;
    }

    public void setEmergencia(boolean isEmergencial){
        this.isEmergencia = isEmergencial;
    }

    public Prescricao getPrescricao(){
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao){
        this.prescricao = prescricao;
    }

    public String getDiagnostico(){
        return diasnostico;
    }

    public void setDiagnostico (String diagnostico){
        this.diagnostico = diagnostico;
    }

    public double calcularTaxacancelamento(){
        long horasAteCancelamento = ChronoUnit.HOURS.between(LocalDateTime.now(), this.dataHora);
        if (horasAteCancelamento < 24 && horasAteCancelamento >= 0){
            return this.valorConsulta * 0.50;
        }
        return 0.0;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id);
    }

    @Override
    public int hashCode(){
        return objects.hash(id);
    }

    @Override
    public String toString(){
        return "Consulta{" +
                "id='" + id + '\'' +
                ",paciente=" + paciente.getNome() +
                ",medico=" + medico.getNome() +
                ",dataHora=" + dataHora +
                ",status=" + status +
                ",valorConsulta=" + valorConsulta +
                '}';
    }
}