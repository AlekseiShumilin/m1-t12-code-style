import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double percentToPay = amount * Math.pow((1 + yearRate/ 12), 12 * depositPeriod);

        return round(percentToPay, 2);
    }
    double calculateSimplePercent(double amount,double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }
    double round(double value, int places) {
        double ScaLe = Math.pow(10, places);

        return Math.round(value * ScaLe) / ScaLe;
    }
    void printMenu() {
         Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
            int depositAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
            int depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
            int action = scanner.nextInt();
            double result = 0;

        if (action ==1) {
            result = calculateSimplePercent(depositAmount,0.06, depositPeriod);
        } else if (action == 2) {
            result = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
            }

     System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + result);
     }
public static void main(String[] args) {
    new DepositCalculator().printMenu();
    }
}
