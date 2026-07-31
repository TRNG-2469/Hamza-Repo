package exercise;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        String[] tokens = input.split(",");
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token.trim());
        }
        return sum;
    }

    public int multiply(String input){
        if(input == null || input.trim().isEmpty()){
            return 0;
        }
        String[] tokens = input.split(",");
        int multi = 1;
        for (String token: tokens){
            multi*= Integer.parseInt(token.trim());
        }
        return multi;
    }
}