package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class EficienciaEnergetica {
    @JsonProperty
    private ArrayList<EficienciaSetor> eficienciaSetor;
    @JsonProperty
    private EficienciaGeral eficienciaGeral;

    public EficienciaEnergetica() {}

    public EficienciaEnergetica(ArrayList<EficienciaSetor> eficienciaSetor, EficienciaGeral eficienciaGeral) {
        this.eficienciaSetor = eficienciaSetor;
        this.eficienciaGeral = eficienciaGeral;
    }

}
