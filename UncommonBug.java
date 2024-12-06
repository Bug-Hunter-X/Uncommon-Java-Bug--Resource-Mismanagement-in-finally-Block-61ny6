public class UncommonBug {
    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        try {
            int z = x / y; // Potential ArithmeticException
            System.out.println(z); 
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } finally {
            System.out.println("This always executes");
            //The bug is here:Incorrect use of resources in finally block. If an exception is thrown before the finally block, the resources may not be released correctly.
            //In a real-world scenario, this could involve closing a database connection or releasing a file handle. 
            //If the exception occurs before the finally block,the resources are not released. 
            //Incorrectly used resource can lead to memory leaks and resource exhaustion
        }
        System.out.println("Program continues");
    }
}