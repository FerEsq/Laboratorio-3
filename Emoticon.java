
/* Nombre: Emoticon.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 01.11.2021 
 *            Modificado el 02.11.2021 */

public class Emoticon extends Post
{
    private String emoji;
    
    public Emoticon(String a, String f, String h, int l, String e)
    {
        super(a, f, h, l);
        emoji = e;
    }

    /** 
     * @return String
     */
    public String getPost()
    {
        return("(emoticón) " + emoji);
    }
}
