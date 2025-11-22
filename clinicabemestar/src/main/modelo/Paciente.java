package com.clinicabemestar.modelo;

import com.clinicabemestar.enums.TipoPaciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paciente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String numeroMatricula;
    private TipoPaciente tipoPaciente;
    private String nomeConvenio;
    private List<String> historicoConsultas;
    private double saldoDevedor;

    public Paciente() {
        super();
        this.historicoConsultas = new ArrayList<>();
        this.saldoDevedor = 0.0;
    }

    public Paciente(String id, String nome, String cpf, String email, String telefone,
                    String endereco, String numeroMatricula, TipoPaciente tipoPaciente, String nomeConvenio) {
        super(id, nome, cpf, email, telefone, endereco);
        this.numeroMatricula = numeroMatricula;
        this.tipoPaciente = tipoPaciente;
        this.nomeConvenio = nomeConvenio;
        this.historicoConsultas = new ArrayList<>();
        this.saldoDevedor = 0.0;
    }

    public String getNumeromatricula(){
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula){
        this.numeromatricula = mumeroMatricula;
    }

    public TipoPaciente getTipoPaciente(){
        return tipoPaciente;
    }

    public void setTipoPaciente(TipoPaciente tipoPaciente){
        this.Paciente = tipoPaciente;
    }

    public String getNomeConvenio(){
        return nomeConvenio;   
    }

    public void setNomeConvenio(String nomeConvenio){
        this.nomeConvenio = nomeConvenio;
    }

    public List<String> getHistoricoConsultas(){
        return historicoConsultas;
    }

    public void setHistoricoConsultas(List<String> historicoConsultas) {
        this.historicoConsultas = historicoConsultas;
    }

    public void adicionarConsultaAoHistorico(String consultaId) {
        this.historicoConsultas.add(consultaId);
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public void adicionarDivida(double valor) {
        this.saldoDevedor += valor;
    }

    public void pagarDivida(double valor) {
        if (valor <= this.saldoDevedor) {
            this.saldoDevedor -= valor;
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(numeroMatricula, paciente.numeroMatricula);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), numeroMatricula);
    }

    @Override
    public String toString(){
        return "Paciente{" +       
                ", numeroMatricula='" + numeroMatricula + '\'' +
                ", tipoPaciente=" + tipoPaciente +
                ", nomeConvenio='" + nomeConvenio + '\'' +
                ", saldoDevedor=" + saldoDevedor +
                ",nome='" + getNome() + '\''+
                '}';
    }
}