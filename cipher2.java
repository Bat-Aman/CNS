import java.util.*;

class cipher2 {
  public static void main(String argv[]) {
    String comm1,comm2;
    encryption e1 = new encryption();
    Scanner scan = new Scanner(System.in);
    int counter =1;
    int key = 3;
    System.out.println("\nCommand lists is: \n\t1.show key\n\t2.encrypt\n\t3.decrypt\n\t4.change key\n\t5.change case\n\t6.exit");
    while(true) {
      System.out.print(">>");
      comm1 = scan.nextLine();
      switch(comm1) {
        case "show key":
          System.out.println("key is "+key);
          break;
        case "encrypt":
          System.out.print(">");
          System.out.print("  Enter the String to encrypt it: ");
          comm2 = scan.nextLine();
          e1.encrypt(comm2,key);
          break;
        case "decrypt":
          System.out.print(">>");
          System.out.print(" Enter the encrypted String to decrypt it: ");
          comm2 = scan.nextLine();
          e1.decrypt(comm2,key);
          break;
        case "change key":
          System.out.print("Enter new key: ");
          key = Integer.parseInt(scan.nextLine());
          System.out.println("Key Updated.");
          break;
        case "change case":
          System.out.println("LOL");
          break;
        case "exit":
          return;
        default:
          System.out.println("Invalid Command...");
      }
    }

  }
}

class encryption {
  public String encrypt(String original,int key) {
    String encrypted = "";
    int len = original.length();

    for(int i=0;i<len;i++){
      int c = original.charAt(i);
      if(Character.isUpperCase(c)){
        c = c + (key%26);
        if(c > 'Z') c = (c-26);
      }

      else if(Character.isLowerCase(c)){
        c = c + (key%26);
        if(c > 'z') c = (c-26);
      }
      if((char)c == ' '){}
      encrypted += (char) c;
    }
    System.out.print("~> ");
    System.out.println("  Encrypted String is: "+ encrypted);
    return encrypted;
  }

  public void decrypt(String original,int key) {
    String decrypted = "";
    int len = original.length();

    for(int i=0;i<len;i++){
      int c = original.charAt(i);
      if(Character.isUpperCase(c)){
        c = c - (key%26);
        if(c < 'A') c = (c+26);
      }

      else if(Character.isLowerCase(c)){
        c = c - (key%26);
        if(c < 'a') c = (c+26);
      }
      if((char)c == ' '){}
      decrypted += (char) c;
    }
    System.out.print("~> ");
    System.out.println("  Decrypted String is: "+ decrypted);
  }
}
