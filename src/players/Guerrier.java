package players;

public class Guerrier extends Player {

    public Guerrier(int level, int life, int force, int agility, int intelligence) {
        super(level, life, force, agility, intelligence);
    }

    @Override
    public int getBasicAttackDamages() {
        return force;
    }

    @Override
    public int getSpecialAttackDamages() {
        this.life = life - (force / 2);
        return force * 2;
    }

    @Override
    protected int computeLifeMax() {
        return super.computeLifeMax() + 200;
    }
}
