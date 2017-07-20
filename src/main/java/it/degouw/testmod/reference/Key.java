package it.degouw.testmod.reference;

/**
 * Created by mathijs on 20-7-17.
 */
public enum Key {

    UNKNOWN, TEST;

    public static final Key[] KEYS = Key.values();

    public static Key getKey(byte ordinal) {
        return KEYS[ordinal % KEYS.length];
    }

}
