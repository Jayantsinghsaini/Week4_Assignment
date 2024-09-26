/***
 * this is a Maths class for mathematical methods
 * Name - Jayant Singh
 * Date - 26/09/24
 */
public class Maths {
    /***
     * this method calculates power of number
     * parameter - number, power
     * return - result( power of number )
     */
    public static int power(int number, int power){
        int result = 1;
        for (int i = 0; i < power; i++) {
            result = result * number;
        }
        return result;
    }
}
