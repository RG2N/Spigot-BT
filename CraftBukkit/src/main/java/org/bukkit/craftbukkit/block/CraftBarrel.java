package org.bukkit.craftbukkit.block;

import net.minecraft.sounds.SoundEffects;
import net.minecraft.world.level.block.BlockBarrel;
import net.minecraft.world.level.block.entity.TileEntityBarrel;
import net.minecraft.world.level.block.state.IBlockData;
import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.inventory.CraftInventory;
import org.bukkit.inventory.Inventory;

public class CraftBarrel extends CraftLootable<TileEntityBarrel> implements Barrel {

    public CraftBarrel(Block block) {
        super(block, TileEntityBarrel.class);
    }

    public CraftBarrel(Material material, TileEntityBarrel te) {
        super(material, te);
    }

    @Override
    public Inventory getSnapshotInventory() {
        return new CraftInventory(this.getSnapshot());
    }

    @Override
    public Inventory getInventory() {
        if (!this.isPlaced()) {
            return this.getSnapshotInventory();
        }

        return new CraftInventory(this.getTileEntity());
    }

    @Override
    public void open() {
        requirePlaced();
        if (!getTileEntity().openersCounter.opened) {
            IBlockData blockData = getTileEntity().getBlock();
            boolean open = blockData.get(BlockBarrel.OPEN);

            if (!open) {
                getTileEntity().setOpenFlag(blockData, true);
                getTileEntity().playOpenSound(blockData, SoundEffects.BARREL_OPEN);
            }
        }
        getTileEntity().openersCounter.opened = true;
    }

    @Override
    public void close() {
        requirePlaced();
        if (getTileEntity().openersCounter.opened) {
            IBlockData blockData = getTileEntity().getBlock();
            getTileEntity().setOpenFlag(blockData, false);
            getTileEntity().playOpenSound(blockData, SoundEffects.BARREL_CLOSE);
        }
        getTileEntity().openersCounter.opened = false;
    }
}
