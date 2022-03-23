package arraysAndStrings;

//https://leetcode.com/problems/reformat-date/
//All testcases passed
public class ReformatDate {
    public String reformatDate(String date) {
        String[] list = date.split(" ");
        String day = list[0].substring(0,list[0].length()-2);
        if(day.length() == 1){
            day = "0" + day;
        }
        String month = getMonth(list[1]);
        String year = list[2];
        String finalDate = year + "-" + month + "-" + day;
        return finalDate;
    }

    public static String getMonth(String month){
        switch(month){
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
            default:
                return "00";
        }
    }
}
