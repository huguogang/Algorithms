package test.name.huguogang.Algorithms;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
/**
 * Some test code for IO
 * 
 * @author ghu
 *
 */
public class IOTest {

    /**
     * Java 1.7 only, asynchronous write
     * @throws IOException 
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    @Test
    public void aynchWriteTest() throws IOException, InterruptedException, ExecutionException {
        Path file = Paths.get("/tmp/asychWriteTest.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(file, 
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(100_000);
        Future<Integer> result = channel.write(buffer, 0);
        int counter = 0;
        while(!result.isDone()) {
            System.out.println(counter++);
        }
        System.out.println("Bytes written: " + result.get());
    }
}
