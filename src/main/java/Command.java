public enum Command {
    PLACE, MOVE, LEFT, RIGHT, REPORT;

    public boolean isLeft(Command command) {
        return command == command.LEFT;
    }
}
