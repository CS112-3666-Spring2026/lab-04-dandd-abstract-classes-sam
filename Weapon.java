public class Weapon {
public static final String DEFAULT_NAME = "sword";
    public static final int DEFAULT_DAMAGE = 8;
    public static final int DEFAULT_RANGE = 1;
    public static final int DEFAULT_ATTACK_BONUS = 2;

    private String name;
    private int damage;
    private int range;
    private int attackBonus;
    

    //default constructor
    public Weapon() {
        this.name = DEFAULT_NAME;
        this.damage = DEFAULT_DAMAGE;
        this.range = DEFAULT_RANGE;
        this.attackBonus = DEFAULT_ATTACK_BONUS;
    }
    //constructor
    public Weapon(String name, int damage, int range, int attackBonus) {
        if (damage < 0 || range < 0 || attackBonus < 0 || name == null || name.length() <= 0) {
            System.out.println("ERROR: data out of bounds");
            System.exit(0);
        }
        this.name = name;
        this.damage = damage;
        this.range = range;
        this.attackBonus = attackBonus;
    }
    //copy contructor
    public Weapon(Weapon other) {
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
