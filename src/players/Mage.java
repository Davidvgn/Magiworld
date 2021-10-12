package players;

public class Mage extends Player {

    public Mage(int level, int life, int force, int agility, int intelligence) {
        super(level, life, force, agility, intelligence);
    }

    @Override
    public int getBasicAttackDamages() {
        return intelligence;
    }

    @Override
    public int getSpecialAttackDamages() {
        this.life = life +(intelligence * 2);
        if (life > lifeMax) {
            life = lifeMax;
        }
        return 0;
    }
}
