public class Rodeur extends Player{

    public Rodeur(int level, int life, int force, int agility, int intelligence) {
        super(level, life, force, agility, intelligence);
    }

    @Override
    public int getBasicAttackDamages() {

        return agility;
    }

    @Override
    public int getSpecialAttackDamages() {
        this.agility = agility + (level / 2);
        return 0;
    }
}
