package com.darksoldier1404.dlr.dEntity.obj;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.elemental.EntityElementalDamageEvent;
import com.darksoldier1404.dlr.obj.WarDamageable;
import com.darksoldier1404.dlr.utils.DamageUtils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("all")
public class ElementalDamageTable {
    private int ImpactStack;
    private double ImpactDamage;
    private int PunctureStack;
    private double PunctureDamage;
    private int SlashStack;
    private double SlashDamage;
    private int ColdStack;
    private double ColdDamage;
    private int ElectricityStack;
    private double ElectricityDamage;
    private int HeatStack;
    private double HeatDamage;
    private int ToxinStack;
    private double ToxinDamage;
    private int BlastStack;
    private double BlastDamage;
    private int CorrosiveStack;
    private double CorrosiveDamage;
    private int GasStack;
    private double GasDamage;
    private int MagneticStack;
    private double MagneticDamage;
    private int RadiationStack;
    private double RadiationDamage;
    private int VirusStack;
    private double VirusDamage;

    public void addStack(WarDamageable entity, ElementalType type, int stack, double damage) {
        switch (type) {
            case IMPACT:
                ImpactStack += stack;
                ImpactDamage += damage;
                BukkitTask task = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (ImpactStack > 0) {
                        DamageUtils.damage(entity, ElementalType.IMPACT, ImpactDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, ImpactDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    ImpactStack -= stack;
                    ImpactDamage -= damage;
                    task.cancel();
                }, 20 * 5L);
                break;
            case PUNCTURE:
                PunctureStack += stack;
                PunctureDamage += damage;
                BukkitTask task1 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (PunctureStack > 0) {
                        DamageUtils.damage(entity, ElementalType.PUNCTURE, PunctureDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, PunctureDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    PunctureStack -= stack;
                    PunctureDamage -= damage;
                    task1.cancel();
                }, 20 * 5L);
                break;
            case SLASH:
                SlashStack += stack;
                SlashDamage += damage;
                BukkitTask task2 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (SlashStack > 0) {
                        DamageUtils.damage(entity, ElementalType.SLASH, SlashDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, SlashDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    SlashStack -= stack;
                    SlashDamage -= damage;
                    task2.cancel();
                }, 20 * 5L);
                break;
            case COLD:
                ColdStack += stack;
                ColdDamage += damage;
                BukkitTask task3 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (ColdStack > 0) {
                        DamageUtils.damage(entity, ElementalType.COLD, ColdDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, ColdDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    ColdStack -= stack;
                    ColdDamage -= damage;
                    task3.cancel();
                }, 20 * 5L);
                break;
            case ELECTRICITY:
                ElectricityStack += stack;
                ElectricityDamage += damage;
                BukkitTask task4 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (ElectricityStack > 0) {
                        DamageUtils.damage(entity, ElementalType.ELECTRICITY, ElectricityDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, ElectricityDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    ElectricityStack -= stack;
                    ElectricityDamage -= damage;
                    task4.cancel();
                }, 20 * 5L);
                break;
            case HEAT:
                HeatStack += stack;
                HeatDamage += damage;
                BukkitTask task5 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (HeatStack > 0) {
                        DamageUtils.damage(entity, ElementalType.HEAT, HeatDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, HeatDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    HeatStack -= stack;
                    HeatDamage -= damage;
                    task5.cancel();
                }, 20 * 5L);
                break;
            case TOXIN:
                ToxinStack += stack;
                ToxinDamage += damage;
                BukkitTask task6 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (ToxinStack > 0) {
                        DamageUtils.damage(entity, ElementalType.TOXIN, ToxinDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, ToxinDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    ToxinStack -= stack;
                    ToxinDamage -= damage;
                    task6.cancel();
                }, 20 * 5L);
                break;
            case BLAST:
                BlastStack += stack;
                BlastDamage += damage;
                BukkitTask task7 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (BlastStack > 0) {
                        DamageUtils.damage(entity, ElementalType.BLAST, BlastDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, BlastDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    BlastStack -= stack;
                    BlastDamage -= damage;
                    task7.cancel();
                }, 20 * 5L);
                break;
            case CORROSIVE:
                CorrosiveStack += stack;
                CorrosiveDamage += damage;
                BukkitTask task8 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (CorrosiveStack > 0) {
                        DamageUtils.damage(entity, ElementalType.CORROSIVE, CorrosiveDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, CorrosiveDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    CorrosiveStack -= stack;
                    CorrosiveDamage -= damage;
                    task8.cancel();
                }, 20 * 5L);
                break;
            case GAS:
                GasStack += stack;
                GasDamage += damage;
                BukkitTask task9 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (GasStack > 0) {
                        DamageUtils.damage(entity, ElementalType.GAS, GasDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, GasDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    GasStack -= stack;
                    GasDamage -= damage;
                    task9.cancel();
                }, 20 * 5L);
                break;
            case RADIATION:
                RadiationStack += stack;
                RadiationDamage += damage;
                BukkitTask task10 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (RadiationStack > 0) {
                        DamageUtils.damage(entity, ElementalType.RADIATION, RadiationDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, RadiationDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    RadiationStack -= stack;
                    RadiationDamage -= damage;
                    task10.cancel();
                }, 20 * 5L);
                break;
            case MAGNETIC:
                MagneticStack += stack;
                MagneticDamage += damage;
                BukkitTask task11 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (MagneticStack > 0) {
                        DamageUtils.damage(entity, ElementalType.MAGNETIC, MagneticDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, MagneticDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    MagneticStack -= stack;
                    MagneticDamage -= damage;
                    task11.cancel();
                }, 20 * 5L);
                break;
            case VIRUS:
                VirusStack += stack;
                VirusDamage += damage;
                BukkitTask task12 = Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                    if (VirusStack > 0) {
                        DamageUtils.damage(entity, ElementalType.VIRUS, VirusDamage);
                        Bukkit.getServer().getPluginManager().callEvent(new EntityElementalDamageEvent(entity, type, VirusDamage));
                    }
                }, 0L, 10L);
                Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                    VirusStack -= stack;
                    VirusDamage -= damage;
                    task12.cancel();
                }, 20 * 5L);
                break;
        }
    }

    public int getImpactStack() {
        return ImpactStack;
    }

    public void setImpactStack(int impactStack) {
        ImpactStack = impactStack;
    }

    public double getImpactDamage() {
        return ImpactDamage;
    }

    public void setImpactDamage(double impactDamage) {
        ImpactDamage = impactDamage;
    }

    public int getPunctureStack() {
        return PunctureStack;
    }

    public void setPunctureStack(int punctureStack) {
        PunctureStack = punctureStack;
    }

    public double getPunctureDamage() {
        return PunctureDamage;
    }

    public void setPunctureDamage(double punctureDamage) {
        PunctureDamage = punctureDamage;
    }

    public int getSlashStack() {
        return SlashStack;
    }

    public void setSlashStack(int slashStack) {
        SlashStack = slashStack;
    }

    public double getSlashDamage() {
        return SlashDamage;
    }

    public void setSlashDamage(double slashDamage) {
        SlashDamage = slashDamage;
    }

    public int getColdStack() {
        return ColdStack;
    }

    public void setColdStack(int coldStack) {
        ColdStack = coldStack;
    }

    public double getColdDamage() {
        return ColdDamage;
    }

    public void setColdDamage(double coldDamage) {
        ColdDamage = coldDamage;
    }

    public int getElectricityStack() {
        return ElectricityStack;
    }

    public void setElectricityStack(int electricityStack) {
        ElectricityStack = electricityStack;
    }

    public double getElectricityDamage() {
        return ElectricityDamage;
    }

    public void setElectricityDamage(double electricityDamage) {
        ElectricityDamage = electricityDamage;
    }

    public int getHeatStack() {
        return HeatStack;
    }

    public void setHeatStack(int heatStack) {
        HeatStack = heatStack;
    }

    public double getHeatDamage() {
        return HeatDamage;
    }

    public void setHeatDamage(double heatDamage) {
        HeatDamage = heatDamage;
    }

    public int getToxinStack() {
        return ToxinStack;
    }

    public void setToxinStack(int toxinStack) {
        ToxinStack = toxinStack;
    }

    public double getToxinDamage() {
        return ToxinDamage;
    }

    public void setToxinDamage(double toxinDamage) {
        ToxinDamage = toxinDamage;
    }

    public int getBlastStack() {
        return BlastStack;
    }

    public void setBlastStack(int blastStack) {
        BlastStack = blastStack;
    }

    public double getBlastDamage() {
        return BlastDamage;
    }

    public void setBlastDamage(double blastDamage) {
        BlastDamage = blastDamage;
    }

    public int getCorrosiveStack() {
        return CorrosiveStack;
    }

    public void setCorrosiveStack(int corrosiveStack) {
        CorrosiveStack = corrosiveStack;
    }

    public double getCorrosiveDamage() {
        return CorrosiveDamage;
    }

    public void setCorrosiveDamage(double corrosiveDamage) {
        CorrosiveDamage = corrosiveDamage;
    }

    public int getGasStack() {
        return GasStack;
    }

    public void setGasStack(int gasStack) {
        GasStack = gasStack;
    }

    public double getGasDamage() {
        return GasDamage;
    }

    public void setGasDamage(double gasDamage) {
        GasDamage = gasDamage;
    }

    public int getMagneticStack() {
        return MagneticStack;
    }

    public void setMagneticStack(int magneticStack) {
        MagneticStack = magneticStack;
    }

    public double getMagneticDamage() {
        return MagneticDamage;
    }

    public void setMagneticDamage(double magneticDamage) {
        MagneticDamage = magneticDamage;
    }

    public int getRadiationStack() {
        return RadiationStack;
    }

    public void setRadiationStack(int radiationStack) {
        RadiationStack = radiationStack;
    }

    public double getRadiationDamage() {
        return RadiationDamage;
    }

    public void setRadiationDamage(double radiationDamage) {
        RadiationDamage = radiationDamage;
    }

    public int getVirusStack() {
        return VirusStack;
    }

    public void setVirusStack(int virusStack) {
        VirusStack = virusStack;
    }

    public double getVirusDamage() {
        return VirusDamage;
    }

    public void setVirusDamage(double virusDamage) {
        VirusDamage = virusDamage;
    }
}
