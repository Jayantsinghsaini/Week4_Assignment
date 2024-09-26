import java.util.Scanner;

public class Methods {
    public static String binaryToOctal(int binaryNumber) {
        int decimal = binaryToDecimal(binaryNumber);
        if (decimal == -1) {
            return "Error: Invalid binary number.";
        }
        String octal = decimalToOctal(decimal);
        return octal;
    }
    public static int binaryToDecimal(int binaryNumber) {
        if (binaryNumber == 0) {
            return 0;
        }
        if (binaryNumber < 0) {
            return -1;
        }
        String binaryString = String.valueOf(binaryNumber);
        if (!binaryString.matches("[01]+")) {
            System.out.println("Error: Invalid binary number.");
            return -1;
        }
        int decimal = 0;
        int position = 0;
        while (binaryNumber > 0) {
            int lastDigit = binaryNumber % 10;
            decimal += lastDigit * Math.pow(2, position);
            position++;
            binaryNumber /= 10;
        }
        return decimal;
    }
    public static String binaryToHex(int binaryNumber) {
        int decimal = binaryToDecimal(binaryNumber);
        if (decimal == -1) {
            return "Error: Invalid binary number.";
        }
        return decimalToHex(decimal);
    }
    public static String octalToBinary(int octalNumber) {
        int decimal = octalToDecimal(octalNumber);
        if (decimal == -1) {
            return "Error: Invalid octal number.";
        }
        return decimalToBinary(decimal);
    }
    public static int octalToDecimal(int octalNumber) {
        if (octalNumber == 0) {
            return 0;
        }
        if (octalNumber < 0) {
            return -1;
        }
        String octalString = String.valueOf(octalNumber);
        for (char character : octalString.toCharArray()) {
            if (character < '0' || character > '7') {
                System.out.println("Error: Invalid octal number.");
                return -1;
            }
        }
        int decimal = 0;
        int position = 0;
        while (octalNumber > 0) {
            int lastDigit = octalNumber % 10;
            decimal += lastDigit * Math.pow(8, position);
            position++;
            octalNumber /= 10;
        }
        return decimal;
    }
    public static String octalToHex(int octalNumber) {
        int decimal = octalToDecimal(octalNumber);
        if (decimal == -1) {
            return "Error: Invalid octal number.";
        }
        return decimalToHex(decimal);
    }
    public static String decimalToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }
        if (decimalNumber < 0) {
            return "-1";
        }
        StringBuilder binaryString = new StringBuilder();
        while (decimalNumber > 0) {
            binaryString.append(decimalNumber % 2);
            decimalNumber /= 2;
        }
        return binaryString.reverse().toString();
    }
    public static String decimalToOctal(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }
        if (decimalNumber < 0) {
            return "-1";
        }
        StringBuilder octalString = new StringBuilder();
        while (decimalNumber > 0) {
            octalString.append(decimalNumber % 8);
            decimalNumber /= 8;
        }
        return octalString.reverse().toString();
    }
    public static String decimalToHex(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }
        if (decimalNumber < 0) {
            return "-1";
        }
        StringBuilder hexString = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 16;
            if (remainder > 9) {
                hexString.append((char) ('A' + (remainder - 10)));
            } else {
                hexString.append(remainder);
            }
            decimalNumber /= 16;
        }
        return hexString.reverse().toString();
    }
    public static String hexToBinary(String hexNumber) {
        int decimal = hexToDecimal(hexNumber);
        if (decimal == -1) {
            return "Error: Invalid hexadecimal number.";
        }
        return decimalToBinary(decimal);
    }
    public static String hexToOctal(String hexNumber) {
        int decimal = hexToDecimal(hexNumber);
        if (decimal == -1) {
            return "Error: Invalid hexadecimal number.";
        }
        return decimalToOctal(decimal);
    }
    public static int hexToDecimal(String hexNumber) {
        if (hexNumber.isEmpty()) {
            System.out.println("Error: Invalid hexadecimal number.");
            return -1;
        }
        int decimal = 0;
        int base = 0;
        for (int i = hexNumber.length() - 1; i >= 0; i--) {
            char hexDigit = hexNumber.charAt(i);
            if (!((hexDigit >= '0' && hexDigit <= '9') || (hexDigit >= 'A' && hexDigit <= 'F') || (hexDigit >= 'a' && hexDigit <= 'f'))) {
                System.out.println("Error: Invalid hexadecimal number.");
                return -1;
            }
            int value;
            if (hexDigit >= '0' && hexDigit <= '9') {
                value = hexDigit - '0';
            } else if (hexDigit >= 'A' && hexDigit <= 'F') {
                value = hexDigit - 'A' + 10;
            } else {
                value = hexDigit - 'a' + 10;
            }
            decimal += value * Math.pow(16, base);
            base++;
        }
        return decimal;
    }
    public static void operation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter operation (eg. decimal(33) + decimal(66) = decimal ) or type 'exit' to quit: ");

        while (true) {
            System.out.println();
            String operationInput = scanner.nextLine().trim();


            if (operationInput.equalsIgnoreCase("exit")) {
                break;
            }

            // Find the index positions of special characters
            int firstLeftBracket = operationInput.indexOf('(');
            int firstRightBracket = operationInput.indexOf(')', firstLeftBracket);
            int operatorIndex = operationInput.indexOf(' ', firstRightBracket + 1) + 1;
            int secondLeftBracket = operationInput.indexOf('(', operatorIndex);
            int secondRightBracket = operationInput.indexOf(')', secondLeftBracket);
            int equalsIndex = operationInput.indexOf('=', secondRightBracket) + 2;
            int thirdLeftBracket = operationInput.indexOf('(', equalsIndex - 1);

            // Check if the format is valid
            if (firstLeftBracket == -1 || firstRightBracket == -1 || secondLeftBracket == -1 || secondRightBracket == -1 || equalsIndex == -1) {
                System.out.println("Invalid input or format.");
                continue;
            }

            // Extract the parts of the input string manually
            String sourceFormat1 = operationInput.substring(0, firstLeftBracket).trim();
            String actualNumber1 = operationInput.substring(firstLeftBracket + 1, firstRightBracket).trim();
            String operation = operationInput.substring(operatorIndex, operatorIndex + 1).trim();
            String sourceFormat2 = operationInput.substring(operatorIndex + 2, secondLeftBracket).trim();
            String actualNumber2 = operationInput.substring(secondLeftBracket + 1, secondRightBracket).trim();
            String resultFormat = operationInput.substring(equalsIndex, thirdLeftBracket != -1 ? thirdLeftBracket : operationInput.length()).trim();

            int decimalResult = 0;

            try {
                // Convert first number to decimal
                int decimalNumber1 = convertToDecimal(sourceFormat1, actualNumber1);
                // Convert second number to decimal
                int decimalNumber2 = convertToDecimal(sourceFormat2, actualNumber2);

                // Perform the arithmetic operation
                switch (operation) {
                    case "+":
                        decimalResult = decimalNumber1 + decimalNumber2;
                        break;
                    case "-":
                        decimalResult = decimalNumber1 - decimalNumber2;
                        break;
                    case "*":
                        decimalResult = decimalNumber1 * decimalNumber2;
                        break;
                    case "/":
                        if (decimalNumber2 == 0) {
                            System.out.println("Error: Division by zero.");
                            continue;
                        }
                        decimalResult = decimalNumber1 / decimalNumber2;
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        continue;
                }
                String result = convertFromDecimal(resultFormat, decimalResult);
                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input or format.");
            }
        }

        scanner.close();
    }
    public static void conversion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter conversion (eg. binary(101) to hex) or type 'exit' to quit:");

        while (true) {
            System.out.println();
            String conversionInput = scanner.nextLine().trim();

            // Allow the user to exit the loop
            if (conversionInput.equalsIgnoreCase("exit")) {
                break;
            }

            // Manually find parts of the input string
            int firstLeftBracket = conversionInput.indexOf('(');
            int firstRightBracket = conversionInput.indexOf(')', firstLeftBracket);
            int toIndex = conversionInput.indexOf("to", firstRightBracket);

            // Handle cases where the basic format is invalid
            if (firstLeftBracket == -1 || firstRightBracket == -1 || toIndex == -1 || toIndex < firstRightBracket) {
                System.out.println("Invalid input or format. ");
                continue;
            }

            // Extract the parts of the input string
            String sourceFormat = conversionInput.substring(0, firstLeftBracket).trim().toLowerCase();
            String actualNumber = conversionInput.substring(firstLeftBracket + 1, firstRightBracket).trim();
            String targetFormat = conversionInput.substring(toIndex + 2).trim().toLowerCase();

            String result = "";

            try {
                // Perform conversion based on the source and target formats
                switch (sourceFormat) {
                    case "binary":
                        int binaryNumber = Integer.parseInt(actualNumber);
                        if (!actualNumber.matches("[01]+")) {
                            System.out.println("Invalid binary input.");
                            continue;
                        }
                        if (targetFormat.equals("decimal")) {
                            result = String.valueOf(binaryToDecimal(binaryNumber));
                        } else if (targetFormat.equals("octal")) {
                            result = binaryToOctal(binaryNumber);
                        } else if (targetFormat.equals("hex")) {
                            result = binaryToHex(binaryNumber);
                        } else {
                            result = "Unacceptable format";
                        }
                        break;

                    case "octal":
                        int octalNumber = Integer.parseInt(actualNumber);
                        if (octalNumber < 0 || !actualNumber.matches("[0-7]+")) {
                            System.out.println("Invalid octal input.");
                            continue;
                        }
                        if (targetFormat.equals("decimal")) {
                            result = String.valueOf(octalToDecimal(octalNumber));
                        } else if (targetFormat.equals("binary")) {
                            result = octalToBinary(octalNumber);
                        } else if (targetFormat.equals("hex")) {
                            result = octalToHex(octalNumber);
                        } else {
                            result = "Unacceptable format";
                        }
                        break;

                    case "decimal":
                        int decimalNumber = Integer.parseInt(actualNumber);
                        if (decimalNumber < 0) {
                            System.out.println("Invalid decimal input.");
                            continue;
                        }
                        if (targetFormat.equals("binary")) {
                            result = decimalToBinary(decimalNumber);
                        } else if (targetFormat.equals("octal")) {
                            result = decimalToOctal(decimalNumber);
                        } else if (targetFormat.equals("hex")) {
                            result = decimalToHex(decimalNumber);
                        } else {
                            result = "Unacceptable format";
                        }
                        break;

                    case "hex":
                        if (!actualNumber.matches("[0-9A-Fa-f]+")) {
                            System.out.println("Invalid hexadecimal input.");
                            continue;
                        }
                        if (targetFormat.equals("binary")) {
                            result = hexToBinary(actualNumber);
                        } else if (targetFormat.equals("octal")) {
                            result = hexToOctal(actualNumber);
                        } else if (targetFormat.equals("decimal")) {
                            result = String.valueOf(hexToDecimal(actualNumber));
                        } else {
                            result = "Unacceptable format";
                        }
                        break;

                    default:
                        System.out.println("Unacceptable format.");
                        continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input or format: " + e.getMessage());
            }

            // Output the result
            if (!result.isEmpty()) {
                System.out.println("result: " + result);
            }
        }

        scanner.close();
    }
    public static int convertToDecimal(String format, String actualNumber) {
        switch (format.toLowerCase()) {
            case "binary":
                return binaryToDecimal(Integer.parseInt(actualNumber));
            case "octal":
                return octalToDecimal(Integer.parseInt(actualNumber));
            case "decimal":
                return Integer.parseInt(actualNumber);
            case "hex":
                return hexToDecimal(actualNumber);
            default:
                throw new NumberFormatException("Invalid input or format.");
        }
    }
    public static String convertFromDecimal(String format, int decimalNumber) {
        switch (format.toLowerCase()) {
            case "binary":
                return decimalToBinary(decimalNumber);
            case "octal":
                return decimalToOctal(decimalNumber);
            case "decimal":
                return String.valueOf(decimalNumber);
            case "hex":
                return decimalToHex(decimalNumber);
            default:
        }
        return "Invalid input or format.";
    }
}
