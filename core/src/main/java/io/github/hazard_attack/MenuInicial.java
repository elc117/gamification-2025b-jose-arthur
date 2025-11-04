package io.github.hazard_attack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MenuInicial extends TelaBase {

    private Texture backgroundImage;

    public MenuInicial(Core game) {
        super(game); // <-- IMPORTANTE!

        backgroundImage = new Texture("background.png");
        Image bgImage = new Image(backgroundImage);

        Table buttonTable = new Table();

        TextButton playButton = new TextButton("Jogar", skin);
        TextButton quitButton = new TextButton("Sair", skin);

        buttonTable.add(playButton).fillX().uniformX().pad(10);
        buttonTable.row();
        buttonTable.add(quitButton).fillX().uniformX().pad(10);

        Stack stack = new Stack();
        stack.setFillParent(true);
        stack.add(bgImage);
        stack.add(buttonTable);

        stage.addActor(stack);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("Menu Principal", "Botão precionado");
            }
        });

        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void dispose() {
        super.dispose(); // <-- Chama o dispose() da BaseScreen (para stage e skin)
        backgroundImage.dispose(); // Libera a textura específica desta tela
    }
}
