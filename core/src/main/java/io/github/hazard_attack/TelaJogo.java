package io.github.hazard_attack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class TelaJogo extends TelaBase{
    int pontos = 0;
    private Texture backgroundImage;
    public TelaJogo(Core game) {
        super(game);

        backgroundImage = new Texture("background.png");
        Image bgImage = new Image(backgroundImage);

        Table gameTable = new Table();
        TextButton pointButton = new TextButton("Clicar", skin);

        TextButton quitButton = new TextButton("Sair", skin);
        Label pontosLabel = new Label("Pontos: 0", skin);
        gameTable.add(pointButton).size(150, 50).pad(10);
        gameTable.add(pontosLabel).pad(10);
        gameTable.row();
        gameTable.add(quitButton).size(150, 50).pad(10);



        Stack stack = new Stack();
        stack.setFillParent(true);
        stack.add(bgImage);
        stack.add(gameTable);

        stage.addActor(stack);
        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        pointButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                pontos = pontos + 1;
                pontosLabel.setText("Pontos:" + pontos);
            }
        });
    }
}
