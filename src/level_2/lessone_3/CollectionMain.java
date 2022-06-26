package level_2.lessone_3;

import java.util.LinkedHashMap;
import java.util.TreeSet;

public class CollectionMain {
    public static String split(String str, String description){
        String newStr = "";
        String[] arr = str.split(description);
        for (int i = 0; i < arr.length; i++) {
            newStr += arr[i];
        }
        return newStr;
    }
    public static String[] textToWord(String str){
        String[] word;
        String newStr = split(str,",");
        newStr = split(newStr,"\\.");
        word = newStr.split(" ");
        return word;
    }
    public static TreeSet<String> getWordList(String[] arr){
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set;
    }
    public static LinkedHashMap<String,Integer> getWordCount(String[] arr){
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = map.getOrDefault(arr[i],0) + 1;
            map.put(arr[i],count);
        }
        return map;
    }
    public static void main(String[] args) {
        String text = "Whether you are working on a new cutting edge app or simply ramping up on new technology," +
                " Java documentation has all the information you need to make your project a smashing success." +
                " Use the rich set of code samples, tutorials, developer guides, API documentation," +
                " and more to quickly develop your prototype and scale it up to a real world application.";
        String[] word = textToWord(text);
        LinkedHashMap<String,Integer> map = getWordCount(word);

        System.out.println(getWordList(word));
        System.out.println(map);

        Person person1 = new Person ("Denis","qwerty@aaa.net","8-888-888-88-88");
        Person person2 = new Person("Anna","asdfg@qqq.net","8-999-999-99-99");
        Person person3 = new Person("Denis","zxcv@qqq.net","8-111-111-11-11");
        Person person4 = new Person("Denis","zxcv@qqq.net","8-222-111-11-11");
        Person person5 = new Person("Denis","zxcv@qqq.net","8-333-111-11-11");


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(person1);
        phoneBook.add(person2);
        phoneBook.add(person3);
        phoneBook.add(person4);
        phoneBook.add(person5);


        System.out.println("{Denis phonenumber} " + phoneBook.getPhoneNumber("Denis"));
        System.out.println("{Anna phonenumber} " + phoneBook.getPhoneNumber("Anna"));

        System.out.println("{Denis email} " + phoneBook.getEmail("Denis"));
    }
}
