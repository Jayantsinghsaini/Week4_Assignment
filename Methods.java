/***
 * this is a Method class which contains methods for mathematical operation & conversion on number system
 * Name - Jayant Singh
 * Date - 26/09/24
 */
import java.util.Scanner;
public class Methods {
    /***
     * this method is for binary to octal conversion
     * parameter - binaryNumber
     * return - octal
     */
    public static String binaryToOctal(int binaryNumber) {
        int decimal = binaryToDecimal(binaryNumber);
        if (decimal == -1) {
            return Constant.INVALID_BINARY;
        }
        String octal = decimalToOctal(decimal);
        return octal;
    }
    /***
     * this method is for binary to decimal conversion
     * parameter - binaryNumber
     * return - decimal
     */
    public static int binaryToDecimal(int binaryNumber) {
        if (binaryNumber == 0) {
            return 0;
        }
        if (binaryNumber < 0) {
            return -1;
        }
        String binaryString = String.valueOf(binaryNumber);
        if (!binaryString.matches("[01]+")) {
            System.out.println(Constant.INVALID_BINARY);
            return -1;
        }
        int decimal = 0;
        int position = 0;
        while (binaryNumber > 0) {
            int lastDigit = binaryNumber % 10;
            decimal += lastDigit * Maths.power(2, position);
            position++;
            binaryNumber /= 10;
        }
        return decimal;
    }
    /***
     * this method is for binary to hex conversion
     * parameter - binaryNumber
     * return - hex
     */
    public static String binaryToHex(int binaryNumber) {
        int decimal = binaryToDecimal(binaryNumber);
        if (decimal == -1) {
            return Constant.INVALID_BINARY;
        }
        return decimalToHex(decimal);
    }
    /***
     * this method is for octal to binary conversion
     * parameter - octalNumber
     * return - binary
     */
    public static String octalToBinary(int octalNumber) {
        int decimal = octalToDecimal(octalNumber);
        if (decimal == -1) {
            return Constant.INVALID_OCTAL;
        }
        return decimalToBinary(decimal);
    }
    /***
     * this method is for octal to decimal conversion
     * parameter - octalNumber
     * return - decimal
     */
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
                System.out.println(Constant.INVALID_OCTAL);
                return -1;
            }
        }
        int decimal = 0;
        int position = 0;
        while (octalNumber > 0) {
            int lastDigit = octalNumber % 10;
            decimal += lastDigit * Maths.power(8, position);
            position++;
            octalNumber /= 10;
        }
        return decimal;
    }
    /***
     * this method is for octal to hex conversion
     * parameter - octalNumber
     * return - hex
     */
    public static String octalToHex(int octalNumber) {
        int decimal = octalToDecimal(octalNumber);
        if (decimal == -1) {
            return Constant.INVALID_OCTAL;
        }
        return decimalToHex(decimal);
    }
    /***
     * this method is for decimal to binary conversion
     * parameter - decimalNumber
     * return - binary
     */
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
    /***
     * this method is for decimal to octal conversion
     * parameter - decimalNumber
     * return - octal
     */
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
    /***
     * this method is for decimal to hex conversion
     * parameter - decimalNumber
     * return - hex
     */
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
    /***
     * this method is for hex to binary conversion
     * parameter - hexNumber
     * return - binary
     */
    public static String hexToBinary(String hexNumber) {
        int decimal = hexToDecimal(hexNumber);
        if (decimal == -1) {
            return Constant.INVALID_HEX;
        }
        return decimalToBinary(decimal);
    }
    /***
     * this method is for hex to octal conversion
     * parameter - hexNumber
     * return - octal
     */
    public static String hexToOctal(String hexNumber) {
        int decimal = hexToDecimal(hexNumber);
        if (decimal == -1) {
            return Constant.INVALID_HEX;
        }
        return decimalToOctal(decimal);
    }
    /***
     * this method is for hex to decimal conversion
     * parameter - hexNumber
     * return - decimal
     */
    public static int hexToDecimal(String hexNumber) {
        if (hexNumber.isEmpty()) {
            System.out.println(Constant.INVALID_HEX);
            return -1;
        }
        int decimal = 0;
        int base = 0;
        for (int i = hexNumber.length() - 1; i >= 0; i--) {
            char hexDigit = hexNumber.charAt(i);
            if (!((hexDigit >= '0' && hexDigit <= '9') || (hexDigit >= 'A' && hexDigit <= 'F') || (hexDigit >= 'a' && hexDigit <= 'f'))) {
                System.out.println(Constant.INVALID_HEX);
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
            decimal += value * Maths.power(16, base);
            base++;
        }
        return decimal;
    }
    /***
     * this is our main method for mathematical operation on different types of number format
     */
    public static void operation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.ENTER_OPERATION);
        while (true) {
            System.out.println();
            String operationInput = scanner.nextLine().trim();
            if (operationInput.equalsIgnoreCase("exit")) {
                break;
            }
            int firstLeftBracket = operationInput.indexOf('(');
            int firstRightBracket = operationInput.indexOf(')', firstLeftBracket);
            int operatorIndex = operationInput.indexOf(' ', firstRightBracket + 1) + 1;
            int secondLeftBracket = operationInput.indexOf('(', operatorIndex);
            int secondRightBracket = operationInput.indexOf(')', secondLeftBracket);
            int equalsIndex = operationInput.indexOf('=', secondRightBracket) + 2;
            int thirdLeftBracket = operationInput.indexOf('(', equalsIndex - 1);
            if (firstLeftBracket == -1 || firstRightBracket == -1 || secondLeftBracket == -1 || secondRightBracket == -1 || equalsIndex == -1) {
                System.out.println(Constant.INVALID_INPUT_FORMAT);
                continue;
            }
            String sourceFormat1 = operationInput.substring(0, firstLeftBracket).trim();
            String actualNumber1 = operationInput.substring(firstLeftBracket + 1, firstRightBracket).trim();
            String operation = operationInput.substring(operatorIndex, operatorIndex + 1).trim();
            String sourceFormat2 = operationInput.substring(operatorIndex + 2, secondLeftBracket).trim();
            String actualNumber2 = operationInput.substring(secondLeftBracket + 1, secondRightBracket).trim();
            String resultFormat = operationInput.substring(equalsIndex, thirdLeftBracket != -1 ? thirdLeftBracket : operationInput.length()).trim();
            int decimalResult = 0;
            try {
                int decimalNumber1 = convertToDecimal(sourceFormat1, actualNumber1);
                int decimalNumber2 = convertToDecimal(sourceFormat2, actualNumber2);
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
                            System.out.println(Constant.BY_ZERO);
                            continue;
                        }
                        decimalResult = decimalNumber1 / decimalNumber2;
                        break;
                    default:
                        System.out.println(Constant.INVALID_OPERATION);
                        continue;
                }
                String result = convertFromDecimal(resultFormat, decimalResult);
                System.out.println(Constant.RESULT + result);
            } catch (NumberFormatException e) {
                System.out.println(Constant.INVALID_INPUT_FORMAT);
            }
        }
        scanner.close();
    }
    /***
     * this is our main method for number format conversion
     */
    public static void conversion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.ENTER_CONVERSION);
        while (true) {
            System.out.println();
            String conversionInput = scanner.nextLine().trim();
            if (conversionInput.equalsIgnoreCase("exit")) {
                break;
            }
            int firstLeftBracket = conversionInput.indexOf('(');
            int firstRightBracket = conversionInput.indexOf(')', firstLeftBracket);
            int toIndex = conversionInput.indexOf("to", firstRightBracket);
            if (firstLeftBracket == -1 || firstRightBracket == -1 || toIndex == -1 || toIndex < firstRightBracket) {
                System.out.println(Constant.INVALID_INPUT_FORMAT);
                continue;
            }
            String sourceFormat = conversionInput.substring(0, firstLeftBracket).trim().toLowerCase();
            String actualNumber = conversionInput.substring(firstLeftBracket + 1, firstRightBracket).trim();
            String targetFormat = conversionInput.substring(toIndex + 2).trim().toLowerCase();
            String result = "";
            try {
                switch (sourceFormat) {
                    case "binary":
                        int binaryNumber = Integer.parseInt(actualNumber);
                        if (!actualNumber.matches("[01]+")) {
                            System.out.println(Constant.INVALID_BINARY);
                            continue;
                        }
                        if (targetFormat.equals("decimal")) {
                            result = String.valueOf(binaryToDecimal(binaryNumber));
                        }
                        else if (targetFormat.equals("octal")) {
                            result = binaryToOctal(binaryNumber);
                        }
                        else if (targetFormat.equals("hex")) {
                            result = binaryToHex(binaryNumber);
                        }
                        else {
                            result = Constant.UNACCEPT;
                        }
                        break;

                    case "octal":
                        int octalNumber = Integer.parseInt(actualNumber);
                        if (octalNumber < 0 || !actualNumber.matches("[0-7]+")) {
                            System.out.println(Constant.INVALID_OCTAL);
                            continue;
                        }
                        if (targetFormat.equals("decimal")) {
                            result = String.valueOf(octalToDecimal(octalNumber));
                        }
                        else if (targetFormat.equals("binary")) {
                            result = octalToBinary(octalNumber);
                        }
                        else if (targetFormat.equals("hex")) {
                            result = octalToHex(octalNumber);
                        }
                        else {
                            result = Constant.UNACCEPT;
                        }
                        break;

                    case "decimal":
                        int decimalNumber = Integer.parseInt(actualNumber);
                        if (decimalNumber < 0) {
                            System.out.println(Constant.INVALID_DECIMAL);
                            continue;
                        }
                        if (targetFormat.equals("binary")) {
                            result = decimalToBinary(decimalNumber);
                        }
                        else if (targetFormat.equals("octal")) {
                            result = decimalToOctal(decimalNumber);
                        }
                        else if (targetFormat.equals("hex")) {
                            result = decimalToHex(decimalNumber);
                        }
                        else {
                            result = Constant.UNACCEPT;
                        }
                        break;

                    case "hex":
                        if (!actualNumber.matches("[0-9A-Fa-f]+")) {
                            System.out.println(Constant.INVALID_HEX);
                            continue;
                        }
                        if (targetFormat.equals("binary")) {
                            result = hexToBinary(actualNumber);
                        }
                        else if (targetFormat.equals("octal")) {
                            result = hexToOctal(actualNumber);
                        }
                        else if (targetFormat.equals("decimal")) {
                            result = String.valueOf(hexToDecimal(actualNumber));
                        }
                        else {
                            result = Constant.UNACCEPT;
                        }
                        break;

                    default:
                        System.out.println(Constant.UNACCEPT);
                        continue;
                }
            }
            catch (NumberFormatException e) {
                System.out.println(Constant.INVALID_INPUT_FORMAT + e.getMessage());
            }
            if (!result.isEmpty()) {
                System.out.println(Constant.RESULT + result);
            }
        }
        scanner.close();
    }
    /***
     * this method is for 'other to decimal' conversion
     * parameter - format, actualNumber
     * return - decimal
     */
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
                throw new NumberFormatException(Constant.INVALID_INPUT_FORMAT);
        }
    }
    /***
     * this method is for 'decimal to other' conversion
     * parameter - format, decimalNumber
     * return - binary, octal, decimal, or hex
     */
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
        return Constant.INVALID_INPUT_FORMAT;
    }
}
