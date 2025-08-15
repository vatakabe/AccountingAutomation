import java.util.ArrayList;
import java.util.List;

public class ReconciliationReports {
    private List<MonthlyReport> MonthlyReports = new ArrayList<>();
    private List<YearlyReport> YearlyReport = new ArrayList<>();

    public ReconciliationReports(List<MonthlyReport> monthlyReports, List<YearlyReport> yearlyReport) {
        MonthlyReports = monthlyReports;
        YearlyReport = yearlyReport;
    }

    public void reconcillation(){
        
    }
}
