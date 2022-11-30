/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author HP
 */
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.util.ArrayList;
import java.util.List;

public class NativeKeyBoard implements NativeKeyListener {
    
    private List<KeyStorage> keyCache = new ArrayList<>();
    
    @Override
    public void nativeKeyPressed(NativeKeyEvent key) {
        System.out.println("PRESSED: "+ NativeKeyEvent.getKeyText(key.getKeyCode()));
        keyCache.add(new KeyStorage(key.getKeyCode(),true));

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent key) {
        keyCache.add(new KeyStorage(key.getKeyCode(),false));
    }
    
    @Override
    public void nativeKeyTyped(NativeKeyEvent key) {

        System.out.println("TYPE: "+ key.getKeyChar());
   }
    public List<KeyStorage> getKeyCache(){
       
        return keyCache;
    }
    public void clear(){
        keyCache.clear();
    }
    
    
}
