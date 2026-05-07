package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    private static final int RHYMERS_COUNT_LIMIT = 15;
    private static final int STANDARD_RHYMERS_TO_FILL = 3;
    private static final int RANDOM_RANGE = 20;
    private static final int HANOI_RHYMER_INDEX = 3;

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();

        testRhymers(factory);
    }

    private static void testRhymers(RhymersFactory factory) {
        DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};

        for (int i = 1; i < RHYMERS_COUNT_LIMIT; i++)
            for (int j = 0; j < STANDARD_RHYMERS_TO_FILL; j++)
                rhymers[j].countIn(i);

        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < RHYMERS_COUNT_LIMIT; i++)
            rhymers[HANOI_RHYMER_INDEX].countIn(rn.nextInt(RANDOM_RANGE));

        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[HANOI_RHYMER_INDEX]).reportRejected());
    }

}