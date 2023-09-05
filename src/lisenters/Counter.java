package lisenters;

/**
 * Counter  is a simple class that is used for counting things.
 */
public class Counter {
    private int count;

    /**
     * constructor.
     *
     * @param count
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * add number to current count.
     *
     * @param number number I'm adding.
     */
    public void increase(int number) {
        this.count = count + number;
    }

    /**
     * subtract number form the current count.
     *
     * @param number
     */
    public void decrease(int number) {
        this.count = count - number;
    }


    /**
     * geet current count.
     *
     * @return the count.
     */
    public int getValue() {
        return this.count;
    }
}
