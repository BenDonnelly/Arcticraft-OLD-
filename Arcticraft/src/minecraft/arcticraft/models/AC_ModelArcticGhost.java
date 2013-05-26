
package arcticraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AC_ModelArcticGhost extends ModelBase
{
  //fields
    ModelRenderer hood;
    ModelRenderer backtail;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer hood1;
    ModelRenderer hood2;
    ModelRenderer hood3;
    ModelRenderer hood_4;
    ModelRenderer Tail;
  
  public AC_ModelArcticGhost()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      hood = new ModelRenderer(this, 0, 15);
      hood.addBox(-4F, -8F, -4F, 7, 1, 1);
      hood.setRotationPoint(-11F, -3F, 7F);
      hood.setTextureSize(64, 64);
      hood.mirror = true;
      setRotation(hood, 0F, 0F, 1.570796F);
      backtail = new ModelRenderer(this, 48, 0);
      backtail.addBox(-4F, -4F, 0F, 4, 9, 2);
      backtail.setRotationPoint(3F, 17F, -7F);
      backtail.setTextureSize(64, 64);
      backtail.mirror = true;
      setRotation(backtail, -1.041001F, 0.2230717F, -0.2230717F);
      rightarm = new ModelRenderer(this, 30, 27);
      rightarm.addBox(-2F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 1.443969F, -0.0954113F, 0.0570141F);
      leftarm = new ModelRenderer(this, 30, 27);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 1.577778F, 0.1559161F, -0.0767945F);
      body = new ModelRenderer(this, 30, 11);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, -0.0569039F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 7);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      hood1 = new ModelRenderer(this, 0, 17);
      hood1.addBox(-4F, -8F, -4F, 1, 1, 1);
      hood1.setRotationPoint(6F, 1F, 7F);
      hood1.setTextureSize(64, 64);
      hood1.mirror = true;
      setRotation(hood1, 0F, 0F, 0F);
      hood2 = new ModelRenderer(this, 0, 15);
      hood2.addBox(-4F, -8F, -4F, 7, 1, 1);
      hood2.setRotationPoint(-4F, -3F, 7F);
      hood2.setTextureSize(64, 64);
      hood2.mirror = true;
      setRotation(hood2, 0F, 0F, 1.570796F);
      hood3 = new ModelRenderer(this, 0, 15);
      hood3.addBox(-4F, -8F, -4F, 8, 1, 1);
      hood3.setRotationPoint(0F, 0F, 7F);
      hood3.setTextureSize(64, 64);
      hood3.mirror = true;
      setRotation(hood3, 0F, 0F, 0F);
      hood_4 = new ModelRenderer(this, 0, 17);
      hood_4.addBox(-4F, -8F, -4F, 1, 1, 1);
      hood_4.setRotationPoint(1F, 1F, 7F);
      hood_4.setTextureSize(64, 64);
      hood_4.mirror = true;
      setRotation(hood_4, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 30, 0);
      Tail.addBox(-4F, -4F, 1F, 6, 8, 3);
      Tail.setRotationPoint(1F, 13F, -4F);
      Tail.setTextureSize(64, 64);
      Tail.mirror = true;
      setRotation(Tail, -0.4089647F, -0.0371786F, -0.2230717F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    hood.render(f5);
    backtail.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    body.render(f5);
    head.render(f5);
    hood1.render(f5);
    hood2.render(f5);
    hood3.render(f5);
    hood_4.render(f5);
    Tail.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
