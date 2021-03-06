package com.arcticraft.model;


import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class AC_ModelCaptain extends ModelBiped
{
	ModelRenderer Face1;
	ModelRenderer Eye1;
	ModelRenderer Eye2;
	ModelRenderer Eyelid1;
	ModelRenderer Ipad1;
	ModelRenderer Ipad2;
	ModelRenderer Eyepad3;
	ModelRenderer Eyepad4;
	ModelRenderer Eyepad5;
	ModelRenderer Eyepad6;
	ModelRenderer Hat1;
	ModelRenderer Hat2;
	ModelRenderer Hat3;
	ModelRenderer Hat4;
	ModelRenderer Hat5;
	ModelRenderer Hair1;
	ModelRenderer Hair2;
	ModelRenderer Hair3;
	ModelRenderer Hair4;
	ModelRenderer Hair5;
	ModelRenderer Hair6;
	ModelRenderer Hair7;
	ModelRenderer Hair8;
	ModelRenderer Hair9;
	ModelRenderer Nose;
	ModelRenderer Hair10;
	ModelRenderer Hair11;
	ModelRenderer Hair12;
	ModelRenderer Hair13;
	ModelRenderer Hair14;
	ModelRenderer Hair15;
	ModelRenderer Hair16;
	ModelRenderer Hair17;
	ModelRenderer Hair18;
	ModelRenderer Hair19;
	ModelRenderer HairMaybe1;
	ModelRenderer HairMaybe2;
	ModelRenderer HairMaybe3;
	ModelRenderer HairMaybe4;
	ModelRenderer HairMaybe5;
	ModelRenderer ShoulderPad1;
	ModelRenderer ShoulderPad2;
	ModelRenderer Beads1;
	ModelRenderer Beads2;
	ModelRenderer Beads3;
	ModelRenderer Beads4;
	ModelRenderer B5;
	ModelRenderer B6;
	ModelRenderer Deco1;
	ModelRenderer Deco2;
	ModelRenderer Deco3;
	ModelRenderer Deco4;
	ModelRenderer Deco5;
	ModelRenderer Deco6;
	ModelRenderer Deco7;
	ModelRenderer Deco8;
	ModelRenderer B19;
	ModelRenderer B22;
	ModelRenderer Body1;
	ModelRenderer Belt1;
	ModelRenderer AC1;
	ModelRenderer AC2;
	ModelRenderer AC3;
	ModelRenderer AC4;
	ModelRenderer AC5;
	ModelRenderer AC6;
	ModelRenderer AC7;
	ModelRenderer Belt2;
	ModelRenderer Belt3;
	ModelRenderer Bu1;
	ModelRenderer Bu2;
	ModelRenderer Bu3;
	ModelRenderer Bu4;
	ModelRenderer Bu5;
	ModelRenderer Bu6;
	ModelRenderer Fleg1;
	ModelRenderer Fleg2;
	ModelRenderer Fleg3;
	ModelRenderer Fh1;
	ModelRenderer Fh2;
	ModelRenderer Deco9;
	ModelRenderer Deco10;
	ModelRenderer Deco11;
	ModelRenderer Deco12;
	ModelRenderer Deco13;
	ModelRenderer Deco14;
	ModelRenderer Deco15;
	ModelRenderer Deco16;
	ModelRenderer B25;
	ModelRenderer B28;
	ModelRenderer B31;
	ModelRenderer B34;
	ModelRenderer B37;
	ModelRenderer B40;
	ModelRenderer B43;
	ModelRenderer B46;
	ModelRenderer Face3;
	ModelRenderer Face4;

	public AC_ModelCaptain()
	{
		super(0F, 0F, 256, 256);

		Face1 = new ModelRenderer(this, 0, 38);
		Face1.addBox(3F, -5F, -4F, 1, 1, 8);
		//Face1.setRotationPoint(0F, -1F, 0F);
		Face1.setTextureSize(256, 256);
		Face1.mirror = true;
		setRotation(Face1, 0F, 0F, 0F);
		Eye1 = new ModelRenderer(this, 0, 64);
		Eye1.addBox(1F, -5F, -3.7F, 2, 1, 1);
		//Eye1.setRotationPoint(0F, -1F, 0F);
		Eye1.setTextureSize(256, 256);
		Eye1.mirror = true;
		setRotation(Eye1, 0F, 0F, 0F);
		Eye2 = new ModelRenderer(this, 0, 71);
		Eye2.addBox(1.5F, -5F, -3.8F, 1, 1, 1);
		//Eye2.setRotationPoint(0F, -1F, 0F);
		Eye2.setTextureSize(256, 256);
		Eye2.mirror = true;
		setRotation(Eye2, 0F, 0F, 0F);
		Eyelid1 = new ModelRenderer(this, 0, 79);
		Eyelid1.addBox(1F, -5.9F, -3.9F, 2, 1, 1);
		//Eyelid1.setRotationPoint(0F, -1F, 0F);
		Eyelid1.setTextureSize(256, 256);
		Eyelid1.mirror = true;
		setRotation(Eyelid1, 0F, 0F, 0F);
		Ipad1 = new ModelRenderer(this, 0, 87);
		Ipad1.addBox(-3F, -5.5F, -4.3F, 2, 1, 1);
		//Ipad1.setRotationPoint(0F, -1F, 0F);
		Ipad1.setTextureSize(256, 256);
		Ipad1.mirror = true;
		setRotation(Ipad1, 0F, 0F, 0F);
		Ipad2 = new ModelRenderer(this, 0, 93);
		Ipad2.addBox(-2.5F, -4.5F, -4.3F, 1, 1, 1);
		//Ipad2.setRotationPoint(0F, -1F, 0F);
		Ipad2.setTextureSize(256, 256);
		Ipad2.mirror = true;
		setRotation(Ipad2, 0F, 0F, 0F);
		Eyepad3 = new ModelRenderer(this, 0, 93);
		Eyepad3.addBox(-2.9F, -4.5F, -4.3F, 1, 1, 1);
		//Eyepad3.setRotationPoint(0F, -1F, 0F);
		Eyepad3.setTextureSize(256, 256);
		Eyepad3.mirror = true;
		setRotation(Eyepad3, 0F, 0F, 0F);
		Eyepad4 = new ModelRenderer(this, 0, 93);
		Eyepad4.addBox(-2.1F, -4.5F, -4.3F, 1, 1, 1);
		//Eyepad4.setRotationPoint(0F, -1F, 0F);
		Eyepad4.setTextureSize(256, 256);
		Eyepad4.mirror = true;
		setRotation(Eyepad4, 0F, 0F, 0F);
		Eyepad5 = new ModelRenderer(this, 0, 98);
		Eyepad5.addBox(0F, -5.6F, -4.3F, 6, 1, 1);
		//Eyepad5.setRotationPoint(0F, -1F, 0F);
		Eyepad5.setTextureSize(256, 256);
		Eyepad5.mirror = true;
		setRotation(Eyepad5, 0F, 0F, -0.5288657F);
		Eyepad6 = new ModelRenderer(this, 0, 103);
		Eyepad6.addBox(-4.4F, -4.9F, -4.3F, 3, 1, 1);
		//Eyepad6.setRotationPoint(0F, -1F, 0F);
		Eyepad6.setTextureSize(256, 256);
		Eyepad6.mirror = true;
		setRotation(Eyepad6, 0F, 0F, 0F);
		Hat1 = new ModelRenderer(this, 95, 0);
		Hat1.addBox(-5F, -9F, -5F, 10, 2, 10);
		//Hat1.setRotationPoint(0F, -1F, 0F);
		Hat1.setTextureSize(256, 256);
		Hat1.mirror = true;
		setRotation(Hat1, 0F, 0F, 0F);
		Hat2 = new ModelRenderer(this, 103, 16);
		Hat2.addBox(-5F, -14F, -5F, 10, 5, 0);
		//Hat2.setRotationPoint(0F, -1F, 0F);
		Hat2.setTextureSize(256, 256);
		Hat2.mirror = true;
		setRotation(Hat2, 0F, 0F, 0F);
		Hat3 = new ModelRenderer(this, 141, 0);
		Hat3.addBox(-5F, -13F, -5F, 0, 4, 10);
		//Hat3.setRotationPoint(0F, -1F, 0F);
		Hat3.setTextureSize(256, 256);
		Hat3.mirror = true;
		setRotation(Hat3, 0F, 0F, 0F);
		Hat4 = new ModelRenderer(this, 141, 17);
		Hat4.addBox(5F, -12.26667F, -5F, 0, 4, 10);
		//Hat4.setRotationPoint(0F, -1F, 0F);
		Hat4.setTextureSize(256, 256);
		Hat4.mirror = true;
		setRotation(Hat4, 0F, 0F, 0F);
		Hat5 = new ModelRenderer(this, 105, 25);
		Hat5.addBox(-5F, -12F, 5F, 10, 3, 0);
		//Hat5.setRotationPoint(0F, -1F, 0F);
		Hat5.setTextureSize(256, 256);
		Hat5.mirror = true;
		setRotation(Hat5, 0F, 0F, 0F);
		Hair1 = new ModelRenderer(this, 113, 52);
		Hair1.addBox(3.5F, -7F, 3.5F, 1, 9, 1);
		//Hair1.setRotationPoint(0F, -1F, 0F);
		Hair1.setTextureSize(256, 256);
		Hair1.mirror = true;
		setRotation(Hair1, 0F, 0F, 0F);
		Hair2 = new ModelRenderer(this, 113, 52);
		Hair2.addBox(2.5F, -7F, 3.5F, 1, 11, 1);
		//Hair2.setRotationPoint(0F, -1F, 0F);
		Hair2.setTextureSize(256, 256);
		Hair2.mirror = true;
		setRotation(Hair2, 0F, 0F, 0F);
		Hair3 = new ModelRenderer(this, 113, 52);
		Hair3.addBox(1.5F, -7F, 3.5F, 1, 10, 1);
		//Hair3.setRotationPoint(0F, -1F, 0F);
		Hair3.setTextureSize(256, 256);
		Hair3.mirror = true;
		setRotation(Hair3, 0F, 0F, 0F);
		Hair4 = new ModelRenderer(this, 113, 52);
		Hair4.addBox(0.5F, -7F, 3.5F, 1, 12, 1);
		//Hair4.setRotationPoint(0F, -1F, 0F);
		Hair4.setTextureSize(256, 256);
		Hair4.mirror = true;
		setRotation(Hair4, 0F, 0F, 0F);
		Hair5 = new ModelRenderer(this, 113, 52);
		Hair5.addBox(-0.5F, -7F, 3.5F, 1, 10, 1);
		//Hair5.setRotationPoint(0F, -1F, 0F);
		Hair5.setTextureSize(256, 256);
		Hair5.mirror = true;
		setRotation(Hair5, 0F, 0F, 0F);
		Hair6 = new ModelRenderer(this, 113, 52);
		Hair6.addBox(-1.5F, -7F, 3.5F, 1, 12, 1);
		//Hair6.setRotationPoint(0F, -1F, 0F);
		Hair6.setTextureSize(256, 256);
		Hair6.mirror = true;
		setRotation(Hair6, 0F, 0F, 0F);
		Hair7 = new ModelRenderer(this, 113, 52);
		Hair7.addBox(-2.5F, -7F, 3.5F, 1, 11, 1);
		//Hair7.setRotationPoint(0F, -1F, 0F);
		Hair7.setTextureSize(256, 256);
		Hair7.mirror = true;
		setRotation(Hair7, 0F, 0F, 0F);
		Hair8 = new ModelRenderer(this, 113, 52);
		Hair8.addBox(-3.5F, -7F, 3.5F, 1, 10, 1);
		//Hair8.setRotationPoint(0F, -1F, 0F);
		Hair8.setTextureSize(256, 256);
		Hair8.mirror = true;
		setRotation(Hair8, 0F, 0F, 0F);
		Hair9 = new ModelRenderer(this, 113, 52);
		Hair9.addBox(-4.5F, -7F, 3.5F, 1, 9, 1);
		//Hair9.setRotationPoint(0F, -1F, 0F);
		Hair9.setTextureSize(256, 256);
		Hair9.mirror = true;
		setRotation(Hair9, 0F, 0F, 0F);
		Nose = new ModelRenderer(this, 14, 63);
		Nose.addBox(-1F, -2.5F, -5.1F, 2, 2, 2);
		//Nose.setRotationPoint(0F, -1F, 0F);
		Nose.setTextureSize(256, 256);
		Nose.mirror = true;
		setRotation(Nose, -0.2974289F, 0F, 0F);
		Hair10 = new ModelRenderer(this, 113, 70);
		Hair10.addBox(-4.5F, -7F, 2.5F, 9, 9, 1);
		//Hair10.setRotationPoint(0F, -1F, 0F);
		Hair10.setTextureSize(256, 256);
		Hair10.mirror = true;
		setRotation(Hair10, 0F, 0F, 0F);
		Hair11 = new ModelRenderer(this, 113, 70);
		Hair11.addBox(-4.5F, -7F, 1.5F, 9, 7, 1);
		//Hair11.setRotationPoint(0F, -1F, 0F);
		Hair11.setTextureSize(256, 256);
		Hair11.mirror = true;
		setRotation(Hair11, 0F, 0F, 0F);
		Hair12 = new ModelRenderer(this, 113, 70);
		Hair12.addBox(-4.5F, -7F, 0.5F, 9, 5, 1);
		//Hair12.setRotationPoint(0F, -1F, 0F);
		Hair12.setTextureSize(256, 256);
		Hair12.mirror = true;
		setRotation(Hair12, 0F, 0F, 0F);
		Hair13 = new ModelRenderer(this, 113, 70);
		Hair13.addBox(-4.5F, -7F, -0.5F, 9, 8, 1);
		//Hair13.setRotationPoint(0F, -1F, 0F);
		Hair13.setTextureSize(256, 256);
		Hair13.mirror = true;
		setRotation(Hair13, 0F, 0F, 0F);
		Hair14 = new ModelRenderer(this, 113, 70);
		Hair14.addBox(-4.5F, -7F, -1.5F, 9, 6, 1);
		//Hair14.setRotationPoint(0F, -1F, 0F);
		Hair14.setTextureSize(256, 256);
		Hair14.mirror = true;
		setRotation(Hair14, 0F, 0F, 0F);
		Hair15 = new ModelRenderer(this, 113, 70);
		Hair15.addBox(-4.5F, -8F, -2.5F, 9, 8, 1);
		//Hair15.setRotationPoint(0F, -1F, 0F);
		Hair15.setTextureSize(256, 256);
		Hair15.mirror = true;
		setRotation(Hair15, 0F, 0F, 0F);
		Hair16 = new ModelRenderer(this, 113, 52);
		Hair16.addBox(-4.5F, -7F, -3.5F, 1, 10, 1);
		//Hair16.setRotationPoint(0F, -1F, 0F);
		Hair16.setTextureSize(256, 256);
		Hair16.mirror = true;
		setRotation(Hair16, 0F, 0F, 0F);
		Hair17 = new ModelRenderer(this, 113, 70);
		Hair17.addBox(-4.5F, -7F, -3.9F, 1, 9, 1);
		//Hair17.setRotationPoint(0F, -1F, 0F);
		Hair17.setTextureSize(256, 256);
		Hair17.mirror = true;
		setRotation(Hair17, 0F, 0F, 0F);
		Hair18 = new ModelRenderer(this, 113, 52);
		Hair18.addBox(3.5F, -7F, -3.5F, 1, 9, 1);
		//Hair18.setRotationPoint(0F, -1F, 0F);
		Hair18.setTextureSize(256, 256);
		Hair18.mirror = true;
		setRotation(Hair18, 0F, 0F, 0F);
		Hair19 = new ModelRenderer(this, 113, 52);
		Hair19.addBox(3.5F, -7F, -3.9F, 1, 10, 1);
		//Hair19.setRotationPoint(0F, -1F, 0F);
		Hair19.setTextureSize(256, 256);
		Hair19.mirror = true;
		setRotation(Hair19, 0F, 0F, 0F);
		HairMaybe1 = new ModelRenderer(this, 110, 83);
		HairMaybe1.addBox(-4.5F, -1.5F, -4.3F, 9, 1, 1);
		//HairMaybe1.setRotationPoint(0F, -1F, 0F);
		HairMaybe1.setTextureSize(256, 256);
		HairMaybe1.mirror = true;
		setRotation(HairMaybe1, 0F, 0F, 0F);
		HairMaybe2 = new ModelRenderer(this, 110, 83);
		HairMaybe2.addBox(-4.5F, -0.5F, -4.3F, 3, 1, 1);
		//HairMaybe2.setRotationPoint(0F, -1F, 0F);
		HairMaybe2.setTextureSize(256, 256);
		HairMaybe2.mirror = true;
		setRotation(HairMaybe2, 0F, 0F, 0F);
		HairMaybe3 = new ModelRenderer(this, 110, 83);
		HairMaybe3.addBox(1.5F, -0.5F, -4.3F, 3, 1, 1);
		//HairMaybe3.setRotationPoint(0F, -1F, 0F);
		HairMaybe3.setTextureSize(256, 256);
		HairMaybe3.mirror = true;
		setRotation(HairMaybe3, 0F, 0F, 0F);
		HairMaybe4 = new ModelRenderer(this, 110, 83);
		HairMaybe4.addBox(-3.5F, 0.5F, -4.3F, 7, 1, 1);
		//HairMaybe4.setRotationPoint(0F, -1F, 0F);
		HairMaybe4.setTextureSize(256, 256);
		HairMaybe4.mirror = true;
		setRotation(HairMaybe4, 0F, 0F, 0F);
		HairMaybe5 = new ModelRenderer(this, 110, 83);
		HairMaybe5.addBox(-2.5F, 1.5F, -4.3F, 5, 1, 1);
		//HairMaybe5.setRotationPoint(0F, -1F, 0F);
		HairMaybe5.setTextureSize(256, 256);
		HairMaybe5.mirror = true;
		setRotation(HairMaybe5, 0F, 0F, 0F);
		ShoulderPad1 = new ModelRenderer(this, 51, 47);
		ShoulderPad1.addBox(-6F, -1F, -2.5F, 6, 2, 5);
		//ShoulderPad1.setRotationPoint(-4F, -1F, 0F);
		ShoulderPad1.setTextureSize(256, 256);
		ShoulderPad1.mirror = true;
		setRotation(ShoulderPad1, 0F, 0F, 0F);
		ShoulderPad2 = new ModelRenderer(this, 51, 47);
		ShoulderPad2.addBox(0F, -1F, -2.5F, 6, 2, 5);
		//ShoulderPad2.setRotationPoint(4F, -1F, 0F);
		ShoulderPad2.setTextureSize(256, 256);
		ShoulderPad2.mirror = true;
		setRotation(ShoulderPad2, 0F, 0F, 0F);
		Beads1 = new ModelRenderer(this, 0, 111);
		Beads1.addBox(-6F, 1F, -2.3F, 1, 3, 1);
		//Beads1.setRotationPoint(-4F, -1F, 0F);
		Beads1.setTextureSize(256, 256);
		Beads1.mirror = true;
		setRotation(Beads1, 0F, 0F, 0F);
		Beads2 = new ModelRenderer(this, 0, 111);
		Beads2.addBox(-4.5F, 1F, -2.3F, 1, 3, 1);
		//Beads2.setRotationPoint(-4F, -1F, 0F);
		Beads2.setTextureSize(256, 256);
		Beads2.mirror = true;
		setRotation(Beads2, 0F, 0F, 0F);
		Beads3 = new ModelRenderer(this, 0, 111);
		Beads3.addBox(-3F, 1F, -2.3F, 1, 3, 1);
		//Beads3.setRotationPoint(-4F, -1F, 0F);
		Beads3.setTextureSize(256, 256);
		Beads3.mirror = true;
		setRotation(Beads3, 0F, 0F, 0F);
		Beads4 = new ModelRenderer(this, 0, 111);
		Beads4.addBox(-1.5F, 1F, -2.3F, 1, 3, 1);
		//Beads4.setRotationPoint(-4F, -1F, 0F);
		Beads4.setTextureSize(256, 256);
		Beads4.mirror = true;
		setRotation(Beads4, 0F, 0F, 0F);
		B5 = new ModelRenderer(this, 0, 111);
		B5.addBox(-6F, 1F, -0.7F, 1, 3, 1);
		//B5.setRotationPoint(-4F, -1F, 0F);
		B5.setTextureSize(256, 256);
		B5.mirror = true;
		setRotation(B5, 0F, 0F, 0F);
		B6 = new ModelRenderer(this, 0, 111);
		B6.addBox(-6F, 1F, 1F, 1, 3, 1);
		//B6.setRotationPoint(-4F, -1F, 0F);
		B6.setTextureSize(256, 256);
		B6.mirror = true;
		setRotation(B6, 0F, 0F, 0F);
		Deco1 = new ModelRenderer(this, 0, 118);
		Deco1.addBox(-4.3F, -1.2F, 0F, 2, 2, 2);
		//Deco1.setRotationPoint(-4F, -1F, 0F);
		Deco1.setTextureSize(256, 256);
		Deco1.mirror = true;
		setRotation(Deco1, 0F, 0.7063936F, 0F);
		Deco2 = new ModelRenderer(this, 0, 118);
		Deco2.addBox(-5F, -1.1F, -1.3F, 2, 2, 2);
		//Deco2.setRotationPoint(-4F, -1F, 0F);
		Deco2.setTextureSize(256, 256);
		Deco2.mirror = true;
		setRotation(Deco2, 0F, 0.7063936F, 0F);
		Deco3 = new ModelRenderer(this, 0, 118);
		Deco3.addBox(-3.9F, -1.2F, -2.066667F, 2, 2, 2);
		//Deco3.setRotationPoint(-4F, -1F, 0F);
		Deco3.setTextureSize(256, 256);
		Deco3.mirror = true;
		setRotation(Deco3, 0F, -0.7063936F, 0F);
		Deco4 = new ModelRenderer(this, 0, 118);
		Deco4.addBox(-2F, -1.1F, -5F, 2, 2, 2);
		//Deco4.setRotationPoint(-4F, -1F, 0F);
		Deco4.setTextureSize(256, 256);
		Deco4.mirror = true;
		setRotation(Deco4, 0F, 0.7063936F, 0F);
		Deco5 = new ModelRenderer(this, 0, 128);
		Deco5.addBox(-5F, -1.6F, 3F, 2, 1, 2);
		//Deco5.setRotationPoint(-4F, -1F, 0F);
		Deco5.setTextureSize(256, 256);
		Deco5.mirror = true;
		setRotation(Deco5, 0F, -0.7807508F, 0F);
		Deco6 = new ModelRenderer(this, 0, 135);
		Deco6.addBox(-5F, -1.5F, -0.5F, 4, 1, 1);
		//Deco6.setRotationPoint(-4F, -1F, 0F);
		Deco6.setTextureSize(256, 256);
		Deco6.mirror = true;
		setRotation(Deco6, 0F, 0F, 0F);
		Deco7 = new ModelRenderer(this, 0, 142);
		Deco7.addBox(-3F, -1.5F, -0.5F, 1, 1, 3);
		//Deco7.setRotationPoint(-4F, -1F, 0F);
		Deco7.setTextureSize(256, 256);
		Deco7.mirror = true;
		setRotation(Deco7, 0F, -0.3717861F, 0F);
		Deco8 = new ModelRenderer(this, 0, 142);
		Deco8.addBox(-3F, -1.5F, -2.5F, 1, 1, 3);
		//Deco8.setRotationPoint(-4F, -1F, 0F);
		Deco8.setTextureSize(256, 256);
		Deco8.mirror = true;
		setRotation(Deco8, 0F, 0.3717861F, 0F);
		B19 = new ModelRenderer(this, 0, 111);
		B19.addBox(-4.6F, 1F, 1.4F, 1, 3, 1);
		//B19.setRotationPoint(-4F, -1F, 0F);
		B19.setTextureSize(256, 256);
		B19.mirror = true;
		setRotation(B19, 0F, 0F, 0F);
		B22 = new ModelRenderer(this, 0, 111);
		B22.addBox(-3F, 1F, 1.4F, 1, 3, 1);
		//B22.setRotationPoint(-4F, -1F, 0F);
		B22.setTextureSize(256, 256);
		B22.mirror = true;
		setRotation(B22, 0F, 0F, 0F);
		Body1 = new ModelRenderer(this, 53, 58);
		Body1.addBox(1F, 2F, -2.4F, 6, 10, 1);
		//Body1.setRotationPoint(-4F, 0F, 0F);
		Body1.setTextureSize(256, 256);
		Body1.mirror = true;
		setRotation(Body1, 0F, 0F, 0F);
		Belt1 = new ModelRenderer(this, 46, 74);
		Belt1.addBox(-0.5F, 10F, -3F, 9, 2, 6);
		//Belt1.setRotationPoint(-4F, 0F, 0F);
		Belt1.setTextureSize(256, 256);
		Belt1.mirror = true;
		setRotation(Belt1, 0F, 0F, 0F);
		AC1 = new ModelRenderer(this, 47, 3);
		AC1.addBox(1.2F, 9.9F, -3.5F, 1, 2, 1);
		//AC1.setRotationPoint(-4F, 0F, 0F);
		AC1.setTextureSize(256, 256);
		AC1.mirror = true;
		setRotation(AC1, 0F, 0F, 0F);
		AC2 = new ModelRenderer(this, 47, 3);
		AC2.addBox(2.7F, 9.9F, -3.5F, 1, 2, 1);
		//AC2.setRotationPoint(-4F, 0F, 0F);
		AC2.setTextureSize(256, 256);
		AC2.mirror = true;
		setRotation(AC2, 0F, 0F, 0F);
		AC3 = new ModelRenderer(this, 47, 3);
		AC3.addBox(1.5F, 9.5F, -3.5F, 2, 1, 1);
		//AC3.setRotationPoint(-4F, 0F, 0F);
		AC3.setTextureSize(256, 256);
		AC3.mirror = true;
		setRotation(AC3, 0F, 0F, 0F);
		AC4 = new ModelRenderer(this, 47, 3);
		AC4.addBox(2F, 10.8F, -3.5F, 1, 1, 1);
		//AC4.setRotationPoint(-4F, 0F, 0F);
		AC4.setTextureSize(256, 256);
		AC4.mirror = true;
		setRotation(AC4, 0F, 0F, 0F);
		AC5 = new ModelRenderer(this, 47, 3);
		AC5.addBox(4F, 9.9F, -3.5F, 1, 2, 1);
		//AC5.setRotationPoint(-4F, 0F, 0F);
		AC5.setTextureSize(256, 256);
		AC5.mirror = true;
		setRotation(AC5, 0F, 0F, 0F);
		AC6 = new ModelRenderer(this, 47, 3);
		AC6.addBox(4.6F, 9.6F, -3.5F, 2, 1, 1);
		//AC6.setRotationPoint(-4F, 0F, 0F);
		AC6.setTextureSize(256, 256);
		AC6.mirror = true;
		setRotation(AC6, 0F, 0F, 0F);
		AC7 = new ModelRenderer(this, 47, 3);
		AC7.addBox(4.6F, 11.2F, -3.5F, 2, 1, 1);
		//AC7.setRotationPoint(-4F, 0F, 0F);
		AC7.setTextureSize(256, 256);
		AC7.mirror = true;
		setRotation(AC7, 0F, 0F, 0F);
		Belt2 = new ModelRenderer(this, 59, 0);
		Belt2.addBox(6.9F, 9.5F, -3.2F, 1, 3, 2);
		//Belt2.setRotationPoint(-4F, 0F, 0F);
		Belt2.setTextureSize(256, 256);
		Belt2.mirror = true;
		setRotation(Belt2, 0F, 0F, 0F);
		Belt3 = new ModelRenderer(this, 59, 0);
		Belt3.addBox(0.1F, 9.5F, -3.2F, 1, 3, 2);
		//Belt3.setRotationPoint(-4F, 0F, 0F);
		Belt3.setTextureSize(256, 256);
		Belt3.mirror = true;
		setRotation(Belt3, 0F, 0F, 0F);
		Bu1 = new ModelRenderer(this, 8, 111);
		Bu1.addBox(1.2F, 3F, -2.7F, 1, 1, 1);
		//Bu1.setRotationPoint(-4F, 0F, 0F);
		Bu1.setTextureSize(256, 256);
		Bu1.mirror = true;
		setRotation(Bu1, 0F, 0F, 0F);
		Bu2 = new ModelRenderer(this, 8, 111);
		Bu2.addBox(1.2F, 5F, -2.7F, 1, 1, 1);
		//Bu2.setRotationPoint(-4F, 0F, 0F);
		Bu2.setTextureSize(256, 256);
		Bu2.mirror = true;
		setRotation(Bu2, 0F, 0F, 0F);
		Bu3 = new ModelRenderer(this, 8, 111);
		Bu3.addBox(1.2F, 7F, -2.7F, 1, 1, 1);
		//Bu3.setRotationPoint(-4F, 0F, 0F);
		Bu3.setTextureSize(256, 256);
		Bu3.mirror = true;
		setRotation(Bu3, 0F, 0F, 0F);
		Bu4 = new ModelRenderer(this, 8, 111);
		Bu4.addBox(5.8F, 3F, -2.7F, 1, 1, 1);
		//Bu4.setRotationPoint(-4F, 0F, 0F);
		Bu4.setTextureSize(256, 256);
		Bu4.mirror = true;
		setRotation(Bu4, 0F, 0F, 0F);
		Bu5 = new ModelRenderer(this, 8, 111);
		Bu5.addBox(5.8F, 5F, -2.7F, 1, 1, 1);
		//Bu5.setRotationPoint(-4F, 0F, 0F);
		Bu5.setTextureSize(256, 256);
		Bu5.mirror = true;
		setRotation(Bu5, 0F, 0F, 0F);
		Bu6 = new ModelRenderer(this, 8, 111);
		Bu6.addBox(5.8F, 7F, -2.7F, 1, 1, 1);
		//Bu6.setRotationPoint(-4F, 0F, 0F);
		Bu6.setTextureSize(256, 256);
		Bu6.mirror = true;
		setRotation(Bu6, 0F, 0F, 0F);
		Fleg1 = new ModelRenderer(this, 47, 86);
		Fleg1.addBox(-2.5F, 4F, -2.5F, 5, 2, 5);
		//Fleg1.setRotationPoint(2F, 12F, 0F);
		Fleg1.setTextureSize(256, 256);
		Fleg1.mirror = true;
		setRotation(Fleg1, 0F, 0F, 0F);
		Fleg2 = new ModelRenderer(this, 47, 97);
		Fleg2.addBox(-1.5F, 6F, -1.5F, 3, 1, 3);
		//Fleg2.setRotationPoint(2F, 12F, 0F);
		Fleg2.setTextureSize(256, 256);
		Fleg2.mirror = true;
		setRotation(Fleg2, 0F, 0F, 0F);
		Fleg3 = new ModelRenderer(this, 47, 103);
		Fleg3.addBox(-0.5F, 7F, -0.5F, 1, 5, 1);
		//Fleg3.setRotationPoint(2F, 12F, 0F);
		Fleg3.setTextureSize(256, 256);
		Fleg3.mirror = true;
		setRotation(Fleg3, 0F, 0F, 0F);
		Fh1 = new ModelRenderer(this, 47, 113);
		Fh1.addBox(-4.5F, 6F, -2.5F, 5, 4, 5);
		//Fh1.setRotationPoint(-4F, -1F, 0F);
		Fh1.setTextureSize(256, 256);
		Fh1.mirror = true;
		setRotation(Fh1, 0F, 0F, 0F);
		Fh2 = new ModelRenderer(this, 47, 113);
		Fh2.addBox(-0.5F, 6F, -2.5F, 5, 4, 5);
		//Fh2.setRotationPoint(4F, -1F, 0F);
		Fh2.setTextureSize(256, 256);
		Fh2.mirror = true;
		setRotation(Fh2, 0F, 0F, 0F);
		Deco9 = new ModelRenderer(this, 0, 135);
		Deco9.addBox(1F, -1.5F, -0.5F, 4, 1, 1);
		//Deco9.setRotationPoint(4F, -1F, 0F);
		Deco9.setTextureSize(256, 256);
		Deco9.mirror = true;
		setRotation(Deco9, 0F, 0F, 0F);
		Deco10 = new ModelRenderer(this, 0, 142);
		Deco10.addBox(2F, -1.5F, -2.5F, 1, 1, 3);
		//Deco10.setRotationPoint(4F, -1F, 0F);
		Deco10.setTextureSize(256, 256);
		Deco10.mirror = true;
		setRotation(Deco10, 0F, -0.3717861F, 0F);
		Deco11 = new ModelRenderer(this, 0, 142);
		Deco11.addBox(2F, -1.5F, -0.5F, 1, 1, 3);
		//Deco11.setRotationPoint(4F, -1F, 0F);
		Deco11.setTextureSize(256, 256);
		Deco11.mirror = true;
		setRotation(Deco11, 0F, 0.3717861F, 0F);
		Deco12 = new ModelRenderer(this, 0, 128);
		Deco12.addBox(3F, -1.6F, -5.1F, 2, 1, 2);
		//Deco12.setRotationPoint(4F, -1F, 0F);
		Deco12.setTextureSize(256, 256);
		Deco12.mirror = true;
		setRotation(Deco12, 0F, -0.7807508F, 0F);
		Deco13 = new ModelRenderer(this, 0, 118);
		Deco13.addBox(-0.9F, -1.2F, -4.266667F, 2, 2, 2);
		//Deco13.setRotationPoint(4F, -1F, 0F);
		Deco13.setTextureSize(256, 256);
		Deco13.mirror = true;
		setRotation(Deco13, 0F, -0.7063936F, 0F);
		Deco14 = new ModelRenderer(this, 0, 118);
		Deco14.addBox(3.7F, -1.1F, 0F, 2, 2, 2);
		//Deco14.setRotationPoint(4F, -1F, 0F);
		Deco14.setTextureSize(256, 256);
		Deco14.mirror = true;
		setRotation(Deco14, 0F, 0.7063936F, 0F);
		Deco15 = new ModelRenderer(this, 0, 118);
		Deco15.addBox(-1.2F, -1.2F, 1.8F, 2, 2, 2);
		//Deco15.setRotationPoint(4F, -1F, 0F);
		Deco15.setTextureSize(256, 256);
		Deco15.mirror = true;
		setRotation(Deco15, 0F, 0.7063936F, 0F);
		Deco16 = new ModelRenderer(this, 0, 118);
		Deco16.addBox(0.7F, -1.1F, 3F, 2, 2, 2);
		//Deco16.setRotationPoint(4F, -1F, 0F);
		Deco16.setTextureSize(256, 256);
		Deco16.mirror = true;
		setRotation(Deco16, 0F, 0.7063936F, 0F);
		B25 = new ModelRenderer(this, 0, 111);
		B25.addBox(0.5F, 1F, -2.3F, 1, 3, 1);
		//B25.setRotationPoint(4F, -1F, 0F);
		B25.setTextureSize(256, 256);
		B25.mirror = true;
		setRotation(B25, 0F, 0F, 0F);
		B28 = new ModelRenderer(this, 0, 111);
		B28.addBox(2F, 1F, -2.3F, 1, 3, 1);
		//B28.setRotationPoint(4F, -1F, 0F);
		B28.setTextureSize(256, 256);
		B28.mirror = true;
		setRotation(B28, 0F, 0F, 0F);
		B31 = new ModelRenderer(this, 0, 111);
		B31.addBox(3.5F, 1F, -2.3F, 1, 3, 1);
		//B31.setRotationPoint(4F, -1F, 0F);
		B31.setTextureSize(256, 256);
		B31.mirror = true;
		setRotation(B31, 0F, 0F, 0F);
		B34 = new ModelRenderer(this, 0, 111);
		B34.addBox(5F, 1F, -2.3F, 1, 3, 1);
		//B34.setRotationPoint(4F, -1F, 0F);
		B34.setTextureSize(256, 256);
		B34.mirror = true;
		setRotation(B34, 0F, 0F, 0F);
		B37 = new ModelRenderer(this, 0, 111);
		B37.addBox(5F, 1F, -0.7F, 1, 3, 1);
		//B37.setRotationPoint(4F, -1F, 0F);
		B37.setTextureSize(256, 256);
		B37.mirror = true;
		setRotation(B37, 0F, 0F, 0F);
		B40 = new ModelRenderer(this, 0, 111);
		B40.addBox(5F, 1F, 1F, 1, 3, 1);
		//B40.setRotationPoint(4F, -1F, 0F);
		B40.setTextureSize(256, 256);
		B40.mirror = true;
		setRotation(B40, 0F, 0F, 0F);
		B43 = new ModelRenderer(this, 0, 111);
		B43.addBox(3.4F, 1F, 1.4F, 1, 3, 1);
		//B43.setRotationPoint(4F, -1F, 0F);
		B43.setTextureSize(256, 256);
		B43.mirror = true;
		setRotation(B43, 0F, 0F, 0F);
		B46 = new ModelRenderer(this, 0, 111);
		B46.addBox(2F, 1F, 1.4F, 1, 3, 1);
		//B46.setRotationPoint(4F, -1F, 0F);
		B46.setTextureSize(256, 256);
		B46.mirror = true;
		setRotation(B46, 0F, 0F, 0F);
		Face3 = new ModelRenderer(this, 0, 151);
		Face3.addBox(-4F, -5F, -4F, 5, 1, 8);
		//Face3.setRotationPoint(0F, -1F, 0F);
		Face3.setTextureSize(256, 256);
		Face3.mirror = true;
		setRotation(Face3, 0F, 0F, 0F);
		Face4 = new ModelRenderer(this, 0, 165);
		Face4.addBox(-4F, -7F, -4F, 8, 2, 8);
		//Face4.setRotationPoint(0F, -1F, 0F);
		Face4.setTextureSize(256, 256);
		Face4.mirror = true;
		setRotation(Face4, 0F, 0F, 0F);
		
		bipedHead = new ModelRenderer(this, 44, 128);
		bipedHead.addBox(-4F, -4F, -4F, 8, 5, 8);
		bipedHead.setRotationPoint(0F, -1F, 0F);
		bipedHead.addChild(Face1);
		bipedHead.addChild(Face3);
		bipedHead.addChild(Face4);
		bipedHead.addChild(Eye1);
		bipedHead.addChild(Eye2);
		bipedHead.addChild(Eyelid1);
		bipedHead.addChild(Ipad1);
		bipedHead.addChild(Ipad2);
		bipedHead.addChild(Eyepad3);
		bipedHead.addChild(Eyepad4);
		bipedHead.addChild(Eyepad5);
		bipedHead.addChild(Eyepad6);
		bipedHead.addChild(Hat1);
		bipedHead.addChild(Hat2);
		bipedHead.addChild(Hat3);
		bipedHead.addChild(Hat4);
		bipedHead.addChild(Hat5);
		bipedHead.addChild(Hair1);
		bipedHead.addChild(Hair2);
		bipedHead.addChild(Hair3);
		bipedHead.addChild(Hair4);
		bipedHead.addChild(Hair5);
		bipedHead.addChild(Hair6);
		bipedHead.addChild(Hair7);
		bipedHead.addChild(Hair8);
		bipedHead.addChild(Hair9);
		bipedHead.addChild(Hair10);
		bipedHead.addChild(Hair11);
		bipedHead.addChild(Hair12);
		bipedHead.addChild(Hair13);
		bipedHead.addChild(Hair14);
		bipedHead.addChild(Hair15);
		bipedHead.addChild(Hair16);
		bipedHead.addChild(Hair17);
		bipedHead.addChild(Hair18);
		bipedHead.addChild(Hair19);
		bipedHead.addChild(Nose);
		bipedHead.addChild(HairMaybe1);
		bipedHead.addChild(HairMaybe2);
		bipedHead.addChild(HairMaybe3);
		bipedHead.addChild(HairMaybe4);
		bipedHead.addChild(HairMaybe5);
		
		bipedBody = new ModelRenderer(this, 66, 16);
		bipedBody.addBox(0F, 0F, -2F, 8, 12, 4);
		bipedBody.setRotationPoint(-4F, 0F, 0F);
		bipedBody.addChild(Body1);
		bipedBody.addChild(Bu1);
		bipedBody.addChild(Bu2);
		bipedBody.addChild(Bu3);
		bipedBody.addChild(Bu4);
		bipedBody.addChild(Bu5);
		bipedBody.addChild(Bu6);
		bipedBody.addChild(Belt1);
		bipedBody.addChild(Belt2);
		bipedBody.addChild(Belt3);
		bipedBody.addChild(AC1);
		bipedBody.addChild(AC2);
		bipedBody.addChild(AC3);
		bipedBody.addChild(AC4);
		bipedBody.addChild(AC5);
		bipedBody.addChild(AC6);
		bipedBody.addChild(AC7);
		
		bipedLeftArm = new ModelRenderer(this, 32, 38);
		bipedLeftArm.addBox(0F, 1F, -2F, 4, 8, 4);
		bipedLeftArm.setRotationPoint(4F, -1F, 0F);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addChild(Fh2);
		bipedLeftArm.addChild(ShoulderPad2);
		bipedLeftArm.addChild(Deco9);
		bipedLeftArm.addChild(Deco10);
		bipedLeftArm.addChild(Deco11);
		bipedLeftArm.addChild(Deco12);
		bipedLeftArm.addChild(Deco13);
		bipedLeftArm.addChild(Deco14);
		bipedLeftArm.addChild(Deco15);
		bipedLeftArm.addChild(Deco16);
		bipedLeftArm.addChild(B25);
		bipedLeftArm.addChild(B28);
		bipedLeftArm.addChild(B31);
		bipedLeftArm.addChild(B34);
		bipedLeftArm.addChild(B37);
		bipedLeftArm.addChild(B40);
		bipedLeftArm.addChild(B43);
		bipedLeftArm.addChild(B46);
		
		bipedRightArm = new ModelRenderer(this, 40, 16);
		bipedRightArm.addBox(-4F, 1F, -2F, 4, 12, 4);
		bipedRightArm.setRotationPoint(-4F, -1F, 0F);
		bipedRightArm.addChild(Fh1);
		bipedRightArm.addChild(ShoulderPad1);
		bipedRightArm.addChild(Deco1);
		bipedRightArm.addChild(Deco2);
		bipedRightArm.addChild(Deco3);
		bipedRightArm.addChild(Deco4);
		bipedRightArm.addChild(Deco5);
		bipedRightArm.addChild(Deco6);
		bipedRightArm.addChild(Deco7);
		bipedRightArm.addChild(Deco8);
		bipedRightArm.addChild(Beads1);
		bipedRightArm.addChild(Beads2);
		bipedRightArm.addChild(Beads3);
		bipedRightArm.addChild(Beads4);
		bipedRightArm.addChild(B5);
		bipedRightArm.addChild(B6);
		bipedRightArm.addChild(B19);
		bipedRightArm.addChild(B22);
		
		bipedRightLeg = new ModelRenderer(this, 21, 16);
		bipedRightLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
		bipedRightLeg.setRotationPoint(-2F, 12F, 0F);
		
		bipedLeftLeg = new ModelRenderer(this, 0, 16);
		bipedLeftLeg.addBox(-2F, 0F, -2F, 4, 4, 4);
		bipedLeftLeg.setRotationPoint(2F, 12F, 0F);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addChild(Fleg1);
		bipedLeftLeg.addChild(Fleg2);
		bipedLeftLeg.addChild(Fleg3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.bipedLeftArm.rotationPointX -= 1F;
		this.bipedRightArm.rotationPointX += 1F;
		
		//AC_EntityCaptain captain = (AC_EntityCaptain) entity;
		//if (captain.isAboutToThrowHook() || captain.isHookAirBorne()) {
			this.bipedLeftArm.rotateAngleX = this.updateRotation(this.bipedLeftArm.rotateAngleX, this.bipedHead.rotateAngleX - 90.0F, 2.0F);
			this.bipedLeftArm.rotateAngleY = this.bipedHead.rotateAngleY;
			this.bipedLeftArm.rotateAngleZ = this.bipedHead.rotateAngleZ;
		//}
	}
	
	private float updateRotation(float par1, float par2, float par3)
    {
        float f3 = MathHelper.wrapAngleTo180_float(par2 - par1);

        if (f3 > par3)
        {
            f3 = par3;
        }

        if (f3 < -par3)
        {
            f3 = -par3;
        }

        return par1 + f3;
    }

}
