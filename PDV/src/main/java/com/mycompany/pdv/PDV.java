package com.mycompany.pdv;

import javax.swing.JFrame;
import view.ViewTelaVenda;

/**
 *
 * @author vsemp
 */
public class PDV {

    public static void main(String[] args) {
        ViewTelaVenda view = new ViewTelaVenda();
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
    }
}
