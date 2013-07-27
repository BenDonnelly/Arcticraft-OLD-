package arcticraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AC_ModelPirateHook extends ModelBase {

	public ModelRenderer box;
	
	public AC_ModelPirateHook() {
		this.box = new ModelRenderer(this, 0, 0);
		this.box.addBox(0F, 0F, 0F, 4, 4, 4);
		this.box.setRotationPoint(0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float f5) {
		this.setRotationAngles(par2, par3, par4, par5, par6, f5, par1Entity);
		this.box.render(f5);
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		
	}
}
