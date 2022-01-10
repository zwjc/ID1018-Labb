import java.util.Arrays;

public class DenKortasteVagen
{
    /* mellanstationer returnerar en vektor med de mellanstationer som finns på den kortaste
     vägen. Ordningsnummer av den första mellanstationen finns på index 1, och ordningsnummer
     av den andra mellanstationen på index 2 i vektorn*/
    public static int[] mellanstationer (double[] XtoU, double[][] UtoV, double[] VtoY)
    {
        double min = XtoU[0]+ UtoV[0][0] + VtoY[0];
        double u = XtoU.length;
        double v = VtoY.length;
        // String Väg = "U1 och V1";
        int [] Vag = new int[2];
        Vag [0] = 0;
        Vag [1] = 0;
        for (int i = 0; i < u; i++)
        {
            for (int j = 0; j < v; j++)
            {
                double KortasteVagen = XtoU[i] + VtoY[j] + UtoV[i][j];
                if (KortasteVagen < min)
                {
                    min = KortasteVagen;
                    // Vag = "U" + (i+1) + " + V" + (j+1)
                    Vag[0] = (i+1);
                    Vag[1] = (j+1);
                }
            }
        }
        return Vag;
    }

    // langd returnerar längden av den kortaste vägen.

    public static double langd (double[] XtoU, double[][] UtoV, double[] VtoY)
    {
        int[] mellanstationer = mellanstationer(XtoU, UtoV, VtoY);
        System.out.println(Arrays.toString(mellanstationer));
        int i = mellanstationer[0]-1;
        int j = mellanstationer[1]-1;

        return UtoV[i][j] + XtoU[i] + VtoY[j];
    }
}
        /*int U = XtoU.length;
        int V = VtoY.length;
        double min = XtoU[0] + VtoY[0] + UtoV[0][0];
        for (int i = 0; i < U; i++)
        {
            //for (int j = 0; j < V; j++)
            {
                double KortasteVagen = UtoV[i][j] + XtoU[i] + VtoY[j];
                if (KortasteVagen < min)
                {
                    min = KortasteVagen;
                }
            }
        }
        return min;*/