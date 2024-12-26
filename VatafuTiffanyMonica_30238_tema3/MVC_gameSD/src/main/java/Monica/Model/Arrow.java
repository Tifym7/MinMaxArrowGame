package Monica.Model;

public class Arrow{
    private Direction type;
    private Boolean mine;

    public Arrow() {
        type = Direction.noDir;
    }
    public Arrow(Direction type, Boolean mine) {
        this.type = type;
        this.mine = mine;
    }
    public Direction getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arrow arrow = (Arrow) o;
        return type == arrow.type;
    }

}
