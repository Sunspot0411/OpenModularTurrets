package omtteam.openmodularturrets.turret;

import net.minecraft.nbt.NBTTagCompound;

import java.util.Objects;

/**
 * Created by Keridos on 17/08/17.
 * This Class is the class used for declaring targeting settings to the targeting system for turrets.
 */
public class TargetingSettings {
    private boolean targetPlayers;
    private boolean targetMobs;
    private boolean targetPassive;
    private int maxRange;
    private EnumTargetingPriority priority;

    private TargetingSettings() {
    }

    public TargetingSettings(boolean targetPlayers, boolean targetMobs, boolean targetPassive, int maxRange, EnumTargetingPriority priority) {
        this.targetPlayers = targetPlayers;
        this.targetMobs = targetMobs;
        this.targetPassive = targetPassive;
        this.maxRange = maxRange;
        this.priority = priority;
    }

    public boolean isTargetPlayers() {
        return targetPlayers;
    }

    public boolean isTargetMobs() {
        return targetMobs;
    }

    public boolean isTargetPassive() {
        return targetPassive;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public static TargetingSettings readFromNBT(NBTTagCompound nbtTagCompound) {
        TargetingSettings settings = new TargetingSettings();
        if (nbtTagCompound.hasKey("targetingSettings")) {
            NBTTagCompound nbt = nbtTagCompound.getCompoundTag("targetingSettings");
            settings.targetPlayers = nbt.getBoolean("targetPlayers");
            settings.targetMobs = nbt.getBoolean("targetMobs");
            settings.targetPassive = nbt.getBoolean("targetPassive");
            settings.maxRange = nbt.getInteger("maxRange");
            settings.priority = EnumTargetingPriority.values()[nbt.getInteger("priority")];
        } else {
            settings.targetPlayers = nbtTagCompound.getBoolean("attacksPlayers");
            settings.targetMobs = nbtTagCompound.getBoolean("attacksMobs");
            settings.targetPassive = nbtTagCompound.getBoolean("attacksNeutrals");
            settings.maxRange = nbtTagCompound.getInteger("currentMaxRange");
            settings.priority = EnumTargetingPriority.DISTANCE;
        }
        return settings;
    }

    public EnumTargetingPriority getPriority() {
        return priority;
    }

    public TargetingSettings setPriority(EnumTargetingPriority priority) {
        this.priority = priority;
        return this;
    }

    public TargetingSettings setTargetPlayers(boolean targetPlayers) {
        this.targetPlayers = targetPlayers;
        return this;
    }

    public TargetingSettings setTargetMobs(boolean targetMobs) {
        this.targetMobs = targetMobs;
        return this;
    }

    public TargetingSettings setTargetPassive(boolean targetPassive) {
        this.targetPassive = targetPassive;
        return this;
    }

    public TargetingSettings setMaxRange(int maxRange) {
        this.maxRange = maxRange;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargetingSettings that = (TargetingSettings) o;
        return targetPlayers == that.targetPlayers &&
                targetMobs == that.targetMobs &&
                targetPassive == that.targetPassive &&
                maxRange == that.maxRange &&
                priority == that.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetPlayers, targetMobs, targetPassive, maxRange, priority);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("maxRange", this.maxRange);
        nbt.setBoolean("targetPlayers", this.targetPlayers);
        nbt.setBoolean("targetMobs", this.targetMobs);
        nbt.setBoolean("targetPassive", this.targetPassive);
        nbt.setInteger("priority", this.priority.ordinal());
        nbtTagCompound.setTag("targetingSettings", nbt);
        return nbtTagCompound;
    }
}
