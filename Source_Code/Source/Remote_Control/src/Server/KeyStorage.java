/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author HP Envy 13-ba1010NR
 */
public class KeyStorage {
    
    private int keyCode;
    private boolean pressed;
    
    public KeyStorage(int keyCode, boolean pressed){
        this.keyCode = keyCode;
        this.pressed = pressed;
    }
    
    public int getKeyCode(){
        return keyCode;
    }
    
    public boolean isPressed(){
        return pressed;
    }
    
}

