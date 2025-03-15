import java.time.LocalDate;

public class Voto {
    private long id;
    public  long getId() { return this.id; }
    public  void setId() { this.id = System.currentTimeMillis(); }

    LocalDate dtCadastro;
    public LocalDate getDtCadastro() { return this.dtCadastro; }
    public void setDtCadastro(LocalDate receba) { this.dtCadastro = receba; }

    SelecaoSolucao selSol;
    UsuarioVisitante usuVis;
    Solucao solucao;

    public static Voto votar(SelecaoSolucao selSol, UsuarioVisitante usuVis){
        Voto temp = new Voto();
        temp.selSol = selSol;
        temp.usuVis = usuVis;
        temp.solucao = selSol.solucao;
        return new Voto(temp);
    }

    public void exibir(){
        System.out.println("\nExibindo o voto"+
                           "\nid:"+this.id+
                           "\ndata de cadastro: "+this.dtCadastro+
                           "\nsolução: "+this.solucao.getTitulo());
    }

    public static void excluir(Voto temp)
    {
        temp.id = -1;
        temp.dtCadastro = LocalDate.parse("1111-11-11");
    }

    Voto() {}

    Voto(Voto temp){
        this.id = System.currentTimeMillis();
        this.dtCadastro = LocalDate.now();
        this.selSol = temp.selSol;
        this.usuVis = temp.usuVis;
        this.solucao = temp.solucao;
    }
}
