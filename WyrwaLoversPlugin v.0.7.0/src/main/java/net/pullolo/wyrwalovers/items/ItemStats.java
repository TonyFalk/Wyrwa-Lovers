package net.pullolo.wyrwalovers.items;

public class ItemStats {
    private Double damage, intelligence, health, defense, abilityPower, critDamage, critChance, resistance, speed;

    public ItemStats(Double damage, Double intelligence, Double health, Double defense, Double abilityPower, Double critDamage, Double critChance, Double resistance, Double speed) {
        this.damage = damage;
        this.intelligence = intelligence;
        this.health = health;
        this.defense = defense;
        this.abilityPower = abilityPower;
        this.critDamage = critDamage;
        this.critChance = critChance;
        this.resistance = resistance;
        this.speed = speed;
    }

    public Double getDamage() {
        return damage;
    }

    public Double getIntelligence() {
        return intelligence;
    }

    public Double getHealth() {
        return health;
    }

    public Double getDefense() {
        return defense;
    }

    public Double getAbilityPower() {
        return abilityPower;
    }

    public Double getCritDamage() {
        return critDamage;
    }

    public Double getCritChance() {
        return critChance;
    }

    public Double getResistance() {
        return resistance;
    }

    public Double getSpeed() {
        return speed;
    }
}
