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
    public void readMonthlyReports(){
        List<String> filesUri = getFilesUri("m");
        for(String fileStringPath: filesUri){
            String fileContent = readFileContentOrNull(fileStringPath);
            if(fileContent != null){
                MonthlyReports.add( new MonthlyReport(fileContent) );
            }
        }
    }


    public void readYearlyReports(){
        List<String> filesUri = getFilesUri("y");
        for(String fileStringPath: filesUri){
            String fileContent = readFileContentOrNull(fileStringPath);
            if(fileContent != null){
                YearlyReport.add( new YearlyReport(fileContent) );
            }
        }
    }
    private List<String> getFilesUri(String type){
        File directory = new File(FolderPath);
        File[] files = directory.listFiles();
        List<String> result = new ArrayList<>();
        if(files !=null){
            for(File file: files){
                String fileName = file.getName();
                if(fileName.split("\\.")[0].equalsIgnoreCase(type)){
                    result.add(file.getAbsolutePath());
                }
            }
        }
        return result;
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
