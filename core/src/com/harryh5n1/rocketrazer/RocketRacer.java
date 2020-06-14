package com.harryh5n1.rocketrazer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

import java.sql.Array;
import java.util.Random;

public class RocketRacer extends ApplicationAdapter{
	SpriteBatch batch;
	Texture background,rocky,askl,askr,askl1,askr1,a5,leftarrow,ri8arrow,hum,go;
	Random random=new Random();int heightr,heightl,heightr1,heightl1,h5;
	int wide;
	int l=0;int k=0;int o=1;
	int v1=random.nextInt(10)+5,v2=random.nextInt(10)+5,v3=random.nextInt(10)+5,v4=5+random.nextInt(10),v5=random.nextInt(10)+5;
	int q,w,e,r,t;
	Circle[] ast;
	int[] cwide=new int[5];
	ShapeRenderer shapeRenderer;
	Texture jok,s,qw;
	boolean game=false;
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer=new ShapeRenderer();
		background=new Texture("galaxy.jpeg");
		jok=new Texture("pahum.png");
		rocky=new Texture("rckt.png");
		leftarrow=new Texture("leftarrow.png");
		wide=Gdx.graphics.getWidth() / 2 - rocky.getWidth() / 2;
		ri8arrow=new Texture("ri8arrow.png");
		askl=new Texture("asteroidlft.png");
		go=new Texture("goo.png");
		s=new Texture("17425.png");
		askr=new Texture("asteroidri8.png");
        askl1=new Texture("asteroidlft.png");
        askr1=new Texture("asteroidri8.png");
        hum=new Texture("human.png");
        qw=new Texture("qw.png");
		a5=new Texture("asteroidri8.png");
		ast=new Circle[5];
		for(int h=0;h<5;h++) {
			ast[h]= new Circle();
		}
	}

	@Override
	public void render () {
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (Gdx.input.isTouched()) {
			Rectangle pa=new Rectangle(Gdx.graphics.getWidth()/2+85,25,s.getWidth(),s.getHeight());
			Vector3 tmp=new Vector3(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY(),0);;
			if(pa.contains(tmp.x,tmp.y)) {
				l=0;o=1;
				wide=Gdx.graphics.getWidth() / 2 - rocky.getWidth() / 2;
				batch.draw(hum, -1000,-1000);
				batch.draw(jok,1000,-1000);
				batch.draw(s,-1000,1000);
				k=0;
				batch.draw(qw,Gdx.graphics.getWidth()+100,Gdx.graphics.getHeight()+100);
				batch.draw(go, -1000,-1000);
				batch.draw(rocky, wide, Gdx.graphics.getHeight() / 2 - rocky.getHeight() / 2 -100);
			}
		}
		if(o==1){
			if (Gdx.input.isTouched()) {
				Rectangle left=new Rectangle(0,0,leftarrow.getWidth(),leftarrow.getHeight());
				Vector3 tmp=new Vector3(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY(),0);;
				if(left.contains(tmp.x,tmp.y)&&wide>=-rocky.getWidth()/2) {
					wide=wide-8;
					game=true;
					batch.draw(rocky, wide, Gdx.graphics.getHeight() / 2 - rocky.getHeight() / 2 -100);
				}
			}

			if (Gdx.input.isTouched()) {
				Rectangle ro=new Rectangle(Gdx.graphics.getWidth()-leftarrow.getWidth(),0,leftarrow.getWidth(),leftarrow.getHeight());
				Vector3 tmp=new Vector3(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY(),0);;
				if(ro.contains(tmp.x,tmp.y)&&wide<=Gdx.graphics.getWidth()-rocky.getWidth()/2) {
					wide=wide+8;
					batch.draw(rocky, wide, Gdx.graphics.getHeight() / 2 - rocky.getHeight() / 2 -100);
					game=true;
				}
			}

		}
		if(k==1) {
			batch.draw(hum, 0, Gdx.graphics.getHeight() / 2 -hum.getHeight()/2-40);
			batch.draw(jok,Gdx.graphics.getWidth()/3-10,0);
			batch.draw(s,Gdx.graphics.getWidth()/2+85,25);
			batch.draw(qw,Gdx.graphics.getWidth()/2+qw.getWidth()+25,Gdx.graphics.getHeight()/2-150);
			batch.draw(go, Gdx.graphics.getWidth()/2-go.getWidth()/2, Gdx.graphics.getHeight()/2+100);
		}

        batch.draw(rocky, wide, Gdx.graphics.getHeight() / 2 - rocky.getHeight() / 2 -100);

		if (game) {
			if (l == 0) {
				start();
				l = 1;
			} else if(l == 1) {
				if (heightr < -100) {
					v1 = random.nextInt(10) + 5;
					q = random.nextInt(Gdx.graphics.getWidth() / 2);
					heightr = Gdx.graphics.getHeight() + random.nextInt(450);
					cwide[0]=Gdx.graphics.getWidth() / 2 + q - askl.getWidth() / 2;
					batch.draw(askr,cwide[0], heightr);
				} else if (heightl < -100) {
					v2 = random.nextInt(10) + 5;
					w = random.nextInt(Gdx.graphics.getWidth() / 2);
					heightl = Gdx.graphics.getHeight() + random.nextInt(450);
					cwide[1]=Gdx.graphics.getWidth() / 2 - w;
					batch.draw(askl,cwide[1] , heightl);
				} else if (h5 < -100) {
					v5 = random.nextInt(10) + 5;
					t = random.nextInt(Gdx.graphics.getWidth() / 6);
					cwide[4]=Gdx.graphics.getWidth() / 2 - t;
					h5 = Gdx.graphics.getHeight() + random.nextInt(450);
					batch.draw(a5, cwide[4], h5);
				} else if (heightr1 < -100) {
					v3 = random.nextInt(10) + 5;
					e = random.nextInt(Gdx.graphics.getWidth() / 2);
					cwide[2]=Gdx.graphics.getWidth() / 2 + e + askl.getWidth() / 2;
					heightr1 = Gdx.graphics.getHeight() + random.nextInt(450);
					batch.draw(askr1, cwide[2], heightr1);
				} else if (heightl1 < -100) {
					v4 = random.nextInt(10) + 5;
					r = random.nextInt(Gdx.graphics.getWidth() / 2);
					cwide[3]=Gdx.graphics.getWidth() / 2 - r;
					heightl1 = Gdx.graphics.getHeight() + random.nextInt(450);
					batch.draw(askl1, cwide[3], heightl1);
				} else {
					heightr = heightr - v1;
					heightl = heightl - v2;//SIZE
					batch.draw(askr, cwide[0], heightr);
					batch.draw(askl, cwide[1], heightl);
					heightr1 = heightr1 - v3;
					heightl1 = heightl1 - v4;
					h5 = h5 - v5;
					batch.draw(askr1, cwide[2], heightr1);
					batch.draw(askl1, cwide[3], heightl1);
					batch.draw(a5, cwide[4], h5);
				}
			}
		}
		//shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		//shapeRenderer.setColor(Color.BLUE);
		Rectangle f=new Rectangle(wide+90, Gdx.graphics.getHeight() / 2 - rocky.getHeight() / 2 -50,rocky.getWidth()-185,rocky.getHeight()-110);
		/*shapeRenderer.rect(wide+90, Gdx.graphics.getHeight() / 2 - rocky.getHeight() / 2 -50,rocky.getWidth()-185,rocky.getHeight()-110);
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.circle(cwide[0]+50, heightr+50,askr.getWidth()/2);*/
		ast[0]=new Circle(cwide[0]+50, heightr+50,askl.getWidth()/2);
		ast[1]=new Circle(cwide[1]+50, heightl+50,askl.getWidth()/2);
		ast[2]=new Circle(cwide[2]+50, heightr1+50,askl.getWidth()/2);
		ast[3]=new Circle(cwide[3]+50, heightl1+50,askl.getWidth()/2);
		ast[4]=new Circle(cwide[4]+50, h5+50,askl.getWidth()/2);
		/*shapeRenderer.circle(cwide[1]+50, heightl+50,askr.getWidth()/2);
		shapeRenderer.circle(cwide[2]+50, heightr1+50,askr.getWidth()/2);
		shapeRenderer.circle(cwide[3]+50, heightl1+50,askr.getWidth()/2);
		shapeRenderer.circle(cwide[4]+50, h5+50,askr.getWidth()/2);
		shapeRenderer.end();*/
		batch.draw(leftarrow,0, 0);
		batch.draw(ri8arrow, Gdx.graphics.getWidth()-leftarrow.getWidth(), 0);

		for(int u=0;u<5;u++){
			if(Intersector.overlaps(ast[u],f)){
				o=0;
				game=false;
				start();
				wide=Gdx.graphics.getWidth() / 2 - rocky.getWidth() / 2;
				batch.draw(rocky, wide, Gdx.graphics.getHeight() / 2 - rocky.getHeight() / 2 -100);
				k=1;
			}
		}
		batch.end();
	}
	public void start(){
		heightr = Gdx.graphics.getHeight() + random.nextInt(450);
		q = random.nextInt(Gdx.graphics.getWidth() / 2);
		cwide[0]=Gdx.graphics.getWidth() / 2 + q - askl.getWidth() / 2;
		batch.draw(askr, cwide[0], heightr);

		heightl = Gdx.graphics.getHeight() + random.nextInt(450);
		w = random.nextInt(Gdx.graphics.getWidth() / 2);
		cwide[1]=Gdx.graphics.getWidth() / 2 - w;
		batch.draw(askl, cwide[1], heightl);




		heightr1 = Gdx.graphics.getHeight() + random.nextInt(450);
		e = random.nextInt(Gdx.graphics.getWidth() / 2);
		cwide[2]=Gdx.graphics.getWidth() / 2 + e + askl.getWidth() / 2;
		batch.draw(askr1, cwide[2], heightr1);



		heightl1 = Gdx.graphics.getHeight() + random.nextInt(450);
		r = random.nextInt(Gdx.graphics.getWidth() / 2);
		cwide[3]=Gdx.graphics.getWidth() / 2 - r;
		batch.draw(askl1,cwide[3] , heightl1);



		h5 = Gdx.graphics.getHeight() + random.nextInt(450);
		t = random.nextInt(Gdx.graphics.getWidth() / 6);
		cwide[4]=Gdx.graphics.getWidth() / 2 - t;
		batch.draw(a5,cwide[4] , h5);
	}
	@Override
	public void dispose () {

	}
}
