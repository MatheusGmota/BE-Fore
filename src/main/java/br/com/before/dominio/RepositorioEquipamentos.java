package br.com.before.dominio;

import java.util.ArrayList;

public interface RepositorioEquipamentos {
    void adicionar(Long idEmpresa, Equipamento equipamento);
    ArrayList<Equipamento> obter(Long idEmpresa);
    void fechar();
}
