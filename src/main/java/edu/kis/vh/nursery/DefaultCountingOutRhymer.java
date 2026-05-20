package edu.kis.vh.nursery;

/**
 * Klasa DefaultCountingOutRhymer zapewnia podstawową funkcjonalność
 * przechowywania i odczytywania liczb w strukturze typu stos.
 */
public class DefaultCountingOutRhymer {

    // Zadanie 6: Stałe
    private static final int MAX_SIZE = 12;
    private static final int EMPTY_INDICATOR = -1;
    private static final int FULL_INDICATOR = 11;
    private static final int IF_EMPTY_STACK = -1;

    // Zadanie 7: Modyfikator final
    private final int[] numbers = new int[MAX_SIZE];

    private int total = IF_EMPTY_STACK;

    /**
     * Dodaje nową liczbę do stosu, o ile nie jest on pełny.
     * @param in wartość do dodania
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    /**
     * Sprawdza, czy stos jest pusty.
     * @return true jeśli stos jest pusty, w przeciwnym razie false
     */
    public boolean callCheck() {
        return total == IF_EMPTY_STACK;
    }

    // TODO: Rozważyć dynamiczne zwiększanie rozmiaru tablicy, gdy isFull() zwróci true
    /**
     * Sprawdza, czy osiągnięto maksymalną pojemność stosu.
     * @return true jeśli stos jest pełny, w przeciwnym razie false
     */
    public boolean isFull() {
        return total == FULL_INDICATOR;
    }


    /**
     * Pozwala podejrzeć ostatnio dodaną wartość bez jej usuwania.
     * @return ostatnia wartość na stosie lub wskaźnik pustego stosu
     */
    protected int peekaboo() {
        if (callCheck())
            return EMPTY_INDICATOR;
        return numbers[total];
    }

    /**
     * Pobiera i usuwa ostatnio dodaną wartość ze stosu.
     * @return pobrana wartość lub wskaźnik pustego stosu
     */
    public int countOut() {
        if (callCheck())
            return EMPTY_INDICATOR;
        return numbers[total--];
    }
}