
/* Nombre: Post.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 01.11.2021 
 *            Modificado el 02.11.2021 */

//Import
import java.lang.annotation.Retention;
import java.util.ArrayList;  
import java.util.List;
import java.util.Arrays;

public abstract class Post
{
    Vista vista = new Vista();

    protected String autor;
    protected String fecha;
    protected String hora;
    protected int likes;
    protected int maximo;
    protected ArrayList<String> hashtags;
    protected ArrayList<String> comentarios;

    public Post(String a, String f, String h, int l)
    {
        this.autor = a;
        this.fecha = f;
        this.hora = h; 
        this.likes = l;
        maximo = 140;
        hashtags = new ArrayList<String>();
        comentarios = new ArrayList<String>();
    }

    public abstract String getPost();

    public void setComentario(String c) 
    {
        if (c.length() <= maximo)
        {
            comentarios.add(c);
        }
        else
        {
            vista.mostrarError();
        } 
    }

    public void setHashtags(String hs)
    {
        String str[] = hs.split(",");
        List<String> ls = Arrays.asList(str);
        hashtags = new ArrayList<String>(ls);
    }

    public void setLikes() 
    {
        likes++;
    }

    public String getAutor()
    {
        return autor;
    }

    public String getFecha()
    {
        return fecha;
    }

    public String getHora()
    {
        return hora;
    }

    public int getLikes()
    {
        return likes;
    }

    public int getMaximo()
    {
        return maximo;
    }

    public ArrayList<String> getHashtags()
    {
        return hashtags;
    }

    public ArrayList<String> getComentarios()
    {
        return comentarios;
    }

}

