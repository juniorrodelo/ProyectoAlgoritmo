package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cliente {

    String nombre, apellido, telefono, direccion, ncedula, sald; // Informacion Perosonal del Cliente
    String[] array = {"", "", "", "", ""};

    int saldo;

    public void agregar_cliente() { // Agrega un Cliente al Archivo de Texto

        String info = "*********************** INFORMACIÓN PERSONAL DEL CLIENTE ******************** /";
        String infoend = "*********************** INFORMACIÓN PERSONAL DEL CLIENTE (Fin) ******************** /";
        String estado = "*********************** ESTADO DEL CLIENTE ******************** /";
        String estadoend = "*********************** ESTADO DEL CLIENTE (Fin) ******************** /";
        String products = "*********************** COMPRAS QUE HA COMPRADO EL CLIENTE ******************** /";
        String productsend = "*********************** COMPRAS QUE HA COMPRADO EL CLIENTE (Fin) ******************** /";

        JTextField id = new JTextField();
        JTextField nombre = new JTextField();
        JTextField apellido = new JTextField();
        JTextField telefono = new JTextField();
        JTextField direccion = new JTextField();
        Object[] message = {
            "Número de Cédula:", id,
            "Nombres:", nombre,
            "Apellidos:", apellido,
            "Telefono:", telefono,
            "Dirección:", direccion,};
        int option = JOptionPane.showConfirmDialog(null, message, "Agregar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            array[0] = id.getText();
            array[1] = nombre.getText();
            array[2] = apellido.getText();
            array[3] = telefono.getText();
            array[4] = direccion.getText();
        }
        try {
            File archivo = new File("Archivos/clientes/" + array[0] + ".txt");
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(array[0] + " | " + array[1] + " | " + array[2] + " | " + array[3] + " | " + array[4] + " / " + "\r\n");
            escribir.write(estado + "\r\n" + "Saldo =" + saldo + "\r\n" + estadoend + "\r\n");
            escribir.write(products + "\r\n" + products + "\r\n");

            escribir.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    public void buscar_cliente() { //Busca el Cliente en el Archivo de Clientes

        ncedula = JOptionPane.showInputDialog(null, " Digite El número de cédula Del Cliente");

        File z = new File("Archivos/clientes/" + ncedula + ".txt");
        if (z.exists()) {

            String texto = "";

            try {
                FileReader lector = new FileReader("Archivos/clientes/" + ncedula + ".txt");

                BufferedReader contenido = new BufferedReader(lector);

                while ((texto = contenido.readLine()) != null) {
                    if (texto.indexOf("Saldo") != -1) {
                        String[] clientes = texto.split("=");
                        sald = clientes[1];
                        saldo = Integer.parseInt(sald);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al leer" + e);
            }

            if (saldo <= 0) {
                JOptionPane.showMessageDialog(null, " El Cliente Se Encuentra a Paz y Salvo ");
            } else {
                JOptionPane.showMessageDialog(null, "El Cliente Tiene una Deuda De " + saldo);
            }
        } else {
            JOptionPane.showMessageDialog(null, " Este Número de Cédula No Está Registrado");
        }

    }

    public void cambia_precio(int nuevo_Saldo, String identidad) { // Busca Información del cliente en el Archivo de Texto

        try {
            File file = new File("Archivos/clientes/" + identidad + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                if (line.indexOf("Saldo") != -1) {
                    String[] clientes = line.split("=");
                    sald = clientes[1];
                    saldo = Integer.parseInt(sald) + nuevo_Saldo;
                }
                oldtext += line + "\r\n";
            }
            reader.close();

            String newtext = oldtext.replaceAll("Saldo =" + sald, "Saldo =" + saldo);

            FileWriter writer = new FileWriter("Archivos/clientes/" + identidad + ".txt");
            writer.write(newtext);
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void Borrar_cliente() {
        ncedula = JOptionPane.showInputDialog(null, " Digite El número de cédula Del Cliente");

        File z = new File("Archivos/clientes/" + ncedula + ".txt");
        if (z.exists()) {
            try {
                File borrar = new File("Archivos/clientes/" + ncedula + ".txt");
                /*Borra el fichero*/
                borrar.delete();
                JOptionPane.showMessageDialog(null, " El Cliente ha sido eliminado con éxito ");

            } catch (Exception ex) {
                /*Captura un posible error y le imprime en pantalla*/
                System.out.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, " Este Cliente No Está Registrado");
        }

    }

}
