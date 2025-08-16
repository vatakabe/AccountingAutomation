import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YearlyReport {
    private List<Item> report = new ArrayList<>();
    public YearlyReport(String fileContent){
        addItems(fileContent);
    }
    public void addItems(String content){
        String[] lines  = content.split("\\n");
        lines = Arrays.copyOfRange(lines, 1, lines.length);
        for (String line: lines){
            line = line.replaceAll("\\r","");
            String[] splitLine = line.split(",");
            int month = Integer.parseInt(splitLine[0]);
            int amount = Integer.parseInt(splitLine[1]);
            boolean isExpense = Boolean.parseBoolean(splitLine[2]);
            report.add(new Item(month,amount,isExpense));
        }
    }

    public List<Item> getReport() {
        return report;
    }

    static class Item{
        private MonthName month;
        private int amount;
        private boolean isExpense;

        public Item(int intMonth, int amount,boolean isExpense) {
            month = MonthName.getMonthNumber(intMonth);
            this.amount = amount;
            this.isExpense = isExpense;
        }

        public MonthName getMonth() {
            return month;
        }

        public int getAmount() {
            return amount;
        }

        public boolean getIsExpense() {
            return isExpense;
        }

    }
}
