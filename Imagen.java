
/* Nombre: Imagen.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 01.11.2021 
 *            Modificado el 02.11.2021 */

public class Imagen extends Archivo 
{
    private String formato;
    private int resolucion;

    public Imagen(int kb, String f, int r) 
    {
        super(kb);
        this.tipo = "imagen";
        formato = f;
        resolucion = r;
    }

    public String getInfo()
    {
        return(kilobytes + " KB, " + formato + ", " + resolucion + " Megapíxeles");
    }

    public String play()
    { 
        return("Estoy mostrando esta imagen con " + resolucion + " megapíxeles de resolución");
    }
    
}
