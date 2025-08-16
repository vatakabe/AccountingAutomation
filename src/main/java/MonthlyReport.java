import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonthlyReport {

    private MonthName month;
    private List<Item> items = new ArrayList<>();
    private String fileContent = null;
    private int totalExpense = 0;
    private String mostExpenseItem;
    private int totalProfit = 0;
    private String mostProfitItem;
    public MonthlyReport(File filePath,String fileContent){
        this.fileContent = fileContent;
        setMonth(filePath);
        addItems(this.fileContent);
        calcTotalExpenseProfit();
    }
    public void setMonth(File filePath){
        String StrDate = filePath.getName().split("\\.")[1];
        int intMonth = Integer.parseInt( StrDate.substring(StrDate.length() - 2,StrDate.length()) );
        month = MonthName.getMonthNumber(intMonth);
    }

    public MonthName getMonth() {
        return month;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getFileContent() {
        return fileContent;
    }

    public int getTotalExpense() {
        return totalExpense;
    }

    public int getTotalProfit() {
        return totalProfit;
    }
    public String getInformation(){
        StringBuilder sb = new StringBuilder();
        Item expenseItem = null;
        Item profitItem = null;
        int maxExpense = 0;
        int maxProfit = 0;
        for (Item item: items){
            int itemValue = item.getQuantity()*item.getSumOfOne();
            if(item.getIsExpense() == true && itemValue >=maxExpense){
                expenseItem = item;
                maxExpense = itemValue;
            }else if ( item.getIsExpense() != true && itemValue >=maxProfit ){
                profitItem = item;
                maxProfit = itemValue;
            }
        }
        sb.append("Month: " + getMonth() + " Most expense is " + expenseItem.getItemName()
        + " " + maxExpense
        + " Most profit is " + profitItem.getItemName()  + " " + maxProfit);
        return sb.toString();
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
            if(item.getIsExpense() == true){
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

        public boolean getIsExpense() {
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
