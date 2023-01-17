package br.com.Ada;

import controller.impl.CidadesArmazenamentoTipo;
import controller.impl.CidadesControllerFactory;
import view.CidadesView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final String ARQUIVO_PROPRIEDADES = "crud.properties";
    private static final String CONTROLLER_TIPO = "cidades.controller.tipo";

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(ARQUIVO_PROPRIEDADES));

        String tipoArmazenamento = properties.getProperty(CONTROLLER_TIPO);
        CidadesArmazenamentoTipo tipo =
                CidadesArmazenamentoTipo.valueOf(tipoArmazenamento);

        CidadesControllerFactory factory = new CidadesControllerFactory();

        CidadesView view = new CidadesView(
                factory.criar(tipo),
                new Scanner(System.in)
        );
        view.exibirOpcoes();

    }
}