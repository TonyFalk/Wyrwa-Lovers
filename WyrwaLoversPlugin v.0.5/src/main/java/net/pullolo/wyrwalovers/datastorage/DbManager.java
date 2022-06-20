package net.pullolo.wyrwalovers.datastorage;

import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static net.pullolo.wyrwalovers.Main.get_Logger;
import static net.pullolo.wyrwalovers.Main.plugin;

public class DbManager {
    public void init(){
        File file = new File(plugin.getDataFolder(), "data.db");
        if (!file.exists()){
            file.getParentFile().mkdirs();
            plugin.saveResource("data.db", false);
        }
    }

    public boolean isDbEnabled(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:data.db");
            Statement stmt = conn.createStatement();
            String sql = "create table if not exists data (name TEXT PRIMARY KEY NOT NULL, level INT NOT NULL, hp INT NOT NULL, mana INT NOT NULL);";
            stmt.execute(sql);
            stmt.close();
            conn.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isPlayerInDb(String name){
        boolean is = false;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:data.db");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from data where name=\"" + name + "\";");
            if (rs.isClosed()){
                return false;
            }
            if(rs.getString("name") != null){
                is = true;
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }

    public EntityStats getPlayer(String name){
        int level = 1;
        int mana = 100;
        int hp = 100;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:data.db");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from data where name=\"" + name + "\";");

            level = rs.getInt("level");
            hp = rs.getInt("hp");
            mana = rs.getInt("mana");
            get_Logger().info("Executed query for player " + rs.getString("name"));

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        EntityStats stats = new EntityStats(Bukkit.getPlayer(name), null);
        stats.setLevel(level);
        stats.setHealth(hp);
        stats.setMana(mana);
        return stats;
    }

    public void addPlayer(String name, int level, int hp, int mana){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:data.db");
            Statement stmt = conn.createStatement();

            String insert = "insert into data (name, level, hp ,mana) values (\"" + name + "\", " + level + ", " + hp + ", " + mana + ");";
            stmt.execute(insert);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePlayer(String name, int level, int hp, int mana){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:data.db");
            Statement stmt = conn.createStatement();

            String update = "update data set level=" + level + ", hp=" + hp + ", mana=" + mana + " where name=\"" + name + "\";";
            stmt.execute(update);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
