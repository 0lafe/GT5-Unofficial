package gregtech.common.blocks;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.objects.GT_CopiedBlockTexture;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class GT_Block_Ores extends GT_Block_Ores_Abstract {
    public GT_Block_Ores() {
        super("gt.blockores", Material.rock);
        for (int i = 0; i < 16; i++) {
            GT_ModHandler.addValuableOre(this, i, 1);
        }
        for (int i = 1; i < GregTech_API.sGeneratedMaterials.length; i++) {
            if (GregTech_API.sGeneratedMaterials[i] != null) {
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + i + ".name", getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 1000) + ".name", getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 2000) + ".name", getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 3000) + ".name", getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 4000) + ".name", getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 5000) + ".name", getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 6000) + ".name", getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 16000) + ".name", "Small " + getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 17000) + ".name", "Small " + getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 18000) + ".name", "Small " + getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 19000) + ".name", "Small " + getLocalizedName(GregTech_API.sGeneratedMaterials[i]));
                GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + (i + 20000) + ".name", "Small " + getLocalizedName(GregTech_API.sGeneratedMaterials[i]));

                if ((GregTech_API.sGeneratedMaterials[i].mTypes & 0x8) != 0) {
                    GT_OreDictUnificator.registerOre(OrePrefixes.ore.get(GregTech_API.sGeneratedMaterials[i]), new ItemStack(this, 1, i));
                    GT_OreDictUnificator.registerOre(OrePrefixes.oreNetherrack.get(GregTech_API.sGeneratedMaterials[i]), new ItemStack(this, 1, i + 1000));
                    GT_OreDictUnificator.registerOre(OrePrefixes.oreEndstone.get(GregTech_API.sGeneratedMaterials[i]), new ItemStack(this, 1, i + 2000));
                    GT_OreDictUnificator.registerOre(OrePrefixes.oreBlackgranite.get(GregTech_API.sGeneratedMaterials[i]), new ItemStack(this, 1, i + 3000));
                    GT_OreDictUnificator.registerOre(OrePrefixes.oreRedgranite.get(GregTech_API.sGeneratedMaterials[i]), new ItemStack(this, 1, i + 4000));
                    GT_OreDictUnificator.registerOre(OrePrefixes.oreMarble.get(GregTech_API.sGeneratedMaterials[i]), new ItemStack(this, 1, i + 5000));
                    GT_OreDictUnificator.registerOre(OrePrefixes.oreBasalt.get(GregTech_API.sGeneratedMaterials[i]), new ItemStack(this, 1, i + 6000));
                    if (tHideOres) {
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 1000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 2000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 3000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 4000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 5000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 6000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 16000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 17000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 18000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 19000));
                        codechicken.nei.api.API.hideItem(new ItemStack(this, 1, i + 20000));
                    }
                }         
            }
        }
    }

    @Override
    public String getUnlocalizedName() {
        return "gt.blockores";
    }

    @Override
    public int getHarvestLevel(int aMeta) {
        return aMeta == 5 || aMeta == 6 ? 2 : aMeta % 8;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World aWorld, int aX, int aY, int aZ, int aMeta, int aFortune) {
        TileEntity tTileEntity = aWorld.getTileEntity(aX, aY, aZ);
        if ((tTileEntity instanceof GT_TileEntity_Ores)) {
            return ((GT_TileEntity_Ores) tTileEntity).getDrops(GregTech_API.sBlockOres1, aFortune);
        }
        return mTemporaryTileEntity.get() == null ? new ArrayList() : mTemporaryTileEntity.get().getDrops(GregTech_API.sBlockOres1, aFortune);
    }

    @Override
    public ITexture[] getStoneTexture(int aTextureIndex, GT_RenderedTexture aIconSet) {
        ITexture[] mStoneTextures = new ITexture[]{new GT_CopiedBlockTexture(Blocks.stone, 0, 0), new GT_CopiedBlockTexture(Blocks.netherrack, 0, 0), new GT_CopiedBlockTexture(Blocks.end_stone, 0, 0), new GT_RenderedTexture(Textures.BlockIcons.GRANITE_BLACK_STONE), new GT_RenderedTexture(Textures.BlockIcons.GRANITE_RED_STONE), new GT_RenderedTexture(Textures.BlockIcons.MARBLE_STONE), new GT_RenderedTexture(Textures.BlockIcons.BASALT_STONE), new GT_CopiedBlockTexture(Blocks.stone, 0, 0), new GT_CopiedBlockTexture(Blocks.stone, 0, 0), new GT_CopiedBlockTexture(Blocks.stone, 0, 0), new GT_CopiedBlockTexture(Blocks.stone, 0, 0), new GT_CopiedBlockTexture(Blocks.stone, 0, 0), new GT_CopiedBlockTexture(Blocks.stone, 0, 0), new GT_CopiedBlockTexture(Blocks.stone, 0, 0), new GT_CopiedBlockTexture(Blocks.stone, 0, 0), new GT_CopiedBlockTexture(Blocks.stone, 0, 0)};
        return new ITexture[]{mStoneTextures[aTextureIndex], aIconSet};
    }

    @Override
    public void getSubBlocks(Item aItem, CreativeTabs aTab, List aList) {
        for (int i = 0; i < GregTech_API.sGeneratedMaterials.length; i++) {
            Materials tMaterial = GregTech_API.sGeneratedMaterials[i];
            if ((tMaterial != null) && ((tMaterial.mTypes & 0x8) != 0)) {
                aList.add(new ItemStack(aItem, 1, i));
                aList.add(new ItemStack(aItem, 1, i + 1000));
                aList.add(new ItemStack(aItem, 1, i + 2000));
                aList.add(new ItemStack(aItem, 1, i + 3000));
                aList.add(new ItemStack(aItem, 1, i + 4000));
                aList.add(new ItemStack(aItem, 1, i + 5000));
                aList.add(new ItemStack(aItem, 1, i + 6000));
                aList.add(new ItemStack(aItem, 1, i + 16000));
                aList.add(new ItemStack(aItem, 1, i + 17000));
                aList.add(new ItemStack(aItem, 1, i + 18000));
                aList.add(new ItemStack(aItem, 1, i + 19000));
                aList.add(new ItemStack(aItem, 1, i + 20000));
            }
        }
    }
}