package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    // Zadanie 6: Stałe
    private static final int MAX_SIZE = 12;
    private static final int EMPTY_INDICATOR = -1;
    private static final int FULL_INDICATOR = 11;

    // Zadanie 7: Modyfikator final
    private final int[] numbers = new int[MAX_SIZE];

    private int total = EMPTY_INDICATOR;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY_INDICATOR;
    }

    public boolean isFull() {
        return total == FULL_INDICATOR;
    }

    protected int peekaboo() {
        if (callCheck())
            return EMPTY_INDICATOR;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return EMPTY_INDICATOR;
        return numbers[total--];
    }

    public int getTotal() {
        return total;
    }
}