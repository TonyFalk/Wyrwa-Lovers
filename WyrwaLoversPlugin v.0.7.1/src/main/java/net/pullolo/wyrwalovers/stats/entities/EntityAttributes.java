package net.pullolo.wyrwalovers.stats.entities;

public class EntityAttributes {
    private short tps=0;
    private short tps2=0;
    private boolean canDoubleJump = false;

    public EntityAttributes(short tps, short tps2, boolean canDoubleJump) {
        this.tps = tps;
        this.tps2 = tps2;
        this.canDoubleJump = canDoubleJump;
    }

    public EntityAttributes(){

    }

    public short getTps() {
        return tps;
    }

    public void setTps(short tps) {
        this.tps = tps;
    }

    public short getTps2() {
        return tps2;
    }

    public void setTps2(short tps2) {
        this.tps2 = tps2;
    }

    public boolean isCanDoubleJump() {
        return canDoubleJump;
    }

    public void setCanDoubleJump(boolean canDoubleJump) {
        this.canDoubleJump = canDoubleJump;
    }
}
