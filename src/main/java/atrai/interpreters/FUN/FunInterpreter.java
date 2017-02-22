package atrai.interpreters.FUN;

import atrai.antlr.ANTLRTokenizer;
import atrai.antlr.GenericAntlrToUntypedTree;
import atrai.antlr.Location;
import atrai.core.InternalNode;
import atrai.core.UntypedTree;
import atrai.core.Transformer;
import atrai.interpreters.common.Environment;
import atrai.interpreters.common.Interpreter;
import atrai.interpreters.common.SemanticException;

import static atrai.interpreters.common.DynamicTypeChecker.*;
import static atrai.interpreters.common.DynamicTypeChecker.i;
import static atrai.interpreters.common.DynamicTypeChecker.s;

class NullValue {
    public final static NullValue instance = new NullValue();

    @Override
    public String toString() {
        return "null";
    }
}

/**
 * Stores a lambda (a triple of bound variables, a body, and the environment it was created in)
 *
 * @author Koushik Sen
 * @author Alex Reinking
 */
class Lambda {
    final String boundVar;
    final InternalNode body;
    final Environment env;

    public Lambda(String boundVar, InternalNode body, Environment env) {
        this.boundVar = boundVar;
        this.body = body;
        this.env = env;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(env);
        sb.append(" fun (");
        if (boundVar != null) {
            sb.append(boundVar);
        }
        sb.append(") ").append(body);
        return sb.toString();
    }
}
//endregion

/**
 * FunInterpreter for the FUN language
 *
 * @author Koushik Sen
 * @author Alex Reinking
 */
public class FunInterpreter extends Interpreter {
    private String grammarName = "atrai.antlr.FUN";


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
