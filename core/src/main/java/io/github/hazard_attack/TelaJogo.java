package io.github.hazard_attack;

import com.badlogic.gdx.scenes.scene2d.ui.*;

public class TelaJogo extends TelaBase{
    public TelaJogo(Core game) {
        super(game);

        Table gameTable = new Table();
        TextButton pointButton = new TextButton("Clicar", skin);

        TextButton quitButton = new TextButton("Clicar", skin);

        gameTable.add(pointButton).size(150, 50).pad(10);

        Stack stack = new Stack();
        stack.setFillParent(true);
        stack.add(gameTable);

        stage.addActor(stack);
    }
}
