public class Dwarf extends GameCharacter{
    Dwarf() {
        super(DEFAULT_NAME,DEFAULT_CHARACTER_CLASS,DEFAULT_ALIGNMENT,DEFAULT_GOLD,DEFAULT_EXP_POINTS,DEFAULT_HIT_POINTS,DEFAULT_ARMOR_CLASS,DEFAULT_WEAPON1,DEFAULT_WEAPON2);
    }

    Dwarf(String name, String characterClass, String alignment, int gold, int expPoints, int hitPoints, int armorClass,Weapon weapon1, Weapon weapon2) {
        super(name, characterClass, alignment, gold, expPoints, hitPoints, armorClass, weapon1, weapon2);
       
    }

    Dwarf(Dwarf original) {
        super(original);
    }
    //if the target is an elf, the dwarf will refuse to assist them. If the target is another dwarf, it will upgrade it's armor.
    @Override
    public void assist(GameCharacter target) {
        if (target instanceof Elf) {
            System.out.println("I would never assist an elf!");
        } else if (target instanceof Dwarf) {
            System.out.println("Here, I will upgrade your armor fellow Dwarf!");
            target.setArmorClass(target.getArmorClass() + 1);
        }
    }
    //If the dwarf targets an elf, it will be less likely to connect due to it's rage but it will do more damage. If the target is another dwarf, damage will be reduced but it will break it's armor.
    @Override
    public boolean attack(GameCharacter target) {
        if (target.getHitPoints() <= 0) {
            System.out.println("target dead");
            return false;
        }
        double hitChance = Math.random() * 100;
        if (target instanceof Elf) {
            if (hitChance <= 60) {
                target.setHitPoints(target.getHitPoints() - (this.getWeapon1().getDamage() + this.getWeapon2().getDamage()+5));
                return true;
            } 
            else {
                return false;
            }
        } 
        else if (target instanceof Dwarf) {
            if (hitChance <= 80) {
                target.setHitPoints(target.getHitPoints() - (this.getWeapon1().getDamage() + this.getWeapon2().getDamage()-5));
                target.setArmorClass(target.getArmorClass() - 1);
                return true;
            } else {
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
