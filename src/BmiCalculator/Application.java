package BmiCalculator;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<String> names = List.of("Karin", "Josef", "Ben", "Jakob");
        //these are my family members btw: mother, father, brother and last but not least me
        Scanner scanner = new Scanner(System.in);
        for (String name : names) {
            System.out.println("Hi " + name + ", could you please tell me your weight in kg?");
            double weightInKg = scanner.nextDouble();
            System.out.println("Thank you, what is your height in cm?");
            double heightInCm = scanner.nextDouble();
            double bmi = calculateBodyMassIndex(weightInKg, heightInCm);
            System.out.println("I see, your BMI is " + bmi + ".");

            double underWeightThreshold = 18.5;
            double normalWeightThreshold = 24.9;
            double overWeightThreshold = 29.9;

            if (bmi < underWeightThreshold) {
                System.out.println("That makes you underweight.");
            } else if (bmi <= normalWeightThreshold) {
                System.out.println("You have a normal body weight.");
            } else if (bmi <= overWeightThreshold) {
                System.out.println("You are overweight.");
            } else {
                System.out.println("Unfortunately, I have to tell you that you're obese.");
            }
        }
    }

    public static double calculateBodyMassIndex(double weightInKg, double heightInCm) {
        return (weightInKg / (heightInCm * heightInCm)) * 10000;
    }
}
