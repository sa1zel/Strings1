import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        String fileName = "notes3.txt";
        String text = readText(fileName);
        List<String> stringList = new ArrayList<>();
        List<Word> words = new ArrayList<>();
        reader(stringList);
        for(int i = 0; i < 4; i++){
            words.add(new Word(stringList.get(i), counting(text, stringList.get(i))));
        }
        Collections.sort(words);
        System.out.println(words);
    }

    private static int counting(String text, String word){
        int counter = 0;
        String str1 = text.replace(".", " ").replace(",", " ").replace("!", " ").replace("?", " ").toLowerCase();
        String[] aStr = str1.split(" ");
        for(String str: aStr){
            if(str.contains(word))counter++;
        }
        return counter;
    }

    private static void reader(List<String> list){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words:");
        System.out.println("First word:");
        list.add(scanner.nextLine());
        System.out.println("Second word:");
        list.add(scanner.nextLine());
        System.out.println("Third word:");
        list.add(scanner.nextLine());
        System.out.println("Fourth word:");
        list.add(scanner.nextLine());
    }

    private static String readText(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            char[] buf = new char[5000];
            while ((c = reader.read(buf)) > 0) {

                if (c < 5000) {
                    buf = Arrays.copyOf(buf, c);
                }

            }
            String buff = new String(buf);
            System.out.println(buff);
            return buff;
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return "";
    }
}
