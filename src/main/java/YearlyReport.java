public class YearlyReport {
    private String fileContent;
    public YearlyReport(String fileContent){
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
