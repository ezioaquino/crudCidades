package controller.impl;

import controller.impl.exception.CidadeNaoEncontrada;
import controller.impl.model.Cidade;

import java.util.*;

public class CidadeArmazenamentoVolatilController implements CidadesController {

    private Scanner scanner = new Scanner(System.in);

    private Map<UUID, Cidade> cidades = new HashMap<>();

    @Override
    public void cadastar(Cidade cidade) {
        cidade.setId(UUID.randomUUID());

        cidades.put(cidade.getId(), cidade);

    }

    @Override
    public Cidade ler(UUID id) {

        Cidade cidadeEncontrada =cidades.get(id);
        if(cidadeEncontrada == null){
            throw new CidadeNaoEncontrada();
        }
        return cidadeEncontrada;
    }

    @Override
    public List<Cidade> listar() {

        return new ArrayList<>(cidades.values());
    }
}
