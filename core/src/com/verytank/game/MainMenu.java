package com.verytank.game;

//public class MainMenu {
//}

//package com.badlogic.drop;

        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.Screen;
        import com.badlogic.gdx.graphics.Color;
        import com.badlogic.gdx.graphics.GL20;
        import com.badlogic.gdx.graphics.OrthographicCamera;
        import com.badlogic.gdx.graphics.Pixmap;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.Animation;
        import com.badlogic.gdx.graphics.g2d.Sprite;
        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
        import com.badlogic.gdx.graphics.g2d.TextureRegion;
        import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
        import com.badlogic.gdx.utils.ScreenUtils;

        import java.awt.*;


public class MainMenu implements Screen {
    static Pixmap pixmap;
    SpriteBatch batch;
    final Very_Tank game;
    Sprite sprite;
    private Texture blue;
    Texture resume;
    Rectangle resumeRect;
    Texture newGame;
    Texture pixmaptex;
    Rectangle newGameRect;
    private Rectangle backgroundBounds;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    MyShapeRenderer shapeRender=new MyShapeRenderer();
    tankThree tank1 =new tankThree();

//    Texture ani;
//    TextureRegion[] aniFrame;
//    Animation animation;
    float elapsedTime;


    //OrthographicCamera camera;

    public MainMenu(final Very_Tank game) {
        batch= new SpriteBatch();
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("bg.png"));
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        blue = new Texture("Color-blue.jpg");
        Rectangle blueRect = new Rectangle(Gdx.graphics.getWidth() - 700, 0, 800, Gdx.graphics.getHeight());
        sprite = new Sprite(blue);
        sprite.setBounds(blueRect.x, blueRect.y, blueRect.width, blueRect.height);
        sprite.setColor(0,0,0.3f,0.6f);
        
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1229);
        resume = new Texture("resume.jpg");
        //shapeRender.roundedRect(Gdx.graphics.getWidth()-600, Gdx.graphics.getHeight()-400, 400, 150,50);
        pixmap=getPixmapRoundedRectangle(400, 150,30, 5, 255, 228,1f);
        pixmaptex = new Texture( pixmap );
        pixmap.dispose();
        resumeRect = new Rectangle(Gdx.graphics.getWidth()-550+20, Gdx.graphics.getHeight()-400+20, 400-45, 150-45);
        newGame = new Texture("newgame.jpg");
        newGameRect = new Rectangle(Gdx.graphics.getWidth()-550+20, Gdx.graphics.getHeight()-800+20, 400-45, 150-45);


//        ani=new Texture("tankani.png");
//        TextureRegion[][] tmpFrame= TextureRegion.split(ani, 295, 211);
//        aniFrame=new TextureRegion[4];
//        int index=0;
//
//        for (int i=0; i<2; i++){
//            for (int j=0; j<2; j++){
//                aniFrame[index++]=tmpFrame[j][i];
//            }
//        }
//        //System.out.println(aniFrame);
//        animation=new Animation<TextureRegion>(1f/4f,aniFrame);
        //camera = new OrthographicCamera();
        //camera.setToOrtho(false, 800, 480);
    }

    public static Pixmap getPixmapRoundedRectangle(int width, int height, int radius, int r, int g, int b, float alpha) {

        pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(r,g,b,alpha);

        // Pink rectangle
        pixmap.fillRectangle(0, radius, pixmap.getWidth(), pixmap.getHeight()-2*radius);

// Green rectangle
        pixmap.fillRectangle(radius, 0, pixmap.getWidth() - 2*radius, pixmap.getHeight());


// Bottom-left circle
        pixmap.fillCircle(radius, radius, radius);

// Top-left circle
        pixmap.fillCircle(radius, pixmap.getHeight()-radius, radius);

// Bottom-right circle
        pixmap.fillCircle(pixmap.getWidth()-radius, radius, radius);

// Top-right circle
        pixmap.fillCircle(pixmap.getWidth()-radius, pixmap.getHeight()-radius, radius);
        return pixmap;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        elapsedTime+=Gdx.graphics.getDeltaTime();
        batch.begin();
        //game.shapeRenderer.begin();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.enableBlending();
        game.batch.begin();
        game.batch.draw(backgroundImage,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);

        sprite.draw(game.batch);

        game.batch.draw(pixmaptex,Gdx.graphics.getWidth()-550+5, Gdx.graphics.getHeight()-400+5, 400-15, 150-15);
        game.batch.draw(resume,resumeRect.x,resumeRect.y,resumeRect.width,resumeRect.height);
        game.batch.draw(pixmaptex,Gdx.graphics.getWidth()-550+5, Gdx.graphics.getHeight()-800+5, 400-15, 150-15);
        game.batch.draw(newGame,newGameRect.x,newGameRect.y,newGameRect.width,newGameRect.height);
        game.batch.draw((TextureRegion) tank1.getAnimation().getKeyFrame(elapsedTime,true),300, 300, 600,432);

        //game.batch.draw(shapeRender,shapeRender.x, );
        game.batch.end();
        batch.end();
//        if (Gdx.input.isTouched()) {
//            game.setScreen(new GameScreen(game));
//            dispose();
//        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
