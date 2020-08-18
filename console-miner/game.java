import java.io.Console;
public class game {

 
  String slot1;
  int cantidad;
  int world = 32;
  String[] blocks = { "wood", "stone", "glass", "dirt" };



  public void welcome(){
    String functions = "inv_add, inv_see, place, destroy, world, exit";
    System.out.println("welcome to ConsoleMiner 2.0 by kymlaar");
    System.out.println("You can place blocks in a invisible world with infinite dimensions");
    System.out.println("Available functions are: " + functions);
    main_game_loop();
  }

  public void main_game_loop(){
    Console console = System.console();
    String function;
    System.out.println("Wich function do you want to do?");
    function = console.readLine();

    switch (function) {
      case "inv_add":
      add_item_to_slot1(console);
      break;

      case "inv_see":
      list_slot1();
      break;

      case "place":
      place_block();
      break;

      case "destroy":
      destroy_block();
      break;

      case "world":
      world();
      break;

      case "exit":
      break;

      default:
      System.out.println("Function: " + function + " not found");
      main_game_loop();
      break;
    }
  }

  public void add_item_to_slot1(Console console) {
    System.out.println("what item do you whant to add to your inventory?");
   
    
    slot1 = console.readLine();
/*
pendiente de hacer   
    for (String element : blocks) { 
      if (element == slot1) { 
        System.out.println("esta dentro del array");
      } else {
        System.out.println("no esta dentro del array");
      }

  } 
  */
    System.out.println("how much of " + slot1 +"you want to add to slot1?");
    cantidad = Integer.parseInt(console.readLine());
    if (cantidad > 64 ){
      cantidad = 64;
    } else if (cantidad < 0){
      cantidad = 0;
    } else {}
    list_slot1();
  }



  public void list_slot1() {
    System.out.println("the slot1 has: " + cantidad + " of " + slot1);
    main_game_loop();
  }
  


  public void world(){
    System.out.println(world);
    main_game_loop();
  }

  public void destroy_block(){
    if(cantidad < 64){
      cantidad ++;
      world --;
    }else{
      System.out.println("your inventory is full of blocks");
    }
        main_game_loop();
  }

  public void place_block(){
    if(cantidad >= 1){
      cantidad --;
      world ++;
    }else{
      System.out.println("you run out of blocks");
    }
        main_game_loop();
  }

 
  public static void main(String [] args) {
    game g = new game(); 
    g.welcome();
  }
}