
/* Nombre: Multimedia.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 01.11.2021 
 *            Modificado el 02.11.2021 */

public class Multimedia extends Post
{
    private Archivo archivo;
    private String link;

    public Multimedia(String a, String f, String h, int l, Archivo ac, String lk) 
    {
        super(a, f, h, l);
        archivo = ac;
        link = lk;
    }

    public String getPost()
    {
        return("(" + archivo.getTipo() + ") " + link + 
                "\n" + archivo.getInfo() + 
                "\n" +  archivo.play());
    }

    public Archivo getArchivo()
    { 
        return archivo;
    }
    
}
