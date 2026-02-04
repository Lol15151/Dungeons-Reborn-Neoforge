package net.lol15.dungeonsreborn.mod.client;

import java.util.UUID;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.resources.ResourceLocation;

public final class PlayerSkinUtil {

    private PlayerSkinUtil() {}

    public static ResourceLocation getSkin(UUID uuid) {

        // Hard fallback
        if (uuid == null) {
            return DefaultPlayerSkin.getDefaultTexture();
        }

        Minecraft mc = Minecraft.getInstance();
        SkinManager skinManager = mc.getSkinManager();

        GameProfile profile = new GameProfile(uuid, null);

        PlayerSkin skin = skinManager.getInsecureSkin(profile);

        return skin != null
                ? skin.texture()
                : DefaultPlayerSkin.getDefaultTexture();
    }
}
