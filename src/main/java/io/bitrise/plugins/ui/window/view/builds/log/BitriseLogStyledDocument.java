package io.bitrise.plugins.ui.window.view.builds.log;

import com.intellij.ui.JBColor;
import javafx.util.Pair;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitriseLogStyledDocument extends DefaultStyledDocument {
    public static final String RESET = "[0m";  // Text Reset

    public static final Pair<String, Color> BLACK = new Pair<>("[30;1m", JBColor.black);   // BLACK
    public static final Pair<String, Color> RED = new Pair<>("[31;1m", JBColor.red);
    ;     // RED
    public static final Pair<String, Color> GREEN = new Pair<>("[32;1m", JBColor.green);
    ;   // GREEN
    public static final Pair<String, Color> YELLOW = new Pair<>("[33;1m", JBColor.yellow);
    ;  // YELLOW
    public static final Pair<String, Color> BLUE = new Pair<>("[34;1m", JBColor.blue);
    ;    // BLUE
    public static final Pair<String, Color> PURPLE = new Pair<>("[35;1m", JBColor.pink);
    ;  // PURPLE
    public static final Pair<String, Color> CYAN = new Pair<>("[36;1m", JBColor.cyan);
    ;    // CYAN
    public static final Pair<String, Color> WHITE = new Pair<>("[37;1m", JBColor.white);
    ;   // WHITE

    public static final Pair[] COLORS = {
            BLACK,
            RED,
            GREEN,
            YELLOW,
            BLUE,
            PURPLE,
            CYAN,
            WHITE
    };

    private List<ColorEntry> locations = new ArrayList<>();

    int from = 0;


    @Override
    public void insertString(int offs, String str, AttributeSet a) {
        try {
            super.insertString(from, str, a);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        StringBuffer text;
        try {
            text = new StringBuffer(getText(0, getLength()));

            Arrays.stream(COLORS).forEach(colorEntry -> {
                final String colorCode = (String) colorEntry.getKey();
                int startLoc = text.indexOf(colorCode);

                while (startLoc != -1) {
                    text.delete(startLoc, startLoc + colorCode.length());

                    int endLoc = text.indexOf(RESET);

                    locations.add(new ColorEntry(startLoc, endLoc, (Color) colorEntry.getValue()));

                    text.delete(endLoc, endLoc + RESET.length());

                    try {
                        super.remove(startLoc, colorCode.length());
                        super.remove(endLoc, RESET.length());
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }

                    startLoc = text.indexOf(colorCode);
                }
            });

            final StyleContext cont = StyleContext.getDefaultStyleContext();

            locations.forEach(entry -> {
                final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, entry.getColor());
                setCharacterAttributes(entry.getStart(), entry.getEnd() - entry.getStart(), attr, false);
            });


            from += text.length();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    class ColorEntry {
        private int start;
        private int end;
        private Color color;

        ColorEntry(int start, int end, Color color) {
            this.start = start;
            this.end = end;
            this.color = color;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public Color getColor() {
            return color;
        }
    }

}
