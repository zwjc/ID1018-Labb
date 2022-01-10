/**
 public class Sortera
{
    Algoritm: sortera
    Förvillkor:
    U är en mängd vars element kan jämföras med operatorn <,
    N är mängden av alla naturliga heltal,
    n ε N, n ≥ 1, X = {x1, x2, ..., xn} ⊂ U,
    för ett godtyckligt heltal i, 1 ≤ i ≤ n, betecknar xi det element som finns på positionen i
    Eftervillkor:
    x1 < x2 < ... < xn
    Stegen i algoritmen:
    sortera (n, X)
    {
        i = 1
        while i < n
        {
            j = i + 1
            while j ≤ n
            {
                if (xj < xi)
                    utbyt xj och xi
                j++
            }

            i++
        }
    }
}
**/

/*
Om vi har att mängden nummer är 5; {4, 2, 1, 5, 3}

i = 1, j = 2, 3, 4, 5;
        {2, 4, 1, 5, 3}
        {1, 4, 2, 5, 3}
        {1, 4, 2, 5, 3}
        {1, 4, 2, 5, 3}

i = 2, j = 3, 4, 5;
        {1, 2, 4, 5, 3}
        {1, 2, 4, 5, 3}
        {1, 2, 4, 5, 3}

i = 3, j = 4, 5;
        {1, 2, 4, 5, 3}
        {1, 2, 3, 5, 4}

i = 4, j = 5;
        {1, 2, 3, 4, 5}
*/

//  För denna jämförelse jämför man (n-1)+(n-2)+..+2+1 gånger = (n-1)+1+(n-2)+2+... = n(n-1)/2, alltså θ-mängd på n^2 för n^2 växer snabbast

/*
//komplextet ska alltid vara specifik
Exchange sort:
Bästa: B(n) = 0 (Inga utbyten, många jämförelser)
Värsta: W(n) = n(n-1)/2 (Lika många utbyten som jämförelser)
Medel: A(n) n(n-1)/4  (Lite mindre utbyten än jämförelser)
 */
/*
Osorterade array: n, n-1, n-2,...,1,0;
Sorterade array:  0, 1, 2,..., n-1, n;

Selection sort: hitta min element och lägg den längst fram i arrayen
finns n+1 steg/utbyten och n+(n-1)+(n-2)+...+1+0 = 1+2+3+...+n = n(n-1)/2 jämförelser
Bästa: B(n) = n^2 (n(n-1)/2 jämförelser och inga utbyten)
Värsta: W(n) = n^2 (n(n-1)/2 jämförelser och n-1 utbyten)
Medel: A(n) = n^2 (n(n-1)/2 jämförelser och (n-1)/2 utbyten)
 */

/*
Om det sker ett medel antal utbyten så är det lite mindre än jämförelser
I sämsta fall för utbyten är det lika många utbyten som antalet jämförelser.
I bästa fall är antalet utbyten inga och därför mycket mindre än antalet jämförelser.
 */

/*
A) INRE LOOPEN
Inre loopen, j loop, byter plats på minsta talet och i indexet
När den inre loopen har utförts, gäller följande:
xi = minimum {xi, xi+1, ..., xn}
BEVIS
Eftersom om X(j) är mindre än X(i) sätts X(i) till värdet på X(j) och X(j) sätts till värdet på X(i).
Man kollar och byter med varje tal, som leder till att X(i) blir det minsta talet i vektorn när loopen är slutförd.
 */

/*
B) HUVUDLOOPEN
Huvudlooped ser till att platsbyten sker n antal gånger, iteration
När huvudloopen har utförts, gäller följande:
x1 < x2 < ...  < xn
BEVIS
I A lägger man det minsta värdet först och man gör detta på varje index så får varje index det
längsta värdet som är kvar att sortera i arrayen ex: 2-5, 3-5, 4-5 får det minsta talet som är kvar
*/