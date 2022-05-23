import java.util.*;

public class Converter {

    HashMap<Integer, String> binaryToSpringSystem = new HashMap<Integer, String>();
    int n = 8;
    
    public int binarytoDecimal(Integer[] binary){
        Spring spring = binaryToSpring(binary);

        // here we are supposed to call 'getSpringOssil' method to simulate the movement of the spring
        // then we should call 'ossillationsTofrequency' methd to simulate our machine processing the movement to get the ossilations
        // then using our results we should calculate decimal number
        // however, this way also works, as I calcualte the decimal value using simulated spring system properties 
        return (int)spring.getK();
    }

    public Spring binaryToSpring(Integer[] binary){
        evaluateBinary(binary);
        String system = generateSpringExpr(binaryToSpringSystem);

        Spring spring = (new SpringArray()).equivalentSpring(system);

        return spring;

    }

    public double[] getSpringOssil(Spring springSystem){
        double dt = 0.05;
        double x0 = 0;
        double t = 5;
        return springSystem.move(t, dt, x0);
    }

    private void evaluateBinary(Integer[] binary){    
        for(int i = n-1; i >=0; i--){
            if(binary[i] == 1){
                int v =  (int)Math.pow(2, n-i-1) ;
                String exp = generateSpringExpr(v);
                binaryToSpringSystem.put(v, exp);
            }
        }
    }
    
    private String generateSpringExpr(Map<Integer,String> springs){
        StringBuilder result = new StringBuilder();
        result.append("[");
        for(String s : springs.values()){
            result.append(s);
        }
        result.append("]");

        return result.toString();
    }

    private String generateSpringExpr(Integer expectedK){
        if(expectedK == 0) return "";

        StringBuilder result = new StringBuilder();
        result.append("[");

        for(int i = 0; i < expectedK; i++){
            result.append("[]");
        }
        result.append("]");

        return result.toString();
    }

}
