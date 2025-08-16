import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Reports {
    private List<MonthlyReport> MonthlyReports = new ArrayList<>();
    private List<YearlyReport> YearlyReport = new ArrayList<>();
    private final static String FolderPath =
            "C:\\dev\\AccountingAutomation\\src\\main\\resources";

    public List<MonthlyReport> getMonthlyReports() {
        return MonthlyReports;
    }

    public List<YearlyReport> getYearlyReport() {
        return YearlyReport;
    }

    public void reconcillation(){
        if(MonthlyReports.size() > 0 || YearlyReport.size() > 0){
            List<String> cashGap = new ArrayList<>();
            for( YearlyReport yearlyReport: YearlyReport){
                List<YearlyReport.Item> reportItems = yearlyReport.getReport();
                for( YearlyReport.Item YItem: reportItems ){
                    for(MonthlyReport mReport: MonthlyReports){
                        if(YItem.getMonth().equals(mReport.getMonth())){
                            if(YItem.getIsExpense()){
                                if( YItem.getAmount() != mReport.getTotalExpense() )
                                    cashGap.add(mReport.getMonth().toString()+ " " + " расход ");
                            }else{
                                if( YItem.getAmount() != mReport.getTotalProfit() )
                                    cashGap.add(mReport.getMonth().toString()+ " " + " доход ");
                            }
                        }
                    }
                }
            }
            System.out.println(cashGap);
        }
        else{
            System.out.println("Считайте данные отчетов");
        }
    }

    public void readMonthlyReports(){
        List<File> filesUri = getFilesUri("m");
        for(File filePath: filesUri){
            String fileContent = readFileContentOrNull(filePath.getAbsolutePath());
            if(fileContent != null){
                MonthlyReports.add( new MonthlyReport(filePath,fileContent) );
            }
        }
    }

    public void readYearlyReports(){
        List<File> filesUri = getFilesUri("y");
        for(File filePath: filesUri){
            String fileContent = readFileContentOrNull(filePath.getAbsolutePath());
            if(fileContent != null){
                YearlyReport.add( new YearlyReport(fileContent) );
            }
        }
    }
    private List<File> getFilesUri(String type){
        File directory = new File(FolderPath);
        File[] files = directory.listFiles();
        List<String> result = new ArrayList<>();
        List<File> res = new ArrayList<>();
        if(files !=null){
            for(File file: files){
                String fileName = file.getName();
                if(fileName.split("\\.")[0].equalsIgnoreCase(type)){
                    result.add(file.getAbsolutePath());
                    res.add(file);
                }
            }
        }
        return res;
    }
    private String readFileContentOrNull(String fileStringPath){
        try{
            return Files.readString(Path.of(fileStringPath));
        }catch(IOException e){
            System.out.println("Невозможно прочитать данные с отчетом.");
            return null;
        }
    }
}
