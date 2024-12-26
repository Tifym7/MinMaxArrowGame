package Monica.Model;

public class ArrowBuilder {

    public Arrow createDefaultArrow(){
        return new Arrow();
    }
    public Arrow createDirectionArrow(Direction type, Boolean mine){
        return new Arrow(type,mine);
    }
    public Arrow[][] createMatrixArrow(int dimension){
        return new Arrow[dimension][dimension];
    }
}
