package main.app;

import main.view.SignupView;
import org.junit.Test;

import javax.swing.*;
import javax.swing.text.View;

import java.awt.*;

import static org.junit.Assert.*;

public class MainTest {

    public static JPanel getCurrentView(int index) {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        JPanel currentView =  (JPanel) jp2.getComponent(index);

        return currentView;
    }

    @Test
    public void main() {
        Main.main(null);
    }
}