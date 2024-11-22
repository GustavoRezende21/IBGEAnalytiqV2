package Utils;

public enum Ordenacoes {

    ID("id"),
    CIDADE("cidade"),
    MICRO_REGIAO("microregiao"),
    ESTADO("estado"),
    REGIAO_GEOGRAFICA("regiaogeografica"),
    AREA_KM("areakm"),
    POPULACAO("populacao"),
    DOMICILIOS("domicilios"),
    PIB_TOTAL("pib_total"),
    IDH_GERAL("idh_geral"),
    RENDA_MEDIA("renda_media"),
    RENDA_NOMINAL("renda_nominal"),
    PEA_DIA("pea_dia"),
    IDH_EDUCACAO("idh_educacao"),
    IDH_LONGEVIDADE("idh_longevidade");

    private final String valor;

    Ordenacoes(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }

}
