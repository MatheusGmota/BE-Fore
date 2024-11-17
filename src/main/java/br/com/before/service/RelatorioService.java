package br.com.before.service;

import br.com.before.dominio.*;

import java.io.IOException;
import java.util.ArrayList;

public class RelatorioService {
    private RepositorioEquipamentos repositorioEquipamentos;
    private RepositorioQuestoes repositorioQuestoes;
    private RepositorioEmpresas repositorioEmpresas;

    public RelatorioService(RepositorioEquipamentos repositorioEquipamentos, RepositorioQuestoes repositorioQuestoes, RepositorioEmpresas repositorioEmpresas) {
        this.repositorioEquipamentos = repositorioEquipamentos;
        this.repositorioQuestoes = repositorioQuestoes;
        this.repositorioEmpresas = repositorioEmpresas;
    }

    public Relatorio relatorio(Long idEmpresa) {
        ArrayList<Equipamento> equipamentos = repositorioEquipamentos.obter(idEmpresa);
        ArrayList<FeedbackQuestoes> feedbackQuestoes = repositorioQuestoes.obterFeedbackQuestoes(idEmpresa);
        double producaoMensal = repositorioEmpresas.obterProducaoMensal(idEmpresa);

        CalculadoraEficienciaEnergetica calculadora = new CalculadoraEficienciaEnergetica();
        EficienciaEnergetica eficienciaEnergetica = calculadora.gerarEficienciaEnergetica(equipamentos, producaoMensal);

        Relatorio relatorio = new Relatorio(feedbackQuestoes, eficienciaEnergetica);

        repositorioEmpresas.fechar();
        repositorioEquipamentos.fechar();
        repositorioQuestoes.fechar();

        return relatorio;
    }
}
