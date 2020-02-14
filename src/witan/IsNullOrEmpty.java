package witan;

public class IsNullOrEmpty {
    boolean isOrIsNot;

    IsNullOrEmpty(String text) {
        //System.out.println(text);
        if (text != null && !text.isEmpty()) {
            isOrIsNot = false;
        } else {
            isOrIsNot = true;
        }

    }
}
