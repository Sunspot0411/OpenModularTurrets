package omtteam.openmodularturrets.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import omtteam.omlib.util.GeneralUtil;
import omtteam.openmodularturrets.handler.config.OMTConfig;
import omtteam.openmodularturrets.reference.OMTNames;
import omtteam.openmodularturrets.reference.Reference;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.text.DecimalFormat;
import java.util.List;

import static omtteam.omlib.util.GeneralUtil.safeLocalize;

@SuppressWarnings("deprecation")
public class ItemBlockRocketTurret extends AbstractItemBlockBaseAddon {
    private static final DecimalFormat df = new DecimalFormat("0.0");

    public ItemBlockRocketTurret(Block block) {
        super(block);
        this.setRegistryName(Reference.MOD_ID, OMTNames.Blocks.rocketTurret);
    }

    @Override
    @SuppressWarnings("unchecked")
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))) {
            tooltip.add(GeneralUtil.getShiftDetail());
        } else {
            tooltip.add(safeLocalize(OMTNames.Localizations.GUI.TURRET_HEAD_DESCRIPTION));
            tooltip.add("");
            tooltip.add(TextFormatting.GOLD + "--" + safeLocalize("text.openmodularturrets.info") + "--");
            tooltip.add(safeLocalize("text.openmodularturrets.tier") + ": " + TextFormatting.WHITE + "4");
            tooltip.add(safeLocalize("text.openmodularturrets.range") + ": " + TextFormatting.WHITE +
                                OMTConfig.TURRETS.rocket_turret.baseRange);
            tooltip.add(safeLocalize("text.openmodularturrets.accuracy") + ": " + TextFormatting.WHITE +
                                safeLocalize("text.openmodularturrets.turret.accuracy.exact"));
            tooltip.add(safeLocalize("text.openmodularturrets.ammo") + ": " + TextFormatting.WHITE +
                                safeLocalize("text.openmodularturrets.turret.ammo.3"));
            tooltip.add(safeLocalize("text.openmodularturrets.tier_required") + ": " + TextFormatting.WHITE +
                                safeLocalize("base.tier.4"));
            tooltip.add("");
            tooltip.add(
                    TextFormatting.DARK_PURPLE + "--" + safeLocalize("text.openmodularturrets.damage.label") + "--");
            tooltip.add(safeLocalize("text.openmodularturrets.damage.stat") + ": " + TextFormatting.WHITE +
                                (OMTConfig.TURRETS.rocket_turret.baseDamage / 2F) + " " + safeLocalize(
                    "text.openmodularturrets.health"));
            tooltip.add(safeLocalize("text.openmodularturrets.aoe") + ": " + TextFormatting.WHITE + "5");
            tooltip.add(safeLocalize("text.openmodularturrets.fire_rate") + ": " + TextFormatting.WHITE + df.format(
                    20.0F / OMTConfig.TURRETS.rocket_turret.baseFireRate));
            tooltip.add(safeLocalize("text.openmodularturrets.energy.stat") + ": " + TextFormatting.WHITE +
                                OMTConfig.TURRETS.rocket_turret.powerUsage + " RF");
            tooltip.add("");
            tooltip.add(TextFormatting.DARK_GRAY + safeLocalize("text.openmodularturrets.flavour.turret.3"));
        }
    }
}
