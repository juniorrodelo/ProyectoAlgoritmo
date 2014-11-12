package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Vender extends Cliente {

    String codigo, codigo_producto, producto, precio, Producto_escribir, producto_error = "";
    int total_venta;

    public String buscar_codigo() {
        codigo = JOptionPane.showInputDialog(null, " Digite El codigo del producto");
        String texto = "";

        try {
            FileReader lector = new FileReader("Archivos/ventas/productos.txt");

            BufferedReader contenido = new BufferedReader(lector);

            while ((texto = contenido.readLine()) != null) {
                if (texto.indexOf(codigo) != -1) {
                    String[] split = texto.split("-");
                    producto = split[0];
                    precio = split[1];
                    codigo_producto = split[2];
                    Producto_escribir = "Producto: " + split[0] + "Precio: " + split[1];
                    return Producto_escribir;
                }

            }
            return producto_error;
        } catch (Exception e) {
            System.out.println("Error al leer");
        }
        return null;
    }

    public void venta_por_codigo() {

        ncedula = JOptionPane.showInputDialog(null, " Digite El número de cédula Del Cliente");
        int totalventa = 0, precio_por_venta;

        String Numero_de_venta = "Venta número";

        File z = new File("Archivos/clientes/" + ncedula + ".txt");
        if (z.exists()) {

            String pregunta;

            do {

                if (buscar_codigo() == Producto_escribir) {
                    System.out.println("El producto es " + Producto_escribir);

                    precio_por_venta = Integer.parseInt(precio);
                    totalventa += precio_por_venta;

                    try {
                        File archivo = new File("Archivos/clientes/" + ncedula + ".txt");
                        FileWriter escribir = new FileWriter(archivo, true);
                        escribir.write(Producto_escribir + "\r\n");

                        escribir.close();
                    } catch (Exception e) {
                        System.out.println("Error al escribir");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Este Código no pertenece a Ningun Producto");
                }

                pregunta = JOptionPane.showInputDialog(null, " ¿Desea ingresar otro producto?");
            } while (pregunta.equalsIgnoreCase("Si"));

            try {
                File archivo = new File("Archivos/clientes/" + ncedula + ".txt");
                FileWriter escribir = new FileWriter(archivo, true);
                escribir.write("\r\n" + "El total de la Venta Fué: " + totalventa + "\r\n" + "\r\n");

                escribir.close();
            } catch (Exception e) {
                System.out.println("Error al escribir");
            }

            Cliente cp = new Cliente();
            cp.cambia_precio(totalventa, ncedula);

        } else {
            JOptionPane.showMessageDialog(null, " Este Número de Cédula No Está Registrado");
        }
    }

    public void venta_manual() {

        ncedula = JOptionPane.showInputDialog(null, " Digite El número de cédula Del Cliente");
        int totalventa = 0, precio_por_venta;

        String Numero_de_venta = "Venta número";

        File z = new File("Archivos/clientes/" + ncedula + ".txt");
        if (z.exists()) {

            String pregunta;

            do {

                JTextField name_product = new JTextField();
                JTextField precio_product = new JTextField();

                Object[] message = {
                    "Nombre del proucto:", name_product,
                    "precio:", precio_product};
                int option = JOptionPane.showConfirmDialog(null, message, "Venta Manual", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    array[0] = name_product.getText();
                    array[1] = precio_product.getText();
                }

                precio_por_venta = Integer.parseInt(array[1]);
                totalventa += precio_por_venta;

                try {
                    File archivo = new File("Archivos/clientes/" + ncedula + ".txt");
                    FileWriter escribir = new FileWriter(archivo, true);
                    escribir.write("Producto: " + array[0] + "Precio:" + array[1] + "\r\n");

                    escribir.close();
                } catch (Exception e) {
                    System.out.println("Error al escribir");
                }

            pregunta = JOptionPane.showInputDialog(null, " ¿Desea ingresar otro producto?");
        }
        while (pregunta.equalsIgnoreCase("Si"));

        try {
            File archivo = new File("Archivos/clientes/" + ncedula + ".txt");
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write("\r\n" + "El total de la Venta Fué: " + totalventa + "\r\n" + "\r\n");

            escribir.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }

        Cliente cp = new Cliente();
        cp.cambia_precio(totalventa, ncedula);

    }

    
        else {
            JOptionPane.showMessageDialog(null, " Este Número de Cédula No Está Registrado");
    }
}


    public void pagar() {

        String pago;
        int consig = 0;

        pago = JOptionPane.showInputDialog(null, "Cuanto desea Pagar? ");
        if ((pago != null) && !pago.equals("") && validador.isNum(pago)) {
            consig = Integer.parseInt(pago);
            if (consig > 0) {
                saldo -= consig;
            } else {
                JOptionPane.showMessageDialog(null, "Consigne una cantidad mayor a 0 !!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un valor a consignar!!!");
        }
    }

}
