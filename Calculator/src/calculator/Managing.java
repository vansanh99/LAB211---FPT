/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author pc
 */
public class Managing {

    public Validation val = new Validation();

    public void normalCal() {
        System.out.println("================Normal Calculator================");
        double number1 = 0;
        String msg = "Enter number: ";
        number1 = val.checkDouble(msg, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        while (true) {
            
            String oprator = val.checkOperator("Enter operator: ");
            
            if (!oprator.equals("=")) {
                double number2 = val.checkDouble(msg, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                if (oprator.equals("+")) {
                    number1 = number1 + number2;
                }
                if (oprator.equals("-")) {
                    number1 = number1 - number2;
                }
                if (oprator.equals("*")) {
                    number1 = number1 * number2;
                }
                if (oprator.equals("/")) {
                    while (number2 == 0) {
                        System.err.println("cannot divide by 0");
                        number2 = val.checkDouble(msg, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                    }
                    number1 = number1 / number2;
                }
                if (oprator.equals("^")) {
                    number1 = Math.pow(number1, number2);
                }
                System.out.println("Memory: " + number1);
            } else {
                break;
            }

        }
        System.out.println("Result: " + number1);
    }

    public void BMICal() {
        System.out.println("=================BMI Calculator=================");
        double weight = val.checkDouble("Enter Weight (kg): ", 0, Double.POSITIVE_INFINITY);
        double height = val.checkDouble("Enter Height (cm): ", 0, Double.POSITIVE_INFINITY) / 100;
        double bmi = weight / (height * height);
        System.out.println("BMI number: " + bmi);
        System.out.print("\nBMI Status: ");
        if (bmi < 19) {
            System.out.println("Under-standard");
        } else if (bmi >= 19 && bmi < 25) {
            System.out.println("Standard");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("Overweight");
        } else if (bmi >= 30 && bmi < 40) {
            System.out.println("Fat - should lose weight");
        } else {
            System.out.println("Very fat - should lose weight immediately");
        }
    }
}
