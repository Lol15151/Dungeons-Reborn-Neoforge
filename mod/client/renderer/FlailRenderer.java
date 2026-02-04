package net.lol15.dungeonsreborn.mod.client.renderer;

import net.lol15.dungeonsreborn.mod.client.renderer.FlailModel;
import net.lol15.dungeonsreborn.mod.item.FlailItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FlailRenderer extends GeoItemRenderer<FlailItem> {
    public FlailRenderer() {
        super(new FlailModel());
    }
}
