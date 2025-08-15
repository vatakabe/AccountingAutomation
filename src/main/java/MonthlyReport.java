import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonthlyReport {

    private MonthName month;
    private List<Item> items = new ArrayList<>();
    private String fileContent = null;
    private int totalExpense = 0;
    private int totalProfit = 0;

    public MonthlyReport(String fileContent){
        this.fileContent = fileContent;
        addItems(this.fileContent);
        calcTotalExpenseProfit();
    }

    private void addItems(String content){
        String[] lines  = content.split("\\n");
        lines = Arrays.copyOfRange(lines, 1, lines.length);
        for (String line: lines){
            line = line.replaceAll("\\r","");
            String[] splitLine = line.split(",");
            String itemName = splitLine[0];
            boolean isExpense = Boolean.parseBoolean(splitLine[1]);
            int quantity = Integer.parseInt(splitLine[2]);
            int sumOfOne = Integer.parseInt(splitLine[3]);
            items.add(new Item(itemName,isExpense,quantity,sumOfOne));
        }
    }

    private void calcTotalExpenseProfit(){
        for (Item item: items){
            if(item.isExpense() == true){
                totalExpense = totalExpense + (item.getQuantity()*item.getSumOfOne());
            }else{
                totalProfit = totalProfit + (item.getQuantity()*item.getSumOfOne());
            }
        }
    }
    static class Item{
        private String itemName;
        private boolean isExpense;
        private int quantity;
        private int sumOfOne;

        public Item(String itemName, boolean isExpense, int quantity, int sumOfOne) {
            this.itemName = itemName;
            this.isExpense = isExpense;
            this.quantity = quantity;
            this.sumOfOne = sumOfOne;
        }

        public String getItemName() {
            return itemName;
        }

        public boolean isExpense() {
            return isExpense;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getSumOfOne() {
            return sumOfOne;
        }

        @Override
        public String toString() {
            return itemName;
        }
    }
}

enum MonthName{
    JANUARY,FEBRUARY,MARCH,
    APRIL,MAY,JUNE,
    JULE,AUGUST,SEPTEMBER,
    OCTOBER,NOVEMBER,DECEMBER;
}
