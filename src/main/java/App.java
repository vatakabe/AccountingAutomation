import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reports reports = new Reports();
        while(true){
            showConsole();
            String line = sc.nextLine();
            if(line.equalsIgnoreCase("exit")) break;
            switch(line){
                case "1": {
                    reports.readMonthlyReports();
                    continue;
                }
                case "2": {
                    reports.readYearlyReports();
                    continue;
                }
                case "3": break;
                case "4": break;
                case "5": break;
                default:
                    System.out.println("Введите цифру");
                    continue;
            }


        }
    }

    static void showConsole(){
        System.out.println("1:Считать все месячные отчеты");
        System.out.println("2:Считать годовой отчет");
        System.out.println("3:Сверить отчеты");
        System.out.println("4:Вывести информацию о всех месячных отчетах");
        System.out.println("5:Вывести информацию о годовом отчете");
    }
}
