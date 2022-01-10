public class Polylinjetest {
    public static void main (String[] args)
    {
        Punkt[] punkttest = new Punkt[4];
        for(int i = 0; i <=3; i++)
        {
            String namn = Integer.toString(i);
            punkttest[i] = new Punkt(namn, 4 - i, 2 + i);
            punkttest[1] = new Punkt ("a", 2, 3);
        }
        Polylinje p2 = new Polylinje(punkttest);
        Punkt[] punkt2 = p2.getHorn();
        int i = 0;
        for(Punkt punkt : punkt2)
        {
            i++;
            System.out.println("Punkt " + i + " är: " + punkt);
        }
        System.out.println();

        System.out.println("p2 har färgen: " + p2.getFarg());

        System.out.println("p2 har bredden: " + p2.getBredd());

        System.out.println("p2 har längden: " + p2.langd());

        p2.setFarg("röd");
        p2.setBredd(5);

        System.out.println("Den nya färgen på p2: " + p2.getFarg());
        System.out.println("Den nya bredden på p2: " + p2.getBredd());

        Punkt laggTillNamn = new Punkt("A", 1, 2);
        p2.laggTill(laggTillNamn);
        System.out.println("p2 med namnet A" + p2.toString());

        Punkt laggTillFramforPunkt = new Punkt("B", 1, 10);
        p2.laggTillFramfor(laggTillFramforPunkt, p2.getHorn()[0].getNamn());
        System.out.println("p2 med en extra punkt på index 0" + p2.toString());

        p2.taBort(p2.getHorn()[0].getNamn());
        System.out.println("p2 med namnet i index 0 borta" + p2.toString());

        System.out.println();

        //PolylinjeIterator test
        Polylinje.PolylinjeIterator iterator = p2.new PolylinjeIterator();
        while(iterator.finnsHorn())
        {
            System.out.println(iterator.horn());
            iterator.gaFram();
        }
    }
}
