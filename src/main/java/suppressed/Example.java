package suppressed;

public class Example {

    public static void main(String[] args)  {
        try {
            playWithSuppressedExceptions();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Suppressed exceptions: ");
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println(throwable);
            }
        }
    }

    private static void playWithSuppressedExceptions() throws Exception {
        try( CloseableError closeableError = new CloseableError()) {
            throw new Exception("exception in try-block");
        } catch (Exception e) {
            Exception exception = new Exception("exception in catch-block");
//            exception.addSuppressed(e);
            throw exception;
        } finally {
            throw new Exception("exception in finally-block");
        }
    }

}
