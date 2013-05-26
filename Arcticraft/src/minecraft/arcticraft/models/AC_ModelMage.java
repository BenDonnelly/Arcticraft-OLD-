package arcticraft.models; import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AC_ModelMage extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
  
  public AC_ModelMage()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 32, 2);
      Shape1.addBox(0F, 0F, 0F, 1, 6, 1);
      Shape1.setRotationPoint(1F, 3F, -3F);
      Shape1.setTextureSize(64, 64);
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 32, 2);
      Shape2.addBox(0F, 0F, 0F, 1, 6, 1);
      Shape2.setRotationPoint(-2F, 3F, -3F);
      Shape2.setTextureSize(64, 64);
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 44, 13);
      Shape3.addBox(0F, 0F, 0F, 1, 2, 1);
      Shape3.setRotationPoint(-3F, 1F, -3F);
      Shape3.setTextureSize(64, 64);
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 44, 13);
      Shape4.addBox(0F, 0F, 0F, 1, 2, 1);
      Shape4.setRotationPoint(2F, 1F, -3F);
      Shape4.setTextureSize(64, 64);
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 32, 9);
      Shape5.addBox(0F, 0F, 0F, 6, 7, 0);
      Shape5.setRotationPoint(-3F, -3F, -5F);
      Shape5.setTextureSize(64, 64);
      setRotation(Shape5, 0.0872665F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 48, 0);
      Shape6.addBox(0F, 0F, 0F, 4, 8, 4);
      Shape6.setRotationPoint(8F, 12F, -6F);
      Shape6.setTextureSize(64, 64);
      setRotation(Shape6, 0F, -0.1745329F, 1.396263F);
      Shape7 = new ModelRenderer(this, 48, 0);
      Shape7.addBox(0F, 0F, 0F, 4, 8, 4);
      Shape7.setRotationPoint(-8.7F, 16F, -6F);
      Shape7.setTextureSize(64, 64);
      setRotation(Shape7, 0F, 0.1745329F, -1.396263F);
      Shape8 = new ModelRenderer(this, 0, 28);
      Shape8.addBox(0F, 0F, 0F, 8, 10, 0);
      Shape8.setRotationPoint(-4F, 12F, 2F);
      Shape8.setTextureSize(64, 64);
      setRotation(Shape8, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 64);
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 64);
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 64);
      setRotation(rightarm, -0.3490659F, -0.3490659F, -0.1745329F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 64);
      setRotation(leftarm, -0.3490659F, 0.3490659F, 0.1745329F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 8, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 64);
      setRotation(rightleg, -0.1745329F, -0.3490659F, 1.22173F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 8, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 64);
      setRotation(leftleg, -0.1745329F, 0.3490659F, -1.22173F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par6Entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, par6Entity);
  }

}
