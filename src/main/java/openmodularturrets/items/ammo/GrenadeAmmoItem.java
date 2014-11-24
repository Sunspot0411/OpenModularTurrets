package openmodularturrets.items.ammo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import openmodularturrets.ModInfo;
import openmodularturrets.items.ItemNames;

public class GrenadeAmmoItem extends AmmoItem {

	public GrenadeAmmoItem() {
		super();

		this.setUnlocalizedName(ItemNames.unlocalisedGrenadeCraftableItem);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(ModInfo.ID.toLowerCase() + ":grenadeAmmo");
	}
}