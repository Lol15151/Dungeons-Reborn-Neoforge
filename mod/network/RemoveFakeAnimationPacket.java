package net.lol15.dungeonsreborn.mod.network;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.neoforge.network.registration.*;

//public record RemoveFakeAnimationPacket() implements CustomPacketPayload {

//    public static final CustomPacketPayload.Type<RemoveFakeAnimationPacket> TYPE =
//            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("dungeonsreborn:remove_fake"));

//    public static final CustomPacketPayload.TypeAndCodec<RemoveFakeAnimationPacket> CODEC =
//            (buf) -> new RemoveFakeAnimationPacket(); // no data

//    @Override
//    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
//        return TYPE;
//    }
//}
