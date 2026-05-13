public class Elf extends GameCharacter{
    Elf() {
        super(DEFAULT_NAME,DEFAULT_CHARACTER_CLASS,DEFAULT_ALIGNMENT,DEFAULT_GOLD,DEFAULT_EXP_POINTS,DEFAULT_HIT_POINTS,DEFAULT_ARMOR_CLASS,DEFAULT_WEAPON1,DEFAULT_WEAPON2);
    }

    Elf(String name, String characterClass, String alignment, int gold, int expPoints, int hitPoints, int armorClass,Weapon weapon1, Weapon weapon2) {
        super(name, characterClass, alignment, gold, expPoints, hitPoints, armorClass, weapon1, weapon2);
       
    }

    Elf(Elf original) {
        super(original);
    }
    //if the target is another elf, the elf will heal them. If the target is a dwarf, it will throw a gold coin at it.
    @Override
    public void assist(GameCharacter target) {
        if (target instanceof Elf) {
            System.out.println("I would always assist another elf!");
            target.setHitPoints(target.getHitPoints() + 20);
        } else if (target instanceof Dwarf) {
            System.out.println("Here, filthy dwarf");
            target.setGold(target.getGold() + 1);
        }
    }
    //If the elf targets an dwarf, it may attack multiple times using recursion. If the target is another elf, damage will be reduced.
    @Override
    public boolean attack(GameCharacter target) {
        if (target.getHitPoints() <= 0) {
            System.out.println("target dead");
            return false;
        }
        double hitChance = Math.random() * 100;
        if (target instanceof Elf) {
            if (hitChance <= 90) {
                target.setHitPoints(target.getHitPoints() - (this.getWeapon1().getDamage() + this.getWeapon2().getDamage()+5));
                return true;
            } 
            else {
                return false;
            }
        } 
        else if (target instanceof Dwarf) {
            if (hitChance <= 80) {
                target.setHitPoints(
                        target.getHitPoints() - (this.getWeapon1().getDamage() + this.getWeapon2().getDamage()));
                System.out.println("hit dwarf");
                this.attack(target);
                return true;
            } 
            else {
                return false;
            }
        }
        else {
            if (hitChance >= 80) {
                target.setHitPoints(target.getHitPoints() - (this.getWeapon1().getDamage() + this.getWeapon2().getDamage()));
                return true;
            } else {
                return false;
            }
        }
    }
}
