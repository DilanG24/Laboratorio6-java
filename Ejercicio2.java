import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: [Dilan Gonzalez]
 * Fecha: [16/11/26]
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        // ============================================================
        // TODO 1: Leer la semilla (últimos 3 dígitos de tu cédula)
        // ============================================================
      int semilla = 0;
     String entrada = JOptionPane.showInputDialog(
                null,
                "Ingrese los últimos 3 dígitos de su cédula:",
                "Semilla",
                JOptionPane.QUESTION_MESSAGE);
        if (entrada == null) {
            return; // el usuario canceló
        }
        try {
            semilla = Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Debe ser un número entero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // ============================================================
        // TODO 2: Calcular precio y código del producto con la semilla:
        //   precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5
        //   codigo = (semilla % 5) + 1
        // ============================================================
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // ============================================================
        // TODO 3: Determinar el porcentaje de descuento con switch:
        //   caso 1 → Electronica  → 10%
        //   caso 2 → Ropa         → 15%
        //   caso 3 → Alimentos    → 5%
        //   caso 4 → Muebles      → 20%
        //   default               → 0%
        // ============================================================
         int descuentoPct;
        switch (codigo) {
            case 1:             // Electronica
                descuentoPct = 10;
                break;
            case 2:             // Ropa
                descuentoPct = 15;
                break;
            case 3:             // Alimentos
                descuentoPct = 5;
                break;
            case 4:             // Muebles
                descuentoPct = 20;
                break;
            default:
                descuentoPct = 0;
                break;
        }

        // ============================================================
        // TODO 4: Calcular descuento_monto y precio_final
        //   descuento_monto = precio * (descuentoPct / 100.0)
        //   precio_final    = precio - descuento_monto
        // ============================================================
        ouble descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        // ============================================================
        // TODO 5: Obtener nombre de PC y fecha/hora
        // ============================================================
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            String env = System.getenv("COMPUTERNAME");
            if (env == null) {
                env = System.getenv("HOSTNAME");
            }
            if (env != null) {
                nombrePC = env;
            }
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // ============================================================
        // TODO 6: Mostrar resultado con JOptionPane.showMessageDialog
        // Formato EXACTO (alinear con espacios):
        //   Precio original : $ XX.XX
        //   Descuento (XX%) : $ XX.XX
        //   Precio final    : $ XX.XX
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // Tolerancia aceptada en dinero: ±0.01
        // ============================================================
        String mensaje = String.format(Locale.US,
                "Precio original : $ %.2f%n"
              + "Descuento (%d%%) : $ %.2f%n"
              + "Precio final    : $ %.2f%n"
              + "Computadora: %s | Fecha: %s",
                precio, descuentoPct, descuentoMonto, precioFinal,
                nombrePC, fechaHora);

        JOptionPane.showMessageDialog(null, mensaje,
                "Calculadora de Descuentos", JOptionPane.INFORMATION_MESSAGE);

    }
}
