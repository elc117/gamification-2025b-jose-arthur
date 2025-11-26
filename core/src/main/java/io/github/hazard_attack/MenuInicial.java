package io.github.hazard_attack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MenuInicial extends TelaBase {

    private Texture backgroundImage;

    public MenuInicial(Core game) {
        super(game);

        backgroundImage = new Texture("background.png");
        Image bgImage = new Image(backgroundImage);

        Table menuTable = new Table();

        Label titulo = new Label("Viral Clicker", skin, "title");
        TextButton playButton = new TextButton("Jogar", skin);

        menuTable.add(titulo).size(150, 150).pad(10);
        menuTable.row();
        menuTable.add(playButton).size(150, 50).pad(10);

        Stack stack = new Stack();
        stack.setFillParent(true);
        stack.add(bgImage);
        stack.add(menuTable);

        stage.addActor(stack);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new TelaJogo(game));
            }
        });

    }

    @Override
    public void dispose() {
        super.dispose();
        backgroundImage.dispose();
    }
}
