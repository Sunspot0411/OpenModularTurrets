package omtteam.openmodularturrets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import omtteam.openmodularturrets.OpenModularTurrets;
import omtteam.openmodularturrets.init.ModItems;
import omtteam.openmodularturrets.reference.OMTNames;
import omtteam.openmodularturrets.reference.Reference;
import omtteam.openmodularturrets.tileentity.TurretBase;

import java.util.List;

import static omtteam.omlib.util.GeneralUtil.getColoredBooleanLocalizationYesNo;
import static omtteam.omlib.util.GeneralUtil.safeLocalize;

public class UsableMetaItem extends Item {
    public UsableMetaItem() {
        super();

        this.setHasSubtypes(true);
        this.setCreativeTab(OpenModularTurrets.modularTurretsTab);
        this.setRegistryName(Reference.MOD_ID, OMTNames.Items.usableMetaItem);
        this.setUnlocalizedName(OMTNames.Items.usableMetaItem);
    }

    public final static String[] subNames = {
            OMTNames.Items.bulletThrowableItem, OMTNames.Items.grenadeThrowableItem, OMTNames.Items.memoryCard
    };


    @Override
    public boolean doesSneakBypassUse(ItemStack stack, IBlockAccess world, BlockPos pos, EntityPlayer player) {
        if (stack.getItemDamage() == 2 && world.getTileEntity(pos) instanceof TurretBase) {
            return true;
        }
        return super.doesSneakBypassUse(stack, world, pos, player);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (stack.getItemDamage() == 2 && playerIn.isSneaking()) {
            stack.getTagCompound().getKeySet().clear();
        }
        return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (itemStackIn.getItemDamage() == 2 && playerIn.isSneaking()) {
            itemStackIn.getTagCompound().getKeySet().clear();
        }
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (int i = 0; i < 3; i++) {
            subItems.add(new ItemStack(ModItems.usableMetaItem, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item." + subNames[itemStack.getItemDamage()];
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    public boolean hasDataStored(ItemStack stack){
        return stack.hasTagCompound() && stack.getTagCompound().hasKey("data");
    }

    public NBTTagCompound getDataStored(ItemStack stack){
        return stack.hasTagCompound() ? stack.getTagCompound().getCompoundTag("data") : null;
    }

    @SuppressWarnings("ConstantConditions")
    public void setDataStored(ItemStack stack, NBTTagCompound nbtTagCompound){
        if (stack.hasTagCompound()) {
            stack.getTagCompound().setTag("data", nbtTagCompound);
        } else {
            NBTTagCompound tagCompound = new NBTTagCompound();
            tagCompound.setTag("data", nbtTagCompound);
            stack.setTagCompound(tagCompound);
        }
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean isAdvanced) {
        if (stack.getItemDamage() ==2) {
            if (hasDataStored(stack)) {
                NBTTagCompound nbtTagCompound = getDataStored(stack);
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc1"));
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc2"));
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc3"));
                tooltip.add("\u00A76-Y: \u00A7b" + nbtTagCompound.getInteger("yAxisDetect"));
                tooltip.add("\u00A76"+safeLocalize(OMTNames.Localizations.INVERT) + ": " + getColoredBooleanLocalizationYesNo(nbtTagCompound.getBoolean("inverted")));
                tooltip.add("\u00A76"+safeLocalize(OMTNames.Localizations.MULTI_TARGETING) + ": " + getColoredBooleanLocalizationYesNo(nbtTagCompound.getBoolean("multiTargeting")));
                tooltip.add("\u00A76"+safeLocalize(OMTNames.Localizations.ATTACK_MOBS) + ": " + getColoredBooleanLocalizationYesNo(nbtTagCompound.getBoolean("attacksMobs")));
                tooltip.add("\u00A76"+safeLocalize(OMTNames.Localizations.ATTACK_NEUTRALS) + ": " + getColoredBooleanLocalizationYesNo(nbtTagCompound.getBoolean("attacksNeutrals")));
                tooltip.add("\u00A76"+safeLocalize(OMTNames.Localizations.ATTACK_PLAYERS) + ": " + getColoredBooleanLocalizationYesNo(nbtTagCompound.getBoolean("attacksPlayers")));
            } else // If the stack does not have valid tag data, a default message
            {
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc1"));
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc2"));
                tooltip.add(safeLocalize("tooltip.openmodularturrets.memory_card.desc3"));
            }
        }
    }
}