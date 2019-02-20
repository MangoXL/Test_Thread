public enum Week_Enum {
    MONDAY(1,"周一"),
    TUESDAY(2,"周二"),
    WEDNESDAY(3,"周三"),
    THURSDAY(4,"周四"),
    FRIDAY(5,"周五"),
    SATURDAY(6,"周六");

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    Week_Enum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Week_Enum for_Week(int index){
        Week_Enum[] values = Week_Enum.values();
        for(Week_Enum day:values){
            if(index == day.code){
                return day;
            }
        }
        return null;
    }
}
