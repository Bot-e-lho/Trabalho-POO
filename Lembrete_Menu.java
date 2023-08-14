package lembrete;

import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Lembrete_Menu {
    private BlocoDeLembretes bloco;

    public Lembrete_Menu() {
        bloco = new BlocoDeLembretes();
    }

    void printMenu() {
        try (Scanner scn = new Scanner(System.in)) {
            int opcao = 0;
            
            while (opcao != 11) {
                System.out.println("------------ MENU ------------");
                System.out.println("1- Inserir novo lembrete");
                System.out.println("2- Buscar por palavra");
                System.out.println("3- Buscar por mes");
                System.out.println("4- Buscar por dia");
                System.out.println("5- Imprimir todos os lembretes");
                System.out.println("6- Imprimir todos os lembretes em ordem(Data)");
                System.out.println("7- Imprimir os lembretes de um ano");
                System.out.println("8- Imprimir os lembretes de um mes");
                System.out.println("9- Imprimir os lembretes de um dia");
                System.out.println("10- Excluir lembrete (posicao)");
                System.out.println("11- Sair");
                System.out.println("Escolha uma opcao: \n");
                opcao = scn.nextInt();
                
                switch (opcao) {
                    case 1 -> {//inserir
                        System.out.print("--------- Informe a data do lembrete --------- ");
                        System.out.print("\nInforme o dia(xx): ");
                        int dia = scn.nextInt();
                        if ( dia < 0 || dia > 31){
                            System.out.print("\nDia invalido, tente novamente. ");
                            break;
                        }
                        System.out.print("\nInforme o mes(xx): ");
                        int mes = scn.nextInt();
                        if ( mes < 0 || mes > 12 ){
                            System.out.print("\nMes invalido, tente novamente. ");
                            break;
                        }
                        System.out.print("\nInforme o ano(xxxx): ");
                        int ano = scn.nextInt();
                        if ( ano < 0 ){
                            System.out.print("\nAno invalido, tente novamente. ");
                            break;
                        }
                        scn.nextLine();
                        System.out.print("\nInforme a descricao do lembrete: ");
                        String descricao = scn.nextLine();
                        bloco.inserir(new Lembrete(descricao, dia, mes, ano));
                        break;
                    }
                    case 2 -> { // buscar por substring -- crescente
                        System.out.print("Informe a palavra para busca: ");
                        scn.nextLine();
                        String palavra = scn.nextLine();
                        List<Lembrete> lemb = bloco.buscarPorPalavra(palavra);
                        Collections.sort(lemb);
                        for (int i = 0; i < lemb.size(); i++) {
                            System.out.println(lemb.get(i));
                        }
                        break;
}
                    case 3 -> {//buscar por mes -- mostrar em ordem crescente
                        System.out.print("Informe o mes para busca: ");
                        int mes = scn.nextInt();
                        if ( mes < 0 || mes > 12){
                            System.out.print("\nMes invalido, tente novamente. ");
                            break;
                        }
                        List<Lembrete> lMes = bloco.buscarPorMes(mes);
                        Collections.sort(lMes); 
                        lMes.forEach(lembrete -> System.out.println(lembrete));
                        break;
                    }
                    case 4 -> {//buscar por dia -- crescente
                        System.out.print("Informe o dia para busca: ");
                        int dia = scn.nextInt();
                        if ( dia < 0 || dia > 31 ){
                            System.out.print("\nDia invalido, tente novamente. ");
                            break;
                        }
                        List<Lembrete> lDia = bloco.buscarPorDia(dia);
                        Collections.sort(lDia);
                        lDia.forEach(lembrete -> System.out.println(lembrete));
                        break;
                    }
                    case 5 -> {//imprime todos os lembretes
                        System.out.println(bloco);
                        break;
                    }
                    case 6 -> {//imprime todos os lembretes com o mecanismo de ordem
                        List<Lembrete> listaordenada = bloco.ordenarPorData();
                        listaordenada.forEach(lembrete -> System.out.println(lembrete));
                        break;
                    }
                    case 7 -> {//Imprime de determinado ano ++
                        System.out.println("Informe o ano: ");
                        int ano = scn.nextInt();
                        if ( ano < 0){
                            System.out.print("\nAno invalido, tente novamente. ");
                            break;
                        }
                        List<Lembrete> lembAno = bloco.buscarPorAno(ano);
                        lembAno.forEach(lembrete -> System.out.println(lembrete));
                        break;
                    }
                    case 8 -> {//Imprime de determinado mes
                        System.out.println("Informe o mes: ");
                        int mes = scn.nextInt();
                        if ( mes < 0 || mes > 12 ){
                            System.out.print("\nMes invalido, tente novamente. ");
                            break;
                        }
                        List<Lembrete> lembMes = bloco.buscarPorMes(mes);
                        lembMes.forEach(lembrete -> System.out.println(lembrete));
                        break;
                    }
                    case 9 -> {//Imprime determinado dia
                        System.out.println("Informe o dia: ");
                        int dia = scn.nextInt();
                        if ( dia < 0 || dia > 31){
                            System.out.print("\nDia invalido, tente novamente. ");
                            break;
                        }
                        List<Lembrete> lembDia = bloco.buscarPorDia(dia);
                        lembDia.forEach(lembrete -> System.out.println(lembrete));
                        break;
                    }
                    case 10 -> {//Excluir por indice
                        System.out.print("Informe uma posicao para excluir(Ind. 0 - posicao inicial): ");
                        int posicao = scn.nextInt();
                        Lembrete exc= bloco.remover(posicao);
                        if (exc != null) {
                            System.out.println("\nLembrete excluido:  " + exc);
                        } else {
                            System.out.println("\nPosicao invalida");
                        }
                        break;
                    }
                    case 11 -> {//Saida
                        System.out.println("\nSaida Solicitada");
                        break;
                    }
                    default -> System.out.println("Comando Invalido!!");
                }
            }
        }
    }
}