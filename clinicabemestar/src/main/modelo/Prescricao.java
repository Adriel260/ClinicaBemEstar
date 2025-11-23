package com.clinicabemestar.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.objects;

public class prescricao implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;
    private Consulta consulta;
    private LocalDateTime dataEmissao;
    private String descricao;
    private List<String> medicamentos;
    private String instrucoes;

    public Prescricao() {
        this.medicamentos = new ArrayList<>();
    }

    public Prescricao(String id, Consulta consulta, String descricao){
        this.id = id;
        this.consulta = consulta;
        this.dataEmissao = LocalDateTime.now();
        this.descricao = descricao;
        this.medicamentos = new ArrayList<>();
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setConsulta(Consulta consulta){
        return consulta;
    }

    public void setConsulta(Consulta consulta){
        this.consulta = consulta;
    }

    public LocalDateTime getDataEmissao(){
        return dataEmissao;
    }

    public void setDataEmissao(localDateTime dataEmissao){
        this.dataEmissao = dataEmissao;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;   
    }
    
    public List<String> getMedicamentos(){
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos){
        this.medicamentos = medicamentos;
    }

    public void adicinonarMedicamento(String medicamento){
        this.medicamentos.add(medicamento);
    }

    public String getInstrucoes(){
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes){
        this.instrucoes = instrucoes;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        Prescricao that = (Prescricao)o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Prescricao{" +
                "id='" + id + '\'' +
                ", dataEmissao=" + dataEmissao +
                ", descricao='" + descricao + '\'' +
                ", medicamentos=" + medicamentos +
                '}';
    }
    }