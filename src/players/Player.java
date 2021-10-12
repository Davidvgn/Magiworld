package players;

public abstract class Player {
    protected final int level;
    protected int life;
    protected final int force;
    protected int agility;
    protected final int intelligence;
    protected final int lifeMax;

    protected Player(int level, int life, int force, int agility, int intelligence) {
        this.level = level;
        this.life = life;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
        this.lifeMax = computeLifeMax();
    }
    protected int computeLifeMax (){
        return level * 5;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int newLife) {
        life = newLife;
    }

    public abstract int getBasicAttackDamages();
    public abstract int getSpecialAttackDamages();
}
