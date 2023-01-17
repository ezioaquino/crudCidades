package view;

import controller.impl.CidadesController;
import controller.impl.model.Cidade;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CidadesView {

    private CidadesController controller;

    private Scanner scanner;

    public CidadesView(CidadesController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }


    public void cadastrar(){
        Cidade cidade = new Cidade();

        System.out.println("Informe o nome da cidade:");
        String nome = scanner.next();
        cidade.setNomeCidade(nome);

        System.out.println("Informe a sigla da cidade");
        String siglaCidade = scanner.next();
        cidade.setSiglaCidade(siglaCidade);

        System.out.println("Informe o UF (sigla):");
        String nomeEstado = scanner.next();
        cidade.setUf(nomeEstado);

        System.out.println("Informe a sigla do país");
        String siglaPais = scanner.next();
        cidade.setSiglaPais(siglaPais);

    }

    public void listar(UUID id){
        Cidade cidade = controller.ler(id);
        exibirCidade(cidade);
    }

    public void listar(){

        List<Cidade> cidades = controller.listar();


        System.out.println("| Número | Nome        | sigla Cidade       |" +
                "UF       | País(sigla)       |");

        for (int index = 0; index < cidades.size(); index++) {

            System.out.println((index + 1) + " - ");
            exibirCidade(cidades.get(index));

        }

    }

   public void exibirCidade(Cidade cidade){

       System.out.print("| ");
       System.out.print(cidade.getNomeCidade());
       System.out.print("    | ");
       System.out.print(cidade.getSiglaCidade());
       System.out.print("    |  ");
       System.out.print(cidade.getUf());
       System.out.print("    |  ");
       System.out.print(cidade.getSiglaPais());
       System.out.println("    |  ");
   }

    public void exibirOpcoes(){
        System.out.println("norme a opção desejada:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Apagar");
        System.out.println("0 - Sair");
        Integer opcao = scanner.nextInt();
        scanner.nextLine();
        switch (opcao){
            case 1:
                cadastrar();
                break;
            case 2:
                listar();
                break;
            case 3:
                //atualizar();
                break;
            case 4:
                //apagar();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Opção invalida");
        }
        exibirOpcoes();
    }
}
