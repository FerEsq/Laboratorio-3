
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
    private Vista vista = new Vista();

    protected String autor;
    protected String fecha;
    protected String hora;
    protected int likes;
    protected ArrayList<String> hashtags;
    protected ArrayList<String> comentarios;

    public Post(String a, String f, String h, int l)
    {
        this.autor = a;
        this.fecha = f;
        this.hora = h; 
        this.likes = l;
        hashtags = new ArrayList<String>();
        comentarios = new ArrayList<String>();
    }
    
    /** 
     * @return String
     */
    public abstract String getPost();

    /** 
     * @param c
     */
    public void setComentario(String c) 
    {
        if (c.length() <= 140) //máximo de cáracteres
        {
            comentarios.add(c);
        }
        else
        {
            vista.mostrarLimite();
        } 
    }
    
    /** 
     * @param hs
     */
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
    
    /** 
     * @return String
     */
    public String getAutor()
    {
        return autor;
    }

    /** 
     * @return String
     */
    public String getFecha()
    {
        return fecha;
    }
    
    /** 
     * @return String
     */
    public String getHora()
    {
        return hora;
    }
    
    /** 
     * @return int
     */
    public int getLikes()
    {
        return likes;
    }

    /** 
     * @return ArrayList<String>
     */
    public ArrayList<String> getHashtags()
    {
        return hashtags;
    }
    
    /** 
     * @return ArrayList<String>
     */
    public ArrayList<String> getComentarios()
    {
        return comentarios;
    }

}

