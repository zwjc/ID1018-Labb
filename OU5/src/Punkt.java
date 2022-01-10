public class Punkt
{
    private String namn = "";
    private int x = 0;
    private int y = 0;
    public Punkt(String namn, int x, int y)
    {
        this.namn = namn;
        this.x = x;
        this.y = y;
    }
    public Punkt(Punkt p)
    {
        this.namn = p.namn;
        this.x = p.x;
        this.y = p.y;
    }
    public String toString()
    {
        return "(\"" + this.namn + "\", " + this.x + ", " + this.y + ")";
    }
    public String getNamn()
    {
        return this.namn;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public int avstand(Punkt p2)
    {
        return (int) Math.sqrt(((this.x - p2.x)*(this.x - p2.x))+((this.y - p2.y)*(this.y - p2.y)));
    }
    public boolean equals(Punkt p2)
    {
        if (p2.x == x && p2.y == y)
            return true;
        else
            return false;
    }
    public void setX(int vardeX)
    {
        x = vardeX;
    }
    public void setY(int vardeY)
    {
        y = vardeY;
    }
}
