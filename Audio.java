
/* Nombre: Audio.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 01.11.2021 
 *            Modificado el 02.11.2021 */

public class Audio extends Archivo 
{
    private double Srate;
    private int Bdepth;

    public Audio(int kb, Double s, int b) 
    {
        super(kb);
        this.tipo = "audio";
        Srate = s;
        Bdepth = b;
    }

    public String getInfo()
    {
        return(kilobytes + "KB, Samplerate: " + Srate + " kHz BitDepth: " + Bdepth);
    }

    public String play()
    { 
        return("Voy a sonar este audio con " + Srate + " kHz de sample rate y " + Bdepth + " de bit depth");
    }
    
}
