package magicGame.models.magicians;

import magicGame.models.magics.Magic;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician{

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);
    }

    @Override
    public void takeDamage(int points) {
        this.protection -= points;

        if (this.protection < 0){
            this.health += this.protection;
            this.protection = 0;
        }

        if (this.health <= 0){
            isAlive = false;
        }

    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()){
            throw  new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        if (protection < 0){
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    public void setMagic(Magic magic) {
        if (magic == null){
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }
}
