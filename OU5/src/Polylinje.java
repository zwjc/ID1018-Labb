public class Polylinje {
    //tom polylinje, färg och bredd
    private Punkt[]    horn;
    private String     farg = "svart";
    private int        bredd = 1;

    //Polylinje konstruktor
    public Polylinje ()
    {
        this.horn = new Punkt[0];   
    }

    //Polylinje som tar emot en array med punkter och skapar en polylinje av dem
    public Polylinje (Punkt[] horn)
    {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt (horn[i]);
    }

    //För att kunna skriva ut informationen om en specifik polylinje
    public String toString()
    {
        String returnString = " { [";
        for(Punkt p : horn)
        {
            returnString += p.toString();
        }
        returnString += "], " + this.farg + ", " + this.bredd + " }";
        return returnString;
    }

    public Punkt[] getHorn()
    {
        Punkt[] horn = new Punkt[this.horn.length];
        for(int i = 0; i < this.horn.length; i++)
        {
            horn[i] = new Punkt(this.horn[i]);
        }
        return horn;
    }

    public String getFarg()
    {
        return this.farg;
    }

    public int getBredd()
    {
        return this.bredd;
    }

    public void setFarg(String farg)
    {
        this.farg = farg;
    }

    public void setBredd(int bredd)
    {
        this.bredd = bredd;
    }

    //Denna beräknar längden av en polylinje, genom att mäta längden mellan alla hörn i polylinjen
    public double langd()
    {
        double langd = 0;
        for(int i = 0; i < this.horn.length - 1; i++)
        {
            langd += horn[i].avstand(horn[i + 1]);
        }
        return langd;
    }

    //Lägger till en punkt till en polylinjes horn add last at the end, + 1 parameter at the point
    public void laggTill (Punkt horn)
    {
        Punkt[]    p = new Punkt[this.horn.length + 1];
        int    i = 0;
        for (i = 0; i < this.horn.length; i++)
            p[i] = this.horn[i];
        p[i] = new Punkt (horn);
        this.horn = p;
    }

    //Med denna metod kan man välja var man vill lägga in en punkt i en polylinjes horn
    public void laggTillFramfor(Punkt punkten, String hornNamn)
    {
        //length + 1 add in a new point array a point before any point
        Punkt[] p = new Punkt[this.horn.length + 1];
        int i = 0;
        for(Punkt punkt : this.horn)
        {
            if(punkt.getNamn().equals(hornNamn))
            {
                p[i] = new Punkt(punkten);
                p[i+1] = punkt;
                i += 2;
                continue;
            }
            p[i] = punkt;
            i++;
        }
        this.horn = p;
    }

    //Denna string ska vara namnet på ett horn man vill radera från en polylinje.
    public void taBort(String hornNamn)
    {
        Punkt[] h = new Punkt[this.horn.length - 1];
        int i = 0;
        for(Punkt punkt : this.horn)
        {
            if(punkt.getNamn() == hornNamn)
            {
                continue;
            }
            h[i] = punkt;
            i++;
        }
        this.horn = h;
    }

    public class PolylinjeIterator
    {
        private int    aktuell = -1;

        public PolylinjeIterator ()
        {
            if (Polylinje.this.horn.length > 0)
                aktuell = 0;

        }

        public boolean finnsHorn ()
        {
            return aktuell != -1;
        }

        public Punkt horn ()throws java.util.NoSuchElementException
        {
            if (!this.finnsHorn ())
                throw new java.util.NoSuchElementException ("slut av iterationen");
            Punkt    horn = Polylinje.this.horn[aktuell];

            return horn;
        }

        public void gaFram ()
        {
            if (aktuell >= 0  && aktuell < Polylinje.this.horn.length -1)
                aktuell++;
            else
                aktuell = -1;
        }
    }
}
