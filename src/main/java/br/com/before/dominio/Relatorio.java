package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Relatorio {
    @JsonProperty
    private ArrayList<FeedbackQuestoes> feedbackQuestoes;

    @JsonProperty
    private EficienciaEnergetica eficienciaEnergetica;

    public Relatorio() {}

    public Relatorio(ArrayList<FeedbackQuestoes> feedbackQuestoes, EficienciaEnergetica eficienciaEnergetica) {
        this.feedbackQuestoes = feedbackQuestoes;
        this.eficienciaEnergetica = eficienciaEnergetica;
    }

    public ArrayList<FeedbackQuestoes> getFeedbackQuestoes() {
        return feedbackQuestoes;
    }

    public EficienciaEnergetica getEficienciaEnergetica() {
        return eficienciaEnergetica;
    }
}
