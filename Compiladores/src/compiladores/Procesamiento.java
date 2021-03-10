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
public class Procesamiento 
{
    ArrayList<Character> caracteres;
    ArrayList<String> letras;
    
    public Procesamiento() 
    {
        caracteres = LectorArchivo.tokenizarDataSet();
        letras = new ArrayList<>();
        boolean punto = false;
        
        String aux= "";
        for(int x = 0; x < caracteres.size(); x++)
        {
            if((caracteres.get(x)>=97 && caracteres.get(x)<=122) || (caracteres.get(x)>=65 && caracteres.get(x)<=90))
            {
                aux = aux + caracteres.get(x);
            }
            else if((caracteres.get(x)>=48 && caracteres.get(x)<=57) || caracteres.get(x)==46)
            {
                if(caracteres.get(x)==46)
                {
                    if(punto == false)
                    {
                        aux = aux + caracteres.get(x);
                        punto = true;
                    }
                }
                else
                {
                    aux = aux + caracteres.get(x);
                }
            }
            else if(caracteres.get(x) == 32)
            {
                letras.add(aux);
                letras.add(" ");
                aux = "";
            }
            else if(caracteres.get(x)== 59)
            {
                letras.add(aux);
                letras.add(";");
                aux = ""; 
                punto = false;
            }
            else
            {
                letras.add(Character.toString(caracteres.get(x)));
            }
        }
    }
}
