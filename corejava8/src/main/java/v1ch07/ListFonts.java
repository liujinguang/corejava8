package v1ch07;

import java.awt.GraphicsEnvironment;

public class ListFonts {

    public ListFonts() {
    }

    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        
        for (String name : fontNames) {
            System.out.println(name);
        }
    }

}
