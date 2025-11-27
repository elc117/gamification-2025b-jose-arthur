package io.github.hazard_attack;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class TelaJogo extends TelaBase{
    int pontos = 0;
    int modifier = 1;
    private final ImageTextButton upgradeButton;
    private final Table gameTable;
    private final Label pontosLabel;
    float passivePointsPerSecond = 0;
    float timeSinceLastTick = 0;
    final float tickInterval = 0.5f;

    int nurseCount = 0;
    int nurseCost = 50;
    final float nursePPS = 2.0f;

    int doctorCount = 0;
    int doctorCost = 200;
    final float doctorPPS = 8.0f;
    public TelaJogo(Core game) {
        super(game);

        Texture backgroundImage = new Texture("background-main.png");
        Image bgImage = new Image(backgroundImage);


        gameTable = new Table();
        gameTable.setFillParent(true);

        ImageButton pointButton = new ImageButton(skin, "virus");
        upgradeButton = new ImageTextButton("(10) Vacina [2x pts]", skin, "vacina");
        upgradeButton.setDisabled(true);
        ImageTextButton nurse = new ImageTextButton("Enfermeiro(a)"+" ["+ nurseCost + "]", skin, "nurse");
        ImageTextButton doctor = new ImageTextButton("Doutor(a)"+" ["+ doctorCost + "]", skin, "doctor");
        pontosLabel = new Label("Pontos: 0", skin);

        pointButton.setTransform(true);
        pointButton.setOrigin(125, 125);
        pointButton.addAction(Actions.forever(Actions.rotateBy(360, 12f)));

        Table topRightTable = new Table();
        topRightTable.add(nurse).width(200).height(50).top().right().padRight(10);
        topRightTable.add(doctor).width(200).height(50).top().right().padRight(10);

        gameTable.add(pontosLabel).top().left().padTop(20).padLeft(20).expandX();
        gameTable.add(topRightTable).top().right().padTop(20).padRight(20).row();

        gameTable.add().colspan(2).expandY().row();

        Table bottomTable = new Table();
        bottomTable.setFillParent(false);

        bottomTable.add(pointButton).size(250, 250).padLeft(50).padBottom(50).expandX().left();
        bottomTable.add(upgradeButton).width(200).height(50).padRight(10).padBottom(10).expandX().right();

        gameTable.add(bottomTable).colspan(2).fillX().bottom();

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
                if (pontos > 0 && Math.random() < 0.02){
                    int perda = (int) (pontos * 0.2);
                    pontos = pontos - perda;

                    Dialog dialog = new Dialog("!!!", skin){
                        @Override
                        protected void result(Object object) {
                        }
                    };
                    dialog.text("O virus sofreu uma mutacao( -" + perda + "pontos)").pad(20);

                    dialog.button("OK");
                    dialog.show(stage);
                }
            }
        });

        nurse.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (pontos >= nurseCost) {
                    pontos -= nurseCost;
                    nurseCount++;
                    passivePointsPerSecond += nursePPS;
                    pontosLabel.setText("Pontos: " + pontos);
                    nurseCost = (int) (nurseCost * 1.5);
                    nurse.setText("Enfermeiro(a) [" + nurseCost + " pts]");
                }
            }
        });

        doctor.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (pontos >= doctorCost) {
                    pontos -= doctorCost;
                    doctorCount++;
                    passivePointsPerSecond += doctorPPS;
                    pontosLabel.setText("Pontos: " + pontos);
                    doctorCost = (int) (doctorCost * 1.5);
                    doctor.setText("Doutor(a) [" + doctorCost + " pts]");

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
    @Override
    public void render(float delta) {
        super.render(delta);

        timeSinceLastTick += delta;

        if (timeSinceLastTick >= tickInterval) {
            int pointsToAdd = (int) (passivePointsPerSecond * tickInterval);

            pontos += pointsToAdd;

            timeSinceLastTick -= tickInterval;

            if (pointsToAdd > 0) {
                pontosLabel.setText("Pontos: " + pontos);
            }
        }
    }
}


