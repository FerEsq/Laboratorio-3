
/* Nombre: Driver.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 02.11.2021 */

//Import
import java.util.Scanner;
import java.util.ArrayList;  
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
import java.util.function.Predicate;
import javax.lang.model.util.ElementScanner14;

class Driver
{	
	/** 
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Propiedades
		Vista vista = new Vista();
        ArrayList<Post> posts = new ArrayList<Post>();
        ArrayList<Post> filtrofecha = new ArrayList<Post>();
        ArrayList<Post> filtrohashtag = new ArrayList<Post>();

        int opcion = 0;
        int tipo = 0;
        boolean hashtags = false;
        int max = 140;
        int contador = -1;
        String cadenaH = "";
		
        //Mensajes de bienvenida	
		vista.mostrarInicio();
     
        try
        {
            while (opcion != 8)
            {
                //Menú
                opcion = vista.mostrarMenu();

                // ---------------------------------------- Opción 1 --------------------------------------    
                if (opcion == 1) //ingresar post
                {
                    boolean b = true;
                    while (b)
                    {
                        tipo = vista.menuTipo();
                        //Pedir datos predeterminados
                        String a = vista.pedirString("el autor del Post");
                        String f = vista.pedirString("la fecha de publicación (en formato dd/mm/yyyy)");
                        String h = vista.pedirString("la hora de publicación (en formato hh:mm)");
                        int l = vista.pedirInt("la cantidad de likes del Post");

                        int hash = vista.menuHashtags();
                        if (hash == 1)
                        {
                            hashtags = true;
                            cadenaH = vista.pedirString("los hashtags separados unicamente por una coma (#lab,#compu,#progra...)");
                        }
                        else if (hash > 2 || hash < 1)
                        {
                            vista.mostrarError();
                        }

                        //Pedir datos específicos
                        if (tipo == 1) //texto
                        {
                            String m = vista.pedirString("el texto del Post (máximo de 140 cáracteres)");
                            if (m.length() <= max)
                            {
                                posts.add(new Texto(a, f, h, l, m));
                                contador++;
                                b = false;
                            }
                            else
                            {
                                vista.mostrarLimite();
                            }
                        }

                        if (tipo == 2) //multimedia
                        {
                            int arc = vista.menuArchivo();
                            if (arc == 1) //imagen
                            {
                                String lk = vista.pedirString("el link de la imagen");
                                int kb = vista.pedirInt("el tamaño de la imagen en kilobytes");

                                String ft = vista.pedirString("el formato de la imagen (png, gif, jpeg, etc...)");
                                int r = vista.pedirInt("la resolución de la imagen en megapíxeles");
                                Imagen i = new Imagen(kb, ft, r);
                                posts.add(new Multimedia(a, f, h, l, i, lk));
                                contador++;
                                b = false;
                            }
                            if (arc == 2) //audio
                            {
                                String lk = vista.pedirString("el link del audio");
                                int kb = vista.pedirInt("el tamaño del audio en kilobytes");

                                String str = vista.pedirString("el sample rate del audio (ingrese solamente el número)");
                                double s = Double.parseDouble(str);
                                int bit = vista.pedirInt("el bit depth del audio");
                                Audio ad = new Audio(kb, s, bit);
                                posts.add(new Multimedia(a, f, h, l, ad, lk));
                                contador++;
                                b = false;
                            }
                            if (arc == 3) //video
                            {
                                String lk = vista.pedirString("el link del video");
                                int kb = vista.pedirInt("el tamaño del video en kilobytes");

                                int fr = vista.pedirInt("el frame rate del video");
                                Video v = new Video(kb, fr);
                                posts.add(new Multimedia(a, f, h, l, v, lk));
                                contador++;
                                b = false;
                            }
                            else if (arc > 3 || arc < 1)
                            {
                                vista.mostrarError();
                            }
                        } //fin multimedia

                        if (tipo == 3) //emoticon
                        {
                            String e = vista.pedirString("el emoticón del Post");
                            posts.add(new Emoticon(a, f, h, l, e));
                            contador++;
                            b = false;
                        }

                        else if (tipo > 3 || tipo < 1)
                        {
                            vista.mostrarError();
                        }

                        if (hashtags == true) //agregar hashtags al post
                        {
                            posts.get(contador).setHashtags(cadenaH);
                            hashtags = false;
                        }

                        vista.vistaPrevia();
                        vista.separar();
                        vista.mostrarPost(posts.get(contador));
                        vista.separar();
                    }
                }

                // ---------------------------------------- Opción 2 --------------------------------------    
                else if (opcion == 2) //darle like a post
                {
                    if (posts.isEmpty() == false)
                    {
                        vista.mostrarEncabezados(posts);
                        int pos = vista.pedirInt("el post al cual darle like");
                        posts.get(pos).setLikes();
                    }
                    else
                    {
                        vista.mostrarSinPosts();
                    }
                }

                // ---------------------------------------- Opción 3 --------------------------------------    
                else if (opcion == 3) //comentar post
                {
                    if (posts.isEmpty() == false)
                    {
                        vista.mostrarEncabezados(posts);
                        int pos = vista.pedirInt("el post a comentar");
                        String cm = vista.pedirString("el comentario (máximo de 140 cáracteres)");
                        posts.get(pos).setComentario(cm);
                    }
                    else
                    {
                        vista.mostrarSinPosts();
                    }
                }

                // ---------------------------------------- Opción 4 --------------------------------------    
                else if (opcion == 4) //filtrar por fecha
                {
                    if (posts.isEmpty() == false)
                    {
                       String ff = vista.pedirString("una fecha de pulicación (dd/mm/yyyy)");
                       for (int i = 0; i < posts.size(); i++)
                        {
                            if (posts.get(i).getFecha().equals(ff))
                            {
                                filtrofecha.add(posts.get(i));
                            }
                        }

                        if (filtrofecha.isEmpty() == false) //validar si encontró
                        {
                            vista.mostrarEncabezados(filtrofecha); //mostrar
                        }
                        else
                        {
                            vista.mostrarSinFiltro();
                        }
                    }
                    else
                    {
                        vista.mostrarSinPosts();
                    }
                }

                // ---------------------------------------- Opción 5 --------------------------------------    
                else if (opcion == 5) //filtrar por hashtag
                {
                    if (posts.isEmpty() == false)
                    {
                        String fh = vista.pedirString("un hashtag (#xxxx)");
                        for (int i = 0; i < posts.size(); i++)
                        {
                            for (int j = 0; j < posts.get(i).getHashtags().size(); j++)
                            {
                                if (posts.get(i).getHashtags().get(j).equals(fh))
                                {
                                    filtrohashtag.add(posts.get(i));
                                }
                            }
                        }

                        if (filtrohashtag.isEmpty() == false) //validar si encontró
                        {
                            vista.mostrarEncabezados(filtrohashtag); //se muestran
                        }
                        else
                        {
                            vista.mostrarSinFiltro();
                        }
                    }
                    else
                    {
                        vista.mostrarSinPosts();
                    }
                }

                // ---------------------------------------- Opción 6 --------------------------------------    
                else if (opcion == 6) //mostrar post filtrado
                {
                    int filter = vista.menuFiltros();

                    if (filter == 1) //fecha
                    {
                        if (filtrofecha.isEmpty() == false)
                        {
                            vista.mostrarEncabezados(filtrofecha);
                            int pf = vista.pedirInt("el post a mostrar");
                            vista.salto();
                            vista.separar();
                            vista.mostrarPost(filtrofecha.get(pf));
                            vista.separar();
                        }
                        else
                        {
                            vista.mostrarSinFiltro();
                        }
                    }
                    if (filter == 2) //hashtag
                    {
                        if (filtrohashtag.isEmpty() == false)
                        {
                            vista.mostrarEncabezados(filtrohashtag);
                            int pf = vista.pedirInt("el post a mostrar");
                            vista.salto();
                            vista.separar();
                            vista.mostrarPost(filtrohashtag.get(pf));
                            vista.separar();
                        }
                        else
                        {
                            vista.mostrarSinFiltro();
                        }
                    }
                }

                // ---------------------------------------- Opción 7 --------------------------------------    
                else if (opcion == 7) //mostrar todos los posts
                {
                    if (posts.isEmpty() == false)
                    {
                        vista.salto();
                        vista.separar();
                        for (int i = 0; i < posts.size(); i++)
                        {
                            vista.mostrarPost(posts.get(i));
                            vista.separar();
                        }
                    }
                    else
                    {
                        vista.mostrarSinPosts();
                    }
                }

                // ---------------------------------------- Opción 8 -------------------------------------- 
                else if (opcion == 8) //salir
                {
                    vista.mostrarDespedida();
                }

                // ---------------------------------------- Opción ? --------------------------------------    
                else if (opcion > 8 || opcion < 0)
                {
                    vista.mostrarError();
                }
            }
        }
        catch (InputMismatchException | IndexOutOfBoundsException e)
        {
            vista.mostrarError();
        }
	}
}