package lembrete;
public class Data implements Comparable<Data>{
    private final int dia;
    private final int mes;
    private final int ano;
    private static final String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril",
                                           "Maio", "Junho", "Julho", "Agosto",
                                           "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    public Data(int dia, int mes, int ano) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }
    
    public String extMes() {
        if (mes > 0 && mes <= 12)
            return meses[mes-1];
        return null;
    }

    public int dia() {
        return dia;
    }
    public int mes(){
        return mes;
    }

    public int ano() {
        return ano;
    }
    
    @Override
    public int compareTo(Data data) {
        int anocompare = Integer.compare(ano, data.ano);
        if ( anocompare != 0 ) {
            return anocompare;
        }
        int mescompare = Integer.compare(mes, data.mes);
        if ( mescompare != 0 ) {
            return mescompare;
        }
        int diacompare = Integer.compare(dia, data.dia);
        return diacompare;
    }

}