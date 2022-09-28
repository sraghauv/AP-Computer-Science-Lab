import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;
class SortedList {
    private ArrayList <String> list;
    public SortedList() {
        list = new ArrayList<>();
    }
    public void add(String word) {
        list.add(word);
        for(int i = 1; i < list.size(); i++){
            String temp = list.remove(i);
            int j = i;
            while(j > 0 && list.get(j-1).compareTo(temp) > 0){
                j--; }
            list.add(j, temp);
        }
    }
    public void remove(String word) {
        if(list.contains(word)){
            list.remove(word);
            for(int i = 1; i < list.size(); i++){
                String temp = list.remove(i);
                int j = i;
                while(j > 0 && list.get(j-1).compareTo(temp) > 0){
                    j--; }
                list.add(j, temp);
            }
        }else{
            for(int i = 1; i < list.size(); i++){
                String temp = list.remove(i);
                int j = i;
                while(j > 0 && list.get(j-1).compareTo(temp) > 0){
                    j--; }
                list.add(j, temp);
            }
        } }
    public String toString() {
        String text = String.valueOf(list);
        return text;
    }
}
class SortedListRunner
{
    public static void main(String args[])
    {

        SortedList test = new SortedList();
        out.println("adding alice");
        test.add("alice");
        out.println("adding tommy");
        test.add("tommy");
        out.println("adding bobby");
        test.add("bobby");
        out.println("adding annabell");
        test.add("annabell");
        out.println("adding sallysue");
        test.add("sallysue");
        out.println("adding sallymae");
        test.add("sallymae");
        out.println("printing the list ::  "+test+"\n\n");
        out.println("removing bobby");
        test.remove("bobby");
        out.println("printing the list ::  "+test+"\n\n");
        out.println("removing alice");
        test.remove("alice");
        out.println("printing the list ::  "+test+"\n\n");
        out.println("adding fred");
        test.add("fred");
        out.println("adding xylophone");
        test.add("xylophone");
        out.println("printing the list ::  "+test+"\n\n");
        out.println("removing tommy");
        test.remove("tommy");
        test.remove("tommy");  //should do nothing
        out.println("printing the list ::  "+test+"\n\n");
        out.println("removing fred");
        test.remove("fred");
        out.println("removing annabell");
        test.remove("annabell");
        out.println("removing sallysue");
        test.remove("sallysue");
        out.println("printing the list ::  "+test+"\n\n");
    } }
