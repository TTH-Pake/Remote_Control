/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import Server.KeyStorage;
import Server.TextFormat;
import Server.NativeKeyBoard;

public class PrintText {
    private NativeKeyBoard keyboard;
    
    public PrintText(){
        keyboard = new NativeKeyBoard();
    }
    
     public NativeKeyBoard getKeyBoard(){
        return keyboard;
    }
        
    
    public String printKey() {
        String str = TextFormat.Text(keyboard.getKeyCache());
        System.out.println(str);
        return str;
    }
}
