package lembrete;
public class Lembrete implements Comparable<Lembrete> {
    private String descricao;
    private Data data;
    
    public Lembrete(String descricao, int dia, int mes, int ano) {
        this.descricao = descricao;
        this.data = new Data(dia, mes, ano);
    }
    public Data getData(){
        return data;
    }
    public String getDescricao(){
        return descricao;
    }
    @Override
    public String toString() {
        return data.dia()+" de "+data.extMes()+" de "+data.ano()+":" + " -- " + descricao;
    }
    
    @Override
    public int compareTo(Lembrete l) {
        return this.data.compareTo(l.getData());
}
    public String mesPorExtenso() {
        return data.extMes();
    }


}
