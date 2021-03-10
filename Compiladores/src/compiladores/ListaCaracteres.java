/*
Analizador Lexico(primera parte)
Daniel Torres Montañez
Bryan Alexis Gaytan 
Compiladores
 */
package compiladores;

import java.util.ArrayList;

/**
 *
 * @author dan00
 */
public class ListaCaracteres 
{
    ArrayList<Character> elem;

    public ListaCaracteres()
    {
        elem = new ArrayList<>();
    }
    
    public void agregarElemento(char elemento)
    {
        elem.add(elemento);
    }
    
    public int numeroElementos()
    {
        return elem.size();
    }
    
    public char extraerCaracter(int indice)
    {
        return elem.get(indice);
    }
}
