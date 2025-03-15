import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Selecao {
    private long id;
    public  long getId() {return this.id;}
    public  void setId(long receba) {this.id = receba;}

    private String titulo;
    public  String getTitulo() {return this.titulo;}
    public  void   setTitulo(String receba) {this.titulo = receba;}
    
    private String descricao;
    public  String getDescricao() {return this.descricao;}
    public  void   setDescricao(String receba) {this.descricao = receba;}
    
    private LocalDate dtInicio;
    public  LocalDate getDtInicio() {return this.dtInicio;}
    public  void setDtInicio(LocalDate receba) {this.dtInicio = receba;}
    
    private LocalDate dtFim;
    public  LocalDate getDtFim() {return this.dtFim;}
    public  void setDtFim(LocalDate receba) {this.dtFim = receba;}
    
    private Boolean isPublico;
    public  Boolean getIsPublico() {return this.isPublico;}
    public  void    setIsPublico(boolean receba) {this.isPublico = receba;}

    public UsuarioOrganizacao usuOrg;
    public SelecaoSolucao selSol;

                //////////////////////////////////
                // ^ atributos, gets e sets     //
                //------------------------------//
                // v outros métodos             //
                //////////////////////////////////

    public void exibir(boolean id, boolean  titulo, boolean descricao, boolean dtInicio, boolean dtFim, boolean isPublico)
    {
        System.out.println("\nExibindo a campanha mais recente\n");
        if (id)
            System.out.println("id: "+this.id);
        if (titulo)
            System.out.println("titulo: "+this.titulo);
        if (descricao)
            System.out.println("descrição: "+this.descricao);
        if (dtInicio)
            System.out.println("dataInício: "+this.dtInicio);
        if (dtFim)
            System.out.println("dataFim: "+this.dtFim);
        if (isPublico)
            System.out.println("isPúblico: "+this.isPublico);
    }

    public static Selecao cadastrar(){
        Scanner coleta = new Scanner(System.in); //esse scanner não deve ser fechado, ou então será necessário reabrir a entrada de dados em main
        Selecao temp = new Selecao();
        
        System.out.println("\n digite o titulo da campanha: ");
        temp.titulo = coleta.nextLine();

        System.out.println("\n digite a descrição da campanha: ");
        temp.descricao = coleta.nextLine();

        System.out.println("\n digite a data de início da campanha: ");
        try { temp.dtInicio = LocalDate.parse(coleta.nextLine()); }
        catch(DateTimeParseException e)
        {
            System.out.println("\nvalor inválido inserido");
            temp.dtInicio = LocalDate.parse("1111-11-11");
        }

        System.out.println("\n digite a data de finalização da campanha: ");
        
        try{ temp.dtFim = LocalDate.parse(coleta.nextLine()); }
        catch(Exception e)
        {
            System.out.println("\nvalor inválido inserido");
            temp.dtFim = LocalDate.parse("1111-11-11");
        }

        return new Selecao(temp);
    }

    public Selecao editar(Selecao temp){
        if(temp == null)
        {
            System.out.println("\nnão há seleção para ser editada");
            return temp;
        }

        Scanner coleta = new Scanner(System.in); //esse scanner não deve ser fechado, ou então será necessário reabrir a entrada de dados em main
        int sel = -1;

        System.out.println("\nSelecione o campo que você deseja editar\n"+
                           "1. Título\n"+
                           "2. Descrição\n"+
                           "3. Data de Início\n"+
                           "4. Data de Finalização\n"+
                           "Escolhido: ");
        try { sel = coleta.nextInt(); }
        catch(Exception e)
        {
            System.out.println("\nOpção inválida escolhida, os dados não serão alterados");
            return temp;
        }

        if(sel < 0 || sel > 4)
        {
            System.out.println("\nOpção inválida escolhida, os dados não serão alterados");
            return temp;
        }

        System.out.println("\nInsira a nova informação:");

        switch(sel)
        {
            case 1:
                temp.titulo = coleta.nextLine();
                break;

            case 2:
                temp.descricao = coleta.nextLine();
                break;

            case 3:
                try{ temp.dtInicio = LocalDate.parse(coleta.nextLine()); }
                catch(Exception e) { System.out.println("\nOpção inválida inserida, os dados não serão alterados");}
                break;

            case 4:
                try{ temp.dtInicio = LocalDate.parse(coleta.nextLine()); }
                catch(Exception e) { System.out.println("\nOpção inválida inserida, os dados não serão alterados");}
                break;
        }

        return temp;

    }

    public boolean publicar(){
        if(this.isPublico == true)
            return false; //não houve alteração
        this.isPublico = true;
        return true; //houve alteraçãoo
    }

    public boolean despublicar(){
        if(this.isPublico == false)
            return false; //não houve alteração
        this.isPublico = false;
        return true; //houve alteração
    }

    public void excluir(){
        this.id = -1;
        this.titulo = "";
        this.descricao = "";
        this.dtInicio = LocalDate.parse("1111-11-11");
        this.dtFim = LocalDate.parse("1111-11-11");
        this.isPublico = false;
    }

    Selecao(){} //favor manter

    Selecao(Selecao temp){
        this.id = System.currentTimeMillis();
        this.titulo = temp.titulo;
        this.descricao = temp.descricao;
        this.dtInicio = temp.dtInicio;
        this.dtFim = temp.dtFim;
        this.isPublico = false;
    }
}
