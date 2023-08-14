package lembrete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlocoDeLembretes {
    private final List<Lembrete> lista;
    
    public BlocoDeLembretes() {
        lista = new ArrayList<>();
    }
    public void inserir(Lembrete ex) {
        lista.add(ex);
    }
    public Lembrete remover(int posicao) {
        if(posicao >= 0 && posicao < lista.size()){
            return lista.remove(posicao);
        } else {
            return null;
        }  
    }
    public Lembrete buscar(int posicao) {
        if(posicao >= 0 && posicao < lista.size()){
            return lista.get(posicao);
        } else {
            return null;
        }  
    }
    public void ordena() {
        Collections.sort(lista);
    }

    public List<Lembrete> buscarPorPalavra(String palavra) {
    List<Lembrete> lemb = new ArrayList<>();
    
    for (int i = 0; i < lista.size(); i++) {
        Lembrete lembrete = lista.get(i);
        if (lembrete.toString().contains(palavra)) {
            lemb.add(lembrete);
        }
    }
    
    return lemb;
}
    
    public List<Lembrete> buscarPorMes(int mes) {
    List<Lembrete> lmes = new ArrayList<>();
    
    for (int i = 0; i < lista.size(); i++) {
        Lembrete lembrete = lista.get(i);
        if (lembrete.getData().mes() == mes) {
            lmes.add(lembrete);
        }
    }
    
    return lmes;
}
    
    public List<Lembrete> buscarPorDia(int dia) {
    List<Lembrete> ldia = new ArrayList<>();
    
    for (int i = 0; i < lista.size(); i++) {
        Lembrete lembrete = lista.get(i);
        if (lembrete.getData().dia() == dia) {
            ldia.add(lembrete);
        }
    }
    
    return ldia;
}
    
    public List<Lembrete> buscarPorAno(int ano) {
    List<Lembrete> lano = new ArrayList<>();
    
    for (int i = 0; i < lista.size(); i++) {
        Lembrete lembrete = lista.get(i);
        if (lembrete.getData().ano() == ano) {
            lano.add(lembrete);
        }
    }
    
    return lano;
}
    
    @Override
    public String toString() {
        return lista.toString();
    }
    
    public List<Lembrete> ordenarPorData() {
        List<Lembrete> ordem = new ArrayList<>(lista);
        Collections.sort(ordem);
        return ordem;
    }
}
