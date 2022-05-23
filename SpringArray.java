import java.util.*;

public class SpringArray {
   public Spring equivalentSpring(String springExpr){

    Deque<Character> stack = new ArrayDeque<Character>();
    ArrayList<Spring> springsList = new ArrayList<Spring>();
    HashMap<Integer, List<Spring>> levelToArrayMap = new HashMap<Integer, List<Spring>>();
    int springCount = 0;
    int springLevel = 0;
    char lastInStack;
    char previous;
    char current;
    char next;
    Spring res = new Spring();

    for(int i = 0; i < springExpr.length(); i++) {

        previous = i-1 >=0 ?springExpr.charAt(i-1) : ' ';
        current = springExpr.charAt(i);
        next = i+1 < springExpr.length() ? springExpr.charAt(i+1) : ' ' ;

        if (current == '[' ){
            stack.push(current);
            if(next == '[' || next == '{'){
                ++springLevel;
                levelToArrayMap.put(springLevel, new ArrayList<Spring>());
            }

            continue;
        }else if(current == '{'){
            stack.push(current);
            if(next == '[' || next == '{'){
                ++springLevel;
                levelToArrayMap.put(springLevel, new ArrayList<Spring>());
            }
            continue;
        }

        if(current == ']'){
            lastInStack = stack.pop();
            if(lastInStack == '['){
                if(previous == '['){
                    springCount++;
                    Spring c = new Spring();
                    springsList.add(c);
                    levelToArrayMap.get(springLevel).add(c);
                }else{
                    Spring c = evaluate(levelToArrayMap.get(springLevel), "parralel");
                    springLevel--;
                    if(springLevel > 0 ){
                        levelToArrayMap.get(springLevel).add(c);
                    }else{
                        res = c;
                        break;
                    }
                }
            }

            continue;
        }else if(current == '}'){
            lastInStack = stack.pop();
            if(lastInStack == '{'){
                Spring c = evaluate(levelToArrayMap.get(springLevel), "series");
                springLevel--;
                if(springLevel > 0 ){
                    levelToArrayMap.get(springLevel).add(c);
                }else{
                    res = c;
                    break;
                }
            }

        }

    }

    return res;
      
   }


   private Spring evaluate(List<Spring> springs, String type){
       Spring res = springs.size() > 0 ? springs.get(0) : new Spring();

       if(springs.size() == 1){
           return res;
       }
       
        for(int i = 1; i < springs.size(); i++){
            if(type == "series"){
                res = res.inSeries(springs.get(i));
            }else{
                res = res.inParallel(springs.get(i));
            }
        }
        
        return res;
   }

   


   public Spring equivalentSpring(String springExpr, Spring[] springs){
        Deque<Character> stack = new ArrayDeque<Character>();
        ArrayList<Spring> springsList = new ArrayList<Spring>();
        HashMap<Integer, List<Spring>> levelToArrayMap = new HashMap<Integer, List<Spring>>();
        int springCount = 0;
        int springLevel = 0;
        char lastInStack;
        char previous;
        char current;
        char next;
        Spring res = new Spring();

        for(int i = 0; i < springExpr.length(); i++) {

            previous = i-1 >=0 ?springExpr.charAt(i-1) : ' ';
            current = springExpr.charAt(i);
            next = i+1 < springExpr.length() ? springExpr.charAt(i+1) : ' ' ;

            if (current == '[' ){
                stack.push(current);
                if(next == '[' || next == '{'){
                    ++springLevel;
                    levelToArrayMap.put(springLevel, new ArrayList<Spring>());
                }

                continue;
            }else if(current == '{'){
                stack.push(current);
                if(next == '[' || next == '{'){
                    ++springLevel;
                    levelToArrayMap.put(springLevel, new ArrayList<Spring>());
                }
                continue;
            }

            if(current == ']'){
                lastInStack = stack.pop();
                if(lastInStack == '['){
                    if(previous == '['){
                        springCount++;
                        Spring c = springs[springCount-1];
                        springsList.add(c);
                        levelToArrayMap.get(springLevel).add(c);
                    }else{
                        Spring c = evaluate(levelToArrayMap.get(springLevel), "parralel");
                        springLevel--;
                        if(springLevel > 0 ){
                            levelToArrayMap.get(springLevel).add(c);
                        }else{
                            res = c;
                            break;
                        }
                    }
                }

                continue;
            }else if(current == '}'){
                lastInStack = stack.pop();
                if(lastInStack == '{'){
                    Spring c = evaluate(levelToArrayMap.get(springLevel), "series");
                    springLevel--;
                    if(springLevel > 0 ){
                        levelToArrayMap.get(springLevel).add(c);
                    }else{
                        res = c;
                        break;
                    }
                }

            }

        }

        return res;
   }

   public static void main(String[] args){

    String expr = "[[][][][][][]]";
    SpringArray ex = new SpringArray();
    System.out.println(ex.equivalentSpring(expr).getK());


   }
}
