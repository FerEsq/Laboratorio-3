
/* Nombre: Archivo.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el 01.11.2021 
 *            Modificado el 02.11.2021 */

public abstract class Archivo 
{
    protected int kilobytes;
    protected String tipo;

    public Archivo(int kb)
    {
        this.kilobytes = kb;
    }

    public abstract String getInfo();
    public abstract String play();

    public String getTipo()
    { 
        return tipo;
    }
}
