import java.util.ArrayList;

public class Diet
{
    private ArrayList<Entry> list;

    public void addEntry(String eD, int w)
    {
        list.add(new Entry(eD, w));
    }

    public Entry getEntry(String w)
    {
        for(int i = 0; i<list.size();i++)
        {
            if (list.get(i).getEntryDate().equals(w))
            {
                return list.get(i);
            }
        }

        return null;
    }

    public int getDifference(int i)
    {
        int difference = 0;
        if(i!=0)
        {
            difference = list.get(i).getWeight()-list.get(i+1).getWeight();
        }

        return difference;
    }

    public void viewList()
    {
        System.out.println("   DATE     WEIGHT    DIFFERENCE");
        System.out.println("------------------------------------");
        for(int i = 0;i<list.size();i++)
        {
            System.out.println(" " + list.get(i).getEntryDate()+ "         " + list.get(i).getWeight() + getDifference(i));
            System.out.println();
        }
        System.out.println("------------------------------------");
        System.out.println("Net Weight Loss/Gain = " + (list.get(0).getWeight()-list.get(list.size()-1).getWeight()));
        System.out.println("------------------------------------");

    }

}
