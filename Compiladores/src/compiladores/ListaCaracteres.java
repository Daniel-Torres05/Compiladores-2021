/*
Daniel Torres Montañez
Bryan Alexis Gaytan MArtinez
Compiladores
19/03/2021
 */
package compiladores;

import java.util.ArrayList;

/**
 *
 * @author dan00
 */
public class ListaCaracteres 
{
    ArrayList<Character> elementos;

    public ListaCaracteres()
    {
        elementos = new ArrayList<>();
    }
    
    public void agregarElemento(char elemento)
    {
        elementos.add(elemento);
    }
    
    public int numeroElementos()
    {
        return elementos.size();
    }
    
    public char extraerCaracter(int indice)
    {
        return elementos.get(indice);
    }
}
