import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 *
 * Autor: [Dilan Gonzalez]
 * Fecha: [16/11/26]
 */
public class Ejercicio3 {

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

        // ============================================================
        // TODO 2: Calcular N y K con la semilla:
        //   N = 5 + (semilla % 10)    → cantidad de términos (5-14)
        //   K = 2 + (semilla % 8)     → múltiplo base (2-9)
        // ============================================================
        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);
        // ============================================================
        // TODO 3: Construir la serie usando un ciclo WHILE
        //   - Acumula la suma total
        //   - Construye un String con los términos separados por coma
        //     Ejemplo: "3, 6, 9, 12, 15"
        // ============================================================
        int sumaTotal = 0;
        StringBuilder serie = new StringBuilder();
        // --- escribe el ciclo while aquí ---
            int i = 1;
        while (i <= n) {
            int termino = k * i;
            sumaTotal += termino;
            if (i > 1) {
                serie.append(", ");
            }
            serie.append(termino);
            i++;

        // ============================================================
        // TODO 4: Obtener nombre de PC y fecha/hora
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
        // TODO 5: Mostrar resultado con JOptionPane.showMessageDialog
        // Formato EXACTO:
        //   Serie: K, 2K, 3K, ... (N terminos)
        //   Suma total: XXXX
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // ============================================================
            String mensaje = "Serie: " + serie + " (" + n + " terminos)\n"
                + "Suma total: " + sumaTotal + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje,
                "Suma de Serie", JOptionPane.INFORMATION_MESSAGE);
    }
}

  
