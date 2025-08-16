enum MonthName {
    JANUARY(1),FEBRUARY(2),MARCH(3),
    APRIL(4),MAY(5),JUNE(6),
    JULE(7),AUGUST(8),SEPTEMBER(9),
    OCTOBER(10),NOVEMBER(11),DECEMBER(12);
    private int monthNumber;
    MonthName(int monthNumber){
        this.monthNumber = monthNumber;
    }
    public static MonthName getMonthNumber(int monthNumber) {
        return MonthName.values()[monthNumber-1];
    }
}
