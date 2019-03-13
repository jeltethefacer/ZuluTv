import java.util.concurrent.ThreadLocalRandom;

public class Entity {
    private int id;
    private String[] newsTicker;

    //initalizes a new newsticker which can hold up to ten items
    public Entity()
    {
        id = generateId();
        newsTicker = new String[10];
    }

    public Entity( String[] newsTicker)
    {
        if(newsTicker.length >10)
        {
            //TODO should handle this
            System.exit(0);
        }
        id = generateId();
        this.newsTicker = newsTicker;
    }

    private int generateId()
    {
        int randomNum = ThreadLocalRandom.current().nextInt(100000, 1000000);
        return randomNum;
    }

    public String generateNewstickerString()
    {
        String completeString = "";
        for(String ticker : this.newsTicker)
        {
            if(ticker != null)
            {
                completeString = completeString + ticker + '\n';
            }
        }
        return completeString;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Code: " + this.id + "\ntickers: " +  generateNewstickerString() + "\n";
    }


    public String toJSON()
    {
        String completeString = "{ \"NewsTicker\" : [ ";
        boolean firstElement = true;
        for(String ticker : this.newsTicker)
        {
            if(ticker != null)
            {
                if(firstElement)
                {
                    completeString = completeString + "\"" + ticker + "\"";
                    firstElement = false;
                }else
                {
                    completeString = completeString + ",\"" + ticker + "\"";

                }
            }
        }

        completeString += "]}";
        return completeString;
    }

    public void setNewsTicker(String[] newsTicker) {
        this.newsTicker = newsTicker;
    }
}
