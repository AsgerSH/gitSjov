
package textadv1;

public class TextAdv1 {

    public static void main(String[] args) {
        //run game
       //filehandler highscore
       
       Controller c = new Controller();
       c.init();
       c.run();
       
       FileHandler fh = new FileHandler();
       fh.setFilename("highscores.txt");
       fh.saveScore("Jackson", 3000);
       fh.loadScores();
       
    }
    
}
