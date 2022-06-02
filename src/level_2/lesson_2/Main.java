package level_2.lesson_2;


public class Main {
    public static void main(String[] args) {
        String str = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        String[][] strings = splitStr(str);
        int a = mathOperation(strings);
        System.out.println(a);
    }

    private static int mathOperation(String[][] str){
        try {
            int[][] arr = toInt(str);
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    sum += arr[i][j];
                }
            }
            return sum / 2;
        }catch (StringFormatException e){
            throw new StringFormatException(e.getMsg(),str);
        }
    }

    private static String[][] splitStr(String str){
        String[] arr = str.split("\n");
        String[][] newStr =  new String[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            newStr[i] = arr[i].split(" ");
        }
        return newStr;
    }

    private static int[][] toInt(String[][] str) throws StringFormatException{
        int[][] arr = new int[4][4];
        if (str.length != 4 ) throw new StringFormatException("Need arr[i][j], index[4][4]. Your i = " + str.length, str);
        for (int i = 0; i < str.length; i++) {
            if(str[i].length != 4) throw new StringFormatException("Need arr[i][j], index[4][4]. Your j = " + str[i].length, str);
            for (int j = 0; j < str[i].length; j++) {
                if(!isNumber(str[i][j])) throw new StringFormatException("It's not number, index[" + i + "][" + j +"] !",str);
                arr[i][j] = Integer.parseInt(str[i][j]);
            }
        }
        return arr;
    }

    private static boolean isNumber(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}
