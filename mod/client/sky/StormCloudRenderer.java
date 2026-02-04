package net.lol15.dungeonsreborn.mod.client.sky;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.lwjgl.opengl.GL11;

public class StormCloudRenderer {

    private static final ResourceLocation DARKEST_FOREST =
            ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "darkest_forest");

    private static final ResourceLocation CLOUD_BASE =
            ResourceLocation.fromNamespaceAndPath(
                    "dungeonsreborn",
                    "textures/environment/storm_clouds.png"
            );

    private static final double CLOUD_Y = 150.0;

    private static final int FOG_SHEETS = 8;
    private static final double FOG_HEIGHT = 10.0;

    // particle fog
    private static final int FOG_RADIUS = 15;
    private static final int FOG_PARTICLES_PER_TICK = 40;

    @SubscribeEvent
    public void onRenderLevel(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_LEVEL) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) return;

        var biomeKey = mc.level.getBiome(mc.player.blockPosition()).unwrapKey().orElse(null);
        if (biomeKey == null || !biomeKey.location().equals(DARKEST_FOREST)) return;

        // cloud-layer volumetric particles
        spawnWindAdvectedCloudParticles(mc);

        PoseStack poseStack = event.getPoseStack();
        Camera camera = mc.gameRenderer.getMainCamera();

        float partial = event.getPartialTick().getGameTimeDeltaTicks();
        float time = mc.level.getGameTime() + partial;

        poseStack.pushPose();

        // cancel camera rotation so clouds stay flat
        Quaternionf inverseRotation = new Quaternionf(camera.rotation()).invert();
        poseStack.mulPose(inverseRotation);

        RenderSystem.enableDepthTest();
        RenderSystem.depthFunc(GL11.GL_LEQUAL);
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();

        float flash = StormLightning.getFlashStrength();

        float rMult = 1f - 0.1f * flash;
        float gMult = 1f - 0.1f * flash;
        float bMult = 1f + 0.4f * flash;

        renderLayer(
                poseStack,
                CLOUD_BASE,
                CLOUD_Y - camera.getPosition().y,
                time * 0.002f,
                0.68f,
                256,
                rMult, gMult, bMult
        );

        for (int i = 0; i < FOG_SHEETS; i++) {
            float heightFrac = i / (float) (FOG_SHEETS - 1);
            double yOffset = CLOUD_Y - camera.getPosition().y + heightFrac * FOG_HEIGHT;

            float swirl =
                    Mth.sin(time * 0.02f + i * 13.2f) * 0.5f +
                            Mth.cos(time * 0.015f + i * 7.1f) * 0.5f;

            poseStack.pushPose();
            poseStack.translate(swirl * 2.5, yOffset, swirl * -2.0);
            poseStack.mulPose(new Quaternionf().rotateY(time * 0.002f + i));

            float alpha = (0.22f * (1f - heightFrac)) + flash * 0.45f;
            alpha *= Mth.clamp(1f - heightFrac, 0.4f, 1f);

            float scroll = time * (0.003f + i * 0.0006f);

            renderLayer(poseStack, CLOUD_BASE, 0, scroll, alpha, 192, rMult, gMult, bMult);
            renderLayer(poseStack, CLOUD_BASE, 0.5, scroll * 1.15f, alpha * 0.6f, 176, rMult, gMult, bMult);

            poseStack.popPose();
        }

        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();

        poseStack.popPose();
    }

    /**
     * Wind-advected cloud particles at y = 150
     */
    private void spawnWindAdvectedCloudParticles(Minecraft mc) {
        RandomSource random = mc.level.random;

        double px = mc.player.getX();
        double pz = mc.player.getZ();
        double y = CLOUD_Y;

        float time = mc.level.getGameTime();

        // coherent wind field
        double windAngle = time * 0.002;
        double windStrength = 0.035 + 0.015 * Mth.sin(time * 0.01f);

        double windX = Mth.cos((float) windAngle) * windStrength;
        double windZ = Mth.sin((float) windAngle) * windStrength;

        for (int i = 0; i < FOG_PARTICLES_PER_TICK; i++) {
            double angle = random.nextDouble() * Math.PI * 2.0;
            double radius = random.nextDouble() * FOG_RADIUS;

            double x = px + Math.cos(angle) * radius;
            double z = pz + Math.sin(angle) * radius;

            // slight vertical thickness so it feels volumetric
            double yJitter = y + random.nextGaussian() * 0.6;

            mc.level.addParticle(
                    ParticleTypes.EXPLOSION_EMITTER,
                    x, yJitter, z,
                    windX, 0.0, windZ
            );
        }
    }

    private void renderLayer(
            PoseStack poseStack,
            ResourceLocation texture,
            double yOffset,
            float scroll,
            float alpha,
            double scale,
            float rMult,
            float gMult,
            float bMult
    ) {
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, texture);

        Tesselator tess = Tesselator.getInstance();
        BufferBuilder buffer = tess.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);

        Matrix4f matrix = poseStack.last().pose();

        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                float x0 = (float) (x * scale);
                float z0 = (float) (z * scale);
                float s = (float) scale;
                float y = (float) yOffset;

                float r = 0.3f + 0.7f * rMult;
                float g = 0.3f + 0.7f * gMult;
                float b = 0.3f + 0.7f * bMult;

                buffer.addVertex(matrix, x0, y, z0).setUv(scroll, scroll).setColor(r, g, b, alpha);
                buffer.addVertex(matrix, x0, y, z0 + s).setUv(scroll, 1f + scroll).setColor(r, g, b, alpha);
                buffer.addVertex(matrix, x0 + s, y, z0 + s).setUv(1f + scroll, 1f + scroll).setColor(r, g, b, alpha);
                buffer.addVertex(matrix, x0 + s, y, z0).setUv(1f + scroll, scroll).setColor(r, g, b, alpha);
            }
        }

        BufferUploader.drawWithShader(buffer.build());
    }
}
