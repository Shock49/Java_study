package level_2.lesson_2;

public class StringFormatException extends NumberFormatException{
    private int iLength;
    private int jLength;
    private String msg;



    public StringFormatException(String msg, String[][] str){
        super(msg);
        this.msg = msg;
       this.iLength = str.length;
       this.jLength = minLength(str);
    }
    public String getMsg() {
        return this.msg;
    }

    public int getiLength() {
        return this.iLength;
    }

    public int getjLength() {
        return this.jLength;
    }

    private static int minLength(String[][] str){
        int min = str[0].length;
        for (int i = 1; i < str.length; i++) {
            if (min > str[i].length)min = str[i].length;
        }
        return min;
    }
}
