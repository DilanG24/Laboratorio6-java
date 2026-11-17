import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contraseña con do-while
 *
 * Autor: [Dilan Gonzalez]
 * Fecha: [16/11/26]
public class Ejercicio4 {

    public static void main(String[] args) {

        // ============================================================
        // Variables de control
        // ============================================================
        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // ============================================================
        // TODO 1: Implementar el ciclo DO-WHILE que:
        //   1. Pide una contraseña con JOptionPane.showInputDialog
        //   2. Incrementa el contador de intentos
        //   3. Verifica las 3 reglas en orden:
        //      a. Longitud >= 8  → si falla: "La contrasena debe tener al menos 8 caracteres"
        //      b. Contiene dígito (usa Character.isDigit en un for)
        //                        → si falla: "La contrasena debe tener al menos un digito"
        //      c. Contiene mayúscula (usa Character.isUpperCase en un for)
        //                        → si falla: "La contrasena debe tener al menos una mayuscula"
        //   4. Si cumple las 3: muestra JOptionPane con "Contrasena aceptada"
        //      y pone valida = true
        //   5. Si falla alguna: muestra el mensaje de error con JOptionPane
        //      y continúa el ciclo
        // El ciclo repite mientras !valida
        // ============================================================
        do {
            String entrada = JOptionPane.showInputDialog(
                    null,
                    "Ingrese una contrasena:",
                    "Validador de Contrasena",
                    JOptionPane.QUESTION_MESSAGE);
            if (entrada == null) {
                return; // el usuario canceló
            }
            contrasena = entrada;
            intentos++;

            // Regla a: longitud >= 8
            if (contrasena.length() < 8) {
                JOptionPane.showMessageDialog(null,
                        "La contrasena debe tener al menos 8 caracteres",
                        "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Regla b: al menos un dígito
            boolean tieneDigito = false;
            for (int i = 0; i < contrasena.length(); i++) {
                if (Character.isDigit(contrasena.charAt(i))) {
                    tieneDigito = true;
                    break;
                }
            }
            if (!tieneDigito) {
                JOptionPane.showMessageDialog(null,
                        "La contrasena debe tener al menos un digito",
                        "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Regla c: al menos una mayúscula
            boolean tieneMayuscula = false;
            for (int i = 0; i < contrasena.length(); i++) {
                if (Character.isUpperCase(contrasena.charAt(i))) {
                    tieneMayuscula = true;
                    break;
                }
            }
            if (!tieneMayuscula) {
                JOptionPane.showMessageDialog(null,
                        "La contrasena debe tener al menos una mayuscula",
                        "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Cumple las 3 reglas
            JOptionPane.showMessageDialog(null, "Contrasena aceptada");
            valida = true;

        } while (!valida);

        // ============================================================
        // TODO 2: Obtener nombre de PC y fecha/hora
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
        // TODO 3: Mostrar resultado final con JOptionPane.showMessageDialog
        // Formato EXACTO:
        //   Contrasena aceptada
        //   Intentos realizados: X
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // ============================================================
        String mensaje = "Contrasena aceptada\n"
                + "Intentos realizados: " + intentos + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje,
                "Resultado", JOptionPane.INFORMATION_MESSAGE);

    }
}
