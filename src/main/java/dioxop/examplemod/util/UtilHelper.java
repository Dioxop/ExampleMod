package dioxop.examplemod.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class UtilHelper {
    public static List<BlockPos> getBlocksNearPlayer(EntityPlayer player, int radius) {
        List<BlockPos> blockPositions = new ArrayList<>();
        BlockPos playerPos = player.getPosition();
        int minX = playerPos.getX() - radius;
        int minY = Math.max(0, playerPos.getY() - radius);
        int minZ = playerPos.getZ() - radius;
        int maxX = playerPos.getX() + radius;
        int maxY = Math.min(255, playerPos.getY() + radius);
        int maxZ = playerPos.getZ() + radius;

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    BlockPos currentPos = new BlockPos(x, y, z);
                    blockPositions.add(currentPos);
                }
            }
        }

        return blockPositions;
    }
}
