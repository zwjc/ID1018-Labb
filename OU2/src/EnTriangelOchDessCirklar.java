import java.util.Locale;
import java.util.Scanner;

public class EnTriangelOchDessCirklar
{
    public static void main(String[] args)
    {
        System.out.println("Triangels Sidolängder\n");
        Scanner in = new Scanner(System.in);
        in.useLocale (Locale.US);


        System.out.println("Bisektris 1: " +Triangle.bisektris(4, 8, 30));
        System.out.println("Bisektris 2: " +Triangle.bisektris(4, 4, 45));
        System.out.println("Bisektris 3: " +Triangle.bisektris(8, 12, 60));
        System.out.println();
        System.out.println("Radian av omskriven triangel: " +Triangle.TriangelIn(3, 4, 5));
        System.out.println("Radian av inskriven triangel: " +Triangle.TriangelUt(3, 4, 5));
        System.out.println();

        triangel();
    }

    public static void triangel()
    {
        double x, y, z = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Sida 1: ");
        x = in.nextDouble();
        System.out.print("Sida 2: ");
        y = in.nextDouble();
        System.out.print("Sida 3: ");
        z = in.nextDouble();
        System.out.println("Triangelns Omskrivna Radius Är: " +Triangle.TriangelIn(x, y, z));
        System.out.println("Triangelns Inskrivna Radius Är: " +Triangle.TriangelUt(x, y, z));
        System.out.println("Triangelns Area Är: " +Triangle.TriangelA(x, y, z));
    }

}
