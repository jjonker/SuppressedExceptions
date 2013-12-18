package suppressed;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CloseableError implements Closeable {

    @Override
    public void close() throws IOException {
        throw new FileNotFoundException();
    }
}
