
public abstract class GameCharacter {
    
    public static final String DEFAULT_NAME = "default";
    public static final String DEFAULT_CHARACTER_CLASS = "default";
    public static final String DEFAULT_ALIGNMENT = "default";
    public static final int DEFAULT_GOLD = 0;
    public static final int DEFAULT_EXP_POINTS = 0;
    public static final int DEFAULT_HIT_POINTS = 50;
    public static final int DEFAULT_ARMOR_CLASS = 0;
    public static final Weapon DEFAULT_WEAPON1 = new Weapon("rusty sword", 1, 1, 1);
    public static final Weapon DEFAULT_WEAPON2 = new Weapon("rusty sword", 1, 1, 1);

    private String name;
    private String characterClass;
    private String alignment;
    private int gold;
    private int expPoints;
    private int hitPoints;
    private int armorClass;
    Weapon weapon1;
    Weapon weapon2;
    

    //default constructor
    public GameCharacter() {
        this.name = DEFAULT_NAME;
        this.characterClass = DEFAULT_CHARACTER_CLASS;
        this.alignment = DEFAULT_ALIGNMENT;
        this.gold = DEFAULT_GOLD;
        this.expPoints = DEFAULT_EXP_POINTS;
        this.hitPoints = DEFAULT_HIT_POINTS;
        this.armorClass = DEFAULT_ARMOR_CLASS;
        this.weapon1 = DEFAULT_WEAPON1;
        this.weapon2 = DEFAULT_WEAPON2;
    }
    //constructor
    public GameCharacter(String name, String characterClass, String alignment, int gold, int expPoints, int hitPoints, int armorClass, Weapon weapon1, Weapon weapon2) {
        if (gold < 0 || expPoints < 0 || hitPoints < 0 || armorClass < 0 || name == null || name.length() <= 0
                || characterClass == null || characterClass.length() <= 0 || alignment == null
                || alignment.length() <= 0) {
            System.out.println("ERROR: data out of bounds");
            System.exit(0);
        }
        this.name = name;
        this.characterClass = characterClass;
        this.alignment = alignment;
        this.gold = gold;
        this.expPoints = expPoints;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
        this.weapon1 = weapon1;
        this.weapon2 = weapon2;
    }
    //copy contructor
    public GameCharacter(GameCharacter other) {
        if (other.gold < 0 || other.expPoints < 0 || other.hitPoints < 0 || other.armorClass < 0 || other.name == null
                || other.name.length() <= 0 || other.characterClass == null || other.characterClass.length() <= 0
                || other.alignment == null || other.alignment.length() <= 0) {
            System.out.println("ERROR: data out of bounds");
            System.exit(0);
        }
        this.name = other.name;
        this.characterClass = other.characterClass;
        this.alignment = other.alignment;
        this.gold = other.gold;
        this.expPoints = other.expPoints;
        this.hitPoints = other.hitPoints;
        this.armorClass = other.armorClass;
        this.weapon1 = other.weapon1;
        this.weapon2 = other.weapon2;
    }

    // accessor
    public String getName() {
        return this.name;
    }

    // mutator
    public void setName(String name) {
        this.name = name;
    }

    // accessor
    public String getCharacterClass() {
        return this.characterClass;
    }

    // mutator
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    // accessor
    public String getAlignment() {
        return this.alignment;
    }

    // mutator
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    // accessor
    public int getGold() {
        return this.gold;
    }

    // mutator
    public void setGold(int gold) {
        this.gold = gold;
    }

    // accessor
    public int getExpPoints() {
        return this.expPoints;
    }

    // mutator
    public void setExpPoints(int expPoints) {
        this.expPoints = expPoints;
    }

    // accessor
    public int getHitPoints() {
        return this.hitPoints;
    }

    // mutator
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    // accessor
    public int getArmorClass() {
        return this.armorClass;
    }

    // mutator
    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    // accessor
    public Weapon getWeapon1() {
        return this.weapon1;
    }

    // mutator
    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    // accessor
    public Weapon getWeapon2() {
        return this.weapon2;
    }

    // mutator
    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        GameCharacter that = (GameCharacter) o;
        return this.gold == that.gold &&
                this.expPoints == that.expPoints &&
                this.hitPoints == that.hitPoints &&
                this.armorClass == that.armorClass &&
                this.name.equals(that.name) &&
                this.characterClass.equals(that.characterClass) &&
                this.alignment.equals(that.alignment) &&
                this.weapon1 == that.weapon1 &&
                this.weapon2 == that.weapon2;
    }
    @Override
    public String toString() {
        return String.format(
                "===========\nName: %s\nCharacter Class: %s\nAlignment: %s\nGold: %d\nExp: %d\nArmor Class: %d\nHitpoints %d\nWeapon 1: %s\nWeapon 2: %s\n==========",
                this.name, this.characterClass, this.alignment,
                this.gold, this.expPoints, this.armorClass, this.hitPoints, this.weapon1.getName(),
                this.weapon2.getName());
    }

    // Create 2 abstract methods, assist and attack, that both take in a
    // GameCharacter object to interact with. Note the different return types
    // (details below).
    public abstract void assist(GameCharacter target);

    public abstract boolean attack(GameCharacter target);
    
}
