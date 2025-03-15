import java.time.LocalDate;
import java.util.Scanner;

/************************************************************************
 * Essa classe armazena datas na classe LocalDate.
 * As datas são coletadas como Strings e convertidas para LocalDate
utilizando LocalDate.parse("SuaString");
 * As datas são armazenadas no formato ISO_LOCAL_DATE (AAAA-MM-DD).
Ex: 2024-12-31.
 * É recomendado atentar-se à formatação dos dados, pois a sua mudança
pode ativar a exceção "DateTimeParseException"
************************************************************************/

public class Comentario {
    private long id;
    public  long getId() { return this.id; }
    public  void setId() { this.id = System.currentTimeMillis(); }
    
    private String descricao;
    public  String getDescricao() { return this.descricao; }
    public  void   setDescricao(String descricao) { this.descricao = descricao; }
   
    private LocalDate dtCadastro;
    public  LocalDate getDtCadastro() { return this.dtCadastro;}
    public  void      setDtCadastro(LocalDate dtCadastro) { this.dtCadastro = dtCadastro; }

    public UsuarioVisitante usuVis;
    public SelecaoSolucao selSol;
    public Solucao solucao;

                //////////////////////////////////
                // ^ atributos, gets e sets     //
                //------------------------------//
                // v outros métodos             //
                //////////////////////////////////
	
	public static Comentario escrever(SelecaoSolucao selSol)
    {
        Comentario temp = new Comentario();
        Scanner entrada = new Scanner(System.in); //esse scanner não deve ser fechado, ou então será necessário reabrir a entrada de dados em main

        System.out.println("\nInsira a descrição do comentario");
        temp.descricao = entrada.nextLine();
        temp.dtCadastro = LocalDate.now();
        temp.selSol = selSol;
        
		return new Comentario(temp);
	}

    public void exibir(boolean id, boolean descricao, boolean dtCadastro){
        System.out.println("\nExibindo comentário:");
        if(id)
            System.out.println("\nid: "+ this.id);
        if(descricao)
            System.out.println("\ndescrição: "+ this.descricao);
        if(dtCadastro)
            System.out.println("\nid: "+ this.dtCadastro);

    }
		
	public static void excluir(Comentario temp){
		temp.id = -1;
        temp.descricao = "";
        temp.dtCadastro = null;
        temp.usuVis = null;
        temp.selSol = null;
        temp.solucao = null;
    }

    Comentario() {} //favor manter
	
    Comentario(Comentario temp) {
        setId();
        setDescricao(temp.descricao);
        setDtCadastro(temp.dtCadastro);
        this.selSol = temp.selSol;
        this.usuVis = null;
        this.solucao = temp.selSol.solucao;
    }
}

