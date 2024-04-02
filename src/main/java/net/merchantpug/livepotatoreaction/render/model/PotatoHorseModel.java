package net.merchantpug.livepotatoreaction.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.merchantpug.livepotatoreaction.LivePotatoReaction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;

public class PotatoHorseModel extends Model {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(LivePotatoReaction.asResource("potato_horse"), "main");
	private final ModelPart root;

	public PotatoHorseModel(ModelPart root) {
		super(RenderType::entityCutoutNoCull);
        this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(10, 0).addBox(-1.5F, -4.0F, -3.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-2.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		root.addOrReplaceChild("leftFront", CubeListBuilder.create().texOffs(0, 9).addBox(1.15F, -3.4F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(10, 9).addBox(1.15F, -3.4F, 1.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		root.addOrReplaceChild("rightFront", CubeListBuilder.create().texOffs(4, 9).addBox(-2.15F, -3.4F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(10, 0).addBox(-2.15F, -3.4F, 1.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 0).addBox(-1.1F, -9.0F, -1.425F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(26, 0).addBox(0.1F, -9.0F, -1.425F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(1, 1).addBox(-0.5F, -7.9F, -3.725F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.2F))
		.texOffs(0, 0).addBox(-1.0F, -8.1F, -2.525F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int j, float f, float g, float h, float k) {
		root.render(poseStack, vertexConsumer, i, j, f, g, h, k);
	}

	public ModelPart getRoot() {
		return root;
	}
}