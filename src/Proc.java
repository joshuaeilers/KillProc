class Proc {
    private String name;
    private Integer pid;

    Proc(String name, Integer pid) {
        this.name = name;
        this.pid = pid;
    }

    String getName() { return name; }
    Integer getPid() { return pid; }
}