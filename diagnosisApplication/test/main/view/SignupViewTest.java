package main.view;

import main.app.Main;
import main.app.MainTest;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class SignupViewTest {

    public static JButton toLoginView() {

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

        SignupView sv = (SignupView) jp2.getComponent(0);

        Box innerBox = (Box) sv.getComponent(1);

        JPanel buttons1 = (JPanel) innerBox.getComponent(9);

        JButton login = (JButton) buttons1.getComponent(3);

        return login;
    }

    @Test
    public void isLoginView() {
        Main.main(null);

        JButton loginButton = toLoginView();
        loginButton.doClick();
        assert MainTest.getCurrentView(1) instanceof LoginView;
    }

    @Test
    public void actionPerformed() {
    }

    @Test
    public void propertyChange() {
    }
}