package model;

import java.util.Date;

public class Onibus {

    private int id;
    private String modelo;
    private Long linha_id;
    private String terminal;
    private String caracteristicas;
    private int lotacaoMax;
    private Date ultimaManutencao;
    private int atrasos;
    private String itinerario;

    public Onibus() {
    }

    public Onibus(int id, String modelo, Long linha_id, String terminal, String caracteristicas,
            int lotacaoMax, Date ultimaManutencao, int atrasos) {
        this.id = id;
        this.modelo = modelo;
        this.linha_id = linha_id;
        this.terminal = terminal;
        this.caracteristicas = caracteristicas;
        this.lotacaoMax = lotacaoMax;
        this.ultimaManutencao = ultimaManutencao;
        this.atrasos = atrasos;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getLinha() {
        return linha_id;
    }

    public void setLinha(Long linha_id) {
        this.linha_id = linha_id;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getLotacaoMax() {
        return lotacaoMax;
    }

    public void setLotacaoMax(int lotacaoMax) {
        this.lotacaoMax = lotacaoMax;
    }

    public Date getUltimaManutencao() {
        return ultimaManutencao;
    }

    public void setUltimaManutencao(Date ultimaManutencao) {
        this.ultimaManutencao = ultimaManutencao;
    }

    public int getAtrasos() {
        return atrasos;
    }

    public void setAtrasos(int atrasos) {
        this.atrasos = atrasos;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }
}
