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
    static class Item{
        private int month;
        private int amount;
        private boolean isExpense;

        public Item(int month, int amount,boolean isExpense) {
            this.month = month;
            this.amount = amount;
            this.isExpense = isExpense;
        }


    }
}
