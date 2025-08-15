import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    private MonthName month;
    private List<Item> items = new ArrayList<>();
    private String fileContent;
    public MonthlyReport(String fileContent){
        this.fileContent = fileContent;
    }
    public void addItems(String line){

    }
    static class Item{
        private String itemName;
        private boolean isExpense;
        private int quantity;
        private int sumOfOne;
    }
}
enum MonthName{
    JANUARY,FEBRUARY,MARCH,
    APRIL,MAY,JUNE,
    JULE,AUGUST,SEPTEMBER,
    OCTOBER,NOVEMBER,DECEMBER;
}
