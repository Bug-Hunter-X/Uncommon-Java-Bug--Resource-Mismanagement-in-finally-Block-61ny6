public class UncommonBugSolution {
    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        try {
            int z = x / y; // Potential ArithmeticException
            System.out.println(z); 
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
            // Resource release moved to catch block to always ensure release 

        } finally {
            System.out.println("This always executes");
            // Removed incorrect resource handling. 
        }
        System.out.println("Program continues");
    }
} 