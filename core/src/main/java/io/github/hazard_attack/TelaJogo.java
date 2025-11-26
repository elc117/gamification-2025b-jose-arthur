package io.github.hazard_attack;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class TelaJogo extends TelaBase{
    int pontos = 0;
    int modifier = 1;
    private final ImageTextButton upgradeButton;
    public TelaJogo(Core game) {
        super(game);

        Texture backgroundImage = new Texture("background-main.png");
        Image bgImage = new Image(backgroundImage);


        Table gameTable = new Table();
        gameTable.setFillParent(true);
        //gameTable.setDebug(true); //debug da tabela REMOVERRRRRRRRR!!!!!!!!!!!!!!!!!

        ImageButton pointButton = new ImageButton(skin, "virus");
        upgradeButton = new ImageTextButton("Vacina [2x pts]", skin, "vacina");
        upgradeButton.setDisabled(true);
        Label pontosLabel = new Label("Pontos: 0", skin);

        pointButton.setTransform(true);
        pointButton.setOrigin(125, 125);
        pointButton.addAction(Actions.forever(Actions.rotateBy(360, 8f)));

        gameTable.add(pontosLabel).colspan(2).expand().top().left().pad(10);
        gameTable.row();
        gameTable.add(pointButton).size(250, 250).expand().bottom().left().pad(50);
        gameTable.add(upgradeButton).size(180, 40).expand().bottom().right().pad(10);

        Stack stack = new Stack();
        stack.setFillParent(true);
        stack.add(bgImage);
        stack.add(gameTable);

        stage.addActor(stack);
        pointButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                pontos = pontos + modifier;
                pontosLabel.setText("Pontos:" + pontos);

                if(pontos >= 10) {
                    if (upgradeButton.isDisabled()) {
                        upgradeButton.setDisabled(false);
                    }
                } else {
                    if (!upgradeButton.isDisabled()) {
                        upgradeButton.setDisabled(true);
                    }
                }
            }
        });

        upgradeButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (pontos >= 10) {
                    pontos = pontos - 10;
                    pontosLabel.setText("Pontos: " + pontos);
                    modifier = 2;
                    upgradeButton.remove();
                }
            }
        });
    }
}
