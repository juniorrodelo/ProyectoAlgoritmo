
package pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class escribir {
    String saludo = "Hola";
    
    public void escribir(){
        try {
            File archivo = new File("texto.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(saludo);
            escribir.close();
        } 
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
    
    public void leer(){
        String texto = "";

        try {
            FileReader lector = new FileReader("texto.txt");

            BufferedReader contenido = new BufferedReader(lector);

            while ((texto = contenido.readLine()) != null) {
                System.out.println(texto);
            }
        } 
        catch (Exception e) {
            System.out.println("Error al leer");
        }
    }
}
