
/* Nombre: Texto.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 01.11.2021 
 *            Modificado el 02.11.2021 */

public class Texto extends Post
{
    private String mensaje;
    
    public Texto(String a, String f, String h, int l, String m)
    {
        super(a, f, h, l);
        mensaje = m;
    }
    
    /** 
     * @return String
     */
    public String getPost()
    {
        return("(texto) " + mensaje);
    }
}
