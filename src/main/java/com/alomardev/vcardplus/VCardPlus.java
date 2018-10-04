package com.alomardev.vcardplus;

import com.alomardev.vcardplus.view.MainFrame;

import javax.swing.*;

public class VCardPlus {

    public static void main(String... args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.err.println(ex.getMessage());
        }

        new VCardPlus();
    }

    private MainFrame mainFrame;

    public VCardPlus() {
        mainFrame = new MainFrame();
        mainFrame.setup();
        mainFrame.setVisible(true);
    }
}
