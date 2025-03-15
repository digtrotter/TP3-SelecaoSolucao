public class Solucao {
    private final long id;

    private String titulo;
    public  String getTitulo() {return this.titulo;}
    public  void   setTitulo(String titulo) { this.titulo = titulo;}

    public void exibir(boolean id, boolean  titulo){
        String retorno = "\n";
        if (id)
            retorno = retorno+this.id+"\n";
        if (titulo)
            retorno = retorno+this.titulo+"\n";
        System.out.println(retorno);
    }
    
    Solucao() { this.id = System.currentTimeMillis(); }
}

