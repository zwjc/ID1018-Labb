import java.util.Random;

public class ValjPolylinje {
    public static final Random    rand = new Random ();
    public static final int    ANTAL_POLYLINJER = 10;

    public static void main (String[] args)
    {
        // skapa ett antal slumpmässiga polylinjer
        Polylinje[]    polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for (int i = 0; i < ANTAL_POLYLINJER; i++)
            polylinjer[i] = slumpPolylinje ();

        // visa polylinjerna
        for(int i = 0; i < ANTAL_POLYLINJER; i++)
        {
            System.out.println("Polylinje " + (i + 1) + " är: " + polylinjer[i].toString());
            System.out.println();
        }

        // bestäm den kortaste av de polylinjer som är gula
        Polylinje kortaste = null;
        for(int i = 0; i < ANTAL_POLYLINJER; i++)
        {
            if(polylinjer[i].getFarg() == "gul")
            {
                if(kortaste == null || polylinjer[i].langd() < kortaste.langd())
                {
                    kortaste = polylinjer[i];
                }
            }
        }

        //visa den valda polylinjen
        if(kortaste != null)
        {
            System.out.println("Den kortaste gula polylinjen är: " + kortaste.toString());
        }
        else
        {
            System.out.println("Det finns ingen gul polylinje");
        }
    }

    // slumpPunkt returnerar en punkt med ett slumpmässigt namn,som är en stor bokstav i
    // det engelska alfabetet, ochslumpmässiga koordinater.
    public static Punkt slumpPunkt ()
    {
        String    n = "" + (char) (65 + rand.nextInt (26));
        int    x = rand.nextInt (11);
        int    y = rand.nextInt (11);

        return new Punkt (n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
    //eller gul. Namn på polylinjens hörn är stora bokstäver i det engelskaalfabetet. Två hörn
    //kan inte ha samma namn.
    public static Polylinje slumpPolylinje ()
    {
        // skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje ();
        int    antalHorn = 2 + rand.nextInt (7);
        int    antalValdaHorn = 0;
        boolean[]    valdaNamn = new boolean[26];
        //samma namn kan inte förekomma flera gånger
        Punkt    valdPunkt= null;
        char    valtChar = 0;
        Punkt[] punkterna = new Punkt[antalHorn];
        int i = 0;
        while (antalValdaHorn < antalHorn)
        {
            Punkt testPunkt = slumpPunkt();
            String namn = testPunkt.getNamn();
            valtChar = namn.charAt(0);
            if(valdaNamn[(int)valtChar - 65] == true)
            {
                continue;
            }
            else
            {
                valdaNamn[(int)valtChar - 65] = true;
                polylinje.laggTill(testPunkt);
                antalValdaHorn++;
            }
        }

        // sätt färg
            String farger[] = {"gul", "blå", "röd"};
            polylinje.setFarg(farger[rand.nextInt(3)]);
            return polylinje;
    }
}
