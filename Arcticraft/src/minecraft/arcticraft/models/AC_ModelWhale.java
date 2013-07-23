package arcticraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AC_ModelWhale extends ModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer LowerBody1;
    ModelRenderer LowerBody2;
    ModelRenderer LowerBody3;
    ModelRenderer LowerBody4;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Fin1;
    ModelRenderer Fin2;
  
  public AC_ModelWhale()
  {
    textureWidth = 512;
    textureHeight = 512;
    
      Head = new ModelRenderer(this, 8, 4);
      Head.addBox(0F, 0F, 0F, 47, 44, 38);
      Head.setRotationPoint(-24F, -28F, -48F);
      Head.setTextureSize(512, 512);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 200);
      Body.addBox(0F, 0F, 0F, 55, 52, 116);
      Body.setRotationPoint(-28F, -30F, -10F);
      Body.setTextureSize(512, 512);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      LowerBody1 = new ModelRenderer(this, 138, 92);
      LowerBody1.addBox(0F, 0F, 0F, 45, 44, 33);
      LowerBody1.setRotationPoint(-23F, -28F, 106F);
      LowerBody1.setTextureSize(512, 512);
      LowerBody1.mirror = true;
      setRotation(LowerBody1, 0F, 0F, 0F);
      LowerBody2 = new ModelRenderer(this, 161, 400);
      LowerBody2.addBox(0F, 0F, 0F, 39, 38, 33);
      LowerBody2.setRotationPoint(-20F, -26F, 139F);
      LowerBody2.setTextureSize(512, 512);
      LowerBody2.mirror = true;
      setRotation(LowerBody2, 0F, 0F, 0F);
      LowerBody3 = new ModelRenderer(this, 0, 400);
      LowerBody3.addBox(0F, 0F, 0F, 32, 30, 33);
      LowerBody3.setRotationPoint(-16F, -23F, 172F);
      LowerBody3.setTextureSize(512, 512);
      LowerBody3.mirror = true;
      setRotation(LowerBody3, 0F, 0F, 0F);
      LowerBody4 = new ModelRenderer(this, 0, 131);
      LowerBody4.addBox(0F, 0F, 0F, 20, 18, 33);
      LowerBody4.setRotationPoint(-10F, -20F, 205F);
      LowerBody4.setTextureSize(512, 512);
      LowerBody4.mirror = true;
      setRotation(LowerBody4, 0F, 0F, 0F);
      Tail1 = new ModelRenderer(this, 329, 390);
      Tail1.addBox(0F, 0F, 0F, 41, 6, 31);
      Tail1.setRotationPoint(-2F, -15F, 227F);
      Tail1.setTextureSize(512, 512);
      Tail1.mirror = true;
      setRotation(Tail1, 0F, 0.0743572F, 0F);
      Tail2 = new ModelRenderer(this, 329, 448);
      Tail2.addBox(-41F, 0F, 0F, 41, 6, 31);
      Tail2.setRotationPoint(0F, -15F, 227F);
      Tail2.setTextureSize(512, 512);
      Tail2.mirror = true;
      setRotation(Tail2, 0F, -0.0743572F, 0F);
      Fin1 = new ModelRenderer(this, 326, 33);
      Fin1.addBox(0F, 0F, 0F, 36, 9, 43);
      Fin1.setRotationPoint(25F, 2F, 23F);
      Fin1.setTextureSize(512, 512);
      Fin1.mirror = true;
      setRotation(Fin1, 0F, 0F, 0.3346075F);
      Fin2 = new ModelRenderer(this, 326, 103);
      Fin2.addBox(-37F, 0F, 0F, 36, 9, 43);
      Fin2.setRotationPoint(-27F, 2F, 23F);
      Fin2.setTextureSize(512, 512);
      Fin2.mirror = true;
      setRotation(Fin2, 0F, 0F, -0.3346075F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Head.render(f5);
    Body.render(f5);
    LowerBody1.render(f5);
    LowerBody2.render(f5);
    LowerBody3.render(f5);
    LowerBody4.render(f5);
    Tail1.render(f5);
    Tail2.render(f5);
    Fin1.render(f5);
    Fin2.render(f5);
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
