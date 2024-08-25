import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        //Clase Scanner que nos permite que el usuario escriba        
        Scanner scanner = new Scanner(System.in);

        //declaraciones y asignaciones
        String palabrasecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        //arreglos
        char[] letrasAdivinadas = new char[palabrasecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!palabraAdivinada && intentos < intentosMaximos) {
            
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + "(" + palabrasecreta.length() + " letras)");

            System.out.println("introduce una letra por favor: ");
            char letra = Character.toLowerCase(scanner.next().charAt(0));
            boolean letraCorrecta = false;
            for (int i = 0; i < palabrasecreta.length(); i++) {
                if (palabrasecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }
            
            if(!letraCorrecta){
                intentos++;
                System.out.println("¡¡Incorrecto!! Te quedan " + (intentosMaximos-intentos)+ " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabrasecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades!! Has adivinado la palabra secreta!! " + palabrasecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("Que pena!! Te quedaste sin intentos!! GAME OVER");
        }

        scanner.close();

    }
}
