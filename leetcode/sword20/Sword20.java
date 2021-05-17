import java.util.HashMap;
import java.util.Map;

public class Sword20 {
    enum State {
        STATE_INITIAL, STATE_INT_SIGN, STATE_INTEGER, STATE_POINT, STATE_POINT_WITHOUT_INT, STATE_FRACTION, STATE_EXP,
        STATE_EXP_SIGN, STATE_EXP_NUMBER, STATE_END
    }

    enum CharType {
        CHAR_NUMBER, CHAR_EXP, CHAR_POINTER, CHAR_SIGN, CHAR_SPACE, CHAR_ILLEGAL
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINTER;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_SPACE, State.STATE_INITIAL);
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_POINTER, State.STATE_POINT_WITHOUT_INT);
                put(CharType.CHAR_SIGN, State.STATE_INITIAL);
            }
        };
        transfer.put(State.STATE_INITIAL, initialMap);

        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_POINTER, State.STATE_POINT_WITHOUT_INT);
            }
        };
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        Map<CharType, State> integerMap = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_POINTER, State.STATE_POINT);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }
        };
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }
        };
        transfer.put(State.STATE_POINT, pointMap);
        // .... no write
        State state = State.STATE_INITIAL;
        for (int i = 0; i < s.length(); i++) {
            CharType charType = toCharType(s.charAt(i));
            if(transfer.get(state).containsKey(charType)){
                state = transfer.get(state).get(charType);
            }else{
                return false;
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public static void main(String[] args) {

    }
}
