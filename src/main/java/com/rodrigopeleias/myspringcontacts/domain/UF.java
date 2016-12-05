package com.rodrigopeleias.myspringcontacts.domain;

public enum UF {

    RS("RS", "Rio Grande do Sul"),
    SC("SC", "Santa Catarina"),
    PR("PR", "Paraná"),
    SP("SP", "São Paulo"),
    RJ("RJ", "Rio de Janeiro"),
    ES("ES", "Espírito Santo"),
    MG("MG", "Minas Gerais"),
    TO("TO", "Tocantins"),
    GO("GO", "Goiás"),
    DF("DF", "Distrito Federal"),
    MS("MS", "Mato Grosso do Sul"),
    MT("MS", "Mato Grosso"),
    BA("BA", "Bahia"),
    MA("MA", "Maranhão"),
    PB("PB", "Paraíba"),
    CE("CE", "Ceará");

    private String id;
    private String name;

    private UF(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
