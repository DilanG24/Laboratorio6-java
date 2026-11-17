import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de Multiplicar con for y Manejo de Excepciones
 *
 * Autor: [Dilan Gonzalez]
 * Fecha: [16/11/26]
 */
public class Ejercicio5 {

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
            JOptionPane.showMessageDialog(null, "Error: entrada no numerica",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ============================================================
        // TODO 2: Calcular M y L con la semilla:
        //   M = 2 + (semilla % 19)    → número de la tabla (2-20)
        //   L = 5 + (semilla % 8)     → límite de la tabla (5-12)
        // ============================================================
      int m = 2 + (semilla % 19);
        int l = 5 + (semilla % 8);
        // ============================================================
        // TODO 3: Implementar la tabla de multiplicar con:
        //   - Un bloque TRY que:
        //       1. Lanza IllegalArgumentException si M < 1 o M > 20
        //          con mensaje: "Error: numero fuera de rango [1-20]"
        //       2. Construye la tabla con un ciclo FOR de 1 hasta L
        //          Formato de cada línea: "M x i  = resultado"
        //   - Un CATCH para NumberFormatException:
        //       Muestra: "Error: entrada no numerica"
        //   - Un CATCH para IllegalArgumentException:
        //       Muestra el mensaje de la excepción
        //   - Un bloque FINALLY que siempre imprime: "Proceso finalizado"
        //
        // Nota: en este ejercicio el valor de M ya está calculado por
        // la semilla, no lo leas del JOptionPane (el autograde lo controla).
        // El try/catch se aplica para demostrar el manejo de excepciones
        // con la validación del rango.
        // ============================================================

        StringBuilder tabla = new StringBuilder();
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        // --- escribe tu try / catch / finally aquí ---
       
        try {
            if (m < 1 || m > 20) {
                throw new IllegalArgumentException("Error: numero fuera de rango [1-20]");
            }
            tabla.append("Tabla del ").append(m).append("\n");
            for (int i = 1; i <= l; i++) {
                tabla.append(m).append(" x ").append(i)
                     .append("  = ").append(m * i).append("\n");
            }
        } catch (NumberFormatException e) {
            tabla.append("Error: entrada no numerica\n");
        } catch (IllegalArgumentException e) {
            tabla.append(e.getMessage()).append("\n");
        } finally {
            System.out.println("Proceso finalizado");
            tabla.append("Proceso finalizado\n");
        }

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
        fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));



        // ============================================================
        // TODO 4: Mostrar resultado con JOptionPane.showMessageDialog
        // Formato EXACTO (salida normal):
        //   Tabla del M
        //   M x 1  = M
        //   M x 2  = 2M
        //   ...
        //   M x L  = resultado
        //   Proceso finalizado
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // ============================================================
        String mensaje = tabla
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje,
                "Tabla de Multiplicar", JOptionPane.INFORMATION_MESSAGE);

    }
}
