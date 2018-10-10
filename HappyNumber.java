package happynumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class HappyNumber {
    
    private int number;

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber(input());
        System.out.printf("%d is %s a happy number.%n", hn.number, 
                hn.isHappyNumber() ? "\b" : "not");
    }
    
    private HappyNumber(int number) {
        this.number = number;
    }
    
    private static int input() {
        int number = 0;
        while (number < 2) {
            System.out.print("Enter a positive whole number: ");
            try {
                String nextLine = new Scanner(System.in).nextLine();
                number = Integer.parseInt(nextLine);
            } catch(NumberFormatException e) {
                System.err.println(e);
                System.out.println("You have to enter a positive whole number!");
            }
        }
        return number;
    }

    public boolean isHappyNumber() {
        HashSet<Integer> holder = new HashSet();
        while (number != 1 && holder.add(number)) {
            //System.out.println(number + "\t" + holder.size());
            number = powerAmount(digitsNumber(number), 2);
        }
        return number == 1;
    }
    
    public List<Integer> digitsNumber(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return digits;
    }
    
    public int powerAmount(List<Integer> nums, int exponent) {
        int sum = 0;
        sum = nums.stream().map((num) -> 
                (int) Math.pow(num, exponent)).reduce(sum, Integer::sum);
        return sum;
    }
}