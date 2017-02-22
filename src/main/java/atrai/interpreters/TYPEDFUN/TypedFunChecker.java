package atrai.interpreters.TYPEDFUN;

import atrai.antlr.ANTLRTokenizer;
import atrai.antlr.GenericAntlrToUntypedTree;
import atrai.antlr.Location;
import atrai.core.UntypedTree;
import atrai.core.Transformer;
import atrai.interpreters.common.Environment;
import atrai.interpreters.common.Interpreter;
import atrai.interpreters.common.SemanticException;

import static atrai.interpreters.TYPEDFUN.PrimitiveTypeValue.BOOL;
import static atrai.interpreters.TYPEDFUN.PrimitiveTypeValue.NULL;
import static atrai.interpreters.common.DynamicTypeChecker.*;
import static atrai.interpreters.common.DynamicTypeChecker.e;

/**
 * Created by ksen on 2/19/17.
 */

class TypeValue {

}

class PrimitiveTypeValue extends TypeValue {
    enum TypeName {INT, STRING, BOOL, NULL}
    public static final PrimitiveTypeValue INT = new PrimitiveTypeValue(PrimitiveTypeValue.TypeName.INT);
    public static final PrimitiveTypeValue STRING = new PrimitiveTypeValue(PrimitiveTypeValue.TypeName.STRING);
    public static final PrimitiveTypeValue BOOL = new PrimitiveTypeValue(PrimitiveTypeValue.TypeName.BOOL);
    public static final PrimitiveTypeValue NULL = new PrimitiveTypeValue(PrimitiveTypeValue.TypeName.NULL);

    private final PrimitiveTypeValue.TypeName val;
    private PrimitiveTypeValue(PrimitiveTypeValue.TypeName val) {
        this.val = val;
    }

}

class FunctionTypeValue extends TypeValue {

}

class StaticTypeError extends RuntimeException {
    final Location location;
    final Object t1;
    final Object t2;

    public StaticTypeError(String message, Object t1, Object t2, Location location) {
        super(message);
        this.location = location;
        this.t1 = t1;
        this.t2 = t2;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return getMessage()+" "+t1+ "!=" + t2 +" at "+getLocation();
    }
}

public class TypedFunChecker extends Interpreter {
    private String grammarName = "atrai.antlr.TYPEDFUN";


    public Object interpret(UntypedTree st) {
        return null;
    }



    public UntypedTree parseString(String pgm) {
        return null;
    }

    public UntypedTree parseFile(String pgm) {
        return null;
    }
}
