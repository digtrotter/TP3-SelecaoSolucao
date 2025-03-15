public class SelecaoSolucao {
    private long id;
    public long getId() { return this.id; }
    public void setId() { this.id = System.currentTimeMillis(); }

    public Comentario comentario; //sem sets e gets porque são públicos
    public Solucao    solucao;
    public Selecao    selecao;
    public Voto       voto;


            //////////////////////////////////
            // ^ atributos, gets e sets     //
            //------------------------------//
            // v outros métodos             //
            //////////////////////////////////

    public SelecaoSolucao escolher(Selecao selecao, Solucao solucao){
        return new SelecaoSolucao(selecao, solucao);
    }
    public static void excluir(SelecaoSolucao objeto){
        objeto.id = -1;
    }
    SelecaoSolucao(Selecao selecao, Solucao solucao){
        this.id = System.currentTimeMillis();
        this.selecao = selecao;
        this.solucao = solucao;
    }

}
