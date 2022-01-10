public class minstaHeltal {
    public static void main(String[] args) {
        int[] test16 = {4, 5, 12, 8, 7, 6, 14, 3 ,2 , 9, 1, 17, 13, 21, 11, 10};
        int[] test19 = {17, 2, 3, 4, 5, 6, 7, 8 ,9, 10, 11, 12, 13, 14, 15, 16, 1, 18, 19};
        System.out.println(minstaHeltal.min(test16));
        System.out.println();
        System.out.println(minstaHeltal.min(test19));
    }
    
    public static int min(int[] elements) throws IllegalArgumentException {
        if (elements.length == 0) {
            throw new IllegalArgumentException("Empty collection!");
        }
        int nofIters = 0;

        int[] sequence = elements;
        int nofPairs = sequence.length / 2;
        int nofUnpairedElements = sequence.length % 2;
        int nofPossibleElements = nofPairs + nofUnpairedElements;
        int[] partialSeq = new int[nofPossibleElements];
        int i;
        int j;

        //sequence length never changes, waiting until no pairs left, compare until you cant
        while (nofPairs > 0) {
            i = 0;
            j = 0;

            while (j < nofPairs) {
                partialSeq[j] = (sequence[i] < sequence[i + 1]) ?
                        sequence[i] : sequence[i + 1];
                i += 2;
                j++;
            }

            if (nofUnpairedElements == 1) //pretend the unpaired element is outside array, 19 becomes 18 and one is left, you always end up in a situation with a pair (last possible thing is a pair if you have 3 and one is left out you end up with 2 for the last and the if loop is never reached)
                partialSeq[j] = sequence[nofPairs*2]; //change to nofPairs*2 = sequence length - 1, because sequence length never changes

            //can't use sequence length because it stays unchanged, but these ones are updated after every loop
            sequence = partialSeq;
            nofPairs = nofPossibleElements / 2;
            nofUnpairedElements = nofPossibleElements % 2;
            nofPossibleElements = nofPairs + nofUnpairedElements;


            // Trace printing 1 - to follow the sequence
            System.out.println(java.util.Arrays.toString(sequence));
            // Trace printing 2 - to terminate the loop preemptively
            // (to be able to see what happens initially)
            if (nofIters++ == 10)
            System.exit (0);
        }

        // sequence[0] is the only remaining possible element
        // - it is the least element
        System.out.println();
        return sequence[0];
    }
}