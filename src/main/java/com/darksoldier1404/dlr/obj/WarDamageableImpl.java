package com.darksoldier1404.dlr.obj;

import com.darksoldier1404.dlr.dentity.obj.ElementalDamageTable;

@SuppressWarnings("unused")
public class WarDamageableImpl extends ElementalDamageTable implements WarDamageable {
    private double defaultHealth;
    private double defaultHealthRecharge;
    private double defaultShield;
    private double defaultShieldRecharge;
    private double defaultArmor;
    private double defaultEnergy;
    private double defaultEnergyRecharge;
    private double defaultMovementSpeed;
    private double defaultAttackSpeed;
    private float defaultAbilityStrength;
    private float defaultAbilityRange;
    private float defaultAbilityEfficiency;
    private float defaultAbilityDuration;
    private double defaultImpactResistance;
    private double defaultPunctureResistance;
    private double defaultSlashResistance;
    private double defaultColdResistance;
    private double defaultElectricityResistance;
    private double defaultHeatResistance;
    private double defaultToxinResistance;
    private double defaultBlastResistance;
    private double defaultCorrosiveResistance;
    private double defaultGasResistance;
    private double defaultMagneticResistance;
    private double defaultRadiationResistance;
    private double defaultVirusResistance;
    private double HealthPerLevel;
    private double HealthRechargePerLevel;
    private double ShieldPerLevel;
    private double ShieldRechargePerLevel;
    private double ArmorPerLevel;
    private double EnergyPerLevel;
    private double EnergyRechargePerLevel;
    private double MovementSpeedPerLevel;
    private double AttackSpeedPerLevel;
    private float AbilityStrengthPerLevel;
    private float AbilityRangePerLevel;
    private float AbilityEfficiencyPerLevel;
    private float AbilityDurationPerLevel;
    private double ImpactResistancePerLevel;
    private double PunctureResistancePerLevel;
    private double SlashResistancePerLevel;
    private double ColdResistancePerLevel;
    private double ElectricityResistancePerLevel;
    private double HeatResistancePerLevel;
    private double ToxinResistancePerLevel;
    private double BlastResistancePerLevel;
    private double CorrosiveResistancePerLevel;
    private double GasResistancePerLevel;
    private double MagneticResistancePerLevel;
    private double RadiationResistancePerLevel;
    private double VirusResistancePerLevel;
    private double currentHealth;
    private double currentHealthRecharge;
    private double currentShield;
    private double currentShieldRecharge;
    private double currentArmor;
    private double currentEnergy;
    private double currentEnergyRecharge;
    private double currentMovementSpeed;
    private double currentAttackSpeed;
    private float currentAbilityStrength;
    private float currentAbilityRange;
    private float currentAbilityEfficiency;
    private float currentAbilityDuration;
    private double currentImpactResistance;
    private double currentPunctureResistance;
    private double currentSlashResistance;
    private double currentColdResistance;
    private double currentElectricityResistance;
    private double currentHeatResistance;
    private double currentToxinResistance;
    private double currentBlastResistance;
    private double currentCorrosiveResistance;
    private double currentGasResistance;
    private double currentMagneticResistance;
    private double currentRadiationResistance;
    private double currentVirusResistance;
    private double additionalHealth;
    private double additionalHealthRecharge;
    private double additionalShield;
    private double additionalShieldRecharge;
    private double additionalArmor;
    private double additionalEnergy;
    private double additionalEnergyRecharge;
    private double additionalMovementSpeed;
    private double additionalAttackSpeed;
    private float additionalAbilityStrength;
    private float additionalAbilityRange;
    private float additionalAbilityEfficiency;
    private float additionalAbilityDuration;
    private double additionalImpactResistance;
    private double additionalPunctureResistance;
    private double additionalSlashResistance;
    private double additionalColdResistance;
    private double additionalElectricityResistance;
    private double additionalHeatResistance;
    private double additionalToxinResistance;
    private double additionalBlastResistance;
    private double additionalCorrosiveResistance;
    private double additionalGasResistance;
    private double additionalMagneticResistance;
    private double additionalRadiationResistance;
    private double additionalVirusResistance;

    @Override
    public double getDefaultHealth() {
        return defaultHealth;
    }

    @Override
    public void setDefaultHealth(double defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    @Override
    public double getDefaultHealthRecharge() {
        return defaultHealthRecharge;
    }

    @Override
    public void setDefaultHealthRecharge(double defaultHealthRecharge) {
        this.defaultHealthRecharge = defaultHealthRecharge;
    }

    @Override
    public double getDefaultShield() {
        return defaultShield;
    }

    @Override
    public void setDefaultShield(double defaultShield) {
        this.defaultShield = defaultShield;
    }

    @Override
    public double getDefaultShieldRecharge() {
        return defaultShieldRecharge;
    }

    @Override
    public void setDefaultShieldRecharge(double defaultShieldRecharge) {
        this.defaultShieldRecharge = defaultShieldRecharge;
    }

    @Override
    public double getDefaultArmor() {
        return defaultArmor;
    }

    @Override
    public void setDefaultArmor(double defaultArmor) {
        this.defaultArmor = defaultArmor;
    }

    @Override
    public double getDefaultEnergy() {
        return defaultEnergy;
    }

    @Override
    public void setDefaultEnergy(double defaultEnergy) {
        this.defaultEnergy = defaultEnergy;
    }

    @Override
    public double getDefaultEnergyRecharge() {
        return defaultEnergyRecharge;
    }

    @Override
    public void setDefaultEnergyRecharge(double defaultEnergyRecharge) {
        this.defaultEnergyRecharge = defaultEnergyRecharge;
    }

    @Override
    public double getDefaultMovementSpeed() {
        return defaultMovementSpeed;
    }

    @Override
    public void setDefaultMovementSpeed(double defaultMovementSpeed) {
        this.defaultMovementSpeed = defaultMovementSpeed;
    }

    @Override
    public double getDefaultAttackSpeed() {
        return defaultAttackSpeed;
    }

    @Override
    public void setDefaultAttackSpeed(double defaultAttackSpeed) {
        this.defaultAttackSpeed = defaultAttackSpeed;
    }

    @Override
    public float getDefaultAbilityStrength() {
        return defaultAbilityStrength;
    }

    @Override
    public void setDefaultAbilityStrength(float defaultAbilityStrength) {
        this.defaultAbilityStrength = defaultAbilityStrength;
    }

    @Override
    public float getDefaultAbilityRange() {
        return defaultAbilityRange;
    }

    @Override
    public void setDefaultAbilityRange(float defaultAbilityRange) {
        this.defaultAbilityRange = defaultAbilityRange;
    }

    @Override
    public float getDefaultAbilityEfficiency() {
        return defaultAbilityEfficiency;
    }

    @Override
    public void setDefaultAbilityEfficiency(float defaultAbilityEfficiency) {
        this.defaultAbilityEfficiency = defaultAbilityEfficiency;
    }

    @Override
    public float getDefaultAbilityDuration() {
        return defaultAbilityDuration;
    }

    @Override
    public void setDefaultAbilityDuration(float defaultAbilityDuration) {
        this.defaultAbilityDuration = defaultAbilityDuration;
    }

    @Override
    public double getDefaultImpactResistance() {
        return defaultImpactResistance;
    }

    @Override
    public void setDefaultImpactResistance(double defaultImpactResistance) {
        this.defaultImpactResistance = defaultImpactResistance;
    }

    @Override
    public double getDefaultPunctureResistance() {
        return defaultPunctureResistance;
    }

    @Override
    public void setDefaultPunctureResistance(double defaultPunctureResistance) {
        this.defaultPunctureResistance = defaultPunctureResistance;
    }

    @Override
    public double getDefaultSlashResistance() {
        return defaultSlashResistance;
    }

    @Override
    public void setDefaultSlashResistance(double defaultSlashResistance) {
        this.defaultSlashResistance = defaultSlashResistance;
    }

    @Override
    public double getDefaultColdResistance() {
        return defaultColdResistance;
    }

    @Override
    public void setDefaultColdResistance(double defaultColdResistance) {
        this.defaultColdResistance = defaultColdResistance;
    }

    @Override
    public double getDefaultElectricityResistance() {
        return defaultElectricityResistance;
    }

    @Override
    public void setDefaultElectricityResistance(double defaultElectricityResistance) {
        this.defaultElectricityResistance = defaultElectricityResistance;
    }

    @Override
    public double getDefaultHeatResistance() {
        return defaultHeatResistance;
    }

    @Override
    public void setDefaultHeatResistance(double defaultHeatResistance) {
        this.defaultHeatResistance = defaultHeatResistance;
    }

    @Override
    public double getDefaultToxinResistance() {
        return defaultToxinResistance;
    }

    @Override
    public void setDefaultToxinResistance(double defaultToxinResistance) {
        this.defaultToxinResistance = defaultToxinResistance;
    }

    @Override
    public double getDefaultBlastResistance() {
        return defaultBlastResistance;
    }

    @Override
    public void setDefaultBlastResistance(double defaultBlastResistance) {
        this.defaultBlastResistance = defaultBlastResistance;
    }

    @Override
    public double getDefaultCorrosiveResistance() {
        return defaultCorrosiveResistance;
    }

    @Override
    public void setDefaultCorrosiveResistance(double defaultCorrosiveResistance) {
        this.defaultCorrosiveResistance = defaultCorrosiveResistance;
    }

    @Override
    public double getDefaultGasResistance() {
        return defaultGasResistance;
    }

    @Override
    public void setDefaultGasResistance(double defaultGasResistance) {
        this.defaultGasResistance = defaultGasResistance;
    }

    @Override
    public double getDefaultMagneticResistance() {
        return defaultMagneticResistance;
    }

    @Override
    public void setDefaultMagneticResistance(double defaultMagneticResistance) {
        this.defaultMagneticResistance = defaultMagneticResistance;
    }

    @Override
    public double getDefaultRadiationResistance() {
        return defaultRadiationResistance;
    }

    @Override
    public void setDefaultRadiationResistance(double defaultRadiationResistance) {
        this.defaultRadiationResistance = defaultRadiationResistance;
    }

    @Override
    public double getDefaultVirusResistance() {
        return defaultVirusResistance;
    }

    @Override
    public void setDefaultVirusResistance(double defaultVirusResistance) {
        this.defaultVirusResistance = defaultVirusResistance;
    }

    @Override
    public double getHealthPerLevel() {
        return HealthPerLevel;
    }

    @Override
    public void setHealthPerLevel(double healthPerLevel) {
        HealthPerLevel = healthPerLevel;
    }

    @Override
    public double getHealthRechargePerLevel() {
        return HealthRechargePerLevel;
    }

    @Override
    public void setHealthRechargePerLevel(double healthRechargePerLevel) {
        HealthRechargePerLevel = healthRechargePerLevel;
    }

    @Override
    public double getShieldPerLevel() {
        return ShieldPerLevel;
    }

    @Override
    public void setShieldPerLevel(double shieldPerLevel) {
        ShieldPerLevel = shieldPerLevel;
    }

    @Override
    public double getShieldRechargePerLevel() {
        return ShieldRechargePerLevel;
    }

    @Override
    public void setShieldRechargePerLevel(double shieldRechargePerLevel) {
        ShieldRechargePerLevel = shieldRechargePerLevel;
    }

    @Override
    public double getArmorPerLevel() {
        return ArmorPerLevel;
    }

    @Override
    public void setArmorPerLevel(double armorPerLevel) {
        ArmorPerLevel = armorPerLevel;
    }

    @Override
    public double getEnergyPerLevel() {
        return EnergyPerLevel;
    }

    @Override
    public void setEnergyPerLevel(double energyPerLevel) {
        EnergyPerLevel = energyPerLevel;
    }

    @Override
    public double getEnergyRechargePerLevel() {
        return EnergyRechargePerLevel;
    }

    @Override
    public void setEnergyRechargePerLevel(double energyRechargePerLevel) {
        EnergyRechargePerLevel = energyRechargePerLevel;
    }

    @Override
    public double getMovementSpeedPerLevel() {
        return MovementSpeedPerLevel;
    }

    @Override
    public void setMovementSpeedPerLevel(double movementSpeedPerLevel) {
        MovementSpeedPerLevel = movementSpeedPerLevel;
    }

    @Override
    public double getAttackSpeedPerLevel() {
        return AttackSpeedPerLevel;
    }

    @Override
    public void setAttackSpeedPerLevel(double attackSpeedPerLevel) {
        AttackSpeedPerLevel = attackSpeedPerLevel;
    }

    @Override
    public float getAbilityStrengthPerLevel() {
        return AbilityStrengthPerLevel;
    }

    @Override
    public void setAbilityStrengthPerLevel(float abilityStrengthPerLevel) {
        AbilityStrengthPerLevel = abilityStrengthPerLevel;
    }

    @Override
    public float getAbilityRangePerLevel() {
        return AbilityRangePerLevel;
    }

    @Override
    public void setAbilityRangePerLevel(float abilityRangePerLevel) {
        AbilityRangePerLevel = abilityRangePerLevel;
    }

    @Override
    public float getAbilityEfficiencyPerLevel() {
        return AbilityEfficiencyPerLevel;
    }

    @Override
    public void setAbilityEfficiencyPerLevel(float abilityEfficiencyPerLevel) {
        AbilityEfficiencyPerLevel = abilityEfficiencyPerLevel;
    }

    @Override
    public float getAbilityDurationPerLevel() {
        return AbilityDurationPerLevel;
    }

    @Override
    public void setAbilityDurationPerLevel(float abilityDurationPerLevel) {
        AbilityDurationPerLevel = abilityDurationPerLevel;
    }

    @Override
    public double getImpactResistancePerLevel() {
        return ImpactResistancePerLevel;
    }

    @Override
    public void setImpactResistancePerLevel(double impactResistancePerLevel) {
        ImpactResistancePerLevel = impactResistancePerLevel;
    }

    @Override
    public double getPunctureResistancePerLevel() {
        return PunctureResistancePerLevel;
    }

    @Override
    public void setPunctureResistancePerLevel(double punctureResistancePerLevel) {
        PunctureResistancePerLevel = punctureResistancePerLevel;
    }

    @Override
    public double getSlashResistancePerLevel() {
        return SlashResistancePerLevel;
    }

    @Override
    public void setSlashResistancePerLevel(double slashResistancePerLevel) {
        SlashResistancePerLevel = slashResistancePerLevel;
    }

    @Override
    public double getColdResistancePerLevel() {
        return ColdResistancePerLevel;
    }

    @Override
    public void setColdResistancePerLevel(double coldResistancePerLevel) {
        ColdResistancePerLevel = coldResistancePerLevel;
    }

    @Override
    public double getElectricityResistancePerLevel() {
        return ElectricityResistancePerLevel;
    }

    @Override
    public void setElectricityResistancePerLevel(double electricityResistancePerLevel) {
        ElectricityResistancePerLevel = electricityResistancePerLevel;
    }

    @Override
    public double getHeatResistancePerLevel() {
        return HeatResistancePerLevel;
    }

    @Override
    public void setHeatResistancePerLevel(double heatResistancePerLevel) {
        HeatResistancePerLevel = heatResistancePerLevel;
    }

    @Override
    public double getToxinResistancePerLevel() {
        return ToxinResistancePerLevel;
    }

    @Override
    public void setToxinResistancePerLevel(double toxinResistancePerLevel) {
        ToxinResistancePerLevel = toxinResistancePerLevel;
    }

    @Override
    public double getBlastResistancePerLevel() {
        return BlastResistancePerLevel;
    }

    @Override
    public void setBlastResistancePerLevel(double blastResistancePerLevel) {
        BlastResistancePerLevel = blastResistancePerLevel;
    }

    @Override
    public double getCorrosiveResistancePerLevel() {
        return CorrosiveResistancePerLevel;
    }

    @Override
    public void setCorrosiveResistancePerLevel(double corrosiveResistancePerLevel) {
        CorrosiveResistancePerLevel = corrosiveResistancePerLevel;
    }

    @Override
    public double getGasResistancePerLevel() {
        return GasResistancePerLevel;
    }

    @Override
    public void setGasResistancePerLevel(double gasResistancePerLevel) {
        GasResistancePerLevel = gasResistancePerLevel;
    }

    @Override
    public double getMagneticResistancePerLevel() {
        return MagneticResistancePerLevel;
    }

    @Override
    public void setMagneticResistancePerLevel(double magneticResistancePerLevel) {
        MagneticResistancePerLevel = magneticResistancePerLevel;
    }

    @Override
    public double getRadiationResistancePerLevel() {
        return RadiationResistancePerLevel;
    }

    @Override
    public void setRadiationResistancePerLevel(double radiationResistancePerLevel) {
        RadiationResistancePerLevel = radiationResistancePerLevel;
    }

    @Override
    public double getVirusResistancePerLevel() {
        return VirusResistancePerLevel;
    }

    @Override
    public void setVirusResistancePerLevel(double virusResistancePerLevel) {
        VirusResistancePerLevel = virusResistancePerLevel;
    }

    @Override
    public double getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    @Override
    public double getCurrentHealthRecharge() {
        return currentHealthRecharge;
    }

    @Override
    public void setCurrentHealthRecharge(double currentHealthRecharge) {
        this.currentHealthRecharge = currentHealthRecharge;
    }

    @Override
    public double getCurrentShield() {
        return currentShield;
    }

    @Override
    public void setCurrentShield(double currentShield) {
        this.currentShield = currentShield;
    }

    @Override
    public double getCurrentShieldRecharge() {
        return currentShieldRecharge;
    }

    @Override
    public void setCurrentShieldRecharge(double currentShieldRecharge) {
        this.currentShieldRecharge = currentShieldRecharge;
    }

    @Override
    public double getCurrentArmor() {
        return currentArmor;
    }

    @Override
    public void setCurrentArmor(double currentArmor) {
        this.currentArmor = currentArmor;
    }

    @Override
    public double getCurrentEnergy() {
        return currentEnergy;
    }

    @Override
    public void setCurrentEnergy(double currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    @Override
    public double getCurrentEnergyRecharge() {
        return currentEnergyRecharge;
    }

    @Override
    public void setCurrentEnergyRecharge(double currentEnergyRecharge) {
        this.currentEnergyRecharge = currentEnergyRecharge;
    }

    @Override
    public double getCurrentMovementSpeed() {
        return currentMovementSpeed;
    }

    @Override
    public void setCurrentMovementSpeed(double currentMovementSpeed) {
        this.currentMovementSpeed = currentMovementSpeed;
    }

    @Override
    public double getCurrentAttackSpeed() {
        return currentAttackSpeed;
    }

    @Override
    public void setCurrentAttackSpeed(double currentAttackSpeed) {
        this.currentAttackSpeed = currentAttackSpeed;
    }

    @Override
    public float getCurrentAbilityStrength() {
        return currentAbilityStrength;
    }

    @Override
    public void setCurrentAbilityStrength(float currentAbilityStrength) {
        this.currentAbilityStrength = currentAbilityStrength;
    }

    @Override
    public float getCurrentAbilityRange() {
        return currentAbilityRange;
    }

    @Override
    public void setCurrentAbilityRange(float currentAbilityRange) {
        this.currentAbilityRange = currentAbilityRange;
    }

    @Override
    public float getCurrentAbilityEfficiency() {
        return currentAbilityEfficiency;
    }

    @Override
    public void setCurrentAbilityEfficiency(float currentAbilityEfficiency) {
        this.currentAbilityEfficiency = currentAbilityEfficiency;
    }

    @Override
    public float getCurrentAbilityDuration() {
        return currentAbilityDuration;
    }

    @Override
    public void setCurrentAbilityDuration(float currentAbilityDuration) {
        this.currentAbilityDuration = currentAbilityDuration;
    }

    @Override
    public double getCurrentImpactResistance() {
        return currentImpactResistance;
    }

    @Override
    public void setCurrentImpactResistance(double currentImpactResistance) {
        this.currentImpactResistance = currentImpactResistance;
    }

    @Override
    public double getCurrentPunctureResistance() {
        return currentPunctureResistance;
    }

    @Override
    public void setCurrentPunctureResistance(double currentPunctureResistance) {
        this.currentPunctureResistance = currentPunctureResistance;
    }

    @Override
    public double getCurrentSlashResistance() {
        return currentSlashResistance;
    }

    @Override
    public void setCurrentSlashResistance(double currentSlashResistance) {
        this.currentSlashResistance = currentSlashResistance;
    }

    @Override
    public double getCurrentColdResistance() {
        return currentColdResistance;
    }

    @Override
    public void setCurrentColdResistance(double currentColdResistance) {
        this.currentColdResistance = currentColdResistance;
    }

    @Override
    public double getCurrentElectricityResistance() {
        return currentElectricityResistance;
    }

    @Override
    public void setCurrentElectricityResistance(double currentElectricityResistance) {
        this.currentElectricityResistance = currentElectricityResistance;
    }

    @Override
    public double getCurrentHeatResistance() {
        return currentHeatResistance;
    }

    @Override
    public void setCurrentHeatResistance(double currentHeatResistance) {
        this.currentHeatResistance = currentHeatResistance;
    }

    @Override
    public double getCurrentToxinResistance() {
        return currentToxinResistance;
    }

    @Override
    public void setCurrentToxinResistance(double currentToxinResistance) {
        this.currentToxinResistance = currentToxinResistance;
    }

    @Override
    public double getCurrentBlastResistance() {
        return currentBlastResistance;
    }

    @Override
    public void setCurrentBlastResistance(double currentBlastResistance) {
        this.currentBlastResistance = currentBlastResistance;
    }

    @Override
    public double getCurrentCorrosiveResistance() {
        return currentCorrosiveResistance;
    }

    @Override
    public void setCurrentCorrosiveResistance(double currentCorrosiveResistance) {
        this.currentCorrosiveResistance = currentCorrosiveResistance;
    }

    @Override
    public double getCurrentGasResistance() {
        return currentGasResistance;
    }

    @Override
    public void setCurrentGasResistance(double currentGasResistance) {
        this.currentGasResistance = currentGasResistance;
    }

    @Override
    public double getCurrentMagneticResistance() {
        return currentMagneticResistance;
    }

    @Override
    public void setCurrentMagneticResistance(double currentMagneticResistance) {
        this.currentMagneticResistance = currentMagneticResistance;
    }

    @Override
    public double getCurrentRadiationResistance() {
        return currentRadiationResistance;
    }

    @Override
    public void setCurrentRadiationResistance(double currentRadiationResistance) {
        this.currentRadiationResistance = currentRadiationResistance;
    }

    @Override
    public double getCurrentVirusResistance() {
        return currentVirusResistance;
    }

    @Override
    public void setCurrentVirusResistance(double currentVirusResistance) {
        this.currentVirusResistance = currentVirusResistance;
    }

    @Override
    public double getAdditionalHealth() {
        return additionalHealth;
    }

    @Override
    public void setAdditionalHealth(double additionalHealth) {
        this.additionalHealth = additionalHealth;
    }

    @Override
    public double getAdditionalHealthRecharge() {
        return additionalHealthRecharge;
    }

    @Override
    public void setAdditionalHealthRecharge(double additionalHealthRecharge) {
        this.additionalHealthRecharge = additionalHealthRecharge;
    }

    @Override
    public double getAdditionalShield() {
        return additionalShield;
    }

    @Override
    public void setAdditionalShield(double additionalShield) {
        this.additionalShield = additionalShield;
    }

    @Override
    public double getAdditionalShieldRecharge() {
        return additionalShieldRecharge;
    }

    @Override
    public void setAdditionalShieldRecharge(double additionalShieldRecharge) {
        this.additionalShieldRecharge = additionalShieldRecharge;
    }

    @Override
    public double getAdditionalArmor() {
        return additionalArmor;
    }

    @Override
    public void setAdditionalArmor(double additionalArmor) {
        this.additionalArmor = additionalArmor;
    }

    @Override
    public double getAdditionalEnergy() {
        return additionalEnergy;
    }

    @Override
    public void setAdditionalEnergy(double additionalEnergy) {
        this.additionalEnergy = additionalEnergy;
    }

    @Override
    public double getAdditionalEnergyRecharge() {
        return additionalEnergyRecharge;
    }

    @Override
    public void setAdditionalEnergyRecharge(double additionalEnergyRecharge) {
        this.additionalEnergyRecharge = additionalEnergyRecharge;
    }

    @Override
    public double getAdditionalMovementSpeed() {
        return additionalMovementSpeed;
    }

    @Override
    public void setAdditionalMovementSpeed(double additionalMovementSpeed) {
        this.additionalMovementSpeed = additionalMovementSpeed;
    }

    @Override
    public double getAdditionalAttackSpeed() {
        return additionalAttackSpeed;
    }

    @Override
    public void setAdditionalAttackSpeed(double additionalAttackSpeed) {
        this.additionalAttackSpeed = additionalAttackSpeed;
    }

    @Override
    public float getAdditionalAbilityStrength() {
        return additionalAbilityStrength;
    }

    @Override
    public void setAdditionalAbilityStrength(float additionalAbilityStrength) {
        this.additionalAbilityStrength = additionalAbilityStrength;
    }

    @Override
    public float getAdditionalAbilityRange() {
        return additionalAbilityRange;
    }

    @Override
    public void setAdditionalAbilityRange(float additionalAbilityRange) {
        this.additionalAbilityRange = additionalAbilityRange;
    }

    @Override
    public float getAdditionalAbilityEfficiency() {
        return additionalAbilityEfficiency;
    }

    @Override
    public void setAdditionalAbilityEfficiency(float additionalAbilityEfficiency) {
        this.additionalAbilityEfficiency = additionalAbilityEfficiency;
    }

    @Override
    public float getAdditionalAbilityDuration() {
        return additionalAbilityDuration;
    }

    @Override
    public void setAdditionalAbilityDuration(float additionalAbilityDuration) {
        this.additionalAbilityDuration = additionalAbilityDuration;
    }

    @Override
    public double getAdditionalImpactResistance() {
        return additionalImpactResistance;
    }

    @Override
    public void setAdditionalImpactResistance(double additionalImpactResistance) {
        this.additionalImpactResistance = additionalImpactResistance;
    }

    @Override
    public double getAdditionalPunctureResistance() {
        return additionalPunctureResistance;
    }

    @Override
    public void setAdditionalPunctureResistance(double additionalPunctureResistance) {
        this.additionalPunctureResistance = additionalPunctureResistance;
    }

    @Override
    public double getAdditionalSlashResistance() {
        return additionalSlashResistance;
    }

    @Override
    public void setAdditionalSlashResistance(double additionalSlashResistance) {
        this.additionalSlashResistance = additionalSlashResistance;
    }

    @Override
    public double getAdditionalColdResistance() {
        return additionalColdResistance;
    }

    @Override
    public void setAdditionalColdResistance(double additionalColdResistance) {
        this.additionalColdResistance = additionalColdResistance;
    }

    @Override
    public double getAdditionalElectricityResistance() {
        return additionalElectricityResistance;
    }

    @Override
    public void setAdditionalElectricityResistance(double additionalElectricityResistance) {
        this.additionalElectricityResistance = additionalElectricityResistance;
    }

    @Override
    public double getAdditionalHeatResistance() {
        return additionalHeatResistance;
    }

    @Override
    public void setAdditionalHeatResistance(double additionalHeatResistance) {
        this.additionalHeatResistance = additionalHeatResistance;
    }

    @Override
    public double getAdditionalToxinResistance() {
        return additionalToxinResistance;
    }

    @Override
    public void setAdditionalToxinResistance(double additionalToxinResistance) {
        this.additionalToxinResistance = additionalToxinResistance;
    }

    @Override
    public double getAdditionalBlastResistance() {
        return additionalBlastResistance;
    }

    @Override
    public void setAdditionalBlastResistance(double additionalBlastResistance) {
        this.additionalBlastResistance = additionalBlastResistance;
    }

    @Override
    public double getAdditionalCorrosiveResistance() {
        return additionalCorrosiveResistance;
    }

    @Override
    public void setAdditionalCorrosiveResistance(double additionalCorrosiveResistance) {
        this.additionalCorrosiveResistance = additionalCorrosiveResistance;
    }

    @Override
    public double getAdditionalGasResistance() {
        return additionalGasResistance;
    }

    @Override
    public void setAdditionalGasResistance(double additionalGasResistance) {
        this.additionalGasResistance = additionalGasResistance;
    }

    @Override
    public double getAdditionalMagneticResistance() {
        return additionalMagneticResistance;
    }

    @Override
    public void setAdditionalMagneticResistance(double additionalMagneticResistance) {
        this.additionalMagneticResistance = additionalMagneticResistance;
    }

    @Override
    public double getAdditionalRadiationResistance() {
        return additionalRadiationResistance;
    }

    @Override
    public void setAdditionalRadiationResistance(double additionalRadiationResistance) {
        this.additionalRadiationResistance = additionalRadiationResistance;
    }

    @Override
    public double getAdditionalVirusResistance() {
        return additionalVirusResistance;
    }

    @Override
    public void setAdditionalVirusResistance(double additionalVirusResistance) {
        this.additionalVirusResistance = additionalVirusResistance;
    }
}
