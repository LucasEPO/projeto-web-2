package model;

public class LinhaPontoBean {
    private Long linha_id;
    private Long ponto_id;
    private String horario_chegada;
    private String nome_linha;
    
    public LinhaPontoBean() {
    }

    public LinhaPontoBean(Long linha_id, Long ponto_id, String horario_chegada, String nome_linha) {
        this.linha_id = linha_id;
        this.ponto_id = ponto_id;
        this.horario_chegada = horario_chegada;
        this.nome_linha = nome_linha;
    }

    public Long getLinha_id() {
        return linha_id;
    }

    public void setLinha_id(Long linha_id) {
        this.linha_id = linha_id;
    }

    public Long getPonto_id() {
        return ponto_id;
    }

    public void setPonto_id(Long ponto_id) {
        this.ponto_id = ponto_id;
    }

    public String getHorario_chegada() {
        return horario_chegada;
    }

    public void setHorario_chegada(String horarrio_chegada) {
        this.horario_chegada = horarrio_chegada;
    }

    public String getNome_linha() {
        return nome_linha;
    }

    public void setNome_linha(String nome_linha) {
        this.nome_linha = nome_linha;
    }
    
}
