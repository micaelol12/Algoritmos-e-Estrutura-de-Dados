package Trabalho1;

public class Tag {
    private String tag;
    private int count;


    public Tag(String tag) {
        setTag(tag);
        setCount(1);
    }
    
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
