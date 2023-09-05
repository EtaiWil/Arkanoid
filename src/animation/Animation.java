package animation;

import biuoop.DrawSurface;

/**
 * Animation interface charged on animations.
 */
public interface Animation {
    /**
     * run one frame on the screen.
     * @param d is the draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * is in charge of stopping condition.
     * @return if the animation need to be stopped
     */
    boolean shouldStop();
}
