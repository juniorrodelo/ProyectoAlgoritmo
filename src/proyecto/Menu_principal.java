
package proyecto;

import javax.swing.JOptionPane;


public class Menu_principal {
    public void menu() {

        String ax;
        int op = 0;
        do {
            ax = JOptionPane.showInputDialog(null, "1. Realizar Venta \n 2. Realizar Pago \n 3. Consultar estado de Clientes \n 4. Ingresar Clientes \n 5. Otras Operaciones \n 6. Salir del programa");
            if (ax != null && validador.isNum(ax)) {
                op = Integer.parseInt(ax);
                switch (op) {
                    case 1:
                        menu_vender();
                        break;
                    case 2:
                        Vender pagar = new Vender();
                        pagar.pagar();
                        break;
                    case 3:
                        Cliente ec = new Cliente();
                        ec.buscar_cliente();
                        break;
                    case 4:
                        Cliente ic = new Cliente();
                        ic.agregar_cliente();
                        break;
                    case 5:
                        otras_operaciones();
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite una opcion valida....");
            }
        } while (op != 6);    
    }
    
    
     public void menu_vender() {
        String ax;
        int op = 0;
        do {
            ax = JOptionPane.showInputDialog(null, "1. Venta Por códigos(valor por unidad) \n 2. Venta Manual \n 3. Regresar al Menú Anterior");
            if (ax != null && validador.isNum(ax)) {
                op = Integer.parseInt(ax);
                switch (op) {
                    case 1:
                        Vender vpc = new Vender();
                        vpc.venta_por_codigo();
                        break;
                    case 2:
                        Vender vm = new Vender();
                        vm.venta_manual();
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite una opcion valida....");
            }
        } while (op != 3);
    }
     
     public void otras_operaciones() {
        String ax;
        int op = 0;
        do {
            ax = JOptionPane.showInputDialog(null, "1. Borrar historial de Ventas \n 2. Eliminar Cliente \n 3. Regresar al Menú Anterior");
            if (ax != null && validador.isNum(ax)) {
                op = Integer.parseInt(ax);
                switch (op) {
                    case 1:
                        Vender vpc = new Vender();
                        vpc.venta_por_codigo();
                        break;
                    case 2:
                        Cliente bc = new Cliente();
                        bc.Borrar_cliente();
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite una opcion valida....");
            }
        } while (op != 3);
    }
}
