package br.com.before.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalculadoraEficienciaEnergetica {

    public double calcularConsumoPorEquipamento(Equipamento e) {
        return e.getPotencia() * e.getQuantidade() * e.getHoraOperacao()/ 1000;
    }

    public ArrayList<EficienciaSetor> calcularEficienciaEnergeticaPorSetor(ArrayList<Equipamento> equipamentos, double producaoMensal) {
        HashMap<String, Double> consumoPorSetor = new HashMap<>();
        ArrayList<EficienciaSetor> eficienciaSetores = new ArrayList<>();

        for (Equipamento equipamento : equipamentos) {
            double consumoPorEquipamento = calcularConsumoPorEquipamento(equipamento);
            String setor = equipamento.getSetor();
            consumoPorSetor.put(setor, consumoPorSetor.getOrDefault(setor, 0.0) + consumoPorEquipamento);
        }

        for (Map.Entry<String, Double> entrada : consumoPorSetor.entrySet()) {
            String setor = entrada.getKey();
            Double consumoMensal = entrada.getValue();

            double eficienciaPorSetor = consumoMensal / producaoMensal;

            EficienciaSetor eficienciaEnergeticaSetor = new EficienciaSetor(setor, eficienciaPorSetor, consumoMensal);
            eficienciaSetores.add(eficienciaEnergeticaSetor);
        }
        return eficienciaSetores;
    }

    public EficienciaEnergetica gerarEficienciaEnergetica(ArrayList<Equipamento> equipamentos, double producaoMensal) {
        ArrayList<EficienciaSetor> eficienciaSetores = calcularEficienciaEnergeticaPorSetor(equipamentos, producaoMensal);
        double somaEficiencia = 0.0;
        double somaConsumo = 0.0;
        for (EficienciaSetor eficienciaSetor : eficienciaSetores) {
            somaEficiencia += eficienciaSetor.getEficienciaEnergetica();
            somaConsumo += eficienciaSetor.getConsumoMensal();
        }
        return new EficienciaEnergetica(eficienciaSetores, new EficienciaGeral(somaEficiencia, somaConsumo));
    }
}
