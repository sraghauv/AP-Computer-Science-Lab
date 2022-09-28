public class Entry
{
    private String entryDate;
    private int weight;
    public Entry()
    {

    }
    public Entry(String d, int w)
    {
        entryDate=d;
        weight=w;
    }

    public void setEntryDate(String d)
    {
        entryDate=d;
    }

    public void setWeight(int w)
    {
        weight=w;
    }

    public String getEntryDate()
    {
        return entryDate;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return " ";
    }
}
