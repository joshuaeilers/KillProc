import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.stream.Stream;

class ProcFinder {
    static Optional<Proc> find(String processName) {
        return getProcs()
            .filter(p -> p.getName().equals(processName))
            .findFirst();
    }

    private static Stream<Proc> getProcs() {
        Process process = CommandRunner.run("tasklist /fo csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        return reader.lines()
            .skip(1)
            .map(line -> {
                String[] parts = line.split(",");
                return new Proc(parts[0].replace("\"", ""), Integer.parseInt(parts[1].replace("\"", "")));
            });
    }
}
