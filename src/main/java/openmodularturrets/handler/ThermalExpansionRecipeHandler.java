package openmodularturrets.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import openmodularturrets.blocks.Blocks;
import openmodularturrets.items.Items;

public class ThermalExpansionRecipeHandler {

    public static void init() {

        String TE = "ThermalExpansion";

        ItemStack powerCoilGold;
        ItemStack powerCoilSilver;
        ItemStack cellResonant;
        ItemStack cellReinforced;
        ItemStack cellHardened;
        ItemStack cellBasic;

		/* Blocks */
        cellResonant = GameRegistry.findItemStack(TE, "cellResonant", 1);
        cellReinforced = GameRegistry.findItemStack(TE, "cellReinforced", 1);
        cellHardened = GameRegistry.findItemStack(TE, "cellHardened", 1);
        cellBasic = GameRegistry.findItemStack(TE, "cellBasic", 1);

		/* Items */
        powerCoilGold = GameRegistry.findItemStack(TE, "powerCoilGold", 1);
        powerCoilSilver = GameRegistry.findItemStack(TE, "powerCoilSilver", 1);

        // Items
        // Barrels
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.barrelTierTwoItem, 1), new Object[]{"AAA", " B ",
                "AAA", 'A', "ingotLead", 'B', Items.barrelTierOneItem}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.barrelTierThreeItem, 1), new Object[]{"AAA", " B ",
                "AAA", 'A', "ingotInvar", 'B', Items.barrelTierTwoItem}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.barrelTierFourItem, 1),
                new Object[]{"CAC", " B ", "CAC", 'A',
                        net.minecraft.init.Items.diamond, 'B',
                        Items.barrelTierThreeItem, 'C',
                        "ingotElectrum"}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.barrelTierFiveItem, 1), new Object[]{"AAA", "CBC",
                "AAA", 'A', net.minecraft.init.Blocks.obsidian, 'B',
                Items.barrelTierFourItem, 'C', "ingotEnderium"}));

        // Chambers
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.chamberTierTwoItem, 1), new Object[]{"AAA", " BC",
                "AAA", 'A', "ingotLead", 'B', Items.chamberTierOneItem, 'C',
                powerCoilSilver}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.chamberTierThreeItem, 1), new Object[]{"AAA", " BC",
                "AAA", 'A', "ingotInvar", 'B', Items.chamberTierTwoItem, 'C',
                powerCoilSilver}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.chamberTierFourItem, 1), new Object[]{"DAD", " BC",
                "DAD", 'A', net.minecraft.init.Items.diamond, 'B',
                Items.chamberTierThreeItem, 'C', powerCoilSilver, 'D',
                "ingotElectrum"}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.chamberTierFiveItem, 1), new Object[]{"ADA", " BC",
                "ADA", 'A', net.minecraft.init.Blocks.obsidian, 'B',
                Items.chamberTierFourItem, 'C', powerCoilSilver, 'D',
                "ingotEnderium"}));

        // Sensors
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.sensorTierTwoItem, 1), new Object[]{" A ", "ABA",
                " C ", 'A', "ingotLead", 'B', Items.sensorTierOneItem, 'C',
                Items.ioBus}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.sensorTierThreeItem, 1), new Object[]{" C ", "ABA",
                " C ", 'A', "ingotInvar", 'B', Items.sensorTierTwoItem, 'C',
                Items.ioBus}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.sensorTierFourItem, 1), new Object[]{"EDE", "CBC",
                "EDE", 'B', Items.sensorTierThreeItem, 'C',
                Items.ioBus, 'D', net.minecraft.init.Items.diamond, 'E',
                "ingotElectrum"}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Items.sensorTierFiveItem, 1), new Object[]{"EDE", "CBC",
                "EDE", 'B', Items.sensorTierFourItem, 'C',
                Items.ioBus, 'D', net.minecraft.init.Items.glowstone_dust, 'E',
                "ingotEnderium"}));

        // Bases
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Blocks.turretBaseTierTwo, 1), new Object[]{"ABA", "DCD",
                "ADA", 'A', "ingotLead", 'B', cellBasic, 'C',
                Items.sensorTierTwoItem, 'D', powerCoilGold}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Blocks.turretBaseTierThree, 1), new Object[]{"ABA", "DCD",
                "ADA", 'A', "ingotInvar", 'B', cellHardened, 'C',
                Items.sensorTierThreeItem, 'D', powerCoilGold}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Blocks.turretBaseTierFour, 1), new Object[]{"ABA", "DCD",
                "ADA", 'A', "ingotElectrum", 'B',
                cellReinforced, 'C', Items.sensorTierFourItem, 'D',
                powerCoilGold}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Blocks.turretBaseTierFive, 1), new Object[]{"ABA", "DCD",
                "ADA", 'A', net.minecraft.init.Blocks.obsidian, 'B',
                cellResonant, 'C', Items.sensorTierFiveItem, 'D',
                powerCoilGold}));

        // Turrets
        GameRegistry
                .addRecipe(new ShapedOreRecipe(new ItemStack(
                        Blocks.machineGunTurret, 1), new Object[]{" A ",
                        "CAC", "DBD", 'A', Items.barrelTierTwoItem, 'B',
                        Items.chamberTierTwoItem, 'C', "ingotIron", 'D',
                        Items.ioBus}));

        GameRegistry
                .addRecipe(new ShapedOreRecipe(new ItemStack(
                        Blocks.incendiaryTurret, 1), new Object[]{"A A",
                        "BCB", "DCD", 'A', Items.barrelTierTwoItem, 'B',
                        Items.chamberTierTwoItem, 'C', "ingotIron", 'D',
                        Items.ioBus}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Blocks.grenadeLauncherTurret, 1),
                new Object[]{" A ", "CBC", "CDC", 'A',
                        Items.barrelTierThreeItem, 'B',
                        Items.chamberTierThreeItem, 'C', "ingotGold", 'D',
                        Items.ioBus}));

        GameRegistry
                .addRecipe(new ShapedOreRecipe(new ItemStack(
                        Blocks.relativisticTurret, 1), new Object[]{"CAC",
                        "ABA", "CDC", 'A',
                        net.minecraft.init.Items.ender_pearl, 'B',
                        Items.sensorTierThreeItem, 'C', "ingotGold", 'D',
                        Items.ioBus}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Blocks.rocketTurret, 1), new Object[]{"CAC", "ABA", "EDE",
                'A', Items.barrelTierFourItem, 'B', Items.chamberTierFourItem,
                'C', net.minecraft.init.Items.quartz, 'D', Items.ioBus, 'E',
                net.minecraft.init.Items.diamond}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Blocks.teleporterTurret, 1), new Object[]{"CEC", "ABA",
                "CDC", 'A', net.minecraft.init.Items.diamond, 'B',
                Items.sensorTierFourItem, 'C',
                net.minecraft.init.Items.ender_eye, 'D', Items.ioBus, 'E',
                net.minecraft.init.Items.quartz}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Blocks.laserTurret, 1), new Object[]{" A ", "CBC", "DCD",
                'A', Items.barrelTierFiveItem, 'B', Items.chamberTierFiveItem,
                'C', net.minecraft.init.Blocks.obsidian, 'D', Items.ioBus}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                Blocks.railGunTurret, 1), new Object[]{"CAC", "CAC", "DBD",
                'A', Items.barrelTierFiveItem, 'B', Items.chamberTierFiveItem,
                'C', net.minecraft.init.Blocks.obsidian, 'D', Items.ioBus}));

        // Ammo
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.rocketCraftable, 32),
                new Object[]{" A ", "ABA", "ACA", 'A',
                        "ingotTin", 'B',
                        net.minecraft.init.Items.gunpowder, 'C',
                        net.minecraft.init.Items.redstone}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.bulletCraftable, 64),
                new Object[]{" A ", " B ", " C ", 'A',
                        "ingotLead", 'B',
                        net.minecraft.init.Items.gunpowder, 'C',
                        "ingotIron"}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.grenadeCraftable, 32),
                new Object[]{" C ", "ABA", " A ", 'A',
                        "ingotIron", 'B',
                        net.minecraft.init.Items.gunpowder, 'C',
                        net.minecraft.init.Items.redstone}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.ferroSlug, 16),
                new Object[]{" C ", "CBC", " A ", 'A',
                        "ingotInvar", 'B',
                        net.minecraft.init.Items.flint, 'C',
                        net.minecraft.init.Items.redstone}));
    }
}