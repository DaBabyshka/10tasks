public class SumOfDigits {
    public static void main(String[] args) {
        String inputText = "Пример текста с цифрами: 123 и 456.";
        int sum = calculateSumOfDigits(inputText);
        System.out.println("Сумма всех встречающихся цифр: " + sum);
    }

    public static int calculateSumOfDigits(String text) {
        int sum = 0;

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }

        return sum;
    }
}
