public class EBook extends Book implements Borrowable{

    private double fileSizeMB;

    public EBook(String title, String author, double fileSizeMB) {
        super(title, author);
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public void borrowItem() {
        // Implementation for borrowing an e-book
    }

    @Override
    public void returnItem() {
        // Implementation for returning an e-book
    }

    /**
     * Simulates downloading the e-book. The method enforces a positive size
     * and simulates a 2-second download using Thread.sleep.
     * If the thread is interrupted during sleep, the interrupt flag is re-set.
     *
     * @param sizeKB size of the download in kilobytes; must be positive
     * @throws IllegalArgumentException if sizeKB is not positive
     */
    public void downloadBook(int sizeKB) {
        if (sizeKB <= 0) {
            throw new IllegalArgumentException("sizeKB must be positive");
        }

        System.out.println("Starting download (" + sizeKB + " KB)...");
        try {
            // Simulate download delay
            Thread.sleep(2000);
            System.out.println("Download complete.");
        } catch (InterruptedException e) {
            // Restore the interrupt status and handle interruption
            Thread.currentThread().interrupt();
            System.out.println("Download was interrupted.");
        }
    }

    @Override
    public String toString(){
        return "Book{" + fileSizeMB+" fileSizeMB}";

    }
}
