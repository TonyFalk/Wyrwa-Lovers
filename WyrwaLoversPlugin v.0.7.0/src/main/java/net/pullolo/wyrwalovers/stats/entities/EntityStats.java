package net.pullolo.wyrwalovers.stats.entities;

import net.pullolo.wyrwalovers.misc.DamageIndicator;
import net.pullolo.wyrwalovers.misc.TimeHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class EntityStats extends EntityStatistics{

    public static int MAX_PLAYER_HEALTH = 100;
    public static int DAMAGE_MULTIPLIER = MAX_PLAYER_HEALTH/20;

    private String entityType;
    private boolean isUndead = false;

    private Double baseDamage, damage;
    private HashMap<String ,Double> bonusDamage = new HashMap<>();
    private Double baseMaxMana, mana, maxMana;
    private HashMap<String ,Double> bonusMana = new HashMap<>();
    private Double baseAbilityPower, abilityPower;
    private HashMap<String ,Double> bonusAbilityPower = new HashMap<>();
    private Double baseCritChance, critChance;
    private HashMap<String ,Double> bonusCritChance = new HashMap<>();
    private Double baseCritDamage, critDamage;
    private HashMap<String ,Double> bonusCritDamage = new HashMap<>();

    private String name;
    private String customName;
    Random rand = new Random();

    public EntityStats(Entity e, String type){
        if (type != null){
            entityType = type;
        } else {
            entityType = e.getType().toString().toLowerCase();
        }
        if (!(e instanceof Player)){
            if (e.getType().equals(EntityType.ZOMBIE)){
                isUndead = true;
                setLevel(rand.nextInt(50)+1);
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.CREEPER)){
                setLevel(rand.nextInt(50)+1);
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.SKELETON)){
                isUndead = true;
                setLevel(rand.nextInt(50)+1);
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.SPIDER)){
                setLevel(rand.nextInt(50)+1);
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.CAVE_SPIDER)){
                setLevel(rand.nextInt(45)+6);
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.ENDERMAN)){
                setLevel(rand.nextInt(40)+11);
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.PHANTOM)){
                setLevel(rand.nextInt(40)+11);
                updateCustom(200, 10, 0, 100, 100, getLevel()*DAMAGE_MULTIPLIER*4, 100, 300, 0, 0);
            }
            else if (e.getType().equals(EntityType.ENDER_DRAGON)){
                setLevel(300);
                updateCustom(200*getLevel(), 5*getLevel(), 0, 0, 100, getLevel()*DAMAGE_MULTIPLIER*7, 50, 100, 0, 0);
            }
            else {
                setLevel(rand.nextInt(10)+1);
                updateDefaults();
            }
            calcStats();
            heal();
            maxOutMana();

            this.name = calcName(e);
        }
        else {
            setLevel(1);
            updateCustom(MAX_PLAYER_HEALTH-40 + ((getLevel()+1)*32) - 24, (getLevel()/4)+1, 10+(getLevel()*3), 10+(getLevel()*2), 100, ((getLevel()/2)+1)*DAMAGE_MULTIPLIER + 2, 2+getLevel(), 20+getLevel()*5, getLevel()*2, getLevel()*20 + 80);
            calcStats();
            heal();
            maxOutMana();
        }
        runChecks();
    }

    public void updateStats(Entity e) {
        //Todo add scaling values for a lot of mobs!
        if (!(e instanceof Player)){
            if (e.getType().equals(EntityType.ZOMBIE)){
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.CREEPER)){
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.SKELETON)){
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.SPIDER)){
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.CAVE_SPIDER)){
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.ENDERMAN)){
                updateDefaults();
            }
            else if (e.getType().equals(EntityType.PHANTOM)){
                if (TimeHandler.isDay(e.getWorld())){
                    updateCustom(200, 0, 0, 100, 100, getLevel()*DAMAGE_MULTIPLIER*7, 0, 100, 0, 0);
                } else {
                    updateCustom(200, 10, 0, 100, 100, getLevel()*DAMAGE_MULTIPLIER*7, 100, 700, 0, 0);
                }
            }
            else if (e.getType().equals(EntityType.ENDER_DRAGON)){
                updateCustom(200*getLevel(), 5*getLevel(), 0, 0, 100, getLevel()*DAMAGE_MULTIPLIER*7, 50, 100, 0, 0);
            }
            else {
                updateDefaults();
            }
            calcStats();

            updateName();
            e.setCustomNameVisible(true);
            e.setCustomName(customName);
        }
        else {
            updateCustom(MAX_PLAYER_HEALTH-40 + ((getLevel()+1)*32) - 24, (getLevel()/4)+1, 10+(getLevel()*1.8), 10+(getLevel()*1.5), 100, ((getLevel()/2)+1)*DAMAGE_MULTIPLIER + 2, 2+getLevel(), 20+getLevel()*5, getLevel()*2, getLevel()*20 + 80);
            calcStats();
        }
        runChecks();
    }

    private void updateDefaults(){
        setBaseMaxHealth(getLevel()*20);
        setBaseHealthRegen(getLevel()/4);
        setBaseDefense((getLevel()/2) + 2);
        setBaseResistance((getLevel()/2) + 2);
        setBaseSpeed(100);
        setBaseDamage((1 + (3 * (getLevel())))*DAMAGE_MULTIPLIER + 1);
        setBaseCritChance(0);
        setbaseCritDamage(0);
        setBaseAbilityPower(0);
        setBaseMaxMana(0);
    }

    private void updateCustom(double maxHp, double hpRegen, double def, double res, double speed, double damage, double cc, double cd, double ap, double maxMana){
        setBaseMaxHealth(maxHp);
        setBaseHealthRegen(hpRegen);
        setBaseDefense(def);
        setBaseResistance(res);
        setBaseSpeed(speed);
        setBaseDamage(damage);
        setBaseCritChance(cc);
        setbaseCritDamage(cd);
        setBaseAbilityPower(ap);
        setBaseMaxMana(maxMana);
    }

    @Override
    public void calcStats(){
        super.calcStats();
        calcDamage();
        calcCritChance();
        calcCritDamage();
        calcAbilityPower();
        calcMana();
    }
    private void calcDamage(){
        double d = 0;
        for (Double i:bonusDamage.values()){
            if (i != null){
                d+=i;
            }
        }
        damage = baseDamage + d;
    }
    private void calcCritChance(){
        double c = 0;
        for (Double i:bonusCritChance.values()){
            if (i != null){
                c+=i;
            }
        }
        critChance = baseCritChance + c;
    }
    private void calcCritDamage(){
        double d = 0;
        for (Double i:bonusCritDamage.values()){
            if (i != null){
                d+=i;
            }
        }
        critDamage = baseCritDamage + d;
    }
    private void calcAbilityPower(){
        double a = 0;
        for (Double i:bonusAbilityPower.values()){
            if (i != null){
                a+=i;
            }
        }
        abilityPower = baseAbilityPower + a;
    }
    private void calcMana(){
        double m = 0;
        for (Double i:bonusMana.values()){
            if (i != null){
                m+=i;
            }
        }
        maxMana = baseMaxMana + m;
    }

    private void runChecks(){
        if (getHealth() > getMaxHealth()){
            setHealth(getMaxHealth());
        }
        if (getCritChance() > (double) 100){
            setCritChance(100);
        }
        if (getCritChance() < (double) 0){
            setCritChance(0);
        }
        if (getMana() > getMaxMana()){
            setMana(getMaxMana());
        }
        if (getMana() < 0){
            setMana(0);
        }
    }

    @Override
    public void regen() {
        setHealth(getHealth()+getHealthRegen());
    }

    public void regenMana(){
        setMana(getMana()+(getMaxMana()/50));
    }

    @Override
    public void dealDamage(Entity e, Double amou, boolean isPhysical, boolean isCrit, double critDamageAmount) {
        double amount;
        double effectiveHpDef = getHealth() * (1 + getDefense()/100);
        double effectiveHpRes = getHealth() * (1 + getResistance()/100);
        if (isCrit){
            amount = amou * ((100+critDamageAmount)/100);
        } else amount = amou;

        if (isPhysical){
            amount = (amount*(getHealth()/effectiveHpDef));
        } else {
            amount = (amount*(getHealth()/effectiveHpRes));
        }
        setHealth(getHealth() - amount);
        new DamageIndicator(e, amount, isCrit);
    }

    public void dealTrueDamage(Entity e, Double amount){
        setHealth(getHealth()-amount);
        new DamageIndicator(e, amount, false);
    }

    public boolean rollForCrit(Entity e) {
        Double cc = entityMap.get(e).getCritChance();
        if (cc <= 0){
            return false;
        }
        return (rand.nextInt(100) <= cc);
    }

    public void respawn() {
        heal();
        maxOutMana();
    }

    public void maxOutMana(){
        setMana(getMaxMana());
    }

    private void updateName(){
        if(getHealth() > getMaxHealth()){
            setHealth(getMaxHealth());
        }
        if (getHealth().equals(getMaxHealth())){
            this.customName = "§8[§7Lv" + getLevel() + "§8] " + "§c" + this.name + " §a" + Math.round(getHealth()) + "§7/§a" + Math.round(getMaxHealth()) + "§c❤";
        }else {
            this.customName = "§8[§7Lv" + getLevel() + "§8] " + "§c" + this.name + " §e" + Math.round(getHealth()) + "§7/§a" + Math.round(getMaxHealth()) + "§c❤";
        }
    }
    private String calcName(Entity e){
        char[] chars = e.getType().toString().toLowerCase().toCharArray();
        String value = "";
        for (int i = 0; i < chars.length; i++){
            if(i == 0){
                value += String.valueOf(chars[i]);
            }else {
                value += chars[i];
            }
        }
        return value;
    }

    public String getName() {
        return name;
    }
    public String getCustomName() {
        return customName;
    }
    public void setCustomName(String customName) {
        this.customName = customName;
    }
    public Double getDamage() {
        return damage;
    }
    public HashMap<String ,Double> getBonusDamage() {
        return bonusDamage;
    }
    public void setBaseDamage(double damage){
        this.baseDamage = damage;
    }
    public Double getCritChance() {
        return critChance;
    }
    public HashMap<String ,Double> getBonusCritChance() {
        return bonusCritChance;
    }
    public void setBaseCritChance(double critChance){
        this.baseCritChance = critChance;
    }
    private void setCritChance(double critChance){
        this.critChance= critChance;
    }
    public Double getCritDamage() {
        return critDamage;
    }
    public HashMap<String ,Double> getBonusCritDamage() {
        return bonusCritDamage;
    }
    public void setbaseCritDamage(double critDamage){
        this.baseCritDamage = critDamage;
    }

    public Double getAbilityPower() {
        return abilityPower;
    }
    public HashMap<String ,Double> getBonusAbilityPower() {
        return bonusAbilityPower;
    }
    public void setBaseAbilityPower(double abilityPower){
        this.baseAbilityPower = abilityPower;
    }

    public Double getMana() {
        return mana;
    }
    public void setMana(double mana){
        this.mana = mana;
    }
    public Double getMaxMana(){
        return maxMana;
    }
    public HashMap<String ,Double> getBonusMana() {
        return bonusMana;
    }
    public void setBaseMaxMana(double maxMana){
        this.baseMaxMana = maxMana;
    }


    public String getEntityType() {
        return entityType;
    }
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public boolean isUndead() {
        return isUndead;
    }
}
