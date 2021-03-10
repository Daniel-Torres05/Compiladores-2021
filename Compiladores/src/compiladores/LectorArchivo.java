/*
Analizador Lexico(primera parte)
Daniel Torres Montañez
Bryan Alexis Gaytan 
Compiladores
 */
package compiladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author dan00
 */
public class LectorArchivo 
{
    public static ArrayList<Character> tokenizarDataSet()
    {
        // conjunto de patrones del data set
        ArrayList<Character> instancias = new ArrayList<>();

        String texto, aux;

        LinkedList<String> lista = new LinkedList();

        try 
        {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("./"));
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null); 
            {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null)
                {
                    texto = aux;
                    lista.add(texto);
                }
                
                lee.close();
                
                for (int i = 0; i < lista.size(); i++)
                {
                    for(int y = 0; y < lista.get(i).length(); y++)
                    {
                        instancias.add(lista.get(i).charAt(y));
                    } 
                    instancias.add(';');
                }
            }
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);

        }
        return instancias;
    }
    
    public static void mostrarLineas(ArrayList<ListaCaracteres> instancias)
    {
        System.out.println("-----Inicio de codigo guardado-----");
        for(int x = 0; x < instancias.size(); x++)
        {
            for(int y = 0; y < instancias.get(x).numeroElementos(); y++)
            {
                System.out.print(instancias.get(x).extraerCaracter(y));
            }
            System.out.println("");
        }
        System.out.println("*****Fin de codigo guardado*****");
    }
}
