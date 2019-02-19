public enum CountDownEnum {
    ONE(1,"齐国"),
    TWO(2,"楚国"),
    THREE(3,"燕国"),
    FOUR(4,"韩国"),
    FIVE(5,"赵国"),
    SIX(6,"魏国");

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

    CountDownEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public static CountDownEnum for_CountDownEnum(int index){
        CountDownEnum[] values = CountDownEnum.values();
        for(CountDownEnum element:values){
            if(index == element.code){
                return element;
            }
        }
        return null;
    }
}
