public class Main{
    public static void main(String[] args)
    {
        Weapon axe = new Weapon("Axe", 8, 2, 3);
        Weapon dagger = new Weapon("Dagger", 3, 1, 5);
        Weapon bow = new Weapon("Bow", 3, 20, 10);

        GameCharacter gimliDef = new Dwarf();
        GameCharacter legolasDef = new Elf();
        System.out.println("default");
        System.out.println(gimliDef.toString());
        System.out.println(legolasDef.toString());

        GameCharacter gimli = new Dwarf("Gimli","Beserker","Chaotic-Good",2,2,75,4,axe,dagger);
        GameCharacter legolas = new Elf("Legolas","Ranger","Lawful-Good",3,2,50,2,bow,dagger);
        System.out.println("regular");
        System.out.println(gimli.toString());
        System.out.println(legolas.toString());
        
        legolas.assist(gimli);
        System.out.println("gimli gold: "+gimli.getGold());

        System.out.println(gimli.attack(legolas));
        System.out.println("legolas hp: "+legolas.getHitPoints());

        System.out.println(legolas.attack(gimli));
        System.out.println("gimli hp: "+gimli.getHitPoints());

    }
}
