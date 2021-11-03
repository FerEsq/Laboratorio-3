
/* Nombre: Vista.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 02.11.2021 */

//Import
import java.util.Scanner;
import java.util.ArrayList;  

public class Vista 
{
    Scanner scan = new Scanner(System.in);

    public Vista()
    {  

    }

    //Mensaje de bienvenida
    public void mostrarInicio()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("        ✦ Bienvenid@ la red social “QueOndaMano” ✦ \n");
		System.out.println(" - Publica texto, multimedia y emoticonos");
        System.out.println(" - Dale like, comenta y filtra tus posts favoritos!");
        System.out.println(" * Si el programa parece congelarse, presiona enter de nuevo");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de despedida
    public void mostrarDespedida()
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Muchas gracias por utilizar QueOndaMano!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    //Mensaje de error de opción
    public void mostrarError()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Esa opción no existe, intente de nuevo");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de error limite de cáracteres
    public void mostrarLimite()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("El post tiene más de 140 cáracteres, intente de nuevo");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de error no hay post
    public void mostrarSinPosts()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("No se ha ingresado ningún post, intente de nuevo");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    //Mensaje de error no hay post
    public void mostrarSinFiltro()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("No hay ningún post que corresponda al filtro");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

     /** 
      * @return int
      */
    public int mostrarMenu()
    {
        int op = 0;
        System.out.println("\n¿Que opción desea ejecutar? (ingrese solo el número)");	
        System.out.println("1. Publicar Post");
        System.out.println("2. Dar like a post existente");
        System.out.println("3. Comentar post existente");
        System.out.println("4. Filtrar posts por fecha");
        System.out.println("5. Filtrar posts por hashtag");
        System.out.println("6. Reproducir/Ver post filtrado");
        System.out.println("7. Ver todos los posts");
        System.out.println("8. Cerrar Sesión");
 
        op = scan.nextInt();
        return op;
    }

    /** 
      * @return int
      */
    public int pedirInt(String d)
    {
        int op = 0;
        System.out.println("\nIngrese " + d + " (ingrese solo el número)");	
        op = scan.nextInt();
        return op;
    }

    /** 
     * @return String
     */
    public String pedirString(String d)
    {
        scan.nextLine();
        System.out.println("\nIngrese " + d);
        return scan.nextLine();
    }

    /** 
      * @return int
      */
    public int menuHashtags()
    {
        int op = 0;
        System.out.println("\n¿Desea incluir hashtags en su post? (ingrese solo el número)");	
        System.out.println("1. Sí");
        System.out.println("2. No");
   
        op = scan.nextInt();
        return op;
    }

    /** 
      * @return int
      */
    public int menuTipo()
    {
        int op = 0;
        System.out.println("\n¿Que tipo de post quiere publicar? (ingrese solo el número)");	
        System.out.println("1. Texto");
        System.out.println("2. Multimedia");
        System.out.println("3. Emoticón");
   
        op = scan.nextInt();
        return op;
    }

      /** 
      * @return int
      */
    public int menuArchivo()
    {
        int op = 0;
        System.out.println("\n¿Que archivo quiere subir? (ingrese solo el número)");	
        System.out.println("1. Imagen");
        System.out.println("2. Audio");
        System.out.println("3. Vídeo");
   
        op = scan.nextInt();
        return op;
    }

    /** 
      * @return int
      */
    public int menuFiltros()
    {
        int op = 0;
        System.out.println("\n¿Sobre cual filtro desea visualizar el post? (ingrese solo el número)");	
        System.out.println("1. Fecha");
        System.out.println("2. Hashtag");
   
        op = scan.nextInt();
        return op;
    }
    
    /** 
     * @param p
     */
    public void mostrarPost(Post p)
    {
        System.out.println(p.getAutor() + ". " + p.getFecha() + ":" + p.getHora() + " likes:" + p.getLikes());

        if (p.getHashtags().isEmpty() == false) //si hay hashtags
        {
            String cadena = "";
            for (int i = 0; i < p.getHashtags().size(); i++)
            {
                cadena += p.getHashtags().get(i) + " ";    
            }
            System.out.println(cadena);
        }

        System.out.println(p.getPost());

        if (p.getComentarios().isEmpty() == false) //si hay comentarios
        {
            System.out.println("\n---> comentarios:");
            for (int i = 0; i < p.getComentarios().size(); i++)
            {
                System.out.println("("+ (i+1) + ") "+ p.getComentarios().get(i));
            }
        }
    }
    
    /** 
     * @param ps
     */
    public void mostrarEncabezados(ArrayList<Post> ps)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < ps.size(); i++)
        {
            System.out.println("("+ i + ") " + "Post publicado por: " + ps.get(i).getAutor() 
                                + ", el " + ps.get(i).getFecha() + " a las " + ps.get(i).getHora());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void separar()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void vistaPrevia()
    {
        System.out.println("\n☛ Vista Previa del post:");
    }

    public void salto()
    {
        System.out.println("");
    }

}
