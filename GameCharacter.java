
public class GameCharacter {
    
    public static final String DEFAULT_NAME = "default";
    public static final String DEFAULT_CHARACTER_CLASS = "default";
    public static final String DEFAULT_ALIGNMENT = "default";
    public static final int DEFAULT_GOLD = 0;
    public static final int DEFAULT_EXP_POINTS = 0;
    public static final int DEFAULT_HIT_POINTS = 50;
    public static final int DEFAULT_ARMOR_CLASS = 0;

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
        this.weapon1 = null;
        this.weapon2 = null;
    }
    //constructor
    public GameCharacter(String name, String characterClass, String alignment, int gold, int expPoints, int hitPoints, int armorClass, Weapon weapon1, Weapon weapon2) {
        if (damage < 0 || range < 0 || attackBonus < 0 || name == null || name.length() <= 0) {
            System.out.println("ERROR: data out of bounds");
            System.exit(0);
        }
        this.name = DEFAULT_NAME;
        this.characterClass = DEFAULT_CHARACTER_CLASS;
        this.alignment = DEFAULT_ALIGNMENT;
        this.gold = DEFAULT_GOLD;
        this.expPoints = DEFAULT_EXP_POINTS;
        this.hitPoints = DEFAULT_HIT_POINTS;
        this.armorClass = DEFAULT_ARMOR_CLASS;
        this.weapon1 = null;
        this.weapon2 = null;
    }
    //copy contructor
    public GameCharacter(Weapon other) {
        if (other.damage < 0 || other.range < 0 || other.attackBonus < 0 || other.name == null || other.name.length() <= 0) 
        {
            System.out.println("ERROR: data out of bounds");
            System.exit(0);
        }
        this.name = other.name;
        this.damage = other.damage;
        this.range = other.range;
        this.attackBonus = other.attackBonus;
    }
    //accessor
    public String getName() {
        return this.name;
    }
    //mutator
    public void setName(String name) {
        this.name = name;
    }
    //accessor
    public int getDamage() {
        return this.damage;
    }
    //mutator
    public void setDamage(int damage) {
        this.damage = damage;
    }
    //accessor
    public int getRange() {
        return this.range;
    }
    //mutator
    public void setRange(int range) {
        this.range = range;
    }
    public int getAttackBonus() {
        return this.attackBonus;
    }
    //mutator
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        Weapon that = (Weapon) o;
        return this.damage == that.damage &&
                this.range == that.range &&
                this.attackBonus == that.attackBonus &&
                this.name.equals(that.name);
    }
    @Override
    public String toString() {
        return String.format("Name: %s\nDamage: %d\nRange: %d\nAttack Bonus: %d", this.name, this.damage, this.range, this.attackBonus);
    }
    
}
