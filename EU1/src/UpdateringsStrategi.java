public class UpdateringsStrategi
{
    public static void main (String[] args)
    {
        int [] x = {13, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 14, 15, 16};
        System.out.println (min(x));
    }

    public static int min (int[] x)
    {
        int min = x[0];
        for (int i : x)
        {
            if (i <= min)
            {
                min = i;
            }
        }
        return min;
    }
}
