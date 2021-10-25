package katas.foliva;

class Fighter {
    private String name;
    private int health, damagePerAttack;
    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
    public void attackTo(Fighter attacked){
        int newHealth = attacked.getHealth() - this.damagePerAttack;
        attacked.setHealth(newHealth);
    }

    public boolean isDead(){
        return this.health <= 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}

public class TwoFighters {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker){
        Fighter firstFighter = firstAttacker == fighter1.getName() ? fighter1 : fighter2;
        Fighter secondFighter = firstAttacker == fighter2.getName() ? fighter1 : fighter2;

        while(true){
            firstFighter.attackTo(secondFighter);
            if( secondFighter.isDead() ) return firstFighter.getName();
            secondFighter.attackTo(firstFighter);
            if( firstFighter.isDead() ) return secondFighter.getName();
        }
    };
}
