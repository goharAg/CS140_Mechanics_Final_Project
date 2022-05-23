import java.util.*;

public class Converter {

    HashMap<Integer, String> binaryToSpringSystem = new HashMap<Integer, String>();
    int n = 8;
    
    public int getSprings(Integer[] binary){
        evaluateBinary(binary);
        String system = generateSpringExpr(binaryToSpringSystem);

        Spring spring = (new SpringArray()).equivalentSpring(system);

        return (int)spring.getK();

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

    public static void main(String[] args){
        Converter c = new Converter();
        Integer[] arr = {0,0,0,0,0,0,1,1};
        System.out.println(c.getSprings(arr));
    }
}
