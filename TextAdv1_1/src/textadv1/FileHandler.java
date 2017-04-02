
package textadv1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
    String filename;
    File f;
    FileWriter fw;
    FileReader fr;
    BufferedReader br;
    
     public FileHandler()
    {
    }

    public void setFilename(String fn)
    {
        filename = fn;
        f = new File(filename);
    }
    
    public void saveScore(String n, int s)
    {
        try
        {
            fw = new FileWriter(f,true);
            fw.write( n + "," + s + "\n");
            fw.close();
        }
        catch (Exception ex)
        {
           
        }    
    }
    
    public void loadScores()
    {
        String[] tokens = {};
        
        try
        {
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String newLine;
            
            //HighScore hs = new HighScore();
            
            while( (newLine = br.readLine()) != null)
            {
                //hs.setName( newLine.split(",")[0] );
                //hs.setScore( newLine.split(",")[1] );
                //hs.setScore(HighScore[0]);
                System.out.println( newLine.split(",")[0] );
                System.out.println( newLine.split(",")[1] );
            }
        }
        catch (Exception ex)
        {
        }
           
    }
}
