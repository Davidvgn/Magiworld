package players;

public class Assassin extends Player {
    protected Assassin(int level, int life, int force, int agility, int intelligence) {
        super(level, life, force, agility, intelligence);
    }

    @Override
    public int getBasicAttackDamages() {
        return 0;
    }

    @Override
    public int getSpecialAttackDamages() {
        return 0;
    }
}
