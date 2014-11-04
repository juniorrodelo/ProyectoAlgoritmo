package pruebas;

import javax.swing.JOptionPane;

public class procesos {

    int saldo = 90000;
    String clave = "1234";

    public void menu() {

        String ax;
        int op = 0;
        do {
            ax = JOptionPane.showInputDialog(null, "1. Saldo \n 2. Consignar \n 3. Retirar \n 4. Cambiar Clave \n 5. Salir");
            if (ax != null && validador.isNum(ax)) {
                op = Integer.parseInt(ax);
                switch (op) {
                    case 1:
                        verSal();
                        break;
                    case 2:
                        consig();
                        break;
                    case 3:
                        retirar();
                        break;
                    case 4:
                        chanPass();
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite una opcion valida....");
            }
        } while (op != 5);    
    }

    
    
    
    
    
    
    
    
    
    
    public void verSal() {
        JOptionPane.showMessageDialog(null, "Tu saldo a la fecha es: " + saldo);
    }

    public void consig() {
        String ax;
        int consig = 0;

        ax = JOptionPane.showInputDialog(null, "Cuanto desea consginar? ");
        if ((ax != null) && !ax.equals("") && validador.isNum(ax)) {
            consig = Integer.parseInt(ax);
            if (consig > 0) {
                saldo += consig;
            } else {
                JOptionPane.showMessageDialog(null, "Consigne una cantidad mayor a 0 !!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un valor a consignar!!!");
        }
    }

    public void retirar() {

        String ax;
        ax = JOptionPane.showInputDialog(null, "Digite su clave.... ");

        if (ax == null) { 

        } else {
            if (!ax.equals("")) {
                if (ax.equals(clave)) {
                    ax = JOptionPane.showInputDialog(null, "a. 5000 \n b. 10.000 \n c. 20.000 \n d. 50.000\n e. 100.000\n f. Ingresar valor",
                            "CANTIDAD A RETIRAR", JOptionPane.INFORMATION_MESSAGE);
                    if (ax != null) {
                        if (!ax.equals("")) {
                            switch (ax) {
                                case "a":
                                    if ((saldo - 5000 >= 10000)) {
                                        saldo -= 5000;
                                    }
                                    break;
                                case "b":
                                    if ((saldo - 10000 >= 10000)) {
                                        saldo -= 10000;
                                    }
                                    break;
                                case "c":
                                    if ((saldo - 20000 >= 10000)) {
                                        saldo -= 20000;
                                    }
                                    break;
                                case "d":
                                    if ((saldo - 50000 >= 10000)) {
                                        saldo -= 50000;
                                    }
                                    break;
                                case "e":
                                    if ((saldo - 100000 >= 10000)) {
                                        saldo -= 100000;
                                    }
                                    break;
                                case "f":
                                    ax = JOptionPane.showInputDialog(null, "Digite el valor a retirar: ");
                                    if (!ax.equals("") && validador.isNum(ax) && (Integer.parseInt(ax) > 0) && (saldo - Integer.parseInt(ax) >= 10000)) {
                                        saldo -= Integer.parseInt(ax);
                                    }
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Digite una opcion valida", "OPCION INCORRECTA", JOptionPane.ERROR_MESSAGE);
                                    break;
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La clave ingresada no coincide....");
                }
            }
        }
    }

    public void chanPass() {

        String ax, cl;

        ax = JOptionPane.showInputDialog(null, "Digite su clave....");
        if (ax != null) {
            if (!ax.equals("")) {
                if (ax.equals(clave)) {
                    cl = JOptionPane.showInputDialog(null, "Digite su nueva clave");
                    if (cl != null) {
                        if (cl.length() > 3) {
                            ax = null;
                            ax = "Su anterior clave es:" + clave;
                            clave = cl;
                            ax += "\nSu nueva clave es: " + clave;
                            JOptionPane.showMessageDialog(null, ax);
                        } else {
                            JOptionPane.showMessageDialog(null, "La clave que desea cambiar es muy corta...");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La clave ingresada no coincide....");
                }
            }
        }
    }
}
