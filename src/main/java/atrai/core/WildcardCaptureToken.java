package atrai.core;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

/**
 * Capture subtrees matching this token.
 *
 * @author Koushik Sen
 * @author Alex Reinking
 */
class WildcardCaptureToken extends LeafNode {
    static final WildcardCaptureToken instance = new WildcardCaptureToken();

    private WildcardCaptureToken() {

    }

    @Override
    public boolean matches(Object other, ObjectArrayList<Object> captures) {
        captures.add(other);
        return true;
    }

    @Override
    public Object replace(Object[] captures) {
        return null;
    }

    @Override
    void toSourceString(StringBuilder sb) {
        sb.append(SerializedTreeParser.WILDCARDCAPTURE);
    }

    @Override
    public void toIndentedString(StringBuilder sb, String indent) {
        sb.append(SerializedTreeParser.WILDCARDCAPTURE);
    }

    @Override
    public String toString() {
        return SerializedTreeParser.WILDCARDCAPTURE;
    }
}
