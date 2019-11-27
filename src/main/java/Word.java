public class Word implements Comparable<Word>{
    private String str;
    private int count;

    Word(String str, int count){
        this.str = str;
        this.count = count;
    }

    @Override
    public String toString() {
        return str + " " + count;
    }

    @Override
    public int compareTo(Word word) {
        return this.count - word.count;
    }
}
