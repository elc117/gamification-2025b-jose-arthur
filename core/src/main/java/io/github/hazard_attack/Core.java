package io.github.hazard_attack;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Core extends Game {

    @Override
    public void create() {
        setScreen(new MenuInicial(this));
    }
    @Override
    public void resize(int width, int height){
    }
}
