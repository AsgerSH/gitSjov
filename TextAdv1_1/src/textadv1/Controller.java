
package textadv1;

import java.util.Scanner;

public class Controller implements NewInterface {
    
    public Player p = new Player();
    Scanner s = new Scanner(System.in);
    boolean endGame = false;
    
    public void init() {
        //create monsters here
        CreateMap();
    }
   
    public void run() {
        p.CreatePlayer();
        
        System.out.println("Your text adventure has started...");
        System.out.println("You are walking inside a town, when there is a strange old man standing on the sidewalk, he looks like a beggar.\n he suddenly starts talking to you"
                + " but you don't want to talk to a beggar so you ignore him,\n the more you try to ignore him the more he want's to talk to you,\n two second later he"
                + " pulls you over, then with his strange old's man voice, ask you if want to go on an adventure, into a huge dungeon with lot's of riches inside\n");
        System.out.println("it is to the north from here, im only telling you this because im to old to do it myself/n "
                + "and you look like a capable man\n I must warn you i have been trying to do complete the dungeon for 46 years but never succeded ");
                               
        System.out.println("Do you want to explore the huge dungeon type: north");
        

        while (endGame == false) {
            
            String cmd = s.next().toLowerCase();
            switch (cmd) {
                case "north":
                    if (p.getCurrent().getRoomN() != null) {

                        p.goNorth();
                       
                         int addSword = p.getCurrent().getRoomSword();
                        //beskrivelsen af rummet vi er i
                        System.out.println(p.getCurrent().getDesc());
                        System.out.println("You walked north");
                        System.out.println("you now have " + p.getPlayerWallet() + " money and " + p.getPotionWallet() + " potions");
                    }
                    break;
                     case "west":
                    if (p.getCurrent().getRoomW() != null) {

                        p.goWest();
                        // int addWallet = p.getCurrent().getroomGold();
                        // p.playerWallet += addWallet;
                        //beskrivelsen af rummet vi er i
                        System.out.println("you walked west");
                        System.out.println(p.getCurrent().getDesc());
                    }
                    break;

                     case "south":
                    if (p.getCurrent().getRoomS() != null) {

                        p.goSouth();
                         //int addWallet = p.getCurrent().getroomGold();
                         //p.playerWallet += addWallet;
                        //beskrivelsen af rummet vi er i
                        System.out.println("you walked south");
                        System.out.println(p.getCurrent().getDesc());
                    }
                    break;
                     case "east":
                    if (p.getCurrent().getRoomE() != null) {

                        p.goEast();

                        //beskrivelsen af rummet vi er i
                        System.out.println("you walked east");
                        System.out.println(p.getCurrent().getDesc());
                    }
                        break;
                     case "pickup": 
                         
                         p.setPlayerWallet(p.getPlayerWallet()+p.getCurrent().getroomGold()); 
                         System.out.println(p.getPlayerWallet());
                         
                         p.setPotionWallet(p.getPotionWallet()+p.getCurrent().getRoomPotion());
                         p.setSwordWallet(p.getSwordWallet()+p.getCurrent().getRoomPotion());
                         p.getCurrent().setroomGold(0);
                         p.getCurrent().setRoomPotion(0);
                         p.getCurrent().setRoomSword(0);
                       //case "equip":
                       //case "unequip":
                       //case "combat":  
                      
                         break;
                     case "potion":
                     if(p.getPotionWallet() > 0){
                         potion(1);
                         p.setPotionWallet(p.getPotionWallet() - p.getPotionWallet());
                     }
                     break;
                     case "help":
                         System.out.println("Type: playerhealth to see your current health");
                         System.out.println("Type: potion to get 25 health." + " You have " + p.getPotionWallet() + " potions left");
                         System.out.println("Type: playerattack to see your damage");
                         System.out.println("Type: pickup to pick up items");
                         System.out.println("Type: inventory to see what you currently have");
                         break;
                     case "playerattack":
                         System.out.println(p.getPlayerAttack());
                         break;
                     case "playerhealth":
                         System.out.println(p.getPlayerHealth());
                         break;
                     case "inventory":
                         System.out.println("You have "+ p.getPlayerWallet() + " Gold");
                         System.out.println("You have " + p.getSwordWallet() + " swords");
                         System.out.println("You have " + p.getPotionWallet() + " potions");
                         break;
                case "quit":
                    endGame = true;
                    System.out.println("QUIT");
                    System.out.println("you quit the game with " + p.getPlayerWallet() + " money");

                    break;
                    
                default:
                    System.out.println("noget gik ikke efter planen ;D");
                    break;
            }

        }
            System.out.println("Text adventure ended...");
            FileHandler fh = new FileHandler();
            fh.setFilename("highscores.txt");
            fh.saveScore(p.getPlayerName(), p.getPlayerWallet());

    }
    
    

    public void CreateMap() {
       
        Room r1 = new Room();
        r1.setDesc("hej med dig ");
        r1.setRoomGold(5);
        Room r2 = new Room();
        r2.setDesc("You came into the dungeon where the old man explained.\n "
                + "You see 3 big tunnels and you are wondring what's inside them, but you can't decide. Which one do you choose \n \n Type: west to go into the left tunnel(it seems like there might or might not be money inside) \n Type: north to take the middle tunnel(might be danger) \n Type: east to take the right tunnel(no danger here)");
        r2.setRoomGold(5);
        
        Room r3 = new Room();
        
        r3.setDesc("You are very careful when you walked into the room \n In the room there is a big monster laying in the corner, seems like he is sleeping, you must be fast before it wakes up \n \n Type: south to go to the room behind you \n Type: west to take the left tunnel(Safest route away from the big monster) \n Type: north to take the middle tunnel(might wake the monster) \n Type: east to take the right tunnel(might be danger)");
        Room r4 = new Room();
        r4.setDesc("You walk into a large room inside the dungeon, and you see a large chest in the middle \n You slowly walk over to the chest, there could be traps laying around it \n After you are sure there is not traps you open the chest \n Inside the chest is some money and you take it fast \n  You might find more money in other rooms in the dungeon \n \n Type: north to take the top tunnel \n Type: west to take the left tunnel \n Type: east to go to the right tunnel");
        r4.setRoomPotion(1);
        r4.setRoomSword(1);
        r4.setroomGold(15);
        Room r5 = new Room();
        r5.setDesc("You walk into a small room, but sadly it's empty \n \n Type: north to take top tunnel \n Type: east to take right tunnel \n Type: west to go to the left room");
        Room r6 = new Room();
        r6.setroomGold(2);
        r6.setRoomPotion(1);
        r6.setDesc("These caverooms are boring... but then you looked on the floor and found some gold laying there, YUHUU! \n \n Type: north to take the top tunnel \n Type: west to take the left tunnel");
        Room r7 = new Room();
        r7.setDesc("OOOOH nothing here... \n \n Type: east to go right \n Type: south to go to the buttom tunnel");
        Room r8 = new Room();
        r8.setRoomSword(1);
        r8.setDesc("You walk into the room and hear a strange noise better hurry up to next room \n \n Type: west to take the left tunnel \n Type: east to take the right tunnel");
        Room r9 = new Room();
        r9.setroomGold(6);
        r9.setDesc("Yeah this cave is awesome, got all these nice rooms with gold in some of them \n \n Type: west to take the left tunnel \n Type: south to take the buttom tunnel");
        Room r10 = new Room();
        r10.setDesc("Ooh damn.. it's a deadend better go back \n \n Type: south to go back");
        Room r11 = new Room();
        r11.setDesc("What a beautiful room this is, but no money here better take another tunnel \n \n Type: west to take the left tunnel \n Type: east to take the right tunnel");
        Room r12 = new Room();
        r12.setDesc("You walk into a huge room with a large chest in the middle, it looks suspecius \n But you really want the money, so you go over to the chest anyway \n you open the chest and take the money \n \n Type: north to take the top tunnel \n Type: south to take the buttom tunnel");
        r12.setroomGold(30);
        Room r13 = new Room();
        r13.setDesc("There is nothing inside this caveroom but it still looks interesting \n better go into another room to find some money \n \n Type: north to take the top tunnel \n Type: east to take the left tunnel");
        Room r14 = new Room();
        r14.setDesc("Nothing inside here.. not even a monster \n \n Type: north to take the top tunnel \n Type: south to take the buttom tunnel");
        Room r15 = new Room();
        r15.setDesc("You are walking pretty fast not because you want more money \n Luckely you find some in this room \n \n Type: west to go into a small crack inside the cavewall \n Type: north to take the top tunnel \n Type: south to go to the buttom tunnel");
        r15.setroomGold(7);
        Room r16 = new Room();
        r16.setDesc("This caveroom is huge, but no money which is sad.. \n \n Type: West to take the left tunnel \n type: east to go into a small crack to the right in the cavewall \n Type: south to go into the buttom tunnel");
        Room r17 = new Room();
        r17.setDesc("This room is sadly very small and there is nothing inside \n \n Type: north to take the top tunnel \n Type: south to take the buttom tunnel");
        Room r18 = new Room();
        r18.setDesc("You walk into the room, and hear a strange room from the room you came from, better hurry to next room \n \n Type: north to take the top tunnel \n Type: east to take the right tunnel");
        Room r19 = new Room();
        r19.setDesc("Yeah there is a huge chest in here, you walk over to it, but there is nearly nothing inside.. \n \n Type: east to go left \n Type: south to take the buttom tunnel");
        r19.setroomGold(3);
        Room r20 = new Room();
        r20.setDesc("What a beautiful caveroom, it got old painting on the side, but no money \n \n Type: north to take the top tunnel \n Type: west to take the left tunnel");
        Room r21 = new Room();
        r21.setDesc("You walk into the room and there is a giant dog with 3 heads sleeping here.. \n Better hurry up to next room \n \n Type: east to take the right tunnel \n Type: south to take the buttom tunnel");
        Room r22 = new Room();
        r22.setDesc("This old caveroom is awesome, it got painting on the walls and everything, but no money. \n Better go into another room \n \n Type: west to take left tunnel \n Type: south to take buttom tunnel");
        Room r23 = new Room();
        r23.setDesc("WHAAT A GIANT CHEST IN THE MIDDLE, better open it, wow it got alot of money inside!! \n \n Type: west to take left tunnel \n Type: north to take top tunnel \n Type: east to take right tunnel");
         r23.setroomGold(100);
       
        Room r24 = new Room();
        r24.setDesc("Yeah nothing inside this room... \n \n Type: north to take top tunnel \n Type: south to take buttom tunnel");
        Room r25 = new Room();
        r25.setDesc("YOU WON THE GAME, AND COMPLETED THE DUNGEON!! \n YOU WON THE GAME, AND COMPLETED THE DUNGEON!! \n YOU WON THE GAME, AND COMPLETED THE DUNGEON!! \n inside is a giant chest you can take!! ");
        r25.setroomGold(200);
        
        Room r26 = new Room();
        r26.setDesc("You chose the crack in the wall, and that was a good idea, there is money inside \n But it's a dead end.. \n \n Type: west to go back!!");
        r25.setroomGold(30);
        Room r27 = new Room();
        r27.setDesc("You chose the crack in the wall, and that was a good idea, there is money inside \n but it's a dead end.. \n \n Type: east to go back!! ");
        r25.setroomGold(30);   
       
        r1.setRoomN(r2);
        r2.setRoomN(r3);
        r2.setRoomW(r4);
        r2.setRoomE(r5);

        r3.setRoomS(r2);
        r3.setRoomW(r7);
        r3.setRoomE(r9);
        r3.setRoomN(r10);

        r4.setRoomN(r7);
        r4.setRoomW(r8);
        r4.setRoomE(r2);

        r5.setRoomW(r2);
        r5.setRoomE(r11);
        r5.setRoomN(r9);

        r6.setRoomW(r11);
        r6.setRoomN(r12);

        r7.setRoomE(r3);
        r7.setRoomS(r4);

        r8.setRoomW(r13);
        r8.setRoomE(r4);

        r9.setRoomW(r3);
        r9.setRoomS(r5);

        r10.setRoomS(r3);

        r11.setRoomW(r5);
        r11.setRoomE(r6);

        r12.setRoomS(r6);
        r12.setRoomN(r14);

        r13.setRoomE(r8);
        r13.setRoomN(r15);

        r14.setRoomS(r12);
        r14.setRoomN(r16);

        r15.setRoomS(r13);
        r15.setRoomN(r17);
        r15.setRoomW(r27);

        r16.setRoomW(r18);
        r16.setRoomS(r14);
        r16.setRoomE(r26);

        r17.setRoomS(r15);
        r17.setRoomN(r19);

        r18.setRoomE(r16);
        r18.setRoomN(r22);

        r19.setRoomE(r20);
        r19.setRoomS(r17);

        r20.setRoomW(r19);
        r20.setRoomN(r21);

        r21.setRoomS(r20);

        r22.setRoomS(r18);

        r23.setRoomN(r24);
        r23.setRoomW(r21);
        r23.setRoomE(r22);

        r24.setRoomN(r25);
        r24.setRoomS(r23);

        r25.setRoomS(r24);
        
        r26.setRoomW(r16);

        r27.setRoomE(r15);

        p.setCurrent(r1);

    }
    @Override
    public void potion(int potion1) {
        if (p.getPlayerHealth() <= 100){
        potion1 = p.getPlayerHealth() + 25;
        System.out.println("you have taken a potion");
        if (p.getPlayerHealth() > 100)
            p.setPlayerHealth(100);
        }
        }

    @Override
    public void sword(int sword1) {
        // gør så spilleren kun kan have max 2 sværd, en til hver hånd
        if(p.getSwordWallet() <= 2){  
        p.setPlayerAttack(p.getPlayerAttack() + 20);
    }
    }
}

