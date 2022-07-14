package net.pullolo.wyrwalovers.stats.entities;

public class PlayerXp {
    private double xp;

    public PlayerXp(double xp){
        this.xp = xp;
    }

    public void addXp(double amount){
        this.xp += amount;
        if (this.xp < 0){
            this.xp = 0;
            throw new IllegalArgumentException();
        }
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
        if (this.xp < 0){
            this.xp = 0;
            throw new IllegalArgumentException();
        }
    }
}
