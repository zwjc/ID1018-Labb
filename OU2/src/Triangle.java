public class Triangle
{
    public static double bisektris(double b, double c, double alfa)
    {
        double p = 2 * b * c * Math.cos(alfa / 2);
        double bis = p / (b + c);
        return bis;
    }
    public static double TriangelIn(double x, double y, double z)
    {
        double s = (x + y + z) / 2;
        double r = ((x * y * z) / (4 * (Math.sqrt(s * (s - x) * (s - y) * (s - z)))));
        return r;
    }
    public static double TriangelUt(double x, double y, double z)
    {
        double s = (x + y + z) / 2;
        double r = ((Math.sqrt(s * (s - x) * (s - y) * (s - z)) / (s)));
        return r;
    }
    public static double TriangelA(double x, double y, double z)
    {
        double s = (x + y + z) / 2;
        double r = (Math.sqrt(s * (s - x) * (s - y) * (s - z)));
        return r;
    }
}