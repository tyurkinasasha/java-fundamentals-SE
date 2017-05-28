package Unit2.Task6;

/**
 * Created by Tyurkina Alexandra on 5/28/2017.
 */
public class NuclearPoweredBoat {
    private Engine engine;
    public NuclearPoweredBoat(){
        engine=new Engine();
    }
    static private class Engine{
        private boolean status;
        private void turnEngineOn(){
            status=true;
        }
        private void turnEngineOff(){
            status=false;
        }
    }
    public void startBoat(){
        System.out.println("Starting boat...");
        engine.turnEngineOn();
        System.out.println("Engine status: "+engine.status);
        System.out.println("Boat is floating");
    }
    public void stopBoat(){
        System.out.println("Stopping boat...");
        engine.turnEngineOff();
        System.out.println("Engine status: "+engine.status);
        System.out.println("Boat has stopped");
    }
}
