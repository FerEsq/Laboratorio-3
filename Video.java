
/* Nombre: Video.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 01.11.2021 
 *            Modificado el 02.11.2021 */

public class Video extends Archivo 
{
    private int Frate;

    public Video(int kb, int f) 
    {
        super(kb);
        this.tipo = "video";
        Frate = f;
    }

    /** 
     * @return String
     */
    public String getInfo()
    {
        return(kilobytes + "KB, FrameRate: " + Frate + " fps");
    }

    /** 
     * @return String
     */
    public String play()
    { 
        return("Voy a mostrar este video con " + Frate + " fps");
    }
    
}
