package net.pullolo.wyrwalovers.stats.entities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class EntityStatistics {
    private int level;

    //Init variables for health stats
    private Double health;
    private Double baseMaxHealth;
    private Double maxHealth;
    private Double healthRegen;
    private Double baseHealthRegen;
    private HashMap<String ,Double> bonusMaxHealth = new HashMap<>();
    private HashMap<String ,Double> bonusHealthRegen = new HashMap<>();
    //Init variables for Defense stats
    private Double baseDefense, defense;
    private HashMap<String ,Double> bonusDefense = new HashMap<>();
    //Init variables for Resistance stats
    private Double baseResistance, resistance;
    private HashMap<String ,Double> bonusResistance = new HashMap<>();
    //Init variables for Speed stats
    private Double baseSpeed, speed;
    private HashMap<String ,Double> bonusSpeed = new HashMap<>();

    public void calcStats(){
        calcHealth();
        calcHealthRegen();
        calcDefense();
        calcSpeed();
        calcResistance();
    }

    private void calcHealth(){
        double h = 0;
        for (Double i:bonusMaxHealth.values()){
            if (i != null){
                h+=i;
            }
        }
        maxHealth = baseMaxHealth + h;
    }
    private void calcHealthRegen(){
        double h = 0;
        for (Double i:bonusHealthRegen.values()){
            if (i != null){
                h+=i;
            }
        }
        healthRegen = baseHealthRegen + h;
    }
    private void calcDefense(){
        double d = 0;
        for (Double i:bonusDefense.values()){
            if (i != null){
                d+=i;
            }
        }
        defense = baseDefense + d;
    }
    private void calcResistance(){
        double r = 0;
        for (Double i:bonusResistance.values()){
            if (i != null){
                r+=i;
            }
        }
        resistance = baseResistance + r;
    }
    private void calcSpeed(){
        double s = 0;
        for (Double i:bonusSpeed.values()){
            if (i != null){
                s+=i;
            }
        }
        speed = baseSpeed + s;
    }

    public abstract void regen();
    public abstract void dealDamage(Entity e, Double amount, boolean isPhysical, boolean isCrit, double critDamageAmount);
    public void heal(){
        setHealth(getMaxHealth());
    }


    public HashMap<String ,Double> getBonusMaxHealth() {
        return bonusMaxHealth;
    }
    public HashMap<String ,Double> getBonusHealthRegen() {
        return bonusHealthRegen;
    }
    public HashMap<String ,Double> getBonusDefense() {
        return bonusDefense;
    }
    public HashMap<String ,Double> getBonusResistance() {
        return bonusResistance;
    }
    public HashMap<String ,Double> getBonusSpeed() {
        return bonusSpeed;
    }
    public int getLevel() {
        return level;
    }
    public Double getHealth() {
        return health;
    }
    public Double getMaxHealth() {
        return maxHealth;
    }
    public Double getHealthRegen() {
        return healthRegen;
    }
    public Double getDefense() {
        return defense;
    }
    public Double getResistance() {
        return resistance;
    }
    public Double getSpeed() {
        return speed;
    }
    public void setHealth(double health){
        this.health = health;
    }
    public void setBaseMaxHealth(double baseMaxHealth) {
        this.baseMaxHealth = baseMaxHealth;
    }
    public void setBaseHealthRegen(double baseHealthRegen) {
        this.baseHealthRegen = baseHealthRegen;
    }
    public void setBaseDefense(double baseDefense) {
        this.baseDefense = baseDefense;
    }
    public void setBaseResistance(double baseResistance) {
        this.baseResistance = baseResistance;
    }
    public void setBaseSpeed(double baseSpeed) {
        this.baseSpeed = baseSpeed;
    }
    public void setLevel(int level){
        this.level = level;
    }
}
