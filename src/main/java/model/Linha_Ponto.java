package model;

public class Linha_Ponto {
    private Long linha_id;
    private Long ponto_id;
    private String horarrio_chegada;
    
    public Linha_Ponto() {
    }

    public Linha_Ponto(Long linha_id, Long ponto_id, String horarrio_chegada) {
        this.linha_id = linha_id;
        this.ponto_id = ponto_id;
        this.horarrio_chegada = horarrio_chegada;
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

    public String getHorarrio_chegada() {
        return horarrio_chegada;
    }

    public void setHorarrio_chegada(String horarrio_chegada) {
        this.horarrio_chegada = horarrio_chegada;
    }
    
}
