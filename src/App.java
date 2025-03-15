import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean loop = true;

        UsuarioVisitante usualrio = null;
        Solucao apagar_sys32 = null;
        Selecao seleSena = null;
        SelecaoSolucao objeto = null;
        Comentario comm = null;
        Voto volta = null;

        while(loop)
        {
            Scanner entrada = new Scanner(System.in);
            System.out.print("\nBem vindo ao sistema, escolha uma opção: \n"+
                    "1.  Solução: Cadastrar\n"+
                    "--------------------------------\n"+
                    "2.  Campanha: Criar\n"+
                    "3.  Campanha: Selecionar solução\n"+
                    "4.  Campanha: Exibir\n"+
                    "5.  Campanha: Publicar\n"+
                    "6.  Campanha: Despublicar\n"+
                    "7.  Campanha: Excluir\n"+
                    "--------------------------------\n"+
                    "8.  Comentário: Escrever\n"+
                    "9.  Comentário: Exibir\n"+
                    "10. Comentário: Excluir\n"+
                    "--------------------------------\n"+
                    "11. Voto: Votar\n"+
                    "12. Voto: Exibir\n"+
                    "13. Voto: Excluir\n"+
                    "--------------------------------\n"+
                    "0.  Sair\n"+
                    "escolhido: ");

            int sel;
            try { sel = entrada.nextInt(); }
            catch(Exception e){ sel = -1; }
            
            entrada.nextLine();

            switch (sel)
            {
                case 1: //Solução: Cadastrar
                    System.out.println("\nInsira o título da solução");
                    String texto = entrada.nextLine();
                    apagar_sys32 = new Solucao();
                    apagar_sys32.setTitulo(texto);
                    break;

                case 2: //Campanha: Criar
                    if (apagar_sys32 == null)
                    {
                        System.out.println("\nNenhuma solução cadastrada");
                        break;
                    }

                    seleSena = Selecao.cadastrar();
                    System.out.println("\nCampanha criada com sucesso");
                    break;
                
                case 3: //Campanha: Selecionar solução
                    if(seleSena == null || apagar_sys32 == null)
                    {
                        System.out.println("\nNenhuma campanha cadastrada");
                        break;
                    }

                    objeto = new SelecaoSolucao(seleSena, apagar_sys32);
                    System.out.println("\nSolução selecionada para a campanha mais recente");
                    break;

                case 4: //Campanha: Exibir
                    if(objeto == null || objeto.solucao == null || objeto.selecao == null)
                    {
                        System.out.println("\nNão existem campanhas");
                        break;
                    }
                    objeto.selecao.exibir(true, true, true, true, true, true);
                    break;

                case 5: //Campanha: Publicar
                    if(objeto == null || objeto.selecao == null)
                    {
                        System.out.println("\nNão existem campanhas");
                        break;
                    }
                    objeto.selecao.publicar();
                    System.out.println("\nCampanha publicada");
                    break;

                case 6: //Campanha: Despublicar
                    if(objeto == null || objeto.selecao == null)
                    {
                        System.out.println("\nNão existem campanhas");
                        break;
                    }
                    objeto.selecao.despublicar();
                    System.out.println("\nCampanha despublicada");
                    break;
                    
                case 7: //Campanha: Excluir
                    if(objeto == null)
                        break;
                    SelecaoSolucao.excluir(objeto);
                    objeto = null;
                    //seleSena = null;
                    //apagar_sys32 = null;
                    System.out.println("\nA campanha foi excluída com sucesso");
                    break;

                case 8: //Comentário: Escrever
                    if(objeto == null)
                    {
                        System.out.println("\nNão há problemas selecionados");
                        break;
                    }
                    comm = Comentario.escrever(objeto);
                    break;

                case 9: //Comentário: Exibir
                    if(comm == null)
                    {
                        System.out.println("\nNão há comentários");
                        break;
                    }
                    comm.exibir(true, true, true);
                    break;

                case 10: //Comentário: Excluir
                    if(comm == null)
                        break;
                    Comentario.excluir(comm);
                    comm = null;
                    System.out.println("\nO comentário foi excluído");
                    break;

                case 11: //Voto: Votar
                    if(objeto == null || seleSena.getIsPublico() == false)
                    {
                        System.out.println("\nNão há seleções para votar");
                        break;
                    }
                    volta = Voto.votar(objeto, usualrio);
                    System.out.println("\nVoto atribuído");
                    break;

                case 12: //Voto: Exibir
                    if(objeto == null || seleSena == null || volta == null)
                    {
                        System.out.println("\nNão há votos");
                        break;
                    }
                    volta.exibir();
                    break;

                case 13: //Voto: Excluir
                    if(volta == null)
                        break;
                    Voto.excluir(volta);
                    volta = null;
                    break;

                case 0:
                    loop = false;

                default:
                    System.out.println("\nbazinga");
                    break;
            }

            if(loop==false)
                entrada.close();
        }
    }
}