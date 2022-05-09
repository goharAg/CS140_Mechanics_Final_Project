public class Spring{

    public double k; 

    public Spring(){
        this.k = 1;
    }

    public Spring(double k){
        this.k = k;
    }

    public double getStiffness(){
        return k;
    }

    private void setStiffness(double k){
        this.k = k;
    }

    public double move(double t, double dt, double x0, double v0){
        return 0;
    }

    public double move(double t, double dt, double x0){
        return 0;
    }
    public double move(double t0, double t1, double dt, double x0, double v0){
        return 0;
    }
    public double move(double t0, double t1, double dt, double x0, double v0, double m){
        return 0;
    }

    public Spring inSeries(Spring that){
        return new Spring();
    }

    public Spring inParallel(Spring that){
        return new Spring();
    }
    public static void main(String[] args){

    }
}