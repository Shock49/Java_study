package level_2.lesson_1;

public class test {
    public static void main(String[] args) {
        float[] arr = new float[30];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Math.sin(Math.random()*360));
        }
        System.out.println(Math.toRadians(30));
        System.out.println(Math.toRadians(60));
        System.out.println(Math.toRadians(90));
        System.out.println(Math.toRadians(180));
        System.out.println(Math.toRadians(270.0d));
        System.out.println(Math.toRadians(360));

    }
}
