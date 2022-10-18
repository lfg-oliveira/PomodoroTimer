/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pomodorotimer;

/**
 *
 * @author guilu
 */
public abstract class State{
    private int duration;
    public State(Configuration conf, String key) {
        this.duration = Integer.parseInt(conf.getProp(key));
    }
    public void tick() {
        this.duration -= 1;
    }
            
}
