package controller.impl;

public class CidadesControllerFactory {

    public CidadesController criar(CidadesArmazenamentoTipo tipo){
        if (tipo == CidadesArmazenamentoTipo.VOLATIL){
            return new CidadeArmazenamentoVolatilController();
        } else if (tipo == CidadesArmazenamentoTipo.DEFINITIVO) {
            return new CidadesArmazenamentoDefinitivoController();
        } else {
            throw new RuntimeException("Nenhuma implementação disponível");
        }
    }
}
