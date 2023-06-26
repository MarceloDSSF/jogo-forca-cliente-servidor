import java.util.Scanner;

public class Util {
    private static final String word = "Teste para forca";
    private static final int maxAttempts = 6;

    private static String maskedWord;
    private static int attempts;

    public static void main(String[] args) {
        initializeGame();

        Scanner scanner = new Scanner(System.in);

        while (attempts < maxAttempts && maskedWord.contains("_")) {
            System.out.println("Palavra: " + maskedWord);
            System.out.print("Digite uma letra: ");
            String letter = scanner.nextLine().toLowerCase();

            if (letter.length() == 1) {
                boolean letterFound = false;
                StringBuilder updatedMaskedWord = new StringBuilder(maskedWord);

                for (int i = 0; i < word.length(); i++) {
                    if (Character.toLowerCase(word.charAt(i)) == letter.charAt(0)) {
                        updatedMaskedWord.setCharAt(i, word.charAt(i));
                        letterFound = true;
                    }
                }

                if (letterFound) {
                    maskedWord = updatedMaskedWord.toString();
                    System.out.println("Letra encontrada!");
                } else {
                    attempts++;
                    System.out.println("Letra não encontrada. Tentativas restantes: " + (maxAttempts - attempts));
                }
            } else {
                System.out.println("Por favor, digite apenas uma letra.");
            }
        }

        scanner.close();

        if (maskedWord.contains("_")) {
            System.out.println("Você perdeu! A palavra correta era: " + word);
        } else {
            System.out.println("Parabéns! Você acertou a palavra: " + word);
        }
    }

    private static void initializeGame() {
        maskedWord = word.replaceAll("[A-Za-z]", "_");
        attempts = 0;
    }
}