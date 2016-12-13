import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String procName = args[1];

        if (procName == null || procName.length() == 0) {
            throw new IllegalStateException("Missing proc name");
        }

        Optional<Proc> proc = ProcFinder.find(args[1]);

        if (proc.isPresent()) {
            kill(proc.get());
        } else {
            System.out.println(args[1] + " was not running");
        }
    }

    private static void kill(Proc proc) {
        CommandRunner.run("taskkill /pid " + proc.getPid() + " /f");
    }

}