package net.minecraft.world.entity.ai.control;

import net.minecraft.world.entity.EntityInsentient;

public class ControllerJump {

    private final EntityInsentient b;
    protected boolean a;

    public ControllerJump(EntityInsentient entityinsentient) {
        this.b = entityinsentient;
    }

    public void jump() {
        this.a = true;
    }

    public void b() {
        this.b.setJumping(this.a);
        this.a = false;
    }
}
