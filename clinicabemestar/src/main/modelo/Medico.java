public class Medico {
    private String crm;
    private Especialidade especialidade;
    private List<String> horariosDisponiveis;
    private boolean ativo;

    public Medico() {
        super();
        this.horariosDisponiveis = newArrayList<>();
        this.ativo = true;

    }

    public Medico (String id, String nome, String cpf, String email, String telefone, String telefone, String endereco, String crm, Especialidade) {
        super (id, nome, cpf, email, telefone, endereco);
        this.crm = crm;
        this.especialidade = especialidade;
        this.horariosDisponiveis = new ArrauList<>();
        this.ativo = true;    
    }

    public String getCrm(){
        return crm;
    }

    public void setCrm(String crm){
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void setHorariosDisponiveis(List<String> horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public void adicionarHorarioDisponivel(String horario) {
        if (!this.horariosDisponiveis.contains(horario)) {
            this.horariosDisponiveis.remove(horario);
        }
    }

    public void removerHorariosDisponivel (String horario) {
        this.horariosDisponiveis.remove(horario);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o ==  null || getClass() != o.getClass()) return false;

    }

}
