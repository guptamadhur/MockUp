package web.app.madhurgupta.Learning.Topic.Debug;

import java.lang.reflect.Field;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

public interface Debuggable {
    default String debug() {
        StringBuilder sb = new StringBuilder(this.getClass().getName());
        sb.append(" [ ");
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field f: fields) {
            f.setAccessible(true);
            try {
                sb.append(f.getName() + " = " + f.get(this));
                sb.append(", ");
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}