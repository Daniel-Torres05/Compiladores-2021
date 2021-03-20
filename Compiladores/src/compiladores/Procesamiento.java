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
public class Procesamiento 
{
    ArrayList<Character> caracteres;
    ArrayList<String> palabras;
    
    public Procesamiento() 
    {
        caracteres = LectorArchivo.tokenizarDataSet();
        palabras = new ArrayList<>();
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
                if(aux != "")
                {
                    palabras.add(aux);
                    aux = "";
                }
            }
            else if(caracteres.get(x)== 59)
            {
                if(aux != "")
                {
                   palabras.add(aux); 
                }
                palabras.add(";");
                aux = ""; 
                punto = false;
            }
            else
            {
                if(aux != "")
                {
                    palabras.add(aux);
                    aux = "";
                }
                switch(caracteres.get(x))
                {
                    case '+':
                    {
                        if(caracteres.get(x+1) == '+')
                        {
                            palabras.add("++");
                            x++;
                        }
                        else if(caracteres.get(x+1) == '=')
                        {
                            palabras.add("+=");
                            x++;
                        }
                        else
                        {
                            palabras.add(Character.toString(caracteres.get(x)));
                        }
                        break;
                    }
                    case '-':
                    {
                        if(caracteres.get(x+1) == '-')
                        {
                            palabras.add("--");
                            x++;
                        }
                        else
                        {
                            palabras.add(Character.toString(caracteres.get(x)));
                        }
                        break;
                    }
                    case '=':
                    {
                        if(caracteres.get(x+1) == '=')
                        {
                            palabras.add("==");
                            x++;
                        }
                        else
                        {
                            palabras.add(Character.toString(caracteres.get(x)));
                        }
                        break;
                    }
                    case '<':
                    {
                        if(caracteres.get(x+1) == '=')
                        {
                            palabras.add("<=");
                            x++;
                        }
                        else
                        {
                            palabras.add(Character.toString(caracteres.get(x)));
                        }
                        break;
                    }
                    case '>':
                    {
                        if(caracteres.get(x+1) == '=')
                        {
                            palabras.add(">=");
                            x++;
                        }
                        else
                        {
                            palabras.add(Character.toString(caracteres.get(x)));
                        }
                        break;
                    }
                    case '!':
                    {
                        if(caracteres.get(x+1) == '=')
                        {
                            palabras.add("!=");
                            x++;
                        }
                        else
                        {
                            palabras.add(Character.toString(caracteres.get(x)));
                        }
                        break;
                    }
                    case '"':
                    {
                        if(aux != "")
                        {
                            palabras.add(aux);
                            aux = "";
                        }
                        aux = Character.toString(caracteres.get(x));
                        x++;
                        while(caracteres.get(x) != '"')
                        {
                            aux += Character.toString(caracteres.get(x));
                            x++;
                        }
                        aux += Character.toString(caracteres.get(x));
                        palabras.add(aux);
                        aux = "";
                        break;
                    }
                    default:
                    {
                        switch (caracteres.get(x))
                        {
                            case '{':
                            case '}':
                            case '(':
                            case ')':
                            case '^':
                            case ',':
                            case ':':
                            case '[':
                            case ']':
                            case '*':
                            case '/':
                            case '|':
                            case '&':
                            {
                                palabras.add(Character.toString(caracteres.get(x)));
                                break;
                            }
                            default:
                            {
                                System.out.println("ERROR CARACTER ERRONEO");
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
