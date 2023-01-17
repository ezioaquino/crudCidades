package controller.impl;

import controller.impl.model.Cidade;

import java.util.List;
import java.util.UUID;

public interface CidadesController {

    void cadastar(Cidade cidade);

    Cidade ler(UUID id);

    List<Cidade> listar();

    //void update(UUID id, Cidade cidade);

    //Cidade delete(UUID id);
}
