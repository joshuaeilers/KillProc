import java.io.IOException;

class CommandRunner {
    static Process run(String command) {
        try {
            System.out.println(command);
            return Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
