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
    public static final PrimitiveTypeValue INT = new PrimitiveTypeValue(PrimitiveTypeValue.TypeName.INT);
    public static final PrimitiveTypeValue STRING = new PrimitiveTypeValue(PrimitiveTypeValue.TypeName.STRING);
    public static final PrimitiveTypeValue BOOL = new PrimitiveTypeValue(PrimitiveTypeValue.TypeName.BOOL);
    public static final PrimitiveTypeValue NULL = new PrimitiveTypeValue(PrimitiveTypeValue.TypeName.NULL);
    private final PrimitiveTypeValue.TypeName val;
    private PrimitiveTypeValue(PrimitiveTypeValue.TypeName val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    enum TypeName {INT, STRING, BOOL, NULL}

    @Override
    public String toString() {
        return val.toString();
    }
}

class FunctionTypeValue extends TypeValue {
    private TypeValue argType = null;
    private TypeValue returnType;

    public FunctionTypeValue(TypeValue argType, TypeValue returnType) {
        this.argType = argType;
        this.returnType = returnType;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FunctionTypeValue)) {
            return false;
        }
        FunctionTypeValue other = (FunctionTypeValue) obj;
        if (argType == null && other.argType == null) return true;
        if (argType == null) return false;
        if (other.argType == null) return false;
        if (!returnType.equals(other.returnType)) return false;
        if (!argType.equals(other.argType)) return false;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        if (argType != null) sb.append(argType);
        sb.append(")->").append(returnType);
        return sb.toString();
    }

    public void setReturnType(TypeValue returntype) {
        this.returnType = returntype;
    }

    public void setArgType(TypeValue argType) {
        this.argType = argType;
    }

    public TypeValue getReturnType() {
        return returnType;
    }

    public TypeValue getArgType() {
        return argType;
    }
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
