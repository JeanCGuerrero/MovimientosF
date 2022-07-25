/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimientos;
import gui.*;

/**
 *
 * @author JEANG
 */
public class movimientos {

    public static Principal principal;   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        principal = new Principal();
        principal.setVisible(true);
        principal.setSize(640, 450);
        principal.requestFocus();       
    }    
} 
