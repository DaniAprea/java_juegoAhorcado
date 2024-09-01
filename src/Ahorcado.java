import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        // Clase Scanner que nos permite que el usuario escriba        
        Scanner scanner = new Scanner(System.in);

        // Declaraciones y asignaciones
        String palabrasecreta = "inteligencia"; // La palabra que se debe adivinar
        int intentosMaximos = 10; // Número máximo de intentos permitidos
        int intentos = 0; // Contador de intentos realizados
        boolean palabraAdivinada = false; // Bandera para verificar si se adivinó la palabra

        // Arreglos
        char[] letrasAdivinadas = new char[palabrasecreta.length()]; // Arreglo para mantener las letras adivinadas

        // Inicializa el arreglo con guiones bajos
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_'; // Representa letras no adivinadas
        }

        // Bucle principal del juego
        while (!palabraAdivinada && intentos < intentosMaximos) {
            
            // Muestra el estado actual de la palabra a adivinar
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabrasecreta.length() + " letras)");

            System.out.println("Introduce una letra por favor: ");
            char letra = Character.toLowerCase(scanner.next().charAt(0)); // Lee la letra ingresada por el usuario
            boolean letraCorrecta = false; // Bandera para verificar si la letra es correcta

            // Verifica si la letra está en la palabra secreta
            for (int i = 0; i < palabrasecreta.length(); i++) {
                if (palabrasecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra; // Actualiza la letra adivinada
                    letraCorrecta = true; // Marca que la letra fue adivinada correctamente
                }
            }
            
            // Manejo de intentos incorrectos
            if (!letraCorrecta) {
                intentos++; // Incrementa el contador de intentos
                System.out.println("¡¡Incorrecto!! Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            // Verifica si se ha adivinado la palabra completa
            if (String.valueOf(letrasAdivinadas).equals(palabrasecreta)) {
                palabraAdivinada = true; // Marca que se ha adivinado la palabra
                System.out.println("Felicidades!! Has adivinado la palabra secreta!! " + palabrasecreta);
            }
        }

        // Mensaje al perder el juego
        if (!palabraAdivinada) {
            System.out.println("Que pena!! Te quedaste sin intentos!! GAME OVER");
        }

        scanner.close(); // Cierra el scanner para liberar recursos
    }
}
